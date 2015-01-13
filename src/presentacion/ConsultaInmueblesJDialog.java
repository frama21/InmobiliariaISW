package presentacion;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import excepciones.*;
import logica.*;

@SuppressWarnings("serial")
public class ConsultaInmueblesJDialog extends JDialog {
	private Controlador control;
	private JTable tableInmuebles;
	
	public void cargaInmuebles(){ 
		try{
			ArrayList<Inmueble> listaInmuebles= control.encontrarInmuebles(); 
			Iterator<Inmueble>it= listaInmuebles.iterator();
			Inmueble in;
			InmuebleTableModel model = (InmuebleTableModel) tableInmuebles.getModel(); 
			model.clear();
			while (it.hasNext()){
				in=it.next(); 
				model.addRow(in);
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	
	class InmuebleTableModel extends AbstractTableModel {
		
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "Código", "Dirección","Localidad","Fecha de Alta","Superficie","Venta/Alquiler","Propietario","Asesor"};
		private ArrayList<Inmueble> data=new ArrayList<Inmueble>();
		
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
				case 6: return in.getCliente().getNombre();
				case 7: return in.getAsesor().getNombre(); 
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaInmueblesJDialog dialog = new ConsultaInmueblesJDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsultaInmueblesJDialog() throws LogicaExcepcion {
		setBounds(130, 130, 760, 348);	
		setTitle("Consultar Inmuebles");
		control = Controlador.getInstance();
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 749, 314);
		getContentPane().add(scrollPane);
		
		tableInmuebles = new JTable(new InmuebleTableModel());
		scrollPane.setViewportView(tableInmuebles);
	}
}
