package com.Enterprise.projeto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.Enterprise.projeto.entities.Users;

@Service
public interface UsersRepository extends JpaRepository<Users, Long> {

}
