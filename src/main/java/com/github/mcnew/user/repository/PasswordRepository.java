package com.github.mcnew.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.mcnew.user.model.Password;
import com.github.mcnew.user.model.User;

@Repository
public interface PasswordRepository extends CrudRepository<Password, Integer> {

	List<Password> findByActiveTrueAndUserOrderByCreation(User user);

}
