package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
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
	private JButton btnAgregarPais;
	private JButton btnAgregarProvincia;
	private JButton btnAgregarLocalidad;
	private JButton btnAgregarContacto;
	private JButton btnBorrar;
	private JButton btnBorrar_2;
	private JButton btnBorrar_3;
	private JButton btnBorrar_4;
	private static VentanaPersona INSTANCE;
	private JTextField txtLengProgramacion;
	private JComboBox<String> tipoDomicilio;
	private JButton btnAgregarDom;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	
	
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 638); 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 566, 577); 
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
		lblAltura.setBounds(221, 175, 113, 14);
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

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(10, 544, 542, 23);
		panel.add(btnAgregarPersona);
		
		altura = new JSpinner();
		altura.setBounds(133, 172, 30, 20);
		panel.add( altura);
		
		piso = new JSpinner();
		piso.setBounds(284, 172, 30, 20);
		panel.add(piso);
		
		btnAgregarPais = new JButton("Agregar Pais");
		btnAgregarPais.setBounds(326, 331, 133, 23);
		panel.add(btnAgregarPais);
		
		btnAgregarProvincia = new JButton("Agregar Provincia");
		btnAgregarProvincia.setBounds(326, 366, 133, 23);
		panel.add(btnAgregarProvincia);
		
		btnAgregarLocalidad = new JButton("Agregar Localidad");
		btnAgregarLocalidad.setBounds(326, 406, 133, 23);
		panel.add(btnAgregarLocalidad);
		
	    btnAgregarContacto = new JButton("Agregar Contacto");
		btnAgregarContacto.setBounds(326, 448, 133, 23);
		panel.add(btnAgregarContacto);
		
		btnAgregarPais.setBounds(326, 331, 136, 23);
		panel.add(btnAgregarPais);
		
		btnAgregarProvincia = new JButton("Agregar Provincia");
		btnAgregarProvincia.setBounds(326, 366, 136, 23);
		panel.add(btnAgregarProvincia);
		
		btnAgregarLocalidad = new JButton("Agregar Localidad");
		btnAgregarLocalidad.setBounds(326, 406, 136, 23);
		panel.add(btnAgregarLocalidad);
		
	    btnAgregarContacto = new JButton("Agregar Contacto");
		btnAgregarContacto.setBounds(326, 448, 136, 23);
		btnAgregarPais.setBounds(326, 331, 133, 23);
		panel.add(btnAgregarPais);
		
		btnAgregarProvincia = new JButton("Agregar Provincia");
		btnAgregarProvincia.setBounds(326, 366, 133, 23);
		panel.add(btnAgregarProvincia);
		
		btnAgregarLocalidad = new JButton("Agregar Localidad");
		btnAgregarLocalidad.setBounds(326, 406, 133, 23);
		panel.add(btnAgregarLocalidad);
		

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(463, 331, 89, 23);
		panel.add(btnBorrar);
		
		btnBorrar_2 = new JButton("Borrar");
		btnBorrar_2.setBounds(463, 366, 89, 23);
		panel.add(btnBorrar_2);
		
		btnBorrar_3 = new JButton("Borrar");
		btnBorrar_3.setBounds(463, 406, 89, 23);
		panel.add(btnBorrar_3);
		
		btnBorrar_4 = new JButton("Borrar");
		btnBorrar_4.setBounds(463, 448, 89, 23);
		panel.add(btnBorrar_4);
		
		JLabel lblNewLabel = new JLabel("Tipo de Domicilio");
		lblNewLabel.setBounds(326, 128, 122, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Lenguaje de Programacion");
		lblNewLabel_1.setBounds(10, 500, 200, 14);
		panel.add(lblNewLabel_1);
		
		txtLengProgramacion = new JTextField();
		txtLengProgramacion.setBounds(209, 497, 125, 20);
		panel.add(txtLengProgramacion);
		txtLengProgramacion.setColumns(10);
		
		tipoDomicilio = new JComboBox<String>();
		tipoDomicilio.setBounds(441, 130, 115, 22);
		panel.add(tipoDomicilio);
		
		btnAgregarDom = new JButton("Agregar");
		btnAgregarDom.setBounds(457, 166, 89, 23);
		panel.add(btnAgregarDom);
		
		lblNewLabel_2 = new JLabel("(obligatorio)");
		lblNewLabel_2.setBounds(133, 24, 113, 20);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("(obligatorio)");
		lblNewLabel_3.setBounds(133, 108, 113, 20);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("(obligatorio)");
		lblNewLabel_4.setBounds(133, 259, 113, 23);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("(obligatorio)");
		lblNewLabel_5.setBounds(209, 519, 88, 14);
		panel.add(lblNewLabel_5);
		
		btnAgregarContacto = new JButton("Agregar Tipo");
		btnAgregarContacto.setBounds(326, 448, 133, 23);
		panel.add(btnAgregarContacto);
		
		
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
	
	public JTextField getTxtApellido() 
	{
		return txtApellido;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
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
	


	public JButton getBtnAgregarPais() 
	{
		return btnAgregarPais;
	}

	public JButton getBtnAgregarProvincia() 
	{
		return btnAgregarProvincia;
	}

	public JButton getBtnAgregarLocalidad() 
	{
		return btnAgregarLocalidad;
	}

	public JButton getBtnAgregarContacto() 
	{
		return btnAgregarContacto;
	}
	
	public JButton getBtnbtnBorrar() 
	{
		return btnBorrar;
	}

	public void setBtnbtnBorrar(JButton btnbtnBorrar) 
	{
		this.btnBorrar = btnbtnBorrar;
	}

	public JButton getBtnbtnBorrar_2() 
	{
		return btnBorrar_2;
	}

	public void setBtnbtnBorrar_2(JButton btnbtnBorrar_2) 
	{
		this.btnBorrar_2 = btnbtnBorrar_2;
	}

	public JButton getBtnbtnBorrar_3() {
		return btnBorrar_3;
	}

	public void setBtnbtnBorrar_3(JButton btnbtnBorrar_3) {
		this.btnBorrar_3 = btnbtnBorrar_3;
	}

	public JButton getBtnBorrar_4() 
	{
		return btnBorrar_4;
	}
	
	

	public JTextField getTxtLengProgramacion() {
		return txtLengProgramacion;
	}

	public void setTxtLengProgramacion(JTextField txtLengProgramacion) {
		this.txtLengProgramacion = txtLengProgramacion;
	}

	public JComboBox<String> getTipoDomicilio() {
		return tipoDomicilio;
	}

	public void setTipoDomicilio(JComboBox<String> tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}
	
	

	public JButton getBtnAgregarDom() {
		return btnAgregarDom;
	}

	public void setBtnAgregarDom(JButton btnNewButton) {
		this.btnAgregarDom = btnNewButton;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtCalle.setText(null);
		this.txtApellido.setText(null);
		this.txtEmail.setText(null);
		this.txtDpto.setText(null);
		this.dispose();
	}


	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	public JButton getBtnBorrar_2() {
		return btnBorrar_2;
	}

	public void setBtnBorrar_2(JButton btnBorrar_2) {
		this.btnBorrar_2 = btnBorrar_2;
	}

	public JButton getBtnBorrar_3() {
		return btnBorrar_3;
	}

	public void setBtnBorrar_3(JButton btnBorrar_3) {
		this.btnBorrar_3 = btnBorrar_3;
	}
}

