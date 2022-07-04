package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JButton;

public class VentanaContacto extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNuevoContacto;
	private JPanel contentPane;
	private JButton btnAgregar;
	private static VentanaContacto INSTANCE;
	
	
	public static VentanaContacto getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaContacto(); 	
			return new VentanaContacto();
		}
		else
			return INSTANCE;
	}
	
	
	public VentanaContacto() 
	{
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 239); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNuevoContacto = new JTextField();
		txtNuevoContacto.setBounds(61, 63, 303, 20);
		getContentPane().add(txtNuevoContacto);
		txtNuevoContacto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Agregar nuevo contacto:");
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
		return txtNuevoContacto;
	}


	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}



	
	
}
