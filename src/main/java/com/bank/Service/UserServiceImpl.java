package com.bank.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.Entity.User;
import com.bank.Exception.UserException;
import com.bank.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository usrepo;
	
	@Override
	public User addUser(User user) throws UserException {
		if(usrepo.existsByemail(user.getEmail())){
			throw new UserException("user email already exist");
		}else {
			User userdetails = usrepo.save(user);
			return userdetails;
		}
		
	}

	@Override
	public User userbyId(Long userId) throws UserException {
		User userdetails = usrepo.findById(userId).get();
		if(userdetails.getUserId()==userId) {
			return userdetails;
		}else {
			throw new UserException("user id was not found");
		}
	}

	@Override
	public List<User> getLsit() {
		List<User> list = usrepo.findAll();
		return list;
	}

	@Override
	public User updateUser(User user, String email) throws UserException {
		
		User byEmail = usrepo.findByEmail(email);
		if(byEmail.getEmail()==email) {
			
			throw new UserException(" given email was not found");
		}else {
			byEmail.setPassword(user.getPassword());
			byEmail.setPhoneNumber(user.getPhoneNumber());
			User save = usrepo.save(byEmail);
			return save;
			
		}
	}



	@Override
	public String deleteuser(Long userId) throws UserException {
		User user = usrepo.findById(userId).get();
		if(user.getUserId()==userId) {
			usrepo.deleteById(userId);
			return "user deleted successfully";
		}else {
			throw new UserException("userid was not found");
		}
	}


}
