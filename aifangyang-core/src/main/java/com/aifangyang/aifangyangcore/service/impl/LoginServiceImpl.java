package com.aifangyang.aifangyangcore.service.impl;

import com.aifangyang.aifangyangcore.model.system.request.User;
import com.aifangyang.aifangyangcore.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean isUserExists(User user) {
        return true;
    }
}
