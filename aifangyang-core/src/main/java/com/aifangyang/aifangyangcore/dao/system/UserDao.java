package com.aifangyang.aifangyangcore.dao.system;

import com.aifangyang.aifangyangcore.model.po.system.UserPo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息查询
 */
public interface UserDao extends JpaRepository<UserPo,Integer> {
    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return 是否有该用户
     */
    UserPo findByUserName(String userName);
}
