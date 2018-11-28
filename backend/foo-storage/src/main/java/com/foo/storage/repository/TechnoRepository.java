package com.foo.storage.repository;

import com.foo.storage.entity.TechnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnoRepository extends JpaRepository<TechnoEntity, String> {

    Optional<TechnoEntity> findById(String Id);

}
