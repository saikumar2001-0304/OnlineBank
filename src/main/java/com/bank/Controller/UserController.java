package com.bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Dto.UserDto;
import com.bank.Entity.User;
import com.bank.Exception.UserException;
import com.bank.Service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	
	@PostMapping("create")
	public ResponseEntity<UserDto> createUser(UserDto request){
		
		return new ResponseEntity<>(service.createUser(request),HttpStatus.CREATED);
		
	}
	
	
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserException{
		User user2 = service.addUser(user);
		return new ResponseEntity<>(user2,HttpStatus.CREATED);
	}
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getuser(@PathVariable(name="id") Long userId) throws UserException{
		User userbyId = service.userbyId(userId);
		return new ResponseEntity<>(userbyId,HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<User>> getAll(){
		List<User> list = service.getLsit();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@PutMapping("/update/{email}")
	public ResponseEntity<User> updateuser(@RequestBody User user,@PathVariable(name="email") String email) throws UserException{
		
		User user2 = service.updateUser(user, email);
		
		return new ResponseEntity<>(user2,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(name="id") Long userId) throws UserException{
		String deleteuser = service.deleteuser(userId);
		return new ResponseEntity<>(deleteuser,HttpStatus.OK);
	}
	
}
