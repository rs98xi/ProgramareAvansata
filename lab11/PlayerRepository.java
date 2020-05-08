package com.example.lab11.repository;

import com.example.lab11.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Player findPlayerById(String id);

    void deleteById(String id);

}
