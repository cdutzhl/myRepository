package com.cdut.service.Impl;

import com.cdut.dao.UserMapper;
import com.cdut.model.User;
import com.cdut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public User getUserById(int id) {
       return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
