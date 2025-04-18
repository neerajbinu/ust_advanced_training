package com.ust.securityjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.securityjpa.entity.MyUser;

@Repository
public interface MyUserRepository extends JpaRepository <MyUser,Long>{
	Optional<MyUser> findByUsername(String username);

}
