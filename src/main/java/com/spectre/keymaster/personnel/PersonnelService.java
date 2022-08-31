package com.spectre.keymaster.personnel;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonnelService {
  private final PersonnelRepository personnelRepositoty;

  @Autowired
  public PersonnelService(PersonnelRepository personnelRepositoty) {
    this.personnelRepositoty = personnelRepositoty;
  }

  public List<Personnel> getPersonnel() {
    return personnelRepositoty.findAll();
  }

  public void addNewPersonnel(Personnel personnel) {
    Optional<Personnel> personnelOptional = personnelRepositoty
      .findPersonnelByFullName(personnel.getFirstName(),
                          personnel.getLastName(),
                          personnel.getSuffix());

    if (personnelOptional.isPresent()) {
      throw new IllegalStateException("Personnel already exists");
    }
    personnelRepositoty.save(personnel);
  }

  public void deletePersonnel(Long personnelId) {
    boolean exists = personnelRepositoty.existsById(personnelId);
    if (!exists)     {
      throw new IllegalStateException(
      "pesonnel with id" + personnelId + " does not exist");
    }
    personnelRepositoty.deleteById(personnelId);
  }

  @Transactional
  public void updatePersonnel(Long personnelId,
                              String firstName,
                              String lastName,
                              String suffix,
                              String email,
                              String phone) {
    Personnel personnel = personnelRepositoty.findById(personnelId)
      .orElseThrow(() -> new IllegalStateException(
        "personnel with id " + personnelId + " does not exists"));
    
    if(firstName != null && firstName.length() > 0 &&
      !Objects.equals(firstName, personnel.getFirstName())) {
        personnel.setFirstName(firstName);
    }

    if(lastName != null && lastName.length() > 0 &&
      !Objects.equals(lastName, personnel.getLastName())) {
        personnel.setLastName(lastName);
    }

    if(!Objects.equals(suffix, personnel.getSuffix())) {
      personnel.setSuffix(suffix);
    }

    if(email != null && email.length() > 0 &&
      !Objects.equals(email, personnel.getEmail())) {
        personnel.setEmail(email);
    }

    if(phone != null && phone.length() > 0 &&
      !Objects.equals(phone, personnel.getPhone())) {
        personnel.setPhone(phone);
    }

  }  
}
