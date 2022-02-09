package com.tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.entity.Game;
import com.tracker.entity.PlateAppearance;
import com.tracker.entity.Player;
import com.tracker.entity.Team;
import com.tracker.repository.GameRepository;
import com.tracker.repository.PlateAppearanceRepository;
import com.tracker.repository.PlayerRepository;
import com.tracker.repository.TeamRepository;

@Service
public class GameService {

	@Autowired
	PlateAppearanceRepository paRepository;

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	GameRepository gameRepository;

	public void startGame(Integer awayId, Integer homeId) {
		Team dbAway = teamRepository.findById(awayId).get();
		Team dbHome = teamRepository.findById(homeId).get();
		Game game = new Game();
		game.setAwayTeam(dbAway);
		game.setHomeTeam(dbHome);
		game.setAwayScore(0);
		game.setHomeScore(0);
		
		gameRepository.save(game);

		PlateAppearance pa = new PlateAppearance();
		pa.setGame(game);
		pa.setAwayIndex(1);
		pa.setHomeIndex(0);
		pa.setStrikes(1);
		pa.setBalls(1);
		pa.setEndGame(false);
		pa.setInningNum(1);
		pa.setOuts(0);
		pa.setBase(0);
		pa.setAwayHits(0);	
		pa.setHomeHits(0);
		pa.setRuns(0);
		
//		playerRepository.findTopByOrderByIdDesc();
		pa.setPlayer(playerRepository.findTopPlayerByTeamIdAndLineUpId(awayId, 1).get());
		pa.getPlayer().getStats().setPaCount(pa.getPlayer().getStats().getPaCount() + 1);
		paRepository.save(pa);
	}

	public void startPA(Integer gameId) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		PlateAppearance lastPA = pas.get(0).get();
		
		List<Player> away= playerRepository.findLineUp(lastPA.getGame().getAwayTeam().getId()).get();
		List<Player> home= playerRepository.findLineUp(lastPA.getGame().getHomeTeam().getId()).get();
		
		int totalOuts = lastPA.getOuts();
		PlateAppearance newAtBat = new PlateAppearance();

		newAtBat.setGame(lastPA.getGame());
		newAtBat.setBalls(1);
		newAtBat.setStrikes(1);
		newAtBat.setBase(0);
		newAtBat.setEndGame(false);
		newAtBat.setAwayHits(lastPA.getAwayHits());
		newAtBat.setHomeHits(lastPA.getHomeHits());
		newAtBat.setRuns(lastPA.getRuns());

