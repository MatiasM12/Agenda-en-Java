package main;

import java.awt.event.ActionEvent;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaLogin;
import presentacion.vista.Vista;


public class Main
{

	public static void main(String[] args) 
	{
		VentanaLogin login= new VentanaLogin();
		login.mostrarVentana();
		login.getBtnNewButton().addActionListener(a->iniciar(a,login));
	}

	private static void iniciar(ActionEvent a,VentanaLogin login) {
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory()); 
		Controlador controlador = new Controlador(vista, modelo, login);
		controlador.inicializar();
	}
	
	
		
}

