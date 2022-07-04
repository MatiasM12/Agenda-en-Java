package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dto.PersonaDTO;

import javax.swing.JButton;

import persistencia.conexion.Conexion;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private JButton btnEditar;
	private JButton btnReporteProgramacion;
	private JButton btnReporteDomicilio;
	private JButton btnReporteDomicilioDescendente;
	private DefaultTableModel modelPersonas;

	private JButton btnReporteProgramacionDescendente;

	private  String[] nombreColumnas = {"Nombre ","Apellido","Telefono","Email","Cumpleaños","Contacto"};



	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1040, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Tu Agenda");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1021, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 1000, 600);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(2).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(2).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(3).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(3).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(4).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(4).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(5).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(5).setResizable(false);

		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 614, 89, 41);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 614, 89, 41);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 614, 89, 41);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(345, 614, 89, 41);
		panel.add(btnReporte);
		
		btnReporteDomicilio = new JButton("Reporte tipo de domicilio A-Z");
		btnReporteDomicilio.setBounds(444, 614, 280, 23);
		panel.add(btnReporteDomicilio);
		
		btnReporteProgramacion = new JButton("Reporte lenguaje de programacion A-Z");
		btnReporteProgramacion.setBounds(734, 614, 276, 23);
		panel.add(btnReporteProgramacion);
		
		btnReporteDomicilioDescendente = new JButton("Reporte tipo de domicilio Z-A");
		btnReporteDomicilioDescendente.setBounds(444, 632, 280, 23);
		panel.add(btnReporteDomicilioDescendente);
		
		btnReporteProgramacionDescendente = new JButton("Reporte lenguaje de programacion Z-A");
		btnReporteProgramacionDescendente.setBounds(734, 632, 276, 23);
		panel.add(btnReporteProgramacionDescendente);
	}
	
	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Estas seguro que quieres salir de la Agenda?", 
		             "Confirmacion", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public JButton getBtnEditar() 
	{
		return btnEditar;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}


	public JButton getBtnReporteDomicilio() {
		return btnReporteDomicilio;
	}


	public void setBtnReporteDomicilio(JButton btnReporteDomicilio) {
		this.btnReporteDomicilio = btnReporteDomicilio;
	}


	public JButton getBtnReporteProgramacion() {
		return btnReporteProgramacion;
	}


	public void setBtnReporteProgramacion(JButton btnReporteProgramacion) {
		this.btnReporteProgramacion = btnReporteProgramacion;
	}

	

	public JButton getBtnReporteDomicilioDescendente() {
		return btnReporteDomicilioDescendente;
	}


	public void setBtnReporteDomicilioDescendente(JButton btnReporteDomicilioDecendente) {
		this.btnReporteDomicilioDescendente = btnReporteDomicilioDecendente;
	}
	
	


	public JButton getBtnReporteProgramacionDescendente() {
		return btnReporteProgramacionDescendente;
	}


	public void setBtnReporteProgramacionDescendente(JButton btnReporteProgramacionDescendente) {
		this.btnReporteProgramacionDescendente = btnReporteProgramacionDescendente;
	}


	public void llenarTabla(List<PersonaDTO> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (PersonaDTO p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			String apellido = p.getApellido();
			String email = p.getEmail();
			String cumpleaños = p.getCumpleaños();
			String contacto = p.getContacto();
			Object[] fila = {nombre, apellido,tel,email,cumpleaños,contacto};
			this.getModelPersonas().addRow(fila);
		}
		
	}
}
