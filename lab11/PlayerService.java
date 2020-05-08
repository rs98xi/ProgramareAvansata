package com.example.lab11.service;

import com.example.lab11.models.Player;
import com.example.lab11.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    public List<Player> getAllPlayers() {
        List<Player> players = repository.findAll();
        if (players.size() > 0) {
            return players;
        } else {
            return new ArrayList<>();
        }
    }

    public Player getPlayerById(String id) {
        return repository.findPlayerById(id);
    }

    public Player updatePlayerName(String id, String name) {
        Player player = repository.findPlayerById(id);
        player.setName(name);
        player = repository.save(player);
        return player;
    }

    public Player createPlayer(Player player) {
        player.setId(UUID.randomUUID().toString());
        System.out.println("================================================" + player.getId());
        player = repository.save(player);
        return player;
    }

    public  void deletePlayer(String id){
        repository.deleteById(id);
    }
}
