package com.yamaguchi.milagre.repositories;

import com.yamaguchi.milagre.models.MilagreModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilagreRepository extends JpaRepository<MilagreModel, Long> {
}
