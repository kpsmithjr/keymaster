package com.spectre.keymaster.key;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="_keys")
@Getter
@Setter
public class Key {
  @Id
  @GeneratedValue
  @Column(
    name = "id",
    updatable = false
  )  
  private Long id;

  @Column(
    name = "key_type_id",
    nullable = false,
    columnDefinition = "INT"
  )
  private int typeId;
  
  @Column(
    name = "number",
    nullable = false,
    columnDefinition = "INT"
  )
  private int number;

  public Key(Long id, int typeId, int number) {
    
    this.id = id;
    this.typeId = typeId;
    this.number = number;
  }

  public Key(int typeId, int number) {
    this.typeId = typeId;
    this.number = number;
  }

  public Key() {
    
  }

  @Override
  public String toString() {
    return "Key{" + 
            "id=" + id + 
            ", typeId=" + typeId + 
            ", number=" + number +
            '}';
  }
}
