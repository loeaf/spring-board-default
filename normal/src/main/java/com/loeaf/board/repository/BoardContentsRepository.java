package com.loeaf.board.repository;

import com.loeaf.board.domain.BoardContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardContentsRepository extends JpaRepository<BoardContent, Long> {
    BoardContent findBoardContentById(Long id);
    Page<BoardContent> findAll(Pageable pageable);
    boolean existsById(Long id);
    List<BoardContent> findAllById(Long id);
}
