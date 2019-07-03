package com.cdut.service;

import com.cdut.model.User;

import java.util.List;

public interface IUserService {
    //保存方法
    public void save(User user);
    //根据id查询
    public User getUserById(int id);
    //查询所有用户
    public List<User> getAll();

}
