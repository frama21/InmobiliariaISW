package presentacion;

import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import javax.swing.*;

import java.util.*;

import excepciones.*;
import logica.*;

@SuppressWarnings("serial")
public class CrearNaveIndustrialJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigo;
	private JTextField direccion;
	private JTextField localidad;
	private JTextField fecha_alta;
	private JTextField superficie;
	private JTextField puertas;
	private JTextField calificacion;
	private Controlador control;

	public static void main(String[] args) {
		try {
			CrearNaveIndustrialJDialog dialog = new CrearNaveIndustrialJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CrearNaveIndustrialJDialog() throws LogicaExcepcion {
		setTitle("Crear Nave Industrial");
		control = Controlador.getInstance();
		setBounds(130, 130, 479, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("C\u00F3digo:");
			lblNewLabel.setBounds(18, 6, 49, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_1.setBounds(18, 36, 72, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblLocalidad = new JLabel("Localidad:");
			lblLocalidad.setBounds(18, 66, 72, 16);
			contentPanel.add(lblLocalidad);
		}
		{
			JLabel lblFechaAlta = new JLabel("Fecha:");
			lblFechaAlta.setBounds(18, 96, 72, 16);
			contentPanel.add(lblFechaAlta);
		}
		{
			JLabel lblSuperficie = new JLabel("Superficie:");
			lblSuperficie.setBounds(18, 126, 72, 16);
			contentPanel.add(lblSuperficie);
		}
		{
			JLabel lblPropietario = new JLabel("Num. Puertas:");
			lblPropietario.setBounds(18, 155, 95, 16);
			contentPanel.add(lblPropietario);
		}
		{
			JLabel lblCalificacin = new JLabel("Calificaci\u00F3n:");
			lblCalificacin.setBounds(18, 185, 84, 16);
			contentPanel.add(lblCalificacin);
		}
		{
			JLabel lblCliente = new JLabel("Cliente:");
			lblCliente.setBounds(18, 215, 61, 16);
			contentPanel.add(lblCliente);
		}
		{
			JLabel lblAsesor_1 = new JLabel("Asesor:");
			lblAsesor_1.setBounds(18, 245, 61, 16);
			contentPanel.add(lblAsesor_1);
		}
		{
			codigo = new JTextField();
			codigo.setBounds(115, 2, 134, 28);
			contentPanel.add(codigo);
			codigo.setColumns(10);
		}
		{
			direccion = new JTextField();
			direccion.setBounds(115, 30, 340, 28);
			contentPanel.add(direccion);
			direccion.setColumns(10);
		}
		{
			localidad = new JTextField();
			localidad.setBounds(115, 60, 134, 28);
			contentPanel.add(localidad);
			localidad.setColumns(10);
		}
		{
			fecha_alta = new JTextField();
			fecha_alta.setBounds(115, 90, 134, 28);
			contentPanel.add(fecha_alta);
			fecha_alta.setColumns(10);
		}
		{
			superficie = new JTextField();
			superficie.setBounds(115, 120, 134, 28);
			contentPanel.add(superficie);
			superficie.setColumns(10);
		}
		{
			puertas = new JTextField();
			puertas.setBounds(115, 149, 134, 28);
			contentPanel.add(puertas);
			puertas.setColumns(10);
		}
		{
			calificacion = new JTextField();
			calificacion.setBounds(115, 180, 134, 28);
			contentPanel.add(calificacion);
			calificacion.setColumns(10);
		}
		
		final JComboBox cliente = new JComboBox();
		cliente.setBounds(115, 210, 215, 27);
		contentPanel.add(cliente);
		ArrayList<Cliente> propietarios = control.encontrarClientes();
		Iterator<Cliente> c = propietarios.iterator();
		while(c.hasNext()){
			Cliente cl = c.next();
			cliente.addItem(cl.toString());
		}
		
		final JComboBox asesor = new JComboBox();
		asesor.setBounds(115, 240, 215, 27);
		contentPanel.add(asesor);
		ArrayList<Asesor> asesores = control.encontrarAsesores();
		Iterator<Asesor> i = asesores.iterator();
		while(i.hasNext()){
			Asesor as = i.next();
			asesor.addItem(as.toString());
		}
		
		ButtonGroup grupoButton = new ButtonGroup();
		
		JRadioButton venta = new JRadioButton("Venta");
		venta.setBounds(115, 270, 141, 23);
		contentPanel.add(venta);
		
		final JRadioButton alquiler = new JRadioButton("Alquiler");
		alquiler.setBounds(115, 295, 141, 23);
		contentPanel.add(alquiler);
		
		grupoButton.add(venta);
		grupoButton.add(alquiler);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							String as[] = asesor.getSelectedItem().toString().split("-");
							String cl[] = cliente.getSelectedItem().toString().split("-");
							Cliente c = control.encontrarClientePorCod(cl[0]);
							Asesor a = control.encontrarAsesorPorCod(as[0]);
							String opcion;
							if(alquiler.isSelected()) opcion = "Alquiler";
							else opcion = "Venta";
							NaveIndustrial ni = new NaveIndustrial(codigo.getText(),direccion.getText(),localidad.getText(),
									fecha_alta.getText(),superficie.getText(),opcion,puertas.getText(),calificacion.getText(),c,a);
							control.crearNaveIndustrial(ni);
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
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
