package vistaMedico;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import panelComunes.Identificacion;
import panelComunes.Mensaje;
import panelComunes.Seleccion;

public class BajaMedico extends JPanel {
	private JTextField bajaConsulta;
	private JTextField bajaHorario;
	private JTextField txtEspecialidad;

	Mensaje mensaje;
	Identificacion identificacion;

	/**
	 * Create the frame.
	 */
	public BajaMedico() {
		setBounds(100, 100, 657, 466);

		JLabel lblEspecialidad = new JLabel("Especialidad");

		JLabel lblConsulta = new JLabel("Consulta");

		JLabel lblHorario = new JLabel("Horario");

		bajaConsulta = new JTextField();
		bajaConsulta.setEditable(false);
		bajaConsulta.setColumns(10);

		bajaHorario = new JTextField();
		bajaHorario.setEditable(false);
		bajaHorario.setColumns(10);

		JLabel lblAltaMedico = new JLabel("Baja Medico");
		lblAltaMedico.setFont(new Font("Tahoma", Font.PLAIN, 24));

		Seleccion seleccion = new Seleccion();
		mensaje = new Mensaje();
		identificacion = new Identificacion();

		int[] camposDeshabilitados = { 0, 1, 2, 3, 4 };
		identificacion.deshabilitarCampo(camposDeshabilitados);

		txtEspecialidad = new JTextField();
		txtEspecialidad.setEditable(false);
		txtEspecialidad.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(133)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(identificacion, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
										.addComponent(seleccion, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(143)
								.addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING).addComponent(lblEspecialidad)
										.addComponent(lblConsulta).addComponent(lblHorario))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(bajaHorario, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
										.addComponent(bajaConsulta, 145, 145, Short.MAX_VALUE)
										.addComponent(txtEspecialidad, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
								.addGap(191)))
				.addGap(103))
				.addGroup(
						gl_contentPane.createSequentialGroup().addContainerGap()
								.addComponent(lblAltaMedico, GroupLayout.PREFERRED_SIZE, 187,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(458, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(37)
						.addComponent(mensaje, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE).addGap(34)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblAltaMedico).addGap(41)
				.addComponent(seleccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(22).addComponent(identificacion, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblEspecialidad)
						.addComponent(txtEspecialidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblConsulta).addComponent(
						bajaConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblHorario).addComponent(
						bajaHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(mensaje, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGap(30)));
		this.setLayout(gl_contentPane);
	}

	public Identificacion getIdentificacionBajaMedico() {
		return identificacion;
	}

	public void setIdentificacionBajaMedico(Identificacion identificacion) {
		this.identificacion = identificacion;
	}

	public Mensaje getMensajeBajaMedico() {
		return mensaje;
	}

	public void setMensajeBajaMedico(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public String getTxtNombre() {
		return identificacion.getTextNombre().getText();
	}

	public String getTextApellidos() {
		return identificacion.getTextApellidos().getText();
	}

	public String getTextDireccion() {
		return identificacion.getTextDireccion().getText();
	}

	public String getTextTelefono() {
		return identificacion.getTextTelefono().getText();
	}

	public String getTxtNacimiento() {
		return identificacion.getTxtNacimiento().getText();
	}

	public String getTextField() {
		return mensaje.getTextField().getText();
	}

	public JTextField getBajaConsulta() {
		return bajaConsulta;
	}

	public void setBajaConsulta(JTextField bajaConsulta) {
		this.bajaConsulta = bajaConsulta;
	}

	public JTextField getBajaHorario() {
		return bajaHorario;
	}

	public void setBajaHorario(JTextField bajaHorario) {
		this.bajaHorario = bajaHorario;
	}

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}


}
