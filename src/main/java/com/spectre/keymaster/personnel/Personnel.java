package com.spectre.keymaster.personnel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personnel")
@Getter
@Setter
public class Personnel {

  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
  private String firstName;

  @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
  private String lastName;

  @Column(name = "suffix", columnDefinition = "TEXT")
  private String suffix;

  @Column(name = "email", nullable = false, columnDefinition = "TEXT")
  private String email;

  @Column(name = "phone", nullable = false, columnDefinition = "TEXT")
  private String phone;

  public Personnel(Long id,
      String firstName,
      String lastName,
      String email,
      String phone) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public Personnel(String firstName,
      String lastName,
      String email,
      String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public Personnel() {
  }

  @Override
  public String toString() {
    return "Personnel{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", phone=" + phone +
        '}';
  }
}
