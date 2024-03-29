package com.loeaf.siginin.repository;

import com.loeaf.siginin.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean findByNickName(String nickName);
}
