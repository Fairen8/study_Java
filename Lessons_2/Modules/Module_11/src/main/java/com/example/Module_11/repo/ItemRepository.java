package com.example.Module_11.repo;

import com.example.Module_11.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
