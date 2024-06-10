package com.smartjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjava.demo.model.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>{

}
