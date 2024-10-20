package com.spaceinvaders.space_invaders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.spaceinvaders.space_invaders.model.dto.LoginDTO;
import com.spaceinvaders.space_invaders.model.dto.RespuestaDTO;
import com.spaceinvaders.space_invaders.model.dto.UsuarioDTO;
import com.spaceinvaders.space_invaders.services.IUsuarioService;

@RestController
@RequestMapping("/login") 
public class UsuarioController {
	
	@Autowired 
	private IUsuarioService loginService;
	
	
	@PostMapping("/auth")
	public ResponseEntity<RespuestaDTO> loginUsuario(@RequestBody LoginDTO usuario)
	{
		RespuestaDTO respuesta = new RespuestaDTO();
		
		respuesta = loginService.LoginService(usuario);
		
		return ResponseEntity.status(respuesta.getEstatus().equals("Ok") ? 200 : 400).body(respuesta);
	}
	
	@PostMapping("/register")
	public ResponseEntity<RespuestaDTO> registerUsuario(@RequestBody UsuarioDTO usuario)
	{
		RespuestaDTO respuesta = new RespuestaDTO();
		
		respuesta = loginService.RegisterService(usuario);
		
		return ResponseEntity.status(respuesta.getEstatus().equals("Ok") ? 200 : 400).body(respuesta);
	}
	
}