		if (totalOuts < 3) {
			newAtBat.setHomeIndex(lastPA.getHomeIndex());
			if (lastPA.getAwayIndex() == away.size()) {
				newAtBat.setAwayIndex(1);
			} else {
				newAtBat.setAwayIndex(lastPA.getAwayIndex() + 1);
			}
			newAtBat.setPlayer(away.get(newAtBat.getAwayIndex() - 1));
			newAtBat.getPlayer().getStats().setPaCount(newAtBat.getPlayer().getStats().getPaCount() + 1);
			newAtBat.setOuts(lastPA.getOuts());
			newAtBat.setInningNum(lastPA.getInningNum());
		}
		if (totalOuts == 3) {
//			if (lastPA.getInningNum() == 1) {
//				newAtBat.setHomeIndex(1);
//			} else {
				if (lastPA.getHomeIndex() == home.size()) {
					newAtBat.setHomeIndex(1);
				} else {
					newAtBat.setHomeIndex(lastPA.getHomeIndex() + 1);
				}
//			}
			newAtBat.setAwayIndex(lastPA.getAwayIndex());
			newAtBat.setPlayer(home.get(newAtBat.getHomeIndex() - 1));
			newAtBat.getPlayer().getStats().setPaCount(newAtBat.getPlayer().getStats().getPaCount() + 1);
			newAtBat.setOuts(lastPA.getOuts());
			newAtBat.setRuns(0);
			newAtBat.setInningNum(lastPA.getInningNum());
		}
		if (totalOuts == 4 || totalOuts == 5) {

			if (lastPA.getHomeIndex() == home.size()) {
				newAtBat.setHomeIndex(1);
			} else {
				newAtBat.setHomeIndex(lastPA.getHomeIndex() + 1);
			}
			newAtBat.setAwayIndex(lastPA.getAwayIndex());
			newAtBat.setPlayer(home.get(newAtBat.getHomeIndex() - 1));
			newAtBat.getPlayer().getStats().setPaCount(newAtBat.getPlayer().getStats().getPaCount() + 1);
			newAtBat.setOuts(lastPA.getOuts());
			newAtBat.setInningNum(lastPA.getInningNum());
		}
		if (totalOuts == 6) {
			clearBasePath(gameId);
			newAtBat.setHomeIndex(lastPA.getHomeIndex());
			if (lastPA.getAwayIndex() == away.size()) {
				newAtBat.setAwayIndex(1);
			} else {
				newAtBat.setAwayIndex(lastPA.getAwayIndex() + 1);
			}
			newAtBat.setPlayer(away.get(newAtBat.getAwayIndex() - 1));
			newAtBat.getPlayer().getStats().setPaCount(newAtBat.getPlayer().getStats().getPaCount() + 1);
			newAtBat.setOuts(0);
			newAtBat.setRuns(0);
			newAtBat.setInningNum(lastPA.getInningNum() + 1);
		}
		paRepository.save(newAtBat);
	}

	public void moveRunner(Integer gameId, Integer startingBase, Integer endingBase) {
		PlateAppearance pa = paRepository.getPAByBase(gameId, startingBase).get(0).get();
		if(startingBase == 0) {
			if (endingBase > 3) {
				pa.setBase(4);
				pa.getPlayer().getStats().setRbis(pa.getPlayer().getStats().getRbis() + 1);
				pa.getPlayer().getStats().setRuns(pa.getPlayer().getStats().getRuns() + 1);
				if(pa.getOuts() < 4) {
					pa.getGame().setAwayScore(pa.getGame().getAwayScore() + 1);
					pa.setRuns(pa.getGame().getAwayScore());
				}
				else {
					pa.getGame().setHomeScore(pa.getGame().getHomeScore() + 1);
					pa.setRuns(pa.getGame().getHomeScore());
				}
			}
			else {
				pa.setBase(endingBase);
			}
		}
		else {
			if (endingBase > 3) {
				pa.setBase(4);
				pa.getPlayer().getStats().setRuns(pa.getPlayer().getStats().getRuns() + 1);
				List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
				PlateAppearance batter = pas.get(0).get();
				batter.getPlayer().getStats().setRbis(batter.getPlayer().getStats().getRbis() + 1);
				if(pa.getOuts() < 4) {
					pa.getGame().setAwayScore(pa.getGame().getAwayScore() + 1);
					batter.setRuns(pa.getGame().getAwayScore());
				}
				else {
					pa.getGame().setHomeScore(pa.getGame().getHomeScore() + 1);
					pa.setRuns(pa.getGame().getHomeScore());
				}
				paRepository.save(batter);
			}
			else {
				pa.setBase(endingBase);
			}
		}
		paRepository.save(pa);
	}
	
	public void moveAllRunners(Integer gameId, Integer bases) {
		List<Optional<PlateAppearance>> onBase = paRepository.getPAsOnBase(gameId);
		
		for(int i = 0; i < onBase.size(); i++) {
			PlateAppearance pa =  onBase.get(i).get();
			if(pa.getBase() == 3 && onBase.get(i+1).get().getBase() == 2) {
				moveRunner(gameId, pa.getBase(), 4);
			}
			if (pa.getBase() == bases) {
				moveRunner(gameId, pa.getBase(), pa.getBase() + 1);
			}
			if (pa.getBase() < bases) {
				moveRunner(gameId, pa.getBase(), pa.getBase() + bases);
			}
			paRepository.save(pa);
		}
	}
	
	public void outOnPlay(Integer gameId) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		PlateAppearance pa = pas.get(0).get();
		pa.setBase(5);
		pa.endPlateAppearance();
		pa.setOuts(pa.getOuts() + 1);
		paRepository.save(pa);
		if(pa.getOuts() == 3 || pa.getOuts() == 6) {
			clearBasePath(gameId);
		}
		//paRepository.save(pa);
		startPA(gameId);
	}

	public void addStrike(Integer gameId) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		PlateAppearance pa = pas.get(0).get();
		if (pa.getBase() == 0) {
			pa.setStrikes(pa.getStrikes() + 1);
			if (pa.getStrikes() == 3) {
				pa.getPlayer().getStats().setStrikeouts(pa.getPlayer().getStats().getStrikeouts() + 1);
				outOnPlay(gameId);
			}
			paRepository.save(pa);
		} else {
			startPA(gameId);
			pas = paRepository.getPAsByGameIdDesc(gameId);
			pa = pas.get(0).get();
			pa.setStrikes(2);
			paRepository.save(pa);
		}
	}

	public void addBall(Integer gameId) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		PlateAppearance pa = pas.get(0).get();
		if (pa.getBase() == 0) {
			pa.setBalls(pa.getBalls() + 1);
			if (pa.getBalls() == 4) {
				moveRunner(gameId, 0, 1);
				pa.getPlayer().getStats().setWalks(pa.getPlayer().getStats().getWalks() + 1);
				startPA(gameId);
			}
			paRepository.save(pa);
			pa.endPlateAppearance();
		} else {
			startPA(gameId);
			pas = paRepository.getPAsByGameIdDesc(gameId);
			pa = pas.get(0).get();
			pa.setStrikes(2);
			paRepository.save(pa);
		}
	}

	public void endGame(Integer gameId) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		PlateAppearance pa = pas.get(0).get();
		Game game = pa.getGame();
		if (game.getAwayScore() > game.getHomeScore()) {
			game.getAwayTeam().setWins(game.getAwayTeam().getWins() + 1);
			game.getHomeTeam().setLosses(game.getHomeTeam().getLosses() + 1);
		} else {
			game.getHomeTeam().setWins(game.getHomeTeam().getWins() + 1);
			game.getAwayTeam().setLosses(game.getAwayTeam().getLosses() + 1);
		}
		pa.setEndGame(true);
		paRepository.save(pa);
	}
	
	public void clearBasePath(Integer gameId) {
		List<Optional<PlateAppearance>> onBase = paRepository.getPAsOnBase(gameId);
		for(Optional<PlateAppearance> pa : onBase) {
			pa.get().setBase(null);
			paRepository.save(pa.get());
		}
	}
	
	public void ballInPlay(Integer gameId) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		PlateAppearance pa = pas.get(0).get();
		pa.setInPlay(true);
		paRepository.save(pa);
	}
	
	public void baseHit(Integer gameId, Integer bases) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		PlateAppearance pa = pas.get(0).get();
		Player batter = pa.getPlayer();

		switch (bases) {
		case 1:
			moveAllRunners(gameId, 1);
			batter.getStats().setSingles(batter.getStats().getSingles() + 1);
			break;
		case 2:
			moveAllRunners(gameId, 2);
			batter.getStats().setDoubles(batter.getStats().getDoubles() + 1);
			break;
		case 3:
			moveAllRunners(gameId, 3);
			batter.getStats().setTriples(batter.getStats().getTriples() + 1);
			break;
		case 4:
			moveAllRunners(gameId, 4);
			batter.getStats().setHomeruns(batter.getStats().getHomeruns() + 1);
			break;
		}
		
		batter.getStats().setHits(batter.getStats().getHits() + 1);
		if(pa.getOuts() < 4) {
			pa.setRuns(pa.getGame().getAwayScore());
			if(pas.size() == 1) {
				pa.setAwayHits(1);
			}
			else {
				pa.setAwayHits(pas.get(1).get().getAwayHits() + 1);
			}
		}
		else {
			pa.setRuns(pa.getGame().getHomeScore());
			if(pas.size() == 1) {
				pa.setHomeHits(1);
			}
			else {
				pa.setHomeHits(pas.get(1).get().getHomeHits() + 1);
			}
		}
		startPA(gameId);
		paRepository.save(pa);
		//paRepository.save(pas.get(1).get());
	}
	
	public Optional<PlateAppearance> findLastPAByGameId(Integer gameId) {
		List<Optional<PlateAppearance>> pas = paRepository.getPAsByGameIdDesc(gameId);
		return pas.get(0);
	}
	
	public Optional<Game> findGameById(Integer id) {
		return gameRepository.findById(id);
	}
	
	public List<Game> findGames() {
		return gameRepository.findAll();
	}
}
