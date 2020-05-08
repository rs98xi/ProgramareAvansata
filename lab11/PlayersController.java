package com.example.lab11.controller;

import com.example.lab11.models.Player;
import com.example.lab11.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/laborator11/players")
public class PlayersController {
    @Autowired
    private PlayerService service;

    @RequestMapping(path = "/create/{name}", method = RequestMethod.POST)
    ResponseEntity<Player> createPlayer(@PathVariable String name) {

        Player player = new Player();
        player.setName(name);

        player = service.createPlayer(player);

        return new ResponseEntity<>(player, new HttpHeaders(), HttpStatus.CREATED);
    }


    @RequestMapping(path = "/get/all", method = RequestMethod.GET)
    ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = service.getAllPlayers();
        return new ResponseEntity<>(players, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/get/{id}", method = RequestMethod.GET)
    ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        Player players = service.getPlayerById(id);
        return new ResponseEntity<>(players, new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(path = "/change/{id}/{name}", method = RequestMethod.PUT)
    ResponseEntity<Player> updatePlayerName(@PathVariable String id, @PathVariable String name) {
        Player players = service.updatePlayerName(id, name);
        return new ResponseEntity<>(players, new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Player> deletePlayerById(@PathVariable String id) {
        service.deletePlayer(id);
        return new ResponseEntity<>(service.getPlayerById(id), new HttpHeaders(), HttpStatus.OK);
    }


}
