package com.example.AutoGarage.repository;

import com.example.AutoGarage.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Long> {
}
