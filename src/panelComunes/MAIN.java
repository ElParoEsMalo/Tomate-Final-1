package panelComunes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Especialidades;
import Modelo.Medico;
import Modelo.MedicoActivo;
import control.GestionHorario;

public class MAIN extends JFrame {

	private ArrayList<MedicoActivo> listaMedicos=new ArrayList<>();
	private JPanel contentPane;
//	Seleccion select=new Seleccion();
//	Identificacion identi = new Identificacion();
	VistaCitaIssam citaIssam=new VistaCitaIssam();
	GestionHorario gestionHorario=new GestionHorario();
	MedicoActivo medicoMio=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
//					frame.add(citaIssam);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MAIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(citaIssam);
		setContentPane(contentPane);
		MedicoActivo medico= new MedicoActivo("1", "papito", "mas", "642", Especialidades.AtencionPrimaria);
		MedicoActivo medico2= new MedicoActivo("1", "loTengoTodoPapi", "mas", "642", Especialidades.AtencionPrimaria);
		listaMedicos.add(medico);
		listaMedicos.add(medico2);
		gestionHorario.ocuparConsultaPrimaria(1, medico);
		gestionHorario.ocuparConsultaEspecialista(0, medico2);
		citaIssam.getCmbMedico().addItem("papito");
		citaIssam.getCmbMedico().addItem("loTengoTodoPapi");
		MedicoActivo copia=medico;
		System.out.println(copia.getNombre());
		System.out.println(medico.getNombre());
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (Iterator iterator = listaMedicos.iterator(); iterator.hasNext();) {
					MedicoActivo medicoActivo = (MedicoActivo) iterator.next();
					if(medicoActivo.getNombre().equals(citaIssam.getCmbMedico().getSelectedItem().toString())) {
				System.out.println("el medico selecciondo es: "+medicoActivo.getNombre());
				limpiarBotonera();
				System.out.println(medicoActivo.getDireccion());
				medicoActivo.setDireccion("hola wuanjo");
				citaIssam.asignarLabels( medicoActivo.getHorarioConsulta().getHoraTrabajo());
//				System.out.println(medicoMio.getHorarioConsulta().getDia());
//				System.out.println(medicoMio.getHorarioConsulta().getFechaCita());
				medicoActivo.getHorarioConsulta().reservarDias();
				citaIssam.asignarHorario(medicoActivo.getHorarioConsulta().getHorarioSemanal());
				}}
				}
		});
		for (int i = 0; i < citaIssam.botonera.length; i++) {
			for (int j = 0; j < citaIssam.botonera[i].length; j++) {
				citaIssam.botonera[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						for (Iterator iterator = listaMedicos.iterator(); iterator.hasNext();) {
							MedicoActivo medicoActivo = (MedicoActivo) iterator.next();
							if(medicoActivo.getNombre().equals(citaIssam.getCmbMedico().getSelectedItem().toString())) {
						JButton boton = (JButton) e.getSource();
						System.out.println(medicoActivo.getDireccion());
						medicoActivo.setDireccion("hola bb");
						int hora = Integer.valueOf(Character.toString(boton.getName().charAt(0)));
						int dia = Integer.valueOf(Character.toString(boton.getName().charAt(1)));
						medicoActivo.getHorarioConsulta().seleccionarDia(hora, dia);
						citaIssam.asignarHorario(medicoActivo.getHorarioConsulta().getHorarioSemanal());
					System.out.println(hora + " " + dia);
							}
						}
					}
				});
			}
		}
		contentPane.add(btnAplicar, BorderLayout.NORTH);
		
	}
	public void limpiarBotonera() {
		for (int i = 0; i < citaIssam.botonera.length; i++) {
			for (int j = 0; j < citaIssam.botonera[i].length; j++) {
				citaIssam.botonera[i][j].setBackground(new JButton().getBackground());
			}
	}
	}
	public MedicoActivo getMedico() {
		MedicoActivo retorno=null;
		for (Iterator iterator = listaMedicos.iterator(); iterator.hasNext();) {
			MedicoActivo medicoActivo = (MedicoActivo) iterator.next();
			if(medicoActivo.getNombre().equals(citaIssam.getCmbMedico().getSelectedItem())) {
				retorno=medicoActivo;
			}
		}
		return retorno;
	}

}