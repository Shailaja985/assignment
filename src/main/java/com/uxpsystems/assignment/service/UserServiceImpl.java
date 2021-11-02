package com.uxpsystems.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserRepository;
import com.uxpsystems.assignment.domain.User;
import com.uxpsystems.assignment.exception.DuplicateUserException;
import com.uxpsystems.assignment.exception.EmptyInputException;
import com.uxpsystems.assignment.exception.NoUserRecordException;
import com.uxpsystems.assignment.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		List<User> users=userRepository.findAll();
		if(null ==users || users.isEmpty()) {
			throw new NoUserRecordException("No user records found");
		}
		return users;
	}

	@Override
	public User findById(long id) {
		Optional<User> result = userRepository.findById(id);
		User user = null;
		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new EmptyInputException("User not exist with id = " + id);
		}
		return user;
	}

	@Override
	public User save(User user) throws Exception {
		User userCreated=null;
		if(user.getUsername().isEmpty() || user.getUsername().length()==0) {
			throw new EmptyInputException("username field is empty,please provide username");
		}else if(user.getPassword().isEmpty() || user.getPassword().length()==0){
			throw new EmptyInputException("password field is empty,please provide password");
		}else {
			try {
				userCreated = userRepository.save(user);
			}catch(DataAccessException exc) {
				throw new DuplicateUserException("Username is already exists,please choose a different username");
			}
			catch(Exception exc) {
				throw new Exception(exc.getMessage());
			}
			return userCreated;
		}
	}

	@Override
	public void deleteByID(long id) {
		User user=findById(id);
		if(user==null) {
			throw new UserNotFoundException("User is not exist with id = "+id);
		}
		userRepository.deleteById(id);
	}

}
