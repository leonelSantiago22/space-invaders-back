package com.spaceinvaders.space_invaders.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceinvaders.space_invaders.model.dto.LoginDTO;
import com.spaceinvaders.space_invaders.model.dto.RespuestaDTO;
import com.spaceinvaders.space_invaders.model.dto.UsuarioDTO;
import com.spaceinvaders.space_invaders.model.entity.UsuarioEntity;
import com.spaceinvaders.space_invaders.repository.IUsuarioRepository;
import com.spaceinvaders.space_invaders.utils.PasswordUtil;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository loginRepository;
	
	
	
	@Override
	public RespuestaDTO LoginService(LoginDTO usuario) {
	    RespuestaDTO retorno = new RespuestaDTO();

	    try {
	        // Buscar usuario por correo
	        UsuarioEntity usuarioLogin = loginRepository.findByCorreoUsuario(usuario.getCorreoUsuario());

	        // Validar si el usuario fue encontrado
	        if (usuarioLogin == null) {
	            retorno.setEstatus("Error");
	            retorno.setMensaje("Usuario no encontrado");
	            return retorno;
	        }

	        // Verificar si la contraseña es correcta (comparar contraseñas encriptadas)
	        if (!PasswordUtil.verificarContrasena(usuario.getPassword(), usuarioLogin.getPassword())) {
	            retorno.setEstatus("Error");
	            retorno.setMensaje("Error: usuario o contraseña no válidos");
	            return retorno;
	        }

	        // Si todo es correcto
	        retorno.setEstatus("Ok");
	        retorno.setMensaje("Usuario validado con éxito");

	    } catch (Exception e) {
	        retorno.setEstatus("Error");
	        retorno.setMensaje("Error en el proceso de validación: " + e.getMessage());
	    }

	    return retorno;
	}


	public RespuestaDTO RegisterService(UsuarioDTO usuario) {
	    RespuestaDTO retorno = new RespuestaDTO();
	    
	    try {
	        // Verifica si el usuario ya existe basado en el correo
	        UsuarioEntity usuarioExistente = loginRepository.findByCorreoUsuario(usuario.getCorreoUsuario());
	        
	        if (usuarioExistente != null) {
	            retorno.setEstatus("Error");
	            retorno.setMensaje("El usuario ya existe con el correo: " + usuario.getCorreoUsuario());
	            return retorno;
	        }
	        
	        // Encriptar la contraseña del usuario
	        String contrasenaEncriptada = PasswordUtil.encriptarContrasena(usuario.getPassword());
	        
	        // Crear entidad UsuarioEntity a partir de UsuarioDTO
	        UsuarioEntity nuevoUsuario = new UsuarioEntity();
	        nuevoUsuario.setNombreCompleto(usuario.getNombreCompleto());
	        nuevoUsuario.setCorreoUsuario(usuario.getCorreoUsuario());
	        nuevoUsuario.setPassword(contrasenaEncriptada);
	        nuevoUsuario.setAliasUsuario(usuario.getAliasUsuario());
	        nuevoUsuario.setEdad(usuario.getEdad());
	        nuevoUsuario.setTopScore(0);  // El puntaje inicial es 0
	        
	        // Guardar el usuario en la base de datos
	        loginRepository.save(nuevoUsuario);
	        
	        // Configurar la respuesta de éxito
	        retorno.setEstatus("Ok");
	        retorno.setMensaje("Usuario registrado correctamente");
	    } catch (Exception e) {
	        retorno.setEstatus("Error");
	        retorno.setMensaje("Error en el registro del usuario: " + e.getMessage());
	    }
	    
	    return retorno;
	}


}
