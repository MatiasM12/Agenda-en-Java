package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaDomicilio extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNuevoDomicilio;
	private JPanel contentPane;
	private JButton btnAgregar;
	private static VentanaDomicilio  INSTANCE;
	
	
	public static VentanaDomicilio  getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaDomicilio (); 	
			return new VentanaDomicilio ();
		}
		else
			return INSTANCE;
	}
	
	
	public VentanaDomicilio() 
	{
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 239); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNuevoDomicilio = new JTextField();
		txtNuevoDomicilio.setBounds(61, 63, 303, 20);
		getContentPane().add(txtNuevoDomicilio);
		txtNuevoDomicilio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Agregar nuevo tipode de domicilio:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 245, 30);
		getContentPane().add(lblNewLabel);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(95, 111, 245, 23);
		getContentPane().add(btnAgregar);
	}

	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public void cerrar()
	{
		this.dispose();
	}
	
	
	public JTextField getTxtNuevoContacto() 
	{
		return txtNuevoDomicilio;
	}


	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}


	public JTextField getTxtNuevoDomicilio() {
		return txtNuevoDomicilio;
	}


	public void setTxtNuevoDomicilio(JTextField txtNuevoDomicilio) {
		this.txtNuevoDomicilio = txtNuevoDomicilio;
	}




}
