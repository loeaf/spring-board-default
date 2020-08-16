package com.loeaf.board.controller;

import com.loeaf.board.domain.Board;
import com.loeaf.board.domain.BoardContent;
import com.loeaf.board.model.BoardForm;
import com.loeaf.board.model.PaginatorInfo;
import com.loeaf.board.service.BoardContentsService;
import com.loeaf.board.service.BoardService;
import com.loeaf.board.types.PageSize;
import com.loeaf.board.util.Paginator;
import com.loeaf.siginin.domain.User;
import com.loeaf.siginin.security.CustomUserInfo;
import com.loeaf.siginin.service.UserService;
import com.loeaf.siginin.util.UserInfoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final BoardContentsService boardContentsService;
    private final UserService userService;

    @GetMapping("/boards")
    public String getNoticePage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            Model model) {

        Page<Board> noticePage =boardService.findAllPgByStartPg(page -1, PageSize.NOTICE.getContent());
        model.addAttribute("boardPage", noticePage);

        PaginatorInfo pageNav = Paginator.getPagenatorMap(noticePage, PageSize.NOTICE);
        model.addAttribute("pageInfo", pageNav);

        return "boards";
    }

    @GetMapping("/boards/{id}")
    public String getNotice(@PathVariable(value = "id") Long id, Model model) {
        Board board = boardService.findOneById(id);
        model.addAttribute("board", board);
        return "content";
    }

    @PostMapping("/board")
    public String addNotice(@Valid @ModelAttribute BoardForm boardForm) {
        boardForm2Board(boardForm);
        return "redirect:/notices";
    }

    @DeleteMapping("/board/{id}")
    public String deleteNotice(@PathVariable(value = "id") Long id) {
        boardService.deleteAllById(id);
        return "redirect:/notices";
    }

    @PutMapping("/board")
    public String modifyNotice(@Valid @ModelAttribute BoardForm boardForm) {
        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        boardService.update(board);
        return "redirect:/notices";
    }

    @GetMapping("/edit")
    public String getEditForm() {
        return "edit";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable(value = "id") Long id, Model model) {
//        Notice notice = noticeService.getNotice(id);
//        model.addAttribute("notice", notice);
        return "edit";
    }

    private Board boardForm2Board(BoardForm boardForm) {
        BoardContent boardContent = boardContentsService.save(
                BoardContent.builder().content(boardForm.getContent()).build());
        CustomUserInfo customUserInfo = UserInfoUtil.get();

        User user = userService.findByUk(User.builder().email(customUserInfo.getEmail()).build());

        return Board.builder()
                .title(boardForm.getTitle())
                .boardContent(boardContent)
                .user(user)
                .build();
    }


}
