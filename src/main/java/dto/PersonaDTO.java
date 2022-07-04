package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String apellido;
	private String telefono;
	private String calle;
	private int altura;
	private int piso;
	private String dpto;
	private String email;
	private String cumpleaños;
	private String contacto;
	private String localidad;
	private String tipoDomicilio;
	private String lenguajeDeProgramacion;

	
	public PersonaDTO(int idPersona, String nombre, String apellido, String telefono, String calle, int altura,
			int piso, String dpto, String email, String cumpleaños, String contacto, String localidad,
			 String tipoDomicilio, String lenguajeDeProgramacion) 
	{
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.dpto = dpto;
		this.email = email;
		this.cumpleaños = cumpleaños;
		this.contacto = contacto;
		this.localidad = localidad;
		this.tipoDomicilio = tipoDomicilio;
		this.lenguajeDeProgramacion= lenguajeDeProgramacion;
	}



	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return this.apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}
	
	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public String getCalle() 
	{
		return calle;
	}

	public void setCalle(String calle) 
	{
		this.calle = calle;
	}

	public int getAltura() 
	{
		return altura;
	}

	public void setAltura(int altura) 
	{
		this.altura = altura;
	}

	public int getPiso() 
	{
		return piso;
	}

	public void setPiso(int piso) 
	{
		this.piso = piso;
	}

	public String getDpto() 
	{
		return dpto;
	}

	public void setDpto(String dpto) 
	{
		this.dpto = dpto;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getCumpleaños() 
	{
		return cumpleaños;
	}

	public void setCumpleaños(String cumpleaños) 
	{
		this.cumpleaños = cumpleaños;
	}

	public String getContacto() 
	{
		return contacto;
	}

	public void setContacto(String contacto) 
	{
		this.contacto = contacto;
	}

	public String getLocalidad() 
	{
		return localidad;
	}

	public void setLocalidad(String localidad) 
	{
		this.localidad = localidad;
	}



	public String getTipoDomicilio() {
		return tipoDomicilio;
	}



	public void setTipoDomicilio(String tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}



	public String getLenguajeDeProgramacion() {
		return lenguajeDeProgramacion;
	}



	public void setLenguajeDeProgramacion(String lenguajeDeProgramacion) {
		this.lenguajeDeProgramacion = lenguajeDeProgramacion;
	}
	
	
	
}
