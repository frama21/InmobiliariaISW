package presentacion;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import excepciones.*;
import logica.*;

@SuppressWarnings("serial")
public class CrearAsesorJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codigo;
	private JTextField nombre;
	private Controlador control;


	public static void main(String[] args) {
		try {
			CrearAsesorJDialog dialog = new CrearAsesorJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearAsesorJDialog() throws LogicaExcepcion{
		setTitle("Crear Asesor");
		control = Controlador.getInstance();
		setTitle("CREAR ASESORES");
		setBounds(130, 130, 353, 137);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCdigoEm = new JLabel("C\u00F3digo:");
			lblCdigoEm.setBounds(18, 18, 61, 16);
			contentPanel.add(lblCdigoEm);
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(18, 46, 61, 16);
			contentPanel.add(lblNombre);
		}
		
		codigo = new JTextField();
		codigo.setBounds(95, 12, 134, 28);
		contentPanel.add(codigo);
		codigo.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(95, 40, 200, 28);
		contentPanel.add(nombre);
		nombre.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg) {
						try{
							Asesor a = new Asesor(codigo.getText(),nombre.getText());
							control.crearAsesor(a);
							dispose();
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
				});
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
