package com.barroncasadc.demo.parkapi.repository;

import com.barroncasadc.demo.parkapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}