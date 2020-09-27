package com.loeaf.siginin.service.impl;

import com.loeaf.board.domain.Board;
import com.loeaf.board.repository.BoardRepository;
import com.loeaf.board.service.BoardService;
import com.loeaf.common.misc.ServiceImpl;
import com.loeaf.siginin.domain.Role;
import com.loeaf.siginin.domain.User;
import com.loeaf.siginin.exception.DuplicateDataException;
import com.loeaf.siginin.repository.RoleRepository;
import com.loeaf.siginin.repository.UserRepository;
import com.loeaf.siginin.service.RoleService;
import com.loeaf.siginin.service.UserService;
import com.loeaf.siginin.types.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        extends ServiceImpl<UserRepository, User, Long>
        implements UserService {
    private final UserRepository userRepository;

    @PostConstruct
    private void init() {
        super.set(userRepository, new User());
    }
    @Override
    public Boolean findByNickName(String nickName) {
        return userRepository.findByNickName(nickName);
    }
}
