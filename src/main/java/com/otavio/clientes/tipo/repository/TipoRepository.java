package com.otavio.clientes.tipo.repository;

import com.otavio.clientes.tipo.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
    Optional<Tipo> findById(Long id);

}
