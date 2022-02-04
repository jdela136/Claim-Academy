package com.tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.entity.Game;
import com.tracker.entity.Team;
import com.tracker.repository.GameRepository;

@Service
public class GameService {
	
	@Autowired
	GameRepository repository;
	
//	public void startGame(Team away, Team home) {
//		Game game = new Game();
//		game.setAwayTeam(away);
//		game.setHomeTeam(home);
//		game.setAwayScore(0);
//		game.setHomeScore(0);
//		repository.save(game);
//	}
//	
//	public void endGame(Integer id) {
//		Game game = repository.getById(id);
//		if(game.getAwayScore() > game.getHomeScore()) {
//			game.getAwayTeam().setWins(game.getAwayTeam().getWins() + 1);
//			game.getHomeTeam().setLosses(game.getHomeTeam().getLosses() + 1);
//		}
//		else {
//			game.getHomeTeam().setWins(game.getHomeTeam().getWins() + 1);
//			game.getAwayTeam().setLosses(game.getAwayTeam().getLosses() + 1);
//		}
//	}
}
