package com.eradaw.springProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eradaw.springProject.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
