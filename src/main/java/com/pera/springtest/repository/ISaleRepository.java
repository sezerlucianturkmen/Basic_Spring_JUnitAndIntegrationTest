package com.pera.springtest.repository;

import com.pera.springtest.repository.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long> {
}
