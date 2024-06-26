package com.eevan.registry.repos;

import com.eevan.registry.entities.Cleaner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CleanerRepository extends JpaRepository<Cleaner, Long> {
}
