package com.pracore.user.controllers;

import java.util.List;

import com.pracore.user.models.UserModel;
import com.pracore.user.services.UserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/")
	public List<UserModel> index() {
		return userService.getAll();
	}
}