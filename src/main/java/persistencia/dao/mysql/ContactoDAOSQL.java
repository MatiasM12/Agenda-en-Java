package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ContactoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ContactoDAO;

public class ContactoDAOSQL implements ContactoDAO
{
	private static final String insert = "INSERT INTO tipoContactos(tipoDeContacto) VALUES(?)";
	private static final String delete = "DELETE FROM tipoContactos WHERE tipoDeContacto = ?";
	private static final String update = "UPDATE tipoContactos SET tipoDeContacto =? ";
	private static final String readall = "SELECT * FROM tipoContactos";


	@Override
	public boolean insert(ContactoDTO contacto) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, contacto.getTipoDeContacto());
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
	public boolean delete(ContactoDTO contacto_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, contacto_a_eliminar.getTipoDeContacto());
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
	public boolean update(ContactoDTO contacto_a_editar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setString(1, contacto_a_editar.getTipoDeContacto());
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
	
	public List<ContactoDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ContactoDTO> personas = new ArrayList<ContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getContactoDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}

	private ContactoDTO getContactoDTO(ResultSet resultSet) throws SQLException
	{
		String tipo = resultSet.getString("tipoDeContacto");
		return new ContactoDTO(tipo);
	}
}
