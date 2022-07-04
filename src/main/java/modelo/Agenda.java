package modelo;

import java.util.List;

import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;
import persistencia.dao.interfaz.ContactoDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PaisDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.ProvinciaDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private ContactoDAO contacto;
	private PaisDAO pais;
	private ProvinciaDAO provincia;
	private LocalidadDAO localidad;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.contacto = metodo_persistencia.createContactoDAO();
		this.pais = metodo_persistencia.createPaisDAO();
		this.provincia = metodo_persistencia.createProvinciaDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public void editarPersona(PersonaDTO persona_a_editar)
	{
		this.persona.update(persona_a_editar);
	}
	
	public void agregarTipoDeContacto(ContactoDTO tipo)
	{
		this.contacto.insert(tipo);
	}
	
	public void borrarContacto(ContactoDTO Contacto_a_eliminar) 
	{
		this.contacto.delete(Contacto_a_eliminar);
	}
	
	public void editarContacto(ContactoDTO Contacto_a_editar)
	{
		this.contacto.update(Contacto_a_editar);
	}
	
	public void agregarPais(PaisDTO pais)
	{
		this.pais.insert(pais);
	}
	
	public void borrarPais(PaisDTO pais_a_eliminar) 
	{
		this.pais.delete(pais_a_eliminar);
	}
	
	public void editarPais(PaisDTO pais_a_editar)
	{
		this.pais.update(pais_a_editar);
	}
	
	public void agregarProvincia(ProvinciaDTO provincia)
	{
		this.provincia.insert(provincia);
	}
	
	public void borrarProvincia(ProvinciaDTO Provincia_a_eliminar) 
	{
		this.provincia.delete(Provincia_a_eliminar);
	}
	
	public void borrarProvincia2(ProvinciaDTO Provincia_a_eliminar) 
	{
		this.provincia.delete2(Provincia_a_eliminar);
	}
	
	public void editarProvincia(ProvinciaDTO Provincia_a_editar)
	{
		this.provincia.update(Provincia_a_editar);
	}
	
	public void agregarLocalidad(LocalidadDTO Localidad)
	{
		this.localidad.insert(Localidad);
	}
	
	public void borrarLocalidad(LocalidadDTO Localidad_a_eliminar) 
	{
		this.localidad.delete(Localidad_a_eliminar);
	}
	
	public void borrarLocalidad2(LocalidadDTO Localidad_a_eliminar) 
	{
		this.localidad.delete2(Localidad_a_eliminar);
	}
	
	
	public void editarLocalidad(LocalidadDTO Localidad_a_editar)
	{
		this.localidad.update(Localidad_a_editar);
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();
	}
	
	public List<ProvinciaDTO> obtenerProvincias()
	{
		return this.provincia.readAll();
	}
	
	public List<ProvinciaDTO> obtener(PaisDTO pais)
	{
		return this.provincia.read(pais);
	}
	
	public List<LocalidadDTO> obtener2(ProvinciaDTO provincia)
	{
		return this.localidad.read(provincia);
	}
	
	public List<PaisDTO> obtenerPaises()
	{
		return this.pais.readAll();
	}
	
	public List<ContactoDTO> obtenerTiposDeContactos()
	{
		return this.contacto.readAll();
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
}
