package com.bank.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Configuration.AuthRequest;
import com.bank.Configuration.JwtUtil;
import com.bank.Dto.UserDto;
import com.bank.Entity.User;
import com.bank.Exception.UserException;
import com.bank.Service.UserServiceImpl;
import com.bank.enums.UserRole;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl service;
	
	 @Autowired 
	 private AuthenticationManager authManager;
	    @Autowired 
	    private JwtUtil jwtUtil;

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody AuthRequest request) throws UserException {
	        authManager.authenticate(new UsernamePasswordAuthenticationToken(
	                request.getEmail(), request.getPassword()
	        ));

	        final UserDetails userDetails = service.UserServiceImpl(request.getEmail());
	        final String token = jwtUtil.generateToken(userDetails.getUsername());

	        return ResponseEntity.ok(token);
	    }
	
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(UserRole role,UserDto request) throws UserException{
		
		return new ResponseEntity<>(service.createUser(request, role),HttpStatus.CREATED);
		
	}
	
	
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<User> getuser(@PathVariable(name="id") String userId) throws UserException{
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
	public ResponseEntity<String> deleteUser(@PathVariable(name="id") String userId) throws UserException{
		String deleteuser = service.deleteuser(userId);
		return new ResponseEntity<>(deleteuser,HttpStatus.OK);
	}
	
}
