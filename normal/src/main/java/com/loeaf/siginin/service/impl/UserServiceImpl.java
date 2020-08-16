package com.loeaf.siginin.service.impl;

import com.loeaf.siginin.domain.Role;
import com.loeaf.siginin.domain.User;
import com.loeaf.siginin.exception.DuplicateDataException;
import com.loeaf.siginin.repository.RoleRepository;
import com.loeaf.siginin.repository.UserRepository;
import com.loeaf.siginin.service.UserService;
import com.loeaf.siginin.types.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        checkDuplication(user);
        encodePassword(user);
        setRoles(user);

        return this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> result = new ArrayList<>();
        this.userRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<User> findAllById(Long id) {
        ArrayList<User> result = new ArrayList<>();
        this.userRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public boolean existVoByUk(User vo) {
        return this.userRepository.existsByEmail(vo.getEmail());
    }

    @Override
    public User findByUk(User vo) {
        return this.userRepository.findUserByEmail(vo.getEmail());
    }

    @Override
    public List<User> findAllByUk(User vo) {
        return null;
    }

    @Override
    public void deleteByVo(User vo) {
        this.userRepository.delete(vo);
    }

    private void checkDuplication(User user) {
        var existsEmail = userRepository.existsByEmail(user.getEmail());
        if (existsEmail) {
            throw new DuplicateDataException(user.getEmail());
        }
        var existsNick = userRepository.existsByNickName(user.getNickName());
        if (existsNick) {
            throw new DuplicateDataException(user.getEmail());
        }
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    private void setRoles(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findRoleByAuthority(Authority.USER));
        user.setRoles(roles);
    }
}
