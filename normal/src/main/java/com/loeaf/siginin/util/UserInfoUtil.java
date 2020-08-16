package com.loeaf.siginin.util;

import com.loeaf.siginin.domain.User;
import com.loeaf.siginin.security.CustomUserInfo;
import com.loeaf.siginin.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Data
public class UserInfoUtil {
    @Autowired
    static UserService userService;
    /**
     * 현 유저 권한에 대한 정보를 가져온다.
     * @return
     */
    public static CustomUserInfo get() {
        CustomUserInfo userDetails = (CustomUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }
    /**
     * 현 유저 권한에 대한 정보를 가져온다.
     * @return
     */
    public static User getMyUserObj() {
        CustomUserInfo userDetails = (CustomUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var p = userService.findByUk(User.builder().email(userDetails.getEmail()).build());
        return p;
    }
}
