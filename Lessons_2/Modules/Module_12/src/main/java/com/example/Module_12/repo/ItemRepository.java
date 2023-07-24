package com.example.Module_12.repo;

import com.example.Module_12.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
