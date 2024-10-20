package com.spaceinvaders.space_invaders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spaceinvaders.space_invaders.model.dto.LoginDTO;
import com.spaceinvaders.space_invaders.model.entity.UsuarioEntity;


@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query("SELECT u FROM UsuarioEntity u WHERE u.correoUsuario = :correo")
    UsuarioEntity findByCorreoUsuario(@Param("correo") String correo);
}
