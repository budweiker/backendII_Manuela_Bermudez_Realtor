package com.Cesde.manuelaBermudezRealtor.repositories;

import com.Cesde.manuelaBermudezRealtor.modelo.MProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProperty extends JpaRepository<MProperty, Integer> {
    List<MProperty> findByBarrioIgnoreCase(String barrio);
    List<MProperty> findByEstrato(int estrato);
    List<MProperty> findByMunicipioIgnoreCase(String municipio);
    List<MProperty> findByPropiedadValorBetween(float min, float max);
}
