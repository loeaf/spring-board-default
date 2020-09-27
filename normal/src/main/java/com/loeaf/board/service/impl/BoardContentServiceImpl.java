package com.loeaf.board.service.impl;

import com.loeaf.board.domain.Board;
import com.loeaf.board.domain.BoardContent;
import com.loeaf.board.repository.BoardContentsRepository;
import com.loeaf.board.repository.BoardRepository;
import com.loeaf.board.service.BoardContentService;
import com.loeaf.board.service.BoardService;
import com.loeaf.common.misc.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardContentServiceImpl
        extends ServiceImpl<BoardContentsRepository, BoardContent, Long>
        implements BoardContentService {
}
