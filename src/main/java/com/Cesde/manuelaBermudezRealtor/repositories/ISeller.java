package com.Cesde.manuelaBermudezRealtor.repositories;

import com.Cesde.manuelaBermudezRealtor.modelo.MSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeller extends JpaRepository<MSeller, Integer> {
}
