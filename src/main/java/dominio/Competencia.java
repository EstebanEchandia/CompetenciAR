package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dto.CompetenciaDTO;

@Entity
@Table(name="Competencia", schema = "tp")
 
public class Competencia {

	public enum Estado {
		CREADA, PLANIFICADA, EN_DISPUTA, FINALIZADA, CANCELADA
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado")
	private Estado estadoCompetencia;

	@OneToMany(mappedBy = "competencia")
	private List<Participante> participantes;
	
	@Column(name="reglamento")
	private String reglamento;
	
	@Column(name="dadadebaja")
	private Boolean dadaDeBaja;
	
	
	@Column(name="fechadebaja")
	private LocalDate fechaBaja;
	
	@ManyToOne()
    @JoinColumn(name = "idUsuario")
	private Usuario usuarioAsociado;
	
	@OneToMany(mappedBy = "competencia")
	private List<Reserva> reservasDisponibles;
	
	
	@OneToOne @MapsId
	@JoinColumn(name="iddeporte")
	private Deporte deporteDeCompetencia;
	
	@OneToOne @MapsId
	@JoinColumn(name="idmodalidad")
	private Modalidad modalidad;

	
	public Competencia(){
	}

	
	public void inicializarCompetencia(CompetenciaDTO compeDTO) {
		this.nombre = compeDTO.getNombre();
		this.estadoCompetencia = compeDTO.getEstadoCompetencia();
		this.participantes = compeDTO.getParticipantes();
		this.reglamento = compeDTO.getReglamento();
		this.dadaDeBaja = false;
		this.fechaBaja = null;
	
	};
	
	



	public void setUsuarioAsociado(Usuario usuarioAsociado) {
		this.usuarioAsociado = usuarioAsociado;
	}

	public void setDeporteDeCompetencia(Deporte deporteDeCompetencia) {
		this.deporteDeCompetencia = deporteDeCompetencia;
	}

	public Integer getId() {
		return id;
	}

	public Deporte getDeporteDeCompetencia() {
		return deporteDeCompetencia;
	}

	public List<Reserva> getReservasDisponibles() {
		return reservasDisponibles;
	}


	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}
	
	public void setReservasDisponibles(List<Reserva> reservas) {
		this.reservasDisponibles = reservas;
	}
		
}



	

