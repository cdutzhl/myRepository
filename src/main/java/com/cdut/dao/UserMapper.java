package com.cdut.dao;

import com.cdut.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //保存方法
    public void save(User user);
    //更具id查询
    public User getUserById(int id);
    //查询所有用户
    public List<User> getAll();

}
