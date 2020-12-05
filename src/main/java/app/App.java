package app;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.CompetenciaDAOHibernate;
import dao.ParticipanteDAO;
import dao.ParticipanteDAOHibernate;
import dominio.Deporte;
import dominio.Competencia;
import dominio.Competencia.Estado;
import dto.CompetenciaDTO;
import dto.ParticipanteDTO;
import exceptions.EstadoCompetenciaException;
import exceptions.ReservasInsuficientesException;
import gestor.*;
import gui.*;
import utils.HibernateUtils;

@SuppressWarnings("serial")
public class App extends JFrame {

	private JPanel tpPanel;
	private CardLayout cl;
	private GestorDeporte gestorDeporte;
	private GestorCompetencia gestorCompetencia;
	private PantallaPrincipalUsuarioNoAutenticado usuarioNoA;
	private PantallaIniciarSesion iniciarSesion;
	private PantallaPrincipalUsuarioAutenticado usuarioA;
	private AltaCompetencia altaCompetencia;
	private ListarCompetencias listarCompetencias;
	private ListarCompetencias listarMisCompetencias;
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("testeando");
//		
//		
//		SessionFactory factory = new Configuration()
//									.configure("hibernate.cfg.xml")
//									.addAnnotatedClass(Deporte.class)
//									.buildSessionFactory();
//		Session session = factory.openSession();
//		
//		try {
//			Deporte temp = new Deporte("Tenis");
//			session.beginTransaction();
//			session.save(temp);
//			session.getTransaction().commit();
//			} finally {
//			factory.close();
//		}
//		
//	}
	
	public void armarApp() {
		this.setBackground(Color.WHITE);
		this.setTitle("Trabajo Pr�ctico 2020 - Dise�o de Sistemas");
		this.setMinimumSize(new Dimension(1280, 720));
		this.setMaximumSize(new Dimension(1280, 720));
		this.setPreferredSize(new Dimension(1280, 720));
		this.setBounds(43, 43, 1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Inicializar gestores
		gestorDeporte = new GestorDeporte();
		gestorCompetencia = new GestorCompetencia();
		
		//Inicializar paneles y CardLayout
		tpPanel = new JPanel();
		cl = new CardLayout(0,0);
		tpPanel.setLayout(cl);
		
		usuarioNoA = new PantallaPrincipalUsuarioNoAutenticado(tpPanel);
		iniciarSesion = new PantallaIniciarSesion(tpPanel);
		usuarioA = new PantallaPrincipalUsuarioAutenticado(tpPanel);
		altaCompetencia = new AltaCompetencia(tpPanel, gestorDeporte, gestorCompetencia);
		listarCompetencias = new ListarCompetencias(tpPanel, gestorDeporte, gestorCompetencia);
		listarMisCompetencias = new ListarCompetencias(tpPanel, gestorDeporte, gestorCompetencia);
		
		tpPanel.add(usuarioNoA, "Card__UsuarionNoAutenticado");
		tpPanel.add(iniciarSesion, "Card__IniciarSesion");
		tpPanel.add(usuarioA, "Card__UsuarioAutenticado");
		tpPanel.add(altaCompetencia, "Card__AltaCompetencia");
		tpPanel.add(listarCompetencias, "Card__ListarCompetencias");
		tpPanel.add(listarMisCompetencias, "Card__MisCompetencias");

		this.setContentPane(tpPanel);
		this.pack();
		//revalidate();
		//repaint();
	} 
	
	private App(){
		armarApp();
	}
	
	public static void main(String[] args) {
		
		/*
		###########Para probar metodo de participanteDAO###########
		
		ParticipanteDTO participante = new ParticipanteDTO("esteban", "esteban@gmail.com");
		CompetenciaDTO competencia = new CompetenciaDTO(5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		ParticipanteDAO participanteDAO = new ParticipanteDAOHibernate();
		System.out.println(participanteDAO.nombreOEmailYaExiste(participante, competencia));


		// TODO Auto-generated method stub
		System.out.println("testeando");
		
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.buildSessionFactory();
		###########Para probar metodo de modificar###########
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		Deporte temp = new Deporte("PES");

		
		try {
			session.beginTransaction(); 
			session.save(temp);
			session.getTransaction().commit();
			session.beginTransaction(); 
			temp.setNombre("Baseboll");
			session.update(temp);
			session.getTransaction().commit();
		} finally {
				session.close();
		}
	
		*/
		//###########Para probar metodo de alta Participante###########
		CompetenciaDAOHibernate competenciaDAO= new CompetenciaDAOHibernate();
		
		//Esta fallando esto de competenciaDTO
		GestorCompetencia gestorCompetencia = new GestorCompetencia();
		
		
//		CompetenciaDTO competencia= new CompetenciaDTO(20,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);

		
////		ParticipanteDTO participante = new ParticipanteDTO("Esteban Echandia", "esteban123@gmail.com");
////		GestorParticipante gestorParticipante = new GestorParticipante();
////		try {
////			gestorParticipante.crearParticipante(participante, competencia);
////			System.out.println("funciono");
////		} catch (Exception e1) {
////			System.out.println("F");
////			e1.printStackTrace();
////		}
////		
//		
		
		
//		try {
//			gestorCompetencia.generarFixture(competencia);
//		} catch (EstadoCompetenciaException e1) {
//			System.out.println(e1.getMessage());
//		
//		} catch (ReservasInsuficientesException e1) {
//			System.out.println(e1.getMessage());
//			
//		}
//		
//		
//		
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				  try {
					  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					  
				  }  
			    catch (UnsupportedLookAndFeelException e) {
			    	e.printStackTrace();
			       // handle exception
			    }
			    catch (ClassNotFoundException e) {
			    	e.printStackTrace();
			       // handle exception
			    }
			    catch (InstantiationException e) {
			    	e.printStackTrace();
			       // handle exception
			    }
			    catch (IllegalAccessException e) {
			    	e.printStackTrace();
			       // handle exception
			    }
				  
				  EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								App ventana = new App();
								ventana.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
			}
		});
	}
}

