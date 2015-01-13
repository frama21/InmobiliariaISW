package presentacion;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;
import excepciones.*;
import logica.*;

@SuppressWarnings("serial")
public class ConsultarInmueblesNoVendidosNiAlquiladosJDialog extends JDialog {
	private JTable tableInmuebles;
	Controlador control;

	public void cargaInmuebles(){ 
		try{
			ArrayList<Inmueble> listaInmuebles = new ArrayList<Inmueble>();
			listaInmuebles = control.encontrarInmuebles();
			ArrayList<Transaccion> listaTrans = new ArrayList<Transaccion>();
			listaTrans = control.encontrarTransacciones();
			Iterator<Inmueble> it = listaInmuebles.iterator();
			String cod_id;
			Transaccion trans;
			Inmueble in;
			InmuebleTableModel model = (InmuebleTableModel) tableInmuebles.getModel();
			model.clear();
			while (it.hasNext()){
				in=it.next();
				boolean encontrado = false;
				Iterator<Transaccion> it2 = listaTrans.iterator();
				while (it2.hasNext()){
					trans=it2.next();
					System.out.println(trans.getOferta().toString());
					cod_id = trans.getOferta().getVisita().getInmueble().getCod_Id();
					if(cod_id.equals(in.getCod_Id().toString())){
						encontrado=true;
					}
				}
				if(!encontrado){
					model.addRow(in);
				}
				encontrado = false;
			}
		}
		catch (Exception e){
			e.printStackTrace();
			//JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarInmueblesNoVendidosNiAlquiladosJDialog dialog = new ConsultarInmueblesNoVendidosNiAlquiladosJDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	class InmuebleTableModel extends AbstractTableModel {
		
		private static final long serialVersionUID = 1L;
		private String[] columnNames = { "C—digo", "Direcci—n","Localidad","Fecha de Alta","Superficie","Venta/Alquiler","Propietario","Asesor"};
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
	
	public ConsultarInmueblesNoVendidosNiAlquiladosJDialog()throws LogicaExcepcion {
		setBounds(130, 130, 760, 380);
		setTitle("Consulta Inmuebles No Vendidos Ni Alquilados");
		control = Controlador.getInstance();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 749, 348);
		getContentPane().setLayout(null);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		tableInmuebles = new JTable(new InmuebleTableModel());
		scrollPane.setViewportView(tableInmuebles);
	}

}
