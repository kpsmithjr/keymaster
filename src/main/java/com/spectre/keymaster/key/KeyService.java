package com.spectre.keymaster.key;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KeyService {
  private final KeyRepository keyRepository;

  @Autowired
  public KeyService(KeyRepository keyRepository) {
    this.keyRepository = keyRepository;
  }

  public List<Key> getKeys() { return keyRepository.findAll(); }

  public void addNewKey(Key key) {
    Optional<Key> keyOptional = keyRepository
      .findKeyByTypeAndNumber(key.getTypeId(), key.getNumber());
    
    if (keyOptional.isPresent()) {
      throw new IllegalStateException("key taken");
    }
    keyRepository.save(key);    
  }

  public void deleteKey(Long keyId) {
    boolean exists = keyRepository.existsById(keyId);
    if (!exists) {
      throw new IllegalStateException(
        "key with id " + keyId + " does not exist");
    }
    keyRepository.deleteById(keyId);
  }

  @Transactional
  public void updateKey(Long keyId, int typeId, int number) {
    Key key = keyRepository.findById(keyId)
        .orElseThrow(() -> new IllegalStateException(
          "key with id" + keyId + " does not exist"));
    
    if (typeId > 0 && key.getTypeId() != typeId) {
        key.setTypeId(typeId);
    }

    if (number > 0 && key.getNumber() != number) {
      key.setNumber(number);
    }
  }
}
