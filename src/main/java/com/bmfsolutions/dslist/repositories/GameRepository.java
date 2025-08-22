package com.bmfsolutions.dslist.repositories;

import com.bmfsolutions.dslist.entities.Game;
import com.bmfsolutions.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
   @Query(nativeQuery = true, value= """
       SELECT g.id, g.title, g.game_year as gameYear, g.img_url as imgUrl, g.short_description as shortDescription, b.position
       FROM tb_game g
       INNER JOIN tb_belonging b ON g.id = b.game_id
       WHERE b.list_id = :listId
       ORDER BY b.position
       """)
   List<GameMinProjection> searChByList(Long listId);
}
