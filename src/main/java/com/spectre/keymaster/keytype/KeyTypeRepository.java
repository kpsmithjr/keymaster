package com.spectre.keymaster.keytype;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyTypeRepository extends JpaRepository<KeyType, Long>{

  @Query("SELECT k FROM KeyType k WHERE k.type = ?1")
  Optional<KeyType> findAllByType(String type);
  
}
