package com.tracker.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tracker.entity.Player;
import com.tracker.service.PlayerService;

@CrossOrigin
@RestController
public class PlayerController {

	@Autowired
	PlayerService service;
	
	@RequestMapping(value = "/save-player", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void submitStudentDetails(@RequestBody Player player) {
		service.savePlayer(player);
	}

	@RequestMapping(value = "/add-to-lineup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void addToLineUp(@RequestBody Player player, Integer lineupPosition) {
		Optional<Player> dbPlayer = service.getPlayerByFirstAndLast(player.getFirstName(), player.getLastName());
		service.addToLineUp(dbPlayer, lineupPosition);
	}

	@RequestMapping(value = "/set-line-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void setLineUp(@RequestBody List<Player> players) {
		// List<Optional<Player>> dbPlayers = new ArrayList<Optional<Player>>();
		Integer lineUpPosition = 1;
		for (Player player : players) {
			if (player != null) {
				Optional<Player> dbPlayer = service.getPlayerByFirstAndLast(player.getFirstName(), player.getLastName());
				service.addToLineUp(dbPlayer, lineUpPosition);
			}
			if (lineUpPosition == 12) {
				lineUpPosition = 1;
			} else {
				lineUpPosition++;
			}
		}
	}
}
