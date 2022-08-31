package com.spectre.keymaster.personnel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/personnel")
public class PersonnelController {
  private final PersonnelService personnelService;

  @Autowired
  public PersonnelController(PersonnelService personnelService) {
    this.personnelService = personnelService;
  }

  @GetMapping
  public List<Personnel> getPersonnel() {
    return personnelService.getPersonnel();
  }

  @PostMapping
  public void addNewPersonnel(@RequestBody Personnel personnel) {
    personnelService.addNewPersonnel(personnel);
  }

  @DeleteMapping(path = "{personnelId}")
  public void deletePersonnel(@PathVariable("personnelId") Long personnelId) {
    personnelService.deletePersonnel(personnelId);
  }

  @PutMapping(path = "{personnelId}")
  public void updatePersonnel(
    @PathVariable("personnelId") Long personnelId,
    @PathVariable(required = false) String firstName,
    @PathVariable(required = false) String lastName,
    @PathVariable(required = false) String suffix,
    @PathVariable(required = false) String email,
    @PathVariable(required = false) String phone ) {
    personnelService.updatePersonnel(personnelId, firstName, lastName, suffix, email, phone);
  }
}
