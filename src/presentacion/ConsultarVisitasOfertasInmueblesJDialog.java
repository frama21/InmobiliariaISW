package presentacion;

import java.awt.*;
import excepciones.*;
import java.util.*;
import javax.swing.table.*;
import logica.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ConsultarVisitasOfertasInmueblesJDialog extends JDialog {
	
	private JTable tableVisitasOfertasInmuebles;
	Controlador control;
	private JComboBox visitas;
	private JLabel lblVisitas;
	private InmuebleTableModel model;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarVisitasOfertasInmueblesJDialog dialog = new ConsultarVisitasOfertasInmueblesJDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void cargaVisitas(String inmueble){
		try{
			visitas.removeAllItems();
			if(inmueble.equals("Seleccione un inmueble...")){
				model.clear();
				model.fireTableDataChanged();
				visitas.setEnabled(false);
				lblVisitas.setEnabled(false);
			}
			else{
				visitas.addItem("Seleccione una visita...");
				ArrayList<Visita> vis = control.encontrarVisitasPorInmueble(inmueble);
				Iterator<Visita> i = vis.iterator();
				while(i.hasNext()){
					Visita v = i.next();
					visitas.addItem(v.toString());
				}
				visitas.setEnabled(true);
				lblVisitas.setEnabled(true);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);			
		}
	}
	
	
	public void cargaOfertas(String cod){ 
		try{
			ArrayList<Oferta> ofertas = control.encontrarOfertaPorVisita(cod);
			model=(InmuebleTableModel) tableVisitasOfertasInmuebles.getModel();
			Iterator<Oferta> it = ofertas.iterator();
			Oferta of;
			model.clear();
			model.fireTableDataChanged();
			while (it.hasNext()){
				of=it.next(); 
				model.addRow(of);
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
		private String[] columnNames = { "Fecha", "Precio"};
		private ArrayList<Oferta> data = new ArrayList<Oferta>();
		
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
			Oferta of = data.get(row);
			switch(col){
				case 0: return of.getFecha();
				case 1: return of.getPrecio();
				default: return null;
			}
		}
		
		public void clear(){
			data.clear();
		}

		public Class<? extends Object> getColumnClass(int c){
			return getValueAt(0, c).getClass();
		}
		
		public void addRow(Oferta row){
			data.add(row); 
			this.fireTableDataChanged();
		}
		
		public void delRow(int row){
			data.remove(row); 
			this.fireTableDataChanged();
		} 
	}

	
	public ConsultarVisitasOfertasInmueblesJDialog()throws LogicaExcepcion {
		setTitle("Consulta Visitas y Ofertas de los Inmuebles");
		control = Controlador.getInstance();
		setBounds(130, 130, 469, 300);
		getContentPane().setLayout(null);
		
		JLabel lblInmuebles = new JLabel("Inmuebles:");
		lblInmuebles.setBounds(47, 6, 69, 16);
		getContentPane().add(lblInmuebles);
		
		final JComboBox inmuebles = new JComboBox();
		inmuebles.addItem("Seleccione un inmueble...");
		ArrayList<Inmueble> in = control.encontrarInmuebles();
		Iterator<Inmueble> i = in.iterator();
		while(i.hasNext()){
			Inmueble im = i.next();
			inmuebles.addItem(im.toString());
		}
		inmuebles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try{
					String inm[] = inmuebles.getSelectedItem().toString().split("-");
					cargaVisitas(inm[0]);
				}
				catch(Exception e){
					
				}
			}
		});
		inmuebles.setBounds(120, 2, 289, 27);
		getContentPane().add(inmuebles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 65, 454, 207);
		getContentPane().add(scrollPane);
		
		tableVisitasOfertasInmuebles = new JTable(new InmuebleTableModel());
		scrollPane.setViewportView(tableVisitasOfertasInmuebles);
		
		lblVisitas = new JLabel("Visitas:");
		lblVisitas.setEnabled(false);
		lblVisitas.setBounds(47, 37, 61, 16);
		getContentPane().add(lblVisitas);
		
		visitas = new JComboBox();
		visitas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(visitas.getSelectedItem() != null){
					String vis[] = visitas.getSelectedItem().toString().split("-");
					cargaOfertas(vis[0]);
				}
			}
		});
		visitas.setEnabled(false);
		visitas.setBounds(120, 33, 289, 27);
		getContentPane().add(visitas);
		

	}
}
