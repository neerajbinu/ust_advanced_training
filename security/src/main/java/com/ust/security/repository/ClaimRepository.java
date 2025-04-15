package com.ust.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.security.entity.Claim;


@Repository
public interface ClaimRepository extends JpaRepository <Claim,Long>{

}
