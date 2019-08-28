package com.aifangyang.aifangyangcore.service;

import com.aifangyang.aifangyangcore.model.po.system.UserPo;
import com.aifangyang.aifangyangcore.model.request.User;

import java.util.List;

public interface LoginService {
    /**
     * check user info
     * @param user userInfo
     * @return is real
     */
    boolean isUserExists(User user);

    List<UserPo> selectAll();
}
