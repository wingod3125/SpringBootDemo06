package com.wg.SpringBootDemo06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wg.SpringBootDemo06.dto.User;
import com.wg.SpringBootDemo06.mapper.UserMapper;
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;
	
	public List<User> find(){
		return userMapper.find();
	}

	public User findById(int id) {
		return userMapper.findById(id);
	}

	public void add(User user) {
		userMapper.add(user);
	}

	public void delete(int id) {
		userMapper.delete(id);
	}

	public void update(User user) {
		userMapper.update(user);
	}
}
