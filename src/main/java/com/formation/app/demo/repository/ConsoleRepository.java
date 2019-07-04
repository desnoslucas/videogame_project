package com.formation.app.demo.repository;

import com.formation.app.demo.entity.Console;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends CrudRepository<Console, Long> {
}
