package com.loeaf.board.service.impl;

import com.loeaf.board.domain.Board;
import com.loeaf.board.repository.BoardRepository;
import com.loeaf.board.service.BoardService;
import com.loeaf.common.misc.ServiceImpl;
import com.loeaf.siginin.domain.User;
import com.loeaf.siginin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl
        extends ServiceImpl<BoardRepository, Board, Long>
        implements BoardService {
    private final BoardRepository jpaRepo;

    @PostConstruct
    private void init() {
        super.set(jpaRepo, new Board());
    }
}
