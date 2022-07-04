package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaLogin extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static VentanaLogin INSTANCE;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private Boolean apreto;
	
	public VentanaLogin() {
		this.apreto=false;
		
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 438); 
		
		JLabel lblNewLabel = new JLabel("Configuracion del Servidor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(34, 28, 280, 54);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Servidor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(72, 131, 81, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(72, 195, 103, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(69, 260, 129, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(198, 128, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 192, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 257, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Acceder");
		btnNewButton.setBounds(64, 326, 220, 23);
		getContentPane().add(btnNewButton);
		
		
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public void cerrar()
	{
		this.dispose();
	}

	public static VentanaLogin getInstance() {
			if(INSTANCE == null)
			{
				INSTANCE = new VentanaLogin(); 	
				return new VentanaLogin();
			}
			else
				return INSTANCE;
		
	}
	
	public boolean apretado(ActionEvent a)
	{
		return this.setApreto(true);
	}
	
	public boolean acceder()
	{
		this.btnNewButton.addActionListener(a->apretado(a));
		if(this.apreto== false) {
		return this.setApreto(true);
		}
		return false;
		
	}

	public Boolean getApreto() {
		return apreto;
	}

	public Boolean setApreto(Boolean apreto) {
		this.apreto = apreto;
		return apreto;
	}

}
