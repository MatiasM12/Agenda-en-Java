package persistencia.dao.interfaz;

import java.util.List;

import dto.PaisDTO;
import dto.ProvinciaDTO;

public interface ProvinciaDAO 
{
	
	public boolean insert(ProvinciaDTO provincia);

	public boolean delete(ProvinciaDTO provincia_a_eliminar);
	
	public boolean update(ProvinciaDTO provincia_a_editar);
	
	public List<ProvinciaDTO> readAll();

	public List<ProvinciaDTO> read(PaisDTO provincia);
	
	public boolean delete2(ProvinciaDTO provincia_a_eliminar);
}
