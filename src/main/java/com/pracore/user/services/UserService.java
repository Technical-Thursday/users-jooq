package com.pracore.user.services;

import com.pracore.user.repo.UserRepo;

import java.util.List;

import com.pracore.user.models.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public List<UserModel> getAll() {
		return userRepo.getUsers();
	}
	
}