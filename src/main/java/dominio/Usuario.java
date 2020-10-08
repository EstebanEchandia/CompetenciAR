package dominio;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuario", schema = "tp")
public class Usuario {

	public enum TipoDoc{
		DNI, PASAPORTE, PART_DE_NACIMIENTO
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String correoElectronico;
	
	@Column
	private String contrase�a;
	
	@Column
	private String apellido;
	
	@Column
	private String nombre;
	
	@Enumerated
	@Column
	private TipoDoc tipoDocumento;
	
	@Column
	private String documento;
	
	@Column
	private Localidad localidad;
	
	
}
