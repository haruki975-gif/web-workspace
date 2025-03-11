package com.kh.mcdonald.model;

import java.util.List;

import com.kh.mcdonald.model.dao.UserDAO;
import com.kh.mcdonald.model.dto.UserDTO;

public class UserService {
	
	UserDAO userDao = new UserDAO();
	
	public List<UserDTO> findAll(){
		return userDao.findAll();
	}
}
