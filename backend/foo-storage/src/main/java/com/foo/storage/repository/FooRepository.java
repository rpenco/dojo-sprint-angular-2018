package com.foo.storage.repository;

import com.foo.storage.entity.FooEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author J.GROCH
 */
@Repository
public interface FooRepository extends JpaRepository<FooEntity, String> {

    Optional<FooEntity> findById(String Id);

//    @Query("SELECT f " +
//            "FROM FooEntity " +
//            "WHERE f.param = :param")
//    List<FooEntity> findByProjectAndUserId(@Param("param") String param);
}
