package com.info.febreserva.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tbl_reserva")
public class ReservaModel {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	
	@Column(name = "restaurante")
	private String restaurante;
	
	@NotEmpty(message = "O Atributo NOME está Vazio!")
	@Size(min=2, 
	  max=64,
	  message = "O Numero de caracteres do atributo 'NOME' tem de estar entre 2 and 64!")
	@Column(name= "nome", length=64, nullable=false, unique=false, updatable=true)
	private String nome;
	

	@Column(name = "quarto")
	private int quarto;

	@Column(name = "paxadulto")
	private int paxadulto;
	
	@Column(name = "paxcrianca")
	private int paxcrianca;
	
	@Column(name = "hora")
	private String hora;
	
	@Column(name = "hoster")
	private String hoster;
	
	
	  
	@Column(name = "observacao")
	private String observacao;
	
	@NotEmpty(message = "O Atributo horaentrada está Vazio!")
	@Size(min=4, 
	  max=12,
	  message = "O Numero de caracteres do atributo horaentrada tem de estar entre 2 and 64!")
	@Column(name = "horaentrada", length=64, nullable=false, unique=false, updatable=true)
	private String horaentrada;
	
	//@FutureOrPresent(message="A Data de Criacão tem de ser uma Data Presente ou Futuro!!") 
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message="A Data de Criacao nao pode ser Null")
	//@Column(name = "datareserva", nullable=false, updatable=false, unique=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Column(name = "datareserva", nullable=false, unique=false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDate datareserva;
	

	
	
	
	public ReservaModel() {
		super();

	}



	public ReservaModel(UUID id, String restaurante, int quarto, String nome, int paxadulto, int paxcrianca, String hora, String hoster, String observacao, String horaentrada, 
			LocalDate datareserva) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.quarto = quarto;
		this.nome = nome;
		
		this.paxadulto = paxadulto;
		this.paxcrianca = paxcrianca;
		this.hora = hora;
		this.hoster = hoster;
		this.observacao = observacao;
		this.horaentrada = horaentrada;
		this.datareserva = datareserva;
	}
	
	public ReservaModel(String restaurante, int quarto, String nome, int paxadulto, int paxcrianca, String hora, String hoster, String observacao, String horaentrada, 
			LocalDate datareserva) {
		super();
		
		this.restaurante = restaurante;
		this.quarto = quarto;
		this.nome = nome;
		
		this.paxadulto = paxadulto;
		this.paxcrianca = paxcrianca;
		this.hora = hora;
		this.hoster = hoster;
		this.observacao = observacao;
		this.horaentrada = horaentrada;
		this.datareserva = datareserva;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQuarto() {
		return quarto;
	}

	public void setQuarto(int quarto) {
		this.quarto = quarto;
	}



	public int getPaxadulto() {
		return paxadulto;
	}



	public void setPaxadulto(int paxadulto) {
		this.paxadulto = paxadulto;
	}



	public int getPaxcrianca() {
		return paxcrianca;
	}



	public void setPaxcrianca(int paxcrianca) {
		this.paxcrianca = paxcrianca;
	}



	public String getHora() {
		return hora;
	}



	public void setHora(String hora) {
		this.hora = hora;
	}



	public String getHoster() {
		return hoster;
	}



	public void setHoster(String hoster) {
		this.hoster = hoster;
	}



	public String getObservacao() {
		return observacao;
	}



	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}



	public String getHoraentrada() {
		return horaentrada;
	}



	public void setHoraentrada(String horaentrada) {
		this.horaentrada = horaentrada;
	}



	public LocalDate getDatareserva() {
		return datareserva;
	}



	public void setDatareserva(LocalDate datareserva) {
		this.datareserva = datareserva;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaModel other = (ReservaModel) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "ReservaModel [id=" + id + ", restaurante=" + restaurante + ", nome=" + nome + ", quarto=" + quarto + ", paxadulto=" + paxadulto
				+ ", paxcrianca=" + paxcrianca + ", hora=" + hora + ", hoster=" + hoster + ", observacao=" + observacao
				+ ", horaentrada=" + horaentrada + ", datareserva=" + datareserva + "]";
	}
	

}
