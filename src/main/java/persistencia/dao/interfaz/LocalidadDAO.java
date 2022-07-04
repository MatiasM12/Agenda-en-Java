package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;
import dto.ProvinciaDTO;

public interface LocalidadDAO 
{
	public boolean insert(LocalidadDTO localidad);

	public boolean delete(LocalidadDTO localidad_a_eliminar);
	
	public boolean update(LocalidadDTO localidad_a_editar);
	
	public List<LocalidadDTO> readAll();
	
	public List<LocalidadDTO> read(ProvinciaDTO provincia);

	public boolean delete2(LocalidadDTO localidad_a_eliminar);

}
