package dto;

public class LocalidadDTO 
{
	private String nombre;
	private String pais;
	private String provincia;
	


	public LocalidadDTO(String nombre, String pais, String provincia) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String localidad) {
		this.provincia = localidad;
	}

	
	
	

}
