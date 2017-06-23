package com.wg.SpringBootDemo06.controller;

import java.util.List;

import org.apache.commons.collections4.Put;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wg.SpringBootDemo06.dto.User;
import com.wg.SpringBootDemo06.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> r = userService.find();
		return r;
	}
	
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.findById(id);
    }
	
	@ApiOperation(value="创建用户", notes="根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value="", method=RequestMethod.POST)
	public String addUser(@RequestBody User user){
		userService.add(user);
		return "success";
	}
	
	@ApiOperation(value="删除指定用户",notes="根据URL的id删除指定用户信息")
	@ApiImplicitParam(name="id",value="用户id",required = true, dataType = "int", paramType = "path")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable int id){
		userService.delete(id);
		return "success";
	}
	
	@ApiOperation(value="更改用户", notes="根据User对象更改用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value="", method=RequestMethod.PUT)
	public String update(@RequestBody User user){
		userService.update(user);
		return "success";
	}
}
