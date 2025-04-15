package com.ust.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.security.entity.Policy;

@Repository
public interface PolicyRepository extends JpaRepository <Policy,Long>{

}
