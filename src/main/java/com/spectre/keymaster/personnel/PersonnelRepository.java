package com.spectre.keymaster.personnel;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

  @Query("SELECT p FROM Personnel p where p.firstName = ?1 AND p.lastName = ?2 AND p.suffix = ?3 AND p.email = ?4 AND p.phone = ?5")
  Optional<Personnel> findPersonnelByAll(String firstName, String lastName, String suffix, String email, String phone);

  @Query("SELECT p FROM Personnel p where p.firstName = ?1 AND p.lastName = ?2 AND p.suffix = ?3")
  Optional<Personnel> findPersonnelByFullName(String firstName, String lastName, String suffix);  
}
