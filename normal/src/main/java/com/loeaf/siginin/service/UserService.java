package com.loeaf.siginin.service;

import com.loeaf.common.misc.Service;
import com.loeaf.siginin.domain.User;

public interface UserService extends Service<User, Long> {
    User save(User user);
}
