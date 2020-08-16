package com.loeaf.board.service.impl;

import com.loeaf.board.domain.Board;
import com.loeaf.board.domain.BoardContent;
import com.loeaf.board.repository.BoardContentsRepository;
import com.loeaf.board.service.BoardContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardContentsServiceImpl extends BoardContentsService {
    private final BoardContentsRepository boardContentsRepository;


    @Override
    public BoardContent save(BoardContent board) {
        return this.boardContentsRepository.save(board);
    }

    @Override
    public List<BoardContent> findAll() {
        ArrayList<BoardContent> result = new ArrayList<>();
        this.boardContentsRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<BoardContent> findAllById(Long id) {
        ArrayList<BoardContent> result = new ArrayList<>();
        this.boardContentsRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Page<BoardContent> findAllByPage(Pageable pageable) {
        return this.boardContentsRepository.findAll(pageable);
    }

    @Override
    public boolean existVoByUk(BoardContent vo) {
        return this.boardContentsRepository.existsById(vo.getId());
    }

    @Override
    public BoardContent findByUk(BoardContent vo) {
        return this.boardContentsRepository.findBoardContentById(vo.getId());
    }

    @Override
    public List<BoardContent> findAllByUk(BoardContent vo) {
        return this.boardContentsRepository.findAllById(vo.getId());
    }

    @Override
    public void deleteByVo(BoardContent vo) {
        this.boardContentsRepository.delete(vo);
    }
}
