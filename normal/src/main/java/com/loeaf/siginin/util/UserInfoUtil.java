package com.loeaf.siginin.util;

import com.loeaf.siginin.security.CustomUserInfo;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserInfoUtil <T> {
    public static CustomUserInfo get() {
        CustomUserInfo userDetails = (CustomUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }
}
