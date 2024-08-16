package com.Enterprise.projeto.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Enterprise.projeto.entities.Users;
import com.Enterprise.projeto.service.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResources {

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		List<Users> list = usersService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(usersService.findById(id));
	
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		usersService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@PostMapping
	public ResponseEntity<Users> insertUser(@RequestBody Users users){
		Users newUser = usersService.insert(users);
		return ResponseEntity.ok().body(newUser);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Long id,  @RequestBody Users users){
		users = usersService.update(id, users);
		return ResponseEntity.ok().body(users);
	}

}
