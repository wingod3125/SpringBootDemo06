package com.wg.SpringBootDemo06.mapper;

import java.util.List;

import com.wg.SpringBootDemo06.dto.User;

public interface UserMapper {
	List<User> find();

	User findById(int id);

	void add(User user);

	void delete(int id);

	void update(User user);
}
