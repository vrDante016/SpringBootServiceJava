package com.Enterprise.projeto.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.Repository.UsersRepository;
import com.Enterprise.projeto.entities.Users;
import com.Enterprise.projeto.service.exception.DataBaseException;
import com.Enterprise.projeto.service.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class UsersService {

	@Autowired
	private UsersRepository userRepository;

	public List<Users> findAll() {
		return userRepository.findAll();
	}

	public Users findById(Long id) {
		Optional<Users> users = userRepository.findById(id);
		return users.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	
	public void deleteById(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}

	}

	public Users insert(Users users) {
		return userRepository.save(users);
	}

	
	public Users update(Long id, Users users) {
		try{
			Users entity = userRepository.getReferenceById(id);
			UpdateData(entity, users);
			return userRepository.save(entity);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void UpdateData(Users entity, Users users) {
		entity.setName(users.getName());
		entity.setEmail(users.getEmail());
		entity.setPhone(users.getPhone());

	}
}
