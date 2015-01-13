package presentacion;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.BorderLayout;

import excepciones.*;
import logica.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InmobiliariaApp {

	private JFrame frmInmobiliaria;
	@SuppressWarnings("unused")
	private Controlador control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InmobiliariaApp window = new InmobiliariaApp();
					window.frmInmobiliaria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InmobiliariaApp() {
		initialize();
		initDominio();
	}
	
	private void initDominio(){
		try{
			control = Controlador.getInstance();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInmobiliaria = new JFrame();
		frmInmobiliaria.setTitle("Inmobiliaria");
		frmInmobiliaria.setBounds(100, 100, 450, 305);
		frmInmobiliaria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmInmobiliaria.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnInmuebles = new JMenu("Inmuebles");
		menuBar.add(mnInmuebles);
		
		JMenuItem mntmCrearPiso = new JMenuItem("Crear Piso");
		mntmCrearPiso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CrearPisoJDialog cp;
					cp = new CrearPisoJDialog();
					cp.setModal(true);
					cp.setVisible(true);
				} 
				catch (LogicaExcepcion e) {
					e.printStackTrace();
				}
			}
		});
		mnInmuebles.add(mntmCrearPiso);
		
		JMenuItem mntmCrearNaveIndustrial = new JMenuItem("Crear Nave Industrial");
		mntmCrearNaveIndustrial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearNaveIndustrialJDialog cni;
				try {
					cni = new CrearNaveIndustrialJDialog();
					cni.setModal(true);
					cni.setVisible(true);
				} catch (LogicaExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnInmuebles.add(mntmCrearNaveIndustrial);
		
		JMenuItem mntmConsultarInmueble = new JMenuItem("Consultar Inmueble");
		mntmConsultarInmueble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ConsultaInmueblesJDialog ci = new ConsultaInmueblesJDialog();
					ci.setModal(true);
					ci.cargaInmuebles();
					ci.setVisible(true);
				}
				catch(LogicaExcepcion e){
					e.printStackTrace();
				}
			}
		});
		mnInmuebles.add(mntmConsultarInmueble);
		
		JMenuItem mntmConsultarVisitasofertas = new JMenuItem("Consultar Visitas/Ofertas");
		mntmConsultarVisitasofertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ConsultarVisitasOfertasInmueblesJDialog cvoi = new ConsultarVisitasOfertasInmueblesJDialog();
					cvoi.setModal(true);
					cvoi.setVisible(true);
				}
				catch(LogicaExcepcion e){
					e.printStackTrace();
				}
			}
		});
		mnInmuebles.add(mntmConsultarVisitasofertas);
		
		JMenuItem mntmConsultaInmueblesDisponibles = new JMenuItem("Consulta Inmuebles Disponibles");
		mntmConsultaInmueblesDisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					ConsultarInmueblesNoVendidosNiAlquiladosJDialog cid = new ConsultarInmueblesNoVendidosNiAlquiladosJDialog();
					cid.setModal(true);
					cid.cargaInmuebles();
					cid.setVisible(true);
				}
				catch(LogicaExcepcion e){
					e.printStackTrace();
				}
			}
		});
		mnInmuebles.add(mntmConsultaInmueblesDisponibles);
		
		JSeparator separator = new JSeparator();
		mnInmuebles.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnInmuebles.add(mntmSalir);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmCrearCliente = new JMenuItem("Crear Cliente");
		mnCliente.add(mntmCrearCliente);
		
		JMenuItem mntmListarClientesinmuebles = new JMenuItem("Listar Clientes-Inmuebles");
		mnCliente.add(mntmListarClientesinmuebles);
		mntmListarClientesinmuebles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					ConsultarClientesInmueblesJDialog cci = new ConsultarClientesInmueblesJDialog(); 
					cci.setModal(true);
					cci.setVisible(true);
				}
				catch(LogicaExcepcion e1){
					e1.printStackTrace();
				}
			}
		});
		mntmCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					CrearClienteJDialog cc;
					cc = new CrearClienteJDialog();
					cc.setModal(true);
					cc.setVisible(true);
				}
				catch(LogicaExcepcion e1){
					e1.printStackTrace();
				}
			}
		});
		
		JMenu mnAsesor = new JMenu("Asesor");
		menuBar.add(mnAsesor);
		
		JMenuItem mntmCrearAsesor = new JMenuItem("Crear Asesor");
		mnAsesor.add(mntmCrearAsesor);
		
		JMenuItem mntmListarAsesoresinmuebles = new JMenuItem("Listar Asesores-Inmuebles");
		mnAsesor.add(mntmListarAsesoresinmuebles);
		
		JMenu mnNewMenu = new JMenu("Transacci\u00F3n");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNuevaTransaccin = new JMenuItem("Nueva transacci\u00F3n");
		mntmNuevaTransaccin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					CrearVentaAlquilerJDialog cva = new CrearVentaAlquilerJDialog();
					cva.setModal(true);
					cva.setVisible(true);
				}
				catch(LogicaExcepcion e1){
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNuevaTransaccin);
		
		JMenu mnOferta = new JMenu("Oferta");
		menuBar.add(mnOferta);
		
		JMenuItem mntmNuevaOferta = new JMenuItem("Nueva oferta");
		mntmNuevaOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					CrearOfertaJDialog co = new CrearOfertaJDialog();
					co.setModal(true);
					co.setVisible(true);
				}
				catch(LogicaExcepcion e1){
					e1.printStackTrace();
				}
			}
		});
		mnOferta.add(mntmNuevaOferta);
		
		JMenu mnVisita = new JMenu("Visita");
		menuBar.add(mnVisita);
		
		JMenuItem mntmNuevaVisita = new JMenuItem("Nueva visita");
		mntmNuevaVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					CrearVisitaJDialog co = new CrearVisitaJDialog();
					co.setModal(true);
					co.setVisible(true);
				}
				catch(LogicaExcepcion e1){
					e1.printStackTrace();
				}
			}
		});
		mnVisita.add(mntmNuevaVisita);
		
		mntmListarAsesoresinmuebles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{	
					ConsultarAsesoresInmueblesJDialog cai;
					cai = new ConsultarAsesoresInmueblesJDialog();
					cai.setModal(true);
					cai.setVisible(true);
				}
				catch(LogicaExcepcion e1){
					e1.printStackTrace();
				}
			}
		});
		mntmCrearAsesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CrearAsesorJDialog ca;
					ca = new CrearAsesorJDialog();
					ca.setModal(true);
					ca.setVisible(true);
				} 
				catch (LogicaExcepcion e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
