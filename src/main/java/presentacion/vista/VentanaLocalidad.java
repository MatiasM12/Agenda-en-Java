package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaLocalidad extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNuevoLocalidad;
	private JPanel contentPane;
	private JButton btnAgregar;
	private static VentanaLocalidad INSTANCE;
	
	
	public static VentanaLocalidad getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaLocalidad(); 	
			return new VentanaLocalidad();
		}
		else
			return INSTANCE;
	}
	
	
	public VentanaLocalidad() 
	{
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 239); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNuevoLocalidad = new JTextField();
		txtNuevoLocalidad.setBounds(61, 63, 303, 20);
		getContentPane().add(txtNuevoLocalidad);
		txtNuevoLocalidad.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Agregar nueva localidad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 245, 30);
		getContentPane().add(lblNewLabel);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(95, 111, 245, 23);
		getContentPane().add(btnAgregar);
	}

	
	public JTextField getTxtNuevoLocalidad() {
		return txtNuevoLocalidad;
	}


	public void setTxtNuevoLocalidad(JTextField txtNuevoLocalidad) {
		this.txtNuevoLocalidad = txtNuevoLocalidad;
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}


	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public void cerrar()
	{
		this.dispose();
	}
	
}
