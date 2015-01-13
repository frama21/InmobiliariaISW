package presentacion;

import java.awt.FlowLayout;

import logica.*;
import excepciones.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

@SuppressWarnings("serial")
public class CrearClienteJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nif;
	private JTextField nombre;
	private JTextField apellidos;
	private Controlador control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearClienteJDialog dialog = new CrearClienteJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearClienteJDialog() throws LogicaExcepcion{
		control = Controlador.getInstance();
		setTitle("Crear Cliente");
		setBounds(130, 130, 306, 157);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 306, 239);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblNif = new JLabel("NIF:");
		lblNif.setBounds(18, 6, 61, 16);
		contentPanel.add(lblNif);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(18, 36, 61, 16);
		contentPanel.add(lblNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(18, 66, 71, 16);
		contentPanel.add(lblApellidos);
		
		nif = new JTextField();
		nif.setBounds(90, 0, 134, 28);
		contentPanel.add(nif);
		nif.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(90, 30, 134, 28);
		contentPanel.add(nombre);
		nombre.setColumns(10);
		
		apellidos = new JTextField();
		apellidos.setBounds(90, 60, 190, 28);
		contentPanel.add(apellidos);
		apellidos.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 94, 304, 39);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							Cliente c = new Cliente(nif.getText(),nombre.getText(),apellidos.getText());
							control.crearCliente(c);
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
