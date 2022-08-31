package com.spectre.keymaster.request;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "request")
@Getter
@Setter
public class Request {
  @Id
  @GeneratedValue
  @Column(
    name = "id",
    updatable = false
  )
  private Long id;

  @Column(
    name = "personnelId",
    nullable = false,
    columnDefinition = "INT"
  )
  private Long personnelId;

  @Column(
    name = "reason",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String reason;

  @Column(
    name = "requestStatus",
    nullable = false,
    columnDefinition = "INT"
  )
  private Long requestStatus;

  @Column(
    name = "keyId",
    nullable = false,
    columnDefinition = "INT"
  )
  private Long keyId;

  @Column(
    name = "issuer",
    nullable = false,
    columnDefinition = "TEXT"
  )
  private String issuer;

  @Column(
    name = "issued_date",
    columnDefinition = "DATE"
  )
  private LocalDate issuedDate;

  @Column(
    name = "due_date",
    columnDefinition = "DATE"
  )
  private LocalDate dueDate;

  public Request(Long id,
                  Long personnelId,
                  String reason,
                  Long requestStatus,
                  Long keyId,
                  String issuer,
                  LocalDate issuedDate,
                  LocalDate dueDate) {
    this.id = id;
    this.personnelId = personnelId;
    this.reason = reason;
    this.requestStatus = requestStatus;
    this.keyId = keyId;
    this.issuer = issuer;
    this.issuedDate = issuedDate;
    this.dueDate = dueDate;
  }

  public Request(Long personnelId,
                  String reason,
                  Long requestStatus,
                  Long keyId,
                  String issuer,
                  LocalDate issuedDate,
                  LocalDate dueDate) {
    this.personnelId = personnelId;
    this.reason = reason;
    this.requestStatus = requestStatus;
    this.keyId = keyId;
    this.issuer = issuer;
    this.issuedDate = issuedDate;
    this.dueDate = dueDate;
  }

  public Request() {}


}
