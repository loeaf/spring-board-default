package com.loeaf.siginin.repository;

import com.loeaf.siginin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    User findUserByEmail(String email);

    boolean existsByNickName(String nickName);
}
