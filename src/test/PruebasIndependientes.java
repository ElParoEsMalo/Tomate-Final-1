package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import Modelo.Cita;
import Modelo.Consulta;
import Modelo.DiasDeLaSemana;
import Modelo.Especialidades;
import Modelo.Horario;
import Modelo.Medico;
import Modelo.Paciente;
import adaptadores.AdaptadorArraylist;
import control.GestionCitas;
import control.GestionHorario;

class PruebasIndependientes {

	@Ignore
	void test() {
		ArrayList<String[]> filas = new ArrayList<>();
		String data[][] = new String[2][1];
		String[] titulosColumnas = { "Paciente", "Operacion", "Cirujano", "Resultado" };
		String[] titulosColumnas2 = { "asffas", "gasfgasf", "wter", "hgf" };
		filas.add(titulosColumnas);
		filas.add(titulosColumnas2);
		System.out.println(data[0].length);
		String cadena2[] = new String[1];
		System.out.println(data.length);

//		filas.add(filas2.toArray(cadena2));
//		filas.add(filas2.toArray(cadena2));

		String cadena[] = new String[1];
//		for (String [] string : filas) {
//			System.out.println(string);
//			for (int i = 0; i < string.length; i++) {
//				System.out.println(string[i]);
//			}
//		}

	}

	@Test
	void test2() {
		ArrayList<Integer[]> prueba = new ArrayList<Integer[]>();
		ArrayList<Integer> prueba2 = new ArrayList<Integer>();
		Integer[][] res;
		Integer[][] res2 = new Integer[1][1];
		AdaptadorArraylist<Integer> adArraylist = new AdaptadorArraylist<Integer>();
		for (int i = 0; i < 10; i++) {
			prueba2.add(i);
		}
		prueba.add(adArraylist.convertir(Integer.class, prueba2));
		prueba.add(adArraylist.convertir(Integer.class, prueba2));
		res = prueba.toArray(new Integer[1][1]);

	}
	@Ignore
	void pruebaObternerTurno() {
		Medico medico= new Medico("1", "pepito", "mas", "642", Especialidades.AtencionPrimaria);
		GestionHorario gestionConsultas=new GestionHorario();
		gestionConsultas.ocuparConsultaPrimaria(0, medico);
		LocalTime[]horarioEsperado= {LocalTime.of(8, 0),LocalTime.of(9, 0),LocalTime.of(10, 0),LocalTime.of(11, 0)};
		assertArrayEquals(medico.getHorario(),horarioEsperado);
		assertTrue(gestionConsultas.getConsultasPrimaria()[0]==1);
		
	}
	@Ignore
	void getDatos() {
		ArrayList<Cita> lista=new ArrayList<Cita>();
		Date date=new Date(1992,2,10);
		Medico medico= new Medico("1", "Papaito", "mas", "642", Especialidades.AtencionPrimaria);
		Paciente paciente= new Paciente("2", "chiquito", "direccion", "telefono", date);
		Cita cita=new Cita("1", paciente, medico, LocalDateTime.of(LocalDate.of(2019, 06, 12), LocalTime.of(20, 0)), DiasDeLaSemana.Monday);
		lista.add(cita);
		lista.add(cita);
		GestionCitas gestionCitas=new GestionCitas();
		String[]retorno;
		int []campos= {1,2,3};
		String[][] camposMatriz;
		camposMatriz=gestionCitas.getDatos(lista, campos);
		retorno=gestionCitas.getDatosCita(cita,campos);
		String[]retornoEsperado= {"AtencionPrimaria","2019-06-12T20:00","Papaito"};
		String[][]retornoMatrizEsperado= {{"AtencionPrimaria","2019-06-12T20:00","Papaito"},{"AtencionPrimaria","2019-06-12T20:00","Papaito"}};
		assertArrayEquals(retornoEsperado, retorno);
		assertArrayEquals(retornoMatrizEsperado, camposMatriz);
	}
	@Test
	void Horario() {
		DiasDeLaSemana[] diaTrabajo = { DiasDeLaSemana.Monday, DiasDeLaSemana.Tuesday, DiasDeLaSemana.Wednesday,
				DiasDeLaSemana.ThursDay, DiasDeLaSemana.Friday };
		LocalTime[]horaTrabajo= {LocalTime.of(8, 0),LocalTime.of(9, 0),LocalTime.of(10, 0),LocalTime.of(11, 0)};
		Horario horario=new Horario(horaTrabajo, diaTrabajo);
		int horarioEsperado[][]= {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
		assertArrayEquals(horarioEsperado, horario.getHorarioSemanal());
		horario.seleccionarDia(0, 0);
		assertTrue(horario.getHorarioSemanal()[0][0]==2);
		horario.seleccionarDia(0, 0);
		assertTrue(horario.getHorarioSemanal()[0][0]==1);
		horario.seleccionarDia(0, 0);
		System.out.println(horario.getFechaCita());
		horario.reservarDias();
		assertTrue(horario.getHorarioSemanal()[0][0]==3);
		assertTrue(horario.getHorarioSemanal()[0][1]!=3);
		System.out.println((LocalDate.now().getDayOfMonth()));
	}
}
