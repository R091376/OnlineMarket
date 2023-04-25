package com.khasim.market.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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

import com.khasim.market.dto.UserDto;
import com.khasim.market.entity.User;
import com.khasim.market.exception.ResourceNotFoundException;
import com.khasim.market.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserRepository userRepository;

	/** comment generated using Shift-Alt-J command
	 * 
	 * @return List<User> all users from database
	 */
	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUsers(@PathVariable Long id) throws ResourceNotFoundException {
		User dbUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for id ::"+id));
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(dbUser, userDto);
		logger.info("fetching user completed");
		return ResponseEntity.ok().body(userDto);
	}
	
	@PostMapping
	public ResponseEntity<UserDto> addUser(@Valid @RequestBody User user) {
		userRepository.save(user);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		logger.info("user creation completed");
		return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) throws ResourceNotFoundException {
		User dbUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for id ::"+id));
		dbUser.setPhoneNumber(userDto.getPhoneNumber());
		dbUser.setEmail(userDto.getEmail());
		userRepository.save(dbUser);
		UserDto updatedDto = new UserDto();
		BeanUtils.copyProperties(dbUser, updatedDto);
		return ResponseEntity.ok(updatedDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) throws ResourceNotFoundException {
		User dbUser = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for id ::"+id));
		userRepository.delete(dbUser);
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(dbUser, userDto);
		return ResponseEntity.ok("User deleted successfully");
	}
	
}
