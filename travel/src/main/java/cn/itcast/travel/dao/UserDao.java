package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @Description: java类作用描述
 * @Author: qyj
 * @CreateDate: 2018/10/11  22:08
 * @Version: 1.0
 */

public interface UserDao {

    User findByUsername(String username);

    void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
