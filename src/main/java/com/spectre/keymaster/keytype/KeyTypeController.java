package com.spectre.keymaster.keytype;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/keytype")
public class KeyTypeController {
  private final KeyTypeService keyTypeService;

  @Autowired
  public KeyTypeController(KeyTypeService keyTypeService) {
    this.keyTypeService = keyTypeService;
  }

  @GetMapping
  public List<KeyType> getKeyTypes() {
    return keyTypeService.getKeyTypes();
  }

  @PostMapping
  public void addNewKeyType(@RequestBody KeyType keyType) {
    keyTypeService.addNewKeyType(keyType);
  }

  @DeleteMapping(path = "{keyTypeId}")
  public void deleteKeyType(@PathVariable("keyTypeId") Long keyTypeId) {
    keyTypeService.deleteKeyType(keyTypeId);
  }
  
  @PutMapping(path = "{keyTypeId}")
  public void updateKeyType(@PathVariable("keyTypeId") Long id,
                            @RequestParam(required = false) String type,
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) String longDescription) {
    keyTypeService.updateKeyType(id, type, description, longDescription);
  }
}
