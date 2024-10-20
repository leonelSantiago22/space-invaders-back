package com.spaceinvaders.space_invaders.services;

import com.spaceinvaders.space_invaders.model.dto.LoginDTO;
import com.spaceinvaders.space_invaders.model.dto.RespuestaDTO;
import com.spaceinvaders.space_invaders.model.dto.UsuarioDTO;

public interface IUsuarioService {

	public RespuestaDTO LoginService(LoginDTO usuario); 
	
	public RespuestaDTO RegisterService(UsuarioDTO usuario);
}
