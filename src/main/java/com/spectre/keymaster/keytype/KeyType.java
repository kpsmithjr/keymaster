package com.spectre.keymaster.keytype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "key_type")
@Getter
@Setter
public class KeyType {
    
  @Id
  @GeneratedValue
  @Column(
    name = "id",
    updatable = false
  )
  private Long id;

  @Column(
    name = "type",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String type;

  @Column(
    name = "description",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String description;

  @Column(
    name = "long_description",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String longDescription;

  public KeyType(Long id, String type, String description, String longDescription) {
    this.id = id;
    this.type = type;
    this.description = description;
    this.longDescription = longDescription;
  }

  public KeyType(String type, String description, String longDescription) {    
    this.type = type;
    this.description = description;
    this.longDescription = longDescription;
  }

  public KeyType() {}

  @Override
  public String toString() {
    return "KeyType{" + 
            "id=" +  id +
            ", type=" + type + 
            ", desctiption='" +  description + '\'' +
            ", longDescription='" + longDescription + '\'' +
            '}';
  }
}
