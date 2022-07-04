package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPais extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JTextField txtNuevoPais;
	private JPanel contentPane;
	private JButton btnAgregar;
	private static VentanaPais INSTANCE;
	
	
	public static VentanaPais getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPais(); 	
			return new VentanaPais();
		}
		else
			return INSTANCE;
	}
	
	
	public VentanaPais() 
	{
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 239); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNuevoPais = new JTextField();
		txtNuevoPais.setBounds(61, 63, 303, 20);
		getContentPane().add(txtNuevoPais);
		txtNuevoPais.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Agregar nueva pais:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 245, 30);
		getContentPane().add(lblNewLabel);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(95, 111, 245, 23);
		getContentPane().add(btnAgregar);
	}

	
	public JTextField getTxtNuevoPais() 
	{
		return txtNuevoPais;
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
