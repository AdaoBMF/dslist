package com.bmfsolutions.dslist.repositories;

import com.bmfsolutions.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {}
