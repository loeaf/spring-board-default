package com.loeaf.board.repository;

import com.loeaf.board.domain.Board;
import com.loeaf.siginin.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findBoardById(Long id);
    Page<Board> findAll(Pageable pageable);
    boolean existsById(Long id);
    List<Board> findAllById(Long id);
}
