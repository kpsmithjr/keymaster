package com.spectre.keymaster.keytype;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KeyTypeService {
  private final KeyTypeRepository keyTypeRepository;

  @Autowired
  public KeyTypeService(KeyTypeRepository keyTypeRepository) {
    this.keyTypeRepository = keyTypeRepository;
  }

  public List<KeyType> getKeyTypes() {
    return keyTypeRepository.findAll();
  }

  public void addNewKeyType(KeyType keyType) {
    Optional<KeyType> keyTypeOptional = keyTypeRepository.findAllByType(keyType.getType());

    if (keyTypeOptional.isPresent()) {
      throw new IllegalStateException("Key Type Taken");
    }
    keyTypeRepository.save(keyType);
  }

  public void deleteKeyType(Long keyTypeId) {
    boolean exists = keyTypeRepository.existsById(keyTypeId);
    if (!exists) {
      throw new IllegalStateException(
          "KeyType with id " + keyTypeId + " does not exist");
    }
    keyTypeRepository.deleteById(keyTypeId);
  }

  @Transactional
  public void updateKeyType(Long keyTypeId, String type, String description, String longDescription) {
    System.out.println(type);
    System.out.println(description);
    System.out.println(longDescription);
    KeyType keyType = keyTypeRepository.findById(keyTypeId)
        .orElseThrow(() -> new IllegalStateException(
            "KeyType with id " + keyTypeId + " does not exists"));

    if (type != null &&
        type.length() > 0 &&
        !Objects.equals(type, keyType.getType())) {
      keyType.setType(type);
    }
    if (description != null &&
        description.length() > 0 &&
        !Objects.equals(description, keyType.getDescription())) {
      keyType.setDescription(description);
    }
    if (longDescription != null &&
        longDescription.length() > 0 &&
        !Objects.equals(longDescription, keyType.getLongDescription())) {
      keyType.setLongDescription(longDescription);
    }
  }
}
