package presentacion;

import java.awt.event.*;
import java.util.*;

import logica.*;
import excepciones.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ConsultarClientesInmueblesJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableInmueblesClientes;
	private Controlador control;

	public void cargaInmuebles(String cod){ 
		try{
			ArrayList<Inmueble> listaInmuebles = control.encontrarInmueblesPorCliente(cod);
			InmuebleTableModel model=(InmuebleTableModel) tableInmueblesClientes.getModel();
			Iterator<Inmueble> it= listaInmuebles.iterator();
			Inmueble in;
			model.clear();
			model.fireTableDataChanged();
			while (it.hasNext()){
				in=it.next(); 
				model.addRow(in);
			}
			this.setModal(true);
			this.setVisible(true);
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public class InmuebleTableModel extends AbstractTableModel {
		
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "Código", "Dirección","Localidad","Fecha de Alta","Superficie","Venta/Alquiler","Asesor"};
		private ArrayList<Inmueble> data = new ArrayList<Inmueble>();
		
		public int getColumnCount(){ 
			return columnNames.length;
		}
		
		public int getRowCount(){
			return data.size();
		}
		
		public String getColumnName(int col){
			return columnNames[col];
		}

		public Object getValueAt(int row, int col){
			Inmueble in = data.get(row);
			switch(col){
				case 0: return in.getCod_Id();
				case 1: return in.getCalle();
				case 2: return in.getLocalidad();
				case 3: return in.getFecha_Alta();
				case 4: return in.getSuperficie_Total();
				case 5: return in.getVenta_Alquiler();
				case 6: return in.getAsesor().getNombre();
				default: return null;
			}
		}
		
		public void clear(){
			data.clear();
		}

		public Class<? extends Object> getColumnClass(int c){
			return getValueAt(0, c).getClass();
		}
		
		public void addRow(Inmueble row){
			data.add(row); 
			this.fireTableDataChanged();
		}
		
		public void delRow(int row){
			data.remove(row); 
			this.fireTableDataChanged();
		} 
	}
	
	
	public static void main(String[] args) {
		try {
			ConsultarClientesInmueblesJDialog dialog = new ConsultarClientesInmueblesJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ConsultarClientesInmueblesJDialog() throws LogicaExcepcion {
		setTitle("Consultar Clientes Inmuebles");
		control = Controlador.getInstance();
		setBounds(130, 130, 688, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 682, 278);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(142, 6, 48, 16);
		contentPanel.add(lblCliente);
		
		final JComboBox cliente = new JComboBox();
		cliente.setBounds(202, 2, 289, 27);
		contentPanel.add(cliente);
		ArrayList<Cliente> clientes = control.encontrarClientes();
		Iterator<Cliente> i = clientes.iterator();
		cliente.addItem("Seleccione un cliente...");
		while(i.hasNext()){
			Cliente cl = i.next();
			cliente.addItem(cl.toString());
		}
		cliente.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent arg0) {
	        	String cl[] = cliente.getSelectedItem().toString().split("-");
	    		cargaInmuebles(cl[0]);
	        }
	    });

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 34, 676, 238);
		contentPanel.add(scrollPane);
		
		tableInmueblesClientes = new JTable(new InmuebleTableModel());
		scrollPane.setViewportView(tableInmueblesClientes);
	}
}
