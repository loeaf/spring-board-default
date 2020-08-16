package com.loeaf.board.service.impl;

import com.loeaf.board.domain.Board;
import com.loeaf.board.repository.BoardRepository;
import com.loeaf.board.service.BoardService;
import com.loeaf.siginin.domain.User;
import com.loeaf.siginin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl extends BoardService {
    private final BoardRepository boardRepository;

    @Override
    public Board save(Board board) {
        return this.boardRepository.save(board);
    }

    @Override
    public List<Board> findAll() {
        ArrayList<Board> result = new ArrayList<>();
        this.boardRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Board> findAllById(Long id) {
        ArrayList<Board> result = new ArrayList<>();
        this.boardRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Page<Board> findAllByPage(Pageable pageable) {
        return this.boardRepository.findAll(pageable);
    }

    @Override
    public boolean existVoByUk(Board vo) {
        return this.boardRepository.existsById(vo.getId());
    }

    @Override
    public Board findByUk(Board vo) {
        return this.boardRepository.findBoardById(vo.getId());
    }

    @Override
    public List<Board> findAllByUk(Board vo) {
        return this.boardRepository.findAllById(vo.getId());
    }

    @Override
    public void deleteByVo(Board vo) {
        this.boardRepository.delete(vo);
    }

}
