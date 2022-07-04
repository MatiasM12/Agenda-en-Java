package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import dto.ProvinciaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOSQL implements LocalidadDAO
{
	private static final String insert = "INSERT INTO localidades(nombre_pk, pais_fk, provincia_fk) VALUES(?,?,?)";
	private static final String delete = "DELETE FROM localidades WHERE nombre_pk = ? ";
	private static final String delete2 = "DELETE FROM localidades WHERE provincia_fk=? ";
	private static final String update = "UPDATE localidades SET nombre_pk =? and pais_fk=? and provincia_fk=? ";
	private static final String readall = "SELECT * FROM localidades";
	private static final String read = "SELECT * FROM localidades WHERE pais_fk=? and provincia_fk=?";
	
	@Override
	public boolean insert(LocalidadDTO localidad) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, localidad.getNombre());
			statement.setString(2, localidad.getPais());
			statement.setString(3, localidad.getProvincia());
			if(statement.executeUpdate() > 0)
			{
				conexion.setAutoCommit(false);
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isInsertExitoso;
	}
	@Override
	public boolean delete(LocalidadDTO localidad_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, localidad_a_eliminar.getNombre());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	@Override
	public boolean delete2(LocalidadDTO localidad_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete2);
			statement.setString(1, localidad_a_eliminar.getProvincia());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	@Override
	public boolean update(LocalidadDTO localidad_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, localidad_a_editar.getNombre());
			statement.setString(2, localidad_a_editar.getPais());
			statement.setString(3, localidad_a_editar.getProvincia());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isUpdateExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isUpdateExitoso;
	}
	@Override
	public List<LocalidadDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidad = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidad.add(getLocalidadesDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidad;
	}
	private LocalidadDTO getLocalidadesDTO(ResultSet resultSet) throws SQLException {
		String localidad = resultSet.getString("nombre_pk");
		String pais = resultSet.getString("pais_fk");
		String provincia = resultSet.getString("provincia_fk");
		return new LocalidadDTO(localidad,pais,provincia);
	}
	
	@Override
	public List<LocalidadDTO> read(ProvinciaDTO provincia) {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidad = new ArrayList<LocalidadDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setString(1, provincia.getPais());
			statement.setString(2, provincia.getNombre());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidad.add(getLocalidadesDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidad;
	}



}
