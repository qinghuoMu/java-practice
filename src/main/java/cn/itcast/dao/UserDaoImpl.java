package cn.itcast.dao;

import cn.itcast.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(long id) {
        return this.sqlSession.selectOne("UserDaoMapper.queryUserById",id);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("UserDaoMapper.queryUserAll");
    }

    @Override
    public void save(User user) {
        this.sqlSession.insert("UserDaoMapper.save",user);
        this.sqlSession.commit();
    }

    @Override
    public void update(User user) {
        this.sqlSession.update("UserDaoMapper.updateUser", user);
        this.sqlSession.commit();

    }

    @Override
    public void deleteById(long id) {
        this.sqlSession.delete("UserDaoMapper.deleteUserById", id);
        this.sqlSession.commit();

    }
}
