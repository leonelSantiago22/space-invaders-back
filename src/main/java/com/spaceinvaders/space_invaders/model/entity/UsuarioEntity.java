package com.spaceinvaders.space_invaders.model.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Getter
@Setter

public class UsuarioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario", length = 1)
	private Long idUsuario;

	
	@Column(name="correo")
	private String correoUsuario;
	
	
	@Column(name="nick_name")
	private String aliasUsuario;
	
	@Column(name ="nombre_completo")
	private String nombreCompleto;
	
	@Column(name="password")
	private String password;
	
	@Column(name ="top_score")
	private Integer topScore;
	
	@Column(name = "edad")
	private Integer edad;
	
}
