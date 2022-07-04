package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.toedter.calendar.JDateChooser;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.reportes.ReporteDomicilio;
import presentacion.reportes.ReporteDomicilioDescendente;
import presentacion.reportes.ReporteProgramacion;
import presentacion.reportes.ReporteProgramacionDescendente;
import presentacion.vista.VentanaContacto;
import presentacion.vista.VentanaDomicilio;
import presentacion.vista.VentanaEditar;
import presentacion.vista.VentanaError;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaLogin;
import presentacion.vista.VentanaPais;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaProvincia;
import presentacion.vista.Vista;
import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PaisDTO;
import dto.PersonaDTO;
import dto.ProvinciaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private VentanaLogin login;
		private List<PersonaDTO> personasEnTabla;
		private List<ContactoDTO> tipoDeContactos;
		private List<PaisDTO> paises;
		private List<ProvinciaDTO> provincias;
		private List<LocalidadDTO> localidades;
		private VentanaPersona ventanaPersona; 
		private VentanaEditar ventanaEditar;
		private VentanaContacto ventanaContacto;
		private VentanaPais ventanaPais;
		private VentanaProvincia ventanaProvincia;
		private VentanaLocalidad ventanaLocalidad;
		private VentanaDomicilio ventanaDomicilio;
		private VentanaError ventanaError;
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda,VentanaLogin login)
		{
			this.login = login;
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.vista.getBtnEditar().addActionListener(e->ventanaEditarPersona(e));
			
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaEditar = VentanaEditar.getInstance();
			this.ventanaContacto = VentanaContacto.getInstance();
			this.ventanaPais = VentanaPais.getInstance();
			this.ventanaProvincia = VentanaProvincia.getInstance();
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			this.ventanaDomicilio = VentanaDomicilio.getInstance();
			this.ventanaError = VentanaError.getInstance();
			
			
			this.ventanaPersona.getBtnAgregarContacto().addActionListener(c->ventanaContacto(c));
			this.ventanaPersona.getBtnAgregarPais().addActionListener(pa->ventanaPais(pa));
			this.ventanaPersona.getBtnAgregarProvincia().addActionListener(pro->ventanaProvincia(pro));
			this.ventanaPersona.getBtnAgregarLocalidad().addActionListener(l->ventanaLocalidad(l));
			this.ventanaPersona.getBtnAgregarDom().addActionListener(a->ventanaDomicilio(a));
			this.ventanaEditar.getBtnAgregar().addActionListener(a->ventanaDomicilio(a));
			
			this.ventanaPersona.getBtnBorrar().addActionListener(b->borrarPais(b));
			this.ventanaPersona.getBtnBorrar_2().addActionListener(b->borrarProvinciaVentanaPersona(b));
			this.ventanaPersona.getBtnBorrar_3().addActionListener(b->borrarLocalidad(b));
			this.ventanaPersona.getBtnBorrar_4().addActionListener(rc->borrarTipoDeContacto(rc));

			
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.ventanaEditar.getBtnEditarPersona().addActionListener(pe->editarPersona(pe));
			
			this.ventanaContacto.getBtnAgregar().addActionListener(a->agregarContacto(a));
			this.ventanaPersona.getBtnBorrar_4().addActionListener(rc->borrarTipoDeContacto(rc));
			this.ventanaPais.getBtnAgregar().addActionListener(a->agregarPais(a));
			this.ventanaProvincia.getBtnAgregar().addActionListener(a->agregarProvincia(a));
			this.ventanaLocalidad.getBtnAgregar().addActionListener(a->agregarLocalidad(a));
			this.ventanaDomicilio.getBtnAgregar().addActionListener(a->agregarTipoDomicilio(a));
			this.ventanaPersona.getBtnAgregarContacto().addActionListener(a->agregarTipoContacto(a));
			
			this.ventanaPersona.getPais().addActionListener(a->llenarVistaPersona(a));
			this.ventanaEditar.getPais().addActionListener(a->llenarVistaEditar(a));
			
			
			
			this.vista.getBtnReporteDomicilio().addActionListener(m->mostrarReporteDomicilio(m));
			this.vista.getBtnReporteDomicilioDescendente().addActionListener(m->mostrarReporteDomicilioDescendente(m));
			this.vista.getBtnReporteProgramacion().addActionListener(m->mostrarReporteProgramacion(m));
			this.vista.getBtnReporteProgramacionDescendente().addActionListener(m->mostrarReporteProgramacionDescendente(m));
			
			this.agenda = agenda;
			this.tipoDeContactos = agenda.obtenerTiposDeContactos();
			this.paises = agenda.obtenerPaises();
			this.localidades = agenda.obtenerLocalidades();
			
		}





		private void ventanaAgregarPersona(ActionEvent a) {
			llenarTipoDeContactos();
			llenarDomicilios();
			llenarPaises();
			this.ventanaPersona.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			Pattern pattern1 = Pattern.compile("(.+)");
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			Pattern pattern2 = Pattern.compile("\\D*");
			String tel = ventanaPersona.getTxtTelefono().getText();
			String apellido = ventanaPersona.getTxtApellido().getText();
			String calle = ventanaPersona.getTxtCalle().getText();
			int altura = (Integer)ventanaPersona.getTxtAltura().getValue();
			int piso = (Integer)ventanaPersona.getTxtPiso().getValue();
			String dpto= ventanaPersona.getTxtDpto().getText();
			Pattern pattern3 = Pattern.compile("^(.+)@(.+)$");
			String email = ventanaPersona.getTxtEmail().getText();
			JDateChooser cumpleaños= ventanaPersona.getCumpleaños();
			String cumple = null;
			if(cumpleaños.getDate() != null )
			{
				cumple = Integer.toString(cumpleaños.getCalendar().get(Calendar.YEAR))
						+ "-"+ Integer.toString(cumpleaños.getCalendar().get(Calendar.MONTH)+1)
						+ "-"+ Integer.toString(cumpleaños.getCalendar().get(Calendar.DAY_OF_MONTH));
			}
			int indiceContacto = ventanaPersona.getContacto().getSelectedIndex();
			String contacto = ventanaPersona.getContacto().getItemAt(indiceContacto);
			int indicePais = ventanaPersona.getPais().getSelectedIndex();
			int indiceProvincia = ventanaPersona.getPais().getSelectedIndex();
			String localidad = ventanaPersona.getPais().getItemAt(indicePais)+","
							+ ventanaPersona.getProvincia().getItemAt(indiceProvincia)+","
							+ ventanaPersona.getLocalidad().getItemAt(indiceProvincia);
			String tipoDomicilio= " ";
			Pattern pattern4 = Pattern.compile("(.+)");
			String lenguajeDeProgramacion="";
			
			if(ventanaPersona.getTipoDomicilio().getSelectedItem() != null){
				tipoDomicilio= ventanaPersona.getTipoDomicilio().getSelectedItem().toString();
			}
			if(ventanaPersona.getTxtLengProgramacion() != null) {
				lenguajeDeProgramacion= ventanaPersona.getTxtLengProgramacion().getText();
			}
			Matcher mather1 = pattern1.matcher(nombre);
			Matcher mather2 = pattern2.matcher(tel);
			Matcher mather3 = pattern3.matcher(email);
			Matcher mather4 = pattern4.matcher(lenguajeDeProgramacion);
			if (mather1.find() == true && mather2.find() == true && mather3.find() == true && mather4.find() == true ) {
	            PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, apellido,tel,calle,altura,piso,dpto,email,cumple,contacto,localidad, tipoDomicilio, lenguajeDeProgramacion);
				this.agenda.agregarPersona(nuevaPersona);
				this.refrescarTabla();
				this.ventanaPersona.cerrar();
	        } else {
	        	this.ventanaError.mostrarVentana();
	        }
			
		}
		

		private void mostrarReporte(ActionEvent r) 
		{
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}


		private void mostrarReporteDomicilio(ActionEvent m) 
		{
			ReporteDomicilio reporte = new ReporteDomicilio(agenda.obtenerPersonas());
			reporte.mostrar();
		}
		
		private void mostrarReporteDomicilioDescendente(ActionEvent m) 
		{
			ReporteDomicilioDescendente reporte = new ReporteDomicilioDescendente(agenda.obtenerPersonas());
			reporte.mostrar();
		}
		
		
		private void mostrarReporteProgramacion(ActionEvent m) 
		{
			ReporteProgramacion reporte = new ReporteProgramacion(agenda.obtenerPersonas());
			reporte.mostrar();
		}
		
		private void mostrarReporteProgramacionDescendente(ActionEvent m) 
		{
			ReporteProgramacionDescendente reporte = new ReporteProgramacionDescendente(agenda.obtenerPersonas());
			reporte.mostrar();
		}

		
		public void borrarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}
		
		private void ventanaEditarPersona(ActionEvent a) 
		{
			int filaSeleccionada = this.vista.getTablaPersonas().getSelectedRow();
			if (filaSeleccionada >= 0)
			{
				PersonaDTO idPersona = this.personasEnTabla.get(filaSeleccionada);
				this.ventanaEditar.setTxtNombre(idPersona.getNombre());
				this.ventanaEditar.setTxtApellido(idPersona.getApellido());
				this.ventanaEditar.setTxtCalle(idPersona.getCalle());
				this.ventanaEditar.setTxtDpto(idPersona.getDpto());
				this.ventanaEditar.setTxtEmail(idPersona.getEmail());
				this.ventanaEditar.setTxtTelefono(idPersona.getTelefono());
				this.ventanaEditar.setTxtEmail(idPersona.getEmail());
				this.ventanaEditar.setTxtLengProgramacion(idPersona.getLenguajeDeProgramacion());
				llenarTipoDeContactos();
				llenarPaises();
				llenarDomicilios();
				this.ventanaEditar.mostrarVentana();
			}
		}
		
		public void editarPersona(ActionEvent s)
		{
			int filaSeleccionada = this.vista.getTablaPersonas().getSelectedRow();
			if (filaSeleccionada >= 0 )
			{
				PersonaDTO idPersona = this.personasEnTabla.get(filaSeleccionada);
				String nombre = this.ventanaEditar.getTxtNombre().getText();
				String tel = ventanaEditar.getTxtTelefono().getText();
				String apellido = ventanaEditar.getTxtApellido().getText();
				String calle = ventanaEditar.getTxtCalle().getText();
				int altura = (Integer)ventanaEditar.getTxtAltura().getValue();
				int piso =(Integer)ventanaEditar.getTxtPiso().getValue();
				String dpto= ventanaEditar.getTxtDpto().getText();
				String email= ventanaEditar.getTxtEmail().getText();
				JDateChooser cumpleaños= ventanaEditar.getCumpleaños();
				String cumple = null;
				if(cumpleaños.getDate() != null )
				{
					cumple = Integer.toString(cumpleaños.getCalendar().get(Calendar.YEAR))
						+ "-"+ Integer.toString(cumpleaños.getCalendar().get(Calendar.MONTH)+1)
						+ "-"+ Integer.toString(cumpleaños.getCalendar().get(Calendar.DAY_OF_MONTH));
				}
				int indiceContacto = ventanaEditar.getContacto().getSelectedIndex();
				String contacto = ventanaEditar.getContacto().getItemAt(indiceContacto);
				int indicePais = ventanaEditar.getPais().getSelectedIndex();
				int indiceProvincia = ventanaEditar.getPais().getSelectedIndex();
				String localidad = ventanaEditar.getPais().getItemAt(indicePais)+","
								+ ventanaEditar.getProvincia().getItemAt(indiceProvincia)+","
								+ ventanaEditar.getLocalidad().getItemAt(indiceProvincia);
				String tipoDomicilio= "";
				String lenguajeDeProgramacion="";
				if(ventanaEditar.getTipoDomicilio().getSelectedItem() != null){
					tipoDomicilio= ventanaEditar.getTipoDomicilio().getSelectedItem().toString();
				}
				if(ventanaEditar.getTxtLengProgramacion() != null) {
					lenguajeDeProgramacion= ventanaEditar.getTxtLengProgramacion().getText();
				}
				
				PersonaDTO nuevaPersona = new PersonaDTO(idPersona.getIdPersona(), nombre, apellido,tel,calle,altura,piso,dpto,email,cumple,contacto,localidad, tipoDomicilio, lenguajeDeProgramacion);
				this.agenda.editarPersona(nuevaPersona);
				this.refrescarTabla();
				this.ventanaEditar.cerrar();
			}
			
		}
		
		public void borrarTipoDeContacto(ActionEvent s)
		{
			ContactoDTO tipo =new ContactoDTO(this.ventanaPersona.getContacto().getSelectedItem().toString());
			this.agenda.borrarContacto(tipo);
			llenarTipoDeContactos();
			
		}
		
		
		
		public void llenarPaises()
		{
			vaciarPais();
			for(PaisDTO s :  paises)
			{
				this.ventanaPersona.getPais().addItem(s.getNombre());
				this.ventanaEditar.getPais().addItem(s.getNombre());
			}
			
		}
		
		
			
		public void llenarVistaPersona(ActionEvent a)
		{
			vaciarProvinciasPersona();
			vaciarLocalidadesPersona();
			String paisSeleccionado="";
			if(this.ventanaPersona.getPais().getSelectedItem()  != null) 
			{
				paisSeleccionado = this.ventanaPersona.getPais().getSelectedItem().toString();
			}
			List<ProvinciaDTO> loc =agenda.obtener(new PaisDTO(paisSeleccionado));
			
			for(ProvinciaDTO p : loc)
			{
				this.ventanaPersona.getProvincia().addItem(p.getNombre());
				
				List<LocalidadDTO> loca =agenda.obtener2(new ProvinciaDTO(p.getNombre(),paisSeleccionado));
				for(LocalidadDTO l : loca)
				{
					this.ventanaPersona.getLocalidad().addItem(l.getNombre());
				}
			}
			
		}
		
		public void llenarVistaEditar(ActionEvent a)
		{
			vaciarProvinciasEditar();
			vaciarLocalidadesEditar();
			String paisSeleccionado="";
			if(this.ventanaEditar.getPais().getSelectedItem()  != null) 
			{
				paisSeleccionado = this.ventanaEditar.getPais().getSelectedItem().toString();
			}
			List<ProvinciaDTO> loc =agenda.obtener(new PaisDTO(paisSeleccionado));
			
			for(ProvinciaDTO p : loc)
			{
				this.ventanaEditar.getProvincia().addItem(p.getNombre());
				
				List<LocalidadDTO> loca =agenda.obtener2(new ProvinciaDTO(p.getNombre(),paisSeleccionado));
				for(LocalidadDTO l : loca)
				{
					this.ventanaEditar.getLocalidad().addItem(l.getNombre());
				}
			}
			
		}
		
		
		public void llenarTipoDeContactos()
		{
			this.ventanaPersona.getContacto().removeAllItems();
			this.ventanaEditar.getContacto().removeAllItems();
			for(ContactoDTO s :  tipoDeContactos)
			{
				this.ventanaPersona.getContacto().addItem(s.getTipoDeContacto());
				this.ventanaEditar.getContacto().addItem(s.getTipoDeContacto());
			}
			
		}
		
		public void llenarDomicilios()
		{
			vaciarDomicilios();
			ArrayList<String> sinRepetir = new ArrayList<String>();
			for(PersonaDTO p : agenda.obtenerPersonas()) 
				if(!sinRepetir.contains(p.getTipoDomicilio())) {
					sinRepetir.add(p.getTipoDomicilio());	this.ventanaPersona.getTipoDomicilio().addItem(p.getTipoDomicilio());
					this.ventanaEditar.getTipoDomicilio().addItem(p.getTipoDomicilio());

				}
		}
		
		

		public void agregarContacto(ActionEvent a)
		{
			this.ventanaPersona.getContacto().addItem(this.ventanaContacto.getTxtNuevoContacto().getText());
			this.ventanaEditar.getContacto().addItem(this.ventanaContacto.getTxtNuevoContacto().getText());
			ContactoDTO tipoDeContacto = new ContactoDTO (this.ventanaContacto.getTxtNuevoContacto().getText());
			this.agenda.agregarTipoDeContacto(tipoDeContacto);
			this.ventanaContacto.cerrar();
		}
		
		public void agregarPais(ActionEvent a)
		{
			this.ventanaPersona.getPais().addItem(this.ventanaPais.getTxtNuevoPais().getText());
			this.ventanaEditar.getPais().addItem(this.ventanaPais.getTxtNuevoPais().getText());
			PaisDTO pais = new PaisDTO (this.ventanaPais.getTxtNuevoPais().getText());
			this.agenda.agregarPais(pais);
			this.ventanaPais.cerrar();
		}
		
		public void agregarProvincia(ActionEvent a)
		{
			this.ventanaPersona.getProvincia().addItem(this.ventanaProvincia.getTxtNuevoProvincia().getText());
			ProvinciaDTO provincia = new ProvinciaDTO (this.ventanaProvincia.getTxtNuevoProvincia().getText()
												,this.ventanaPersona.getPais().getSelectedItem().toString());
			this.agenda.agregarProvincia(provincia);
			this.ventanaProvincia.cerrar();
		}
		
		public void agregarProvinciaVistaEditar(ActionEvent a)
		{
			this.ventanaEditar.getProvincia().addItem(this.ventanaProvincia.getTxtNuevoProvincia().getText());
			ProvinciaDTO provincia = new ProvinciaDTO (this.ventanaProvincia.getTxtNuevoProvincia().getText()
												,this.ventanaEditar.getPais().getSelectedItem().toString());
			this.agenda.agregarProvincia(provincia);
			this.ventanaProvincia.cerrar();
		}
		
		public void agregarLocalidad(ActionEvent a)
		{
			this.ventanaPersona.getLocalidad().addItem(this.ventanaLocalidad.getTxtNuevoLocalidad().getText());
			LocalidadDTO localidad = new LocalidadDTO (this.ventanaLocalidad.getTxtNuevoLocalidad().getText(),
									this.ventanaPersona.getPais().getSelectedItem().toString(),
									this.ventanaPersona.getProvincia().getSelectedItem().toString());
			this.agenda.agregarLocalidad(localidad);
			this.ventanaLocalidad.cerrar();
		}
		

		private void agregarTipoDomicilio(ActionEvent a) 
		{
			this.ventanaPersona.getTipoDomicilio().addItem(this.ventanaDomicilio.getTxtNuevoDomicilio().getText());
			this.ventanaEditar.getTipoDomicilio().addItem(this.ventanaDomicilio.getTxtNuevoDomicilio().getText());
			this.ventanaDomicilio.cerrar();
		}
		
		private void agregarTipoContacto(ActionEvent a) 
		{
			this.ventanaPersona.getTipoDomicilio().addItem(this.ventanaContacto.getTxtNuevoContacto().getText());
			this.ventanaEditar.getTipoDomicilio().addItem(this.ventanaContacto.getTxtNuevoContacto().getText());
			this.ventanaContacto.cerrar();
		}
	
		
		public void borrarTipoDeContactoVentanaEditar(ActionEvent s)
		{
			ContactoDTO tipo =new ContactoDTO(this.ventanaEditar.getContacto().getSelectedItem().toString());
			this.agenda.borrarContacto(tipo);
			llenarTipoDeContactos();
		}

		public void borrarLocalidad(ActionEvent s)
		{

			LocalidadDTO localidad = new LocalidadDTO(this.ventanaPersona.getLocalidad().getSelectedItem().toString()
					,this.ventanaPersona.getPais().getSelectedItem().toString()
					,this.ventanaPersona.getPais().getSelectedItem().toString());
			this.agenda.borrarLocalidad(localidad);
			llenarPaises();

		}

		public void borrarLocalidadVentanaEditar(ActionEvent s)
		{

			LocalidadDTO localidad = new LocalidadDTO(this.ventanaEditar.getLocalidad().getSelectedItem().toString()
					,this.ventanaEditar.getPais().getSelectedItem().toString()
					,this.ventanaEditar.getPais().getSelectedItem().toString());
			this.agenda.borrarLocalidad(localidad);
			llenarPaises();

		}

		public void borrarPais(ActionEvent s)
		{
			PaisDTO pais = new PaisDTO(this.ventanaPersona.getPais().getSelectedItem().toString());
			String provincia ="" ;
			String loc ="";
			if(this.ventanaPersona.getProvincia().getSelectedItem() != null) {
				provincia= this.ventanaPersona.getProvincia().getSelectedItem().toString();
			}
			ProvinciaDTO prov = new ProvinciaDTO(provincia ,pais.getNombre());
			if(this.ventanaPersona.getLocalidad().getSelectedItem() != null) {
				loc =this.ventanaPersona.getLocalidad().getSelectedItem().toString();
			}
			LocalidadDTO localidad = new LocalidadDTO(loc,pais.getNombre(),prov.getNombre());
			this.agenda.borrarLocalidad2(localidad);
			this.agenda.borrarProvincia2(prov);
			this.agenda.borrarPais(pais);
			llenarPaises();
		}
		
		public void borrarPaisVentanaEditar(ActionEvent s)
		{
			PaisDTO pais = new PaisDTO(this.ventanaEditar.getPais().getSelectedItem().toString());
			String provincia ="" ;
			String loc ="";
			if(this.ventanaEditar.getProvincia().getSelectedItem() != null) {
				provincia= this.ventanaEditar.getProvincia().getSelectedItem().toString();
			}
			ProvinciaDTO prov = new ProvinciaDTO(provincia,pais.getNombre());
			if(this.ventanaEditar.getLocalidad().getSelectedItem() != null) {
				loc =this.ventanaEditar.getLocalidad().getSelectedItem().toString();
			}
			LocalidadDTO localidad = new LocalidadDTO(loc,pais.getNombre(),prov.getNombre());
			this.agenda.borrarLocalidad2(localidad);
			this.agenda.borrarProvincia2(prov);
			this.agenda.borrarPais(pais);
			llenarPaises();
		}

		public void borrarProvinciaVentanaPersona(ActionEvent s)
		{
			ProvinciaDTO prov = new ProvinciaDTO(this.ventanaPersona.getProvincia().getSelectedItem().toString()
					,this.ventanaPersona.getPais().getSelectedItem().toString());
			String loc ="";
			if(this.ventanaPersona.getLocalidad().getSelectedItem() != null) {
				loc = this.ventanaPersona.getLocalidad().getSelectedItem().toString();
			}
			LocalidadDTO localidad = new LocalidadDTO(loc,this.ventanaPersona.getPais().getSelectedItem().toString(),prov.getNombre());
			this.agenda.borrarLocalidad2(localidad);
			this.agenda.borrarProvincia(prov);
			llenarPaises();
		}

		public void borrarProvinciaVentanaEditar(ActionEvent s)
		{
			ProvinciaDTO prov = new ProvinciaDTO(this.ventanaEditar.getProvincia().getSelectedItem().toString()
					,this.ventanaEditar.getPais().getSelectedItem().toString());
			String loc ="";
			if(this.ventanaEditar.getLocalidad().getSelectedItem() != null) {
				loc = this.ventanaEditar.getLocalidad().getSelectedItem().toString();
			}
			LocalidadDTO localidad = new LocalidadDTO(loc,this.ventanaEditar.getPais().getSelectedItem().toString(),prov.getNombre());
			this.agenda.borrarLocalidad2(localidad);
			this.agenda.borrarProvincia(prov);
			llenarPaises();
		}



		public void vaciarProvinciasEditar() 
		{
			this.ventanaEditar.getProvincia().removeAllItems();
		}
		
		public void vaciarProvinciasPersona() 
		{
			this.ventanaPersona.getProvincia().removeAllItems();
		}
		
		public void vaciarLocalidadesEditar() 
		{
			this.ventanaEditar.getProvincia().removeAllItems();
		}
		
		public void vaciarLocalidadesPersona() 
		{
			this.ventanaPersona.getLocalidad().removeAllItems();
		}
		
		public void vaciarPais() 
		{
			this.ventanaPersona.getPais().removeAllItems();
			this.ventanaEditar.getPais().removeAllItems();
		}
		
		public void vaciarDomicilios() 
		{
			this.ventanaPersona.getTipoDomicilio().removeAllItems();
			this.ventanaEditar.getTipoDomicilio().removeAllItems();
		}
		


		private void ventanaDomicilio(ActionEvent a) 
		{
			this.ventanaDomicilio.mostrarVentana();
		}

		private void ventanaPais(ActionEvent a) 
		{
			this.ventanaPais.mostrarVentana();
		}
		
		private void ventanaProvincia(ActionEvent a)
		{
			this.ventanaProvincia.mostrarVentana();
		}
		
		private  void ventanaLocalidad(ActionEvent a) 
		{
			this.ventanaLocalidad.mostrarVentana();;
		}
		
		public void ventanaContacto(ActionEvent a)
		{
			this.ventanaContacto.mostrarVentana();
		}
		
	
		public void inicializar()
		{
			this.refrescarTabla();
			this.vista.show();
			this.login.cerrar();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = agenda.obtenerPersonas();
			this.vista.llenarTabla(this.personasEnTabla);
		}

		
		
		public List<PaisDTO> getPaises() 
		{
			return paises;
		}


		public void setPaises(List<PaisDTO> paises) 
		{
			this.paises = paises;
		}

		public List<ProvinciaDTO> getProvincias() 
		{
			return provincias;
		}


		public void setProvincias(List<ProvinciaDTO> provincias) 
		{
			this.provincias = provincias;
		}



		public List<LocalidadDTO> getLocalidades() 
		{
			return localidades;
		}



		public void setLocalidades(List<LocalidadDTO> localidades) 
		{
			this.localidades = localidades;
		}

	





		@Override
		public void actionPerformed(ActionEvent e) {}

		
}
