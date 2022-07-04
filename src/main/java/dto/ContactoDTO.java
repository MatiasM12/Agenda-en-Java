package dto;

public class ContactoDTO 
{
	private String tipoDeContacto;

	public ContactoDTO(String tipoDeContacto) 
	{
		super();
		this.setTipoDeContacto(tipoDeContacto);
	}

	public String getTipoDeContacto() 
	{
		return tipoDeContacto;
	}

	public void setTipoDeContacto(String tipoDeContacto) 
	{
		this.tipoDeContacto = tipoDeContacto;
	}
	

}
