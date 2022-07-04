package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class VentanaError extends JFrame
{

	private static final long serialVersionUID = 1L;
	private static VentanaError INSTANCE;
	private JPanel contentPane;
	
	public static VentanaError getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaError(); 	
			return new VentanaError();
		}
		else
			return INSTANCE;
	}

	public VentanaError() 
	{
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 441, 239); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Porfavor llene los campos obligatorios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(51, 83, 414, 53);
		getContentPane().add(lblNewLabel);
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
