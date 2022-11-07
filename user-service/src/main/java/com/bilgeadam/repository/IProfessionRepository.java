package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Department;
import com.bilgeadam.repository.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfessionRepository extends JpaRepository<Profession, Long> {
}
