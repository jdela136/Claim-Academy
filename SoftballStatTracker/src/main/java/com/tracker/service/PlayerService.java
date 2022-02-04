package com.tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tracker.entity.Player;
import com.tracker.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository repository;
	
	public void savePlayer(Player player) {
		player.getStats().setAtBats(0);
		player.getStats().setDoubles(0);
		player.getStats().setHits(0);
		player.getStats().setHomeruns(0);
		player.getStats().setPaCount(0);
		player.getStats().setRbis(0);
		player.getStats().setRuns(0);
		player.getStats().setSingles(0);
		player.getStats().setStrikeouts(0);
		player.getStats().setTriples(0);
		player.getStats().setWalks(0);
		repository.save(player);
	}
	
	public Optional<Player> getPlayerById(Integer id) {
		return repository.findById(id);
	}
	
	public Optional<Player> getPlayerByFirstAndLast(String first, String last) {
		return repository.getPlayerByFirstAndLast(first, last);
	}
	
	public List<Player> getPlayers() {
		return repository.findAll();
	}
	
	public void addToLineUp(Optional<Player> player, Integer lineupPosition) {
		player.get().setLineupId(lineupPosition);
		repository.save(player.get());
	}
	
	public void setLineUp(List<Optional<Player>> players, List<Integer> lineUpPositions) {
		
	}
}
