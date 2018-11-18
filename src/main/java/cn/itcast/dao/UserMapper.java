package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


public interface UserMapper {

    /**根据多个用户id查询用户信息
     * @param ids
     * @return
     */
    public List<User> queryUserListByIds(@Param("ids")Long[] ids);
    /**
     * 修改用户信息，如果用户的某一项信息为null，则不修改
     */
    public void updateUserSelective(User user);

    public List<User> queryUserListlikeUsernameAndAge(@Param("username") String username, @Param("age") int age);
    /**查询男性用户，如果输入了用户名则按照用户名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找用户名为“zhangsan”的用户。
     * @param username
     * @param age
     * @return
     */
    public List<User> queryUserListLikeQueryNameOrAge(@Param("userName") String username, @Param("age") int age);
    /**查询男性用户，如果输入了用户名，按用户名模糊查询
     * @param userName
     * @return
     */
    public List<User> queryUserListLikeUserName(@Param("userName")String userName);
    /**根据用户名模糊查询
     * @param username
     * @return
     */
    public List<User> queryUserByLikeUsername(String username);
    /**根据hashmap查询用户
     * @param map
     * @return
     */
    public User loginUp(HashMap<String,String>map);
    /**根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
    /**根据表明查询用户信息
     * @param tableName
     * @return
     */
    public List<User>queryUserByTableName(@Param("tableName") String tableName);
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
