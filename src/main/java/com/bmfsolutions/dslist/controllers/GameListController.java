package com.bmfsolutions.dslist.controllers;

import com.bmfsolutions.dslist.dto.GameListDTO;
import com.bmfsolutions.dslist.dto.GameMinDTO;
import com.bmfsolutions.dslist.services.GameListService;
import com.bmfsolutions.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findById(@PathVariable Long id) {
        return gameListService.findById(id);
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findGamesByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
