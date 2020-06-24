package com.pracore.user.repo;

import java.util.List;

import static com.pracore.user.jooq.tables.Users.USERS;
import com.pracore.user.models.UserModel;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
	
	@Autowired
	DSLContext jooqDslContext;

	public List<UserModel> getUsers() {
		return jooqDslContext.select(USERS.FIRST_NAME, USERS.LAST_NAME)
		.from(USERS)
		.fetchInto(UserModel.class);
	}
}