package com.Cesde.manuelaBermudezRealtor.repositories;

import com.Cesde.manuelaBermudezRealtor.modelo.MContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContract extends JpaRepository<MContract, Integer> {
}