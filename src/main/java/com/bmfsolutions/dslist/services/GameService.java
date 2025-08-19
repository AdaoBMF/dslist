package com.bmfsolutions.dslist.services;

import java.util.List;
import com.bmfsolutions.dslist.dto.GameMinDTO;
import com.bmfsolutions.dslist.entities.Game;
import com.bmfsolutions.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
