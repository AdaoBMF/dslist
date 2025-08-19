package com.bmfsolutions.dslist.services;

import java.util.List;

import com.bmfsolutions.dslist.dto.GameDTO;
import com.bmfsolutions.dslist.dto.GameMinDTO;
import com.bmfsolutions.dslist.entities.Game;
import com.bmfsolutions.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game =  gameRepository.findById(id).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
