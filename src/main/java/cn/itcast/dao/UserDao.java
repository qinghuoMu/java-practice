package cn.itcast.dao;

import cn.itcast.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
   public User queryUserById(long id);

    /**
     * 查询所有
     * @return
     */
   public List<User> queryUserAll();

    /**
     * 保存
     * @param user
     */
   public void save(User user);

    /**
     * 更新
     * @param user
     */
   public void update(User user);

    /**
     *
     * @param id
     */
   public void deleteById(long id);
}
