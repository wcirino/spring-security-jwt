package com.projetoSpringSec.Spring.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projetoSpringSec.Spring.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//@Query("select u from User u where u.login =: userName")
	User findBylogin(String userName);
	
}
