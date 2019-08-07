package com.aifangyang.aifangyangcore.service;

import com.aifangyang.aifangyangcore.model.system.request.User;

public interface LoginService {
    /**
     * check user info
     * @param user userInfo
     * @return is real
     */
    boolean isUserExists(User user);
}
