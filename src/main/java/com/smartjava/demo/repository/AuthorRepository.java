package com.smartjava.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartjava.demo.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
