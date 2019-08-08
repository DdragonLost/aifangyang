package com.aifangyang.aifangyangcore.service.impl;

import com.aifangyang.aifangyangcore.dao.system.UserDao;
import com.aifangyang.aifangyangcore.model.po.system.UserPo;
import com.aifangyang.aifangyangcore.model.request.User;
import com.aifangyang.aifangyangcore.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserDao userDao;
    @Override
    public boolean isUserExists(User user) {
        UserPo userPo = userDao.findByUserName(user.getUserName());
        if (userPo!=null){
            return true;
        }
        return false;
    }
}
