package persistencia.conexion;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import presentacion.vista.VentanaLogin;


public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private VentanaLogin login;
	private String servidor;
	private String usuario;
	private String contraseña;
	private Logger log = LogManager.getLogger(Conexion.class);	
	
	private Conexion()
	{ 
		try
		{
			login= VentanaLogin.getInstance();
			servidor=login.getTextField().getText();
			usuario=login.getTextField_1().getText();
			contraseña=login.getTextField_2().getText();
			//Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysql -h "+servidor+" -u "+usuario+" -p");
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","root");
			log.info("Conexión exitosa");
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexion!", e);
		}
		instancia = null;
	}
}
