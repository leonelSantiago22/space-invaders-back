package com.spaceinvaders.space_invaders.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	private String correoUsuario;
	private String aliasUsuario;
	private String nombreCompleto;
	private String password;
	private Integer topScore;
	private Integer edad;
}
