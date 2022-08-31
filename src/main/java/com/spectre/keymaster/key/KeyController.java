package com.spectre.keymaster.key;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "api/v1/key")
public class KeyController {
  private final KeyService keyService;
  
  @Autowired
  public KeyController(KeyService keyService) {
    this.keyService = keyService;
  }

  @GetMapping
	public List<Key> getKeys() {
		return keyService.getKeys();
	}

  @PostMapping
  public void addNewKey(@RequestBody Key key) {
    keyService.addNewKey(key);
  }

  @DeleteMapping(path = "{keyId}")
  public void deleteKey(@PathVariable("keyId") Long keyId) {
    keyService.deleteKey(keyId);
  }

  @PutMapping(path = "{keyId}")
  public void updateKey(@PathVariable("keyId") Long keyId,
                        @RequestParam(required = false) int typeId,
                        @RequestParam(required = false) int number ) {
    keyService.updateKey(keyId, typeId, number);
  }
}
