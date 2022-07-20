package com.opencode.ParserCB.repositories.handbooks;

import com.opencode.ParserCB.entities.cbrf_reference.Handbook;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@NoRepositoryBean
public interface HandbookRepo<T extends Handbook>
        extends JpaRepository<T, Integer> {
    @Query(value = "SELECT * FROM #{#entityName} i WHERE i.code = :code",
            nativeQuery = true)
    T findByCode(@Param("code") String code);

}
