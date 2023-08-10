package com.example.Spring.repo;

import com.example.Spring.models.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Long> {
    Link findByAbbreviated(String abbreviated);
}
