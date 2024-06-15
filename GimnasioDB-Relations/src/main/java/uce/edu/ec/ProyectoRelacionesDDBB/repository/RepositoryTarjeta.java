package uce.edu.ec.ProyectoRelacionesDDBB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uce.edu.ec.ProyectoRelacionesDDBB.models.Tarjeta;

public interface RepositoryTarjeta extends JpaRepository<Tarjeta,Integer> {
}
