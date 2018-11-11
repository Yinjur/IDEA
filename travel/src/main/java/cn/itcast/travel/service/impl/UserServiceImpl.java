package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @Description: java类作用描述
 * @Author: qyj
 * @CreateDate: 2018/10/11  22:10
 * @Version: 1.0
 */

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册Service
     * @param user
     * @return
     */
    @Override
    public Boolean regist(User user) {
        // 根据用户名查询用户对象
        User u = userDao.findByUsername(user.getUsername());
        // 判断 u 是否为空
        if (u != null) {
            // 用户名存在，注册失败
            return false;
        }
        // 注册成功
        // 保存用户信息
        // 设置激活码
        user.setCode(UuidUtil.getUuid());
        // 设置激活状态
        user.setStatus("N");
        userDao.save(user);

        sendMail(user);

        return true;
    }

    /**
     * 激活
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        // 判断 校验码是否正确
        if (user != null) {
            // 调用 dao 的修改激活状态方法
            userDao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 登录验证查询
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    /**
     * 发送邮件
     * @param user
     */
    public void sendMail(User user){
        // 激活邮件发送，邮件正文
        String content = "<a href='http://localhost/travel/user/active?code="+ user.getCode()+"'>点击激活【黑马旅游网】</a>";
        System.out.println(content);
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
    }
}
