package com.opencode.ParserCB.repositories;

import com.opencode.ParserCB.entities.cbrf_reference.Handbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface HandbookRepo<T extends Handbook> extends JpaRepository<T, Integer> {
    @Query(value = "SELECT * FROM XCH_TYPE i WHERE i.code = :code",
            nativeQuery = true)
    T findByCode(@Param("code") String code);
}
