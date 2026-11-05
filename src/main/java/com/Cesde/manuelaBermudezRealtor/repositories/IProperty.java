package com.Cesde.manuelaBermudezRealtor.repositories;

import com.Cesde.manuelaBermudezRealtor.modelo.MProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProperty extends JpaRepository<MProperty, Integer> {
    // Consulta por barrio
    List<MProperty> findByBarrio(String barrio);
    //Consulta por estrato
    List<MProperty> findByEstrato(int estrato);
    // Consulta por municipio
    List<MProperty> findByMunicipio(String municipio);
    //Consulta por valor
    List<MProperty> findByValor(float min, float max);

}
