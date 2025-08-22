package com.bmfsolutions.dslist.services;

import com.bmfsolutions.dslist.dto.GameListDTO;
import com.bmfsolutions.dslist.entities.GameList;
import com.bmfsolutions.dslist.projections.GameMinProjection;
import com.bmfsolutions.dslist.repositories.GameListRepository;
import com.bmfsolutions.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList gameList =  gameListRepository.findById(id).get();
        return new GameListDTO(gameList);
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIdx, int targetIdx) {
        List<GameMinProjection> list = gameRepository.searChByList(listId);

        GameMinProjection gameObj = list.remove(sourceIdx);
        list.add(targetIdx, gameObj);

        int min = Math.min(sourceIdx, targetIdx);
        int max = Math.max(sourceIdx, targetIdx);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
