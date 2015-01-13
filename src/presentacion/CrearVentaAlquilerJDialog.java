package presentacion;

import java.awt.*;
import logica.*;
import excepciones.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


@SuppressWarnings("serial")
public class CrearVentaAlquilerJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	Controlador control;
	private JTextField txtPrecio;
	private JTextField textFecha;
	private JTextField textId;
	private JComboBox ofertasVisitas;
	private JLabel lblOfertasVisitas;
	private JRadioButton rdbtnAlquiler;
	private JRadioButton rdbtnVenta;
	private JRadioButton rdbtninvisible;
	
	public static void main(String[] args) {
		try {
			CrearVentaAlquilerJDialog dialog = new CrearVentaAlquilerJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cargaOfertasVisitas(String asesor){
		try{
			ofertasVisitas.removeAllItems();
			if(asesor.equals("Seleccione un asesor...")){
				ofertasVisitas.setEnabled(false);
				lblOfertasVisitas.setEnabled(false);
				rdbtnAlquiler.setSelected(false);
				rdbtnVenta.setSelected(false);
				rdbtninvisible.setSelected(true);
				txtPrecio.setEnabled(false);
				txtPrecio.setText("Û");
				textId.setEnabled(false);
				textId.setText("");
			}
			else{
				textId.setText("");
				txtPrecio.setText("");
				ofertasVisitas.addItem("Seleccione una oferta...");
				ArrayList<Visita> visitas = control.encontrarVisitasPorAsesor(asesor);
				Iterator<Visita> i = visitas.iterator();
				while(i.hasNext()){
					Visita v = i.next();
					Inmueble in = v.getInmueble();
					ArrayList<Oferta> of = control.encontrarOfertaPorVisita(v.getCod_Id());
					if(!of.isEmpty()){
						Oferta o = of.get(0);
						if(!control.comprobarOfertaTransaccion(o.getCod_Id())){
							ofertasVisitas.addItem("IN: "+in.toString()+" - OF: "+o.toString()+" - VIS: "+v.toString());
						}
					}
				}
				ofertasVisitas.setEnabled(true);
				lblOfertasVisitas.setEnabled(true);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	public CrearVentaAlquilerJDialog()throws LogicaExcepcion {
		setTitle("Nueva Transacci\u00F3n");
		control = Controlador.getInstance();
		setBounds(130, 130, 450, 265);
		getContentPane().setLayout(null);
		contentPanel.setBorder(null);
		contentPanel.setBounds(0, 0, 450, 203);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblAsesores = new JLabel("Asesores:");
		lblAsesores.setBounds(52, 6, 69, 16);
		contentPanel.add(lblAsesores);
		
		final JComboBox asesores = new JComboBox();
		asesores.setBounds(116, 2, 289, 27);
		contentPanel.add(asesores);
		asesores.addItem("Seleccione un asesor...");
		ArrayList<Asesor> asesor = control.encontrarAsesores();
		Iterator<Asesor> i = asesor.iterator();
		while(i.hasNext()){
			Asesor as = i.next();
			asesores.addItem(as.toString());
		}
		asesores.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String as[] = asesores.getSelectedItem().toString().split("-");
	    		cargaOfertasVisitas(as[0]);
			}
		});
		
		lblOfertasVisitas = new JLabel("Ofertas y Visitas:");
		lblOfertasVisitas.setEnabled(false);
		lblOfertasVisitas.setBounds(6, 37, 113, 16);
		contentPanel.add(lblOfertasVisitas);
		
		ofertasVisitas = new JComboBox();
		ofertasVisitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(ofertasVisitas.getSelectedItem() != null){
					if(ofertasVisitas.getSelectedItem().toString().equals("Seleccione una oferta...")){
						rdbtnAlquiler.setSelected(false);
						rdbtnVenta.setSelected(false);
						rdbtninvisible.setSelected(true);
						txtPrecio.setEnabled(false);
						txtPrecio.setText("Û");
						textId.setEnabled(false);
						textId.setText("");
					}
					else{
						try{
							txtPrecio.setEnabled(true);
							textId.setEnabled(true);
							txtPrecio.setText("");
							textId.setText("");
							String datos[] = ofertasVisitas.getSelectedItem().toString().split("-");
							Inmueble in = control.encontrarInmueblePorCod(datos[0].substring(4));
							if(in.getVenta_Alquiler().equals("Venta"))
								rdbtnVenta.setSelected(true);
							else{
								rdbtnAlquiler.setSelected(true);
							}
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
					}
				}
			}
		});
		ofertasVisitas.setEnabled(false);
		ofertasVisitas.setBounds(116, 33, 289, 27);
		contentPanel.add(ofertasVisitas);
		
		JLabel lblPrecio = new JLabel("Precio Final:");
		lblPrecio.setBounds(37, 97, 80, 16);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEnabled(false);
		txtPrecio.setText("\u20AC");
		txtPrecio.setBounds(116, 90, 134, 28);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(72, 125, 40, 16);
		contentPanel.add(lblFecha);
		
		textFecha = new JTextField();
		textFecha.setEditable(false);
		textFecha.setBounds(116, 120, 134, 28);
		contentPanel.add(textFecha);
		textFecha.setColumns(10);
		Date now = new Date();
		DateFormat df =  DateFormat.getDateInstance(DateFormat.DEFAULT);
		textFecha.setText(df.format(now));
		
		final ButtonGroup grupoButton = new ButtonGroup();
		
		rdbtnVenta = new JRadioButton("Venta");
		rdbtnVenta.setEnabled(false);
		rdbtnVenta.setBounds(116, 152, 141, 23);
		contentPanel.add(rdbtnVenta);
		
		rdbtnAlquiler = new JRadioButton("Alquiler");
		rdbtnAlquiler.setEnabled(false);
		rdbtnAlquiler.setBounds(116, 176, 141, 23);
		contentPanel.add(rdbtnAlquiler);
		
		grupoButton.add(rdbtnAlquiler);
		grupoButton.add(rdbtnVenta);
		
		
		JLabel lblId = new JLabel("ID Transaccion:");
		lblId.setBounds(15, 67, 98, 16);
		contentPanel.add(lblId);
		
		textId = new JTextField();
		textId.setEnabled(false);
		textId.setBounds(116, 61, 134, 28);
		contentPanel.add(textId);
		textId.setColumns(10);
		
		rdbtninvisible = new JRadioButton("invisible");
		rdbtninvisible.setEnabled(false);
		rdbtninvisible.setBounds(238, 152, 141, 23);
		contentPanel.add(rdbtninvisible);
		rdbtninvisible.setVisible(false);
		grupoButton.add(rdbtninvisible);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBounds(0, 203, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							String boton;
							if(rdbtnAlquiler.isSelected())
								boton = "Alquiler";
							else
								boton = "Venta";
							String cod = ofertasVisitas.getSelectedItem().toString().split("OF:")[1].split("-")[0].trim();
							Oferta o = control.encontrarOfertaPorCod(cod);
							control.crearTransaccion(new Transaccion(txtPrecio.getText(),textFecha.getText(),boton,o),textId.getText());
							dispose();
						}
						catch(Exception e1){
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
