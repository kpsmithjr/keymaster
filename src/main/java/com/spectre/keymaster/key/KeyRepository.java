package com.spectre.keymaster.key;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends JpaRepository<Key, Long> {
  
  @Query("SELECT k FROM Key k WHERE k.typeId = ?1 AND k.number = ?2")
  Optional<Key> findKeyByTypeAndNumber(int type_id, int number);
}
