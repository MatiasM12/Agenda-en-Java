package presentacion.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaProvincia extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField txtNuevoProvincia;
	private JPanel contentPane;
	private  JButton btnAgregar;
	private static VentanaProvincia INSTANCE;
	
	
	public static VentanaProvincia getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaProvincia(); 	
			return new VentanaProvincia();
		}
		else
			return INSTANCE;
	}
	
	
	public VentanaProvincia() 
	{
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 239); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNuevoProvincia = new JTextField();
		txtNuevoProvincia.setBounds(58, 68, 303, 20);
		getContentPane().add(txtNuevoProvincia);
		txtNuevoProvincia.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Agregar nueva provincia:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(20, 11, 245, 30);
		getContentPane().add(lblNewLabel);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(93, 110, 245, 23);
		getContentPane().add(btnAgregar);

	}

	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}


	public void setTxtNuevoProvincia(JTextField txtNuevoProvincia) {
		this.txtNuevoProvincia = txtNuevoProvincia;
	}
	
	


	public JTextField getTxtNuevoProvincia() 
	{
		return this.txtNuevoProvincia;
		
	}
	
	public void cerrar()
	{
		this.dispose();
	}
}
