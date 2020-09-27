package com.loeaf.board.service.impl;

import com.loeaf.board.domain.Board;
import com.loeaf.board.domain.BoardContent;
import com.loeaf.board.repository.BoardContentRepository;
import com.loeaf.board.service.BoardContentService;
import com.loeaf.common.misc.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class BoardContentServiceImpl
        extends ServiceImpl<BoardContentRepository, BoardContent, Long>
        implements BoardContentService {
    private final BoardContentRepository jpaRepo;

    @PostConstruct
    private void init() {
        super.set(jpaRepo, new BoardContent());
    }
}
