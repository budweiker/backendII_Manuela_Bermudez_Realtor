package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MBuyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuyer extends JpaRepository<MBuyer,String> {
    //Consultar propiedades disponibles
}
