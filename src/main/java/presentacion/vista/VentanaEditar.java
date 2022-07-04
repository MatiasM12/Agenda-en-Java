package presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;


public class VentanaEditar extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JButton btnEditarPersona;
	private JTextField txtCalle;
	private JSpinner altura;
	private JSpinner piso;
	private JTextField txtDpto;		
	private JTextField txtEmail;
	private JDateChooser cumpleaños;
	private JComboBox<String> contacto;
	private JComboBox<String> pais;
	private JComboBox<String> provincia;
	private JComboBox<String> localidad;
	private JTextField txtLengProgramacion;
	private JComboBox<String> tipoDomicilio;
	
	private static VentanaEditar INSTANCE;
	private JButton btnAgregar;
	
	public static VentanaEditar getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaEditar(); 	
			return new VentanaEditar();
		}
		else
			return INSTANCE;
	}

	private VentanaEditar() 
	{
		super();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 628); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 476, 689); 
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(10, 11, 113, 14);
		panel.add(lblNombre);
		
		JLabel Apellido = new JLabel("Apellido");
		Apellido.setBounds(10, 52, 113, 14);
		panel.add(Apellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 93, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 134, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 175, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(209, 175, 75, 14);
		panel.add(lblAltura);
		
		JLabel lblDpto = new JLabel("Departamento");
		lblDpto.setBounds(10, 214, 113, 14);
		panel.add(lblDpto);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 249, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblCumpleaños = new JLabel("Cumpleaños");
		lblCumpleaños.setBounds(10, 290, 113, 14);
		panel.add(lblCumpleaños);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 335, 113, 14);
		panel.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 370, 113, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 410, 113, 14);
		panel.add(lblLocalidad);
		
		JLabel lblContacto = new JLabel("Contacto");
		lblContacto.setBounds(10, 452, 113, 14);
		panel.add(lblContacto);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(133, 49, 164, 20);
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 90, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 131, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
			
		txtDpto = new JTextField();
		txtDpto.setBounds(133, 211, 164, 20);
		panel.add(txtDpto);
		txtDpto.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(133, 246, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		cumpleaños = new JDateChooser();
		cumpleaños.setBounds(133, 284, 164, 20);
		panel.add(cumpleaños);
		
		pais = new JComboBox<String>();
		pais.setBounds(133, 331, 164, 20);
		panel.add(pais);
		
		provincia = new JComboBox<String>();
		provincia.setBounds(133, 366, 164, 20);
		panel.add(provincia);
		
		localidad = new JComboBox<String>();
		localidad.setBounds(133, 406, 164, 20);
		panel.add(localidad);

		contacto = new JComboBox<String>();
		contacto.setBounds(133,  448, 164, 20);
		panel.add(contacto);
		
		btnEditarPersona = new JButton("Editar");
		btnEditarPersona.setBounds(10, 538, 450, 23);
		panel.add(btnEditarPersona);
		
		altura = new JSpinner();
		altura.setBounds(133, 172, 48, 20);
		panel.add( altura);
		
		piso = new JSpinner();
		piso.setBounds(275, 172, 48, 20);
		panel.add(piso);
		

		
		JLabel lblNewLabel = new JLabel("Tipo de Domicilio");
		lblNewLabel.setBounds(348, 128, 146, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lenguaje de Programacion");
		lblNewLabel_1.setBounds(10, 500, 199, 14);
		panel.add(lblNewLabel_1);
		
		txtLengProgramacion = new JTextField();
		txtLengProgramacion.setBounds(219, 497, 125, 20);
		panel.add(txtLengProgramacion);
		txtLengProgramacion.setColumns(10);
		
		tipoDomicilio = new JComboBox<String>();
		tipoDomicilio.setBounds(347, 166, 113, 22);
		panel.add(tipoDomicilio);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(347, 199, 89, 23);
		panel.add(btnAgregar);
		
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}
	
	public void setTxtNombre(String nombre) 
	{
		txtNombre.setText(nombre);
	}
	
	public JTextField getTxtApellido() 
	{
		return txtApellido;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnEditarPersona() 
	{
		return btnEditarPersona;
	}
	

	public JTextField getTxtCalle() 
	{
		return txtCalle;
	}


	public JSpinner getTxtAltura() 
	{
		return altura;
	}


	public JSpinner getTxtPiso() 
	{
		return piso;
	}

	public JTextField getTxtDpto() 
	{
		return txtDpto;
	}

	public JTextField getTxtEmail() 
	{
		return txtEmail;
	}
	
	public JDateChooser getCumpleaños() 
	{
		return cumpleaños;
	}

	public JComboBox<String> getContacto() 
	{
		return contacto;
	}

	public JComboBox<String> getPais() 
	{
		return pais;
	}

	public JComboBox<String> getProvincia() 
	{
		return provincia;
	}

	public JComboBox<String> getLocalidad() 
	{
		return localidad;
	}

	public JSpinner getPiso() 
	{
		return piso;
	}

	public void setPiso(JSpinner piso) 
	{
		this.piso = piso;
	}




	public void setTxtApellido(String txtApellido) 
	{
		this.txtApellido.setText(txtApellido);
	}

	public void setTxtTelefono(String txtTelefono) 
	{
		this.txtTelefono.setText(txtTelefono);
	}

	public void setTxtCalle(String txtCalle) {
		this.txtCalle.setText(txtCalle);
	}

	public void setTxtDpto(String txtDpto) 
	{
		this.txtDpto.setText(txtDpto);
	}

	public void setTxtEmail(String txtEmail) 
	{
		this.txtEmail.setText(txtEmail);
	}

	public void setCumpleaños(Date cumpleaños) 
	{
		this.cumpleaños.setDate(cumpleaños);
	}

	public void setContacto(JComboBox<String> contacto) 
	{
		this.contacto = contacto;
	}

	public void setPais(JComboBox<String> pais) 
	{
		this.pais = pais;
	}

	public void setProvincia(JComboBox<String> provincia) 
	{
		this.provincia = provincia;
	}

	public JTextField getTxtLengProgramacion() {
		return txtLengProgramacion;
	}

	public void setTxtLengProgramacion(String txtLengProgramacion) {
		this.txtLengProgramacion.setText(txtLengProgramacion);
	}

	public JComboBox<String> getTipoDomicilio() {
		return tipoDomicilio;
	}
	

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnNewButton) {
		this.btnAgregar = btnNewButton;
	}

	public void setTipoDomicilio(JComboBox<String> tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}

	public JSpinner getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura.setValue(altura);;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.dispose();
	}
}
