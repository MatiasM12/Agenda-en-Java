package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, apellido, telefono,calle ,altura , piso, departamento"
										+ ",email, cumpleaños, contacto , localidad, tipoDomicilio , lenguajeDeProgramacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String update = "UPDATE personas SET idPersona =?, nombre=?,apellido =?, telefono=?, calle =?, altura=?, piso=?, departamento=?"
										+ ", email=?, cumpleaños=?, contacto=?, localidad=?, tipoDomicilio=?, lenguajeDeProgramacion=? WHERE idPersona=?";
	private static final String readall = "SELECT * FROM personas";
		
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			statement.setString(4, persona.getTelefono());
			statement.setString(5, persona.getCalle());
			statement.setInt(6, persona.getAltura());
			statement.setInt(7, persona.getPiso());
			statement.setString(8, persona.getDpto());
			statement.setString(9, persona.getEmail());
			statement.setString(10, persona.getCumpleaños());
			statement.setString(11, persona.getContacto());
			statement.setString(12, persona.getLocalidad());
			statement.setString(13, persona.getTipoDomicilio());
			statement.setString(14, persona.getLenguajeDeProgramacion());
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
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
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
	public boolean update(PersonaDTO persona_a_editar) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try
		{
			statement = conexion.prepareStatement(update);
			statement.setInt(1, persona_a_editar.getIdPersona());
			statement.setString(2, persona_a_editar.getNombre());
			statement.setString(3, persona_a_editar.getApellido());
			statement.setString(4, persona_a_editar.getTelefono());
			statement.setString(5, persona_a_editar.getCalle());
			statement.setInt(6, persona_a_editar.getAltura());
			statement.setInt(7, persona_a_editar.getPiso());
			statement.setString(8, persona_a_editar.getDpto());
			statement.setString(9, persona_a_editar.getEmail());
			statement.setString(10, persona_a_editar.getCumpleaños());
			statement.setString(11, persona_a_editar.getContacto());
			statement.setString(12, persona_a_editar.getLocalidad());
			statement.setString(13, persona_a_editar.getTipoDomicilio());
			statement.setString(14, persona_a_editar.getLenguajeDeProgramacion());
			statement.setInt(15, persona_a_editar.getIdPersona());
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
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String apellido = resultSet.getString("Apellido");
		String calle = resultSet.getString("Calle");
		int altura = resultSet.getInt("Altura");
		int piso = resultSet.getInt("Piso");
		String departamento = resultSet.getString("Departamento");
		String email = resultSet.getString("Email");
		String cumpleaños = resultSet.getString("Cumpleaños");
		String contacto = resultSet.getString("Contacto");
		String localidad = resultSet.getString("Localidad");
		String tipoDomicilio = resultSet.getString("TipoDomicilio");
		String lenguajeDeProgramacion = resultSet.getString("LenguajeDeProgramacion");
		return new PersonaDTO(id, nombre, apellido,tel,calle,altura,piso,departamento,email,cumpleaños,contacto,localidad,tipoDomicilio,lenguajeDeProgramacion);
	}


}
