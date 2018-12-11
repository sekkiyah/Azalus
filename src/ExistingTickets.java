import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;

public class ExistingTickets extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnAddDemo;
	private HashMap<Integer,Ticket> hmap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExistingTickets frame = new ExistingTickets();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExistingTickets() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 960);
		
		//TEST CODE
		TicketApplication app = new TicketApplication();
		Map<Integer,Ticket> hmap = new HashMap<>(app.getHmap());
		app.createTicket("Seth", "Hinshaw");
		app.createTicket();
		app.createTicket("Shiori", "Takashima");
		app.createTicket("Priscilla", "Guevara");
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainSplash.main(null);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		menuBar.add(btnHome);
		
		btnAddDemo = new JButton("Open Ticket");
		btnAddDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				app.createTicket("Seth", "Hinshaw");
			}
		});
		btnAddDemo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		menuBar.add(btnAddDemo);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 21, 1372, 806);
		contentPane.add(scrollPane);
		
		
		/*
		 * 
		 */
		table = new JTable(app.getHmap().size(),2);
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowHeight(35);
		
//		Set<Entry<Integer, Ticket>> set = app.getHmap().entrySet();
//		Iterator<Entry<Integer, Ticket>> iterator = set.iterator();
//		while(iterator.hasNext()) {
//			Entry<Integer, Ticket> mentry = iterator.next();
//			//String c0 = String.valueOf(mentry.getKey());
//			//String c1 = mentry.getValue().getCust().toString();
//			model.setValueAt(mentry.getKey().intValue(), row, 0);
//			model.setValueAt(mentry.getValue().getCust().toString(), row, 1);
//			row++;
//		}
//		table.setModel(model);
//			OLD
//		String[][] tableArray = new String[2][app.getHmap().size()];
//		String[] colNames = new String[2];
//		
//		Set<Entry<Integer, Ticket>> set = hmap.entrySet();
//		Iterator<Entry<Integer, Ticket>> iterator = set.iterator();
//		int row = 0;
//		for(int x=0; x<app.getHmap().size(); x++) {
//			for(int y=0; y<2; y++) {
//				if(y==0) {
//					tableArray[x][y] = app.getKey().toString();
//				} else {
//					tableArray[x][y] = app.getTicketIndex(app.getKey().getKey()).getCust().toString();
//				}
//			}
//		}
//		
//		table.setModel(new DefaultTableModel(tableArray, colNames));
//		
//		table.setModel(new DefaultTableModel(
//				new Object[][] {
//					//{mentry.getKey(), mentry.getValue().getCust().toString()}
//				}, getDefaultCloseOperation()));
//		while(iterator.hasNext()) {
//			Entry<Integer, Ticket> mentry = iterator.next();
//			String c0 = String.valueOf(mentry.getKey());
//			String c1 = mentry.getValue().getCust().toString();
//			//table.setValueAt(row, row, 0);
//			//table.setValueAt(mentry.getValue().getCust().toString(), row, 1);
//			row++;
			
			
			
//			table.setModel(new DefaultTableModel(
//					new Object[][] {
//						{mentry.getKey(), mentry.getValue().getCust().toString()}
//					}, getDefaultCloseOperation()));
//			System.out.print("Key: "+ mentry.getKey() + ", Value: ");
//			System.out.println(mentry.getValue());
//		}
		
	
				//WORKS
 			table.setModel(new DefaultTableModel(
				new Object[][] {
					//while(iterator.hasNext()) {
						//Entry<Integer, Ticket> mentry = iterator.next();
						//table.setValueAt(mentry.getKey(), row, 0);
						//table.setValueAt(mentry.getValue().getCust().toString(), row, 1);
						//row++;
					//}
					{"000000001", "Ann Takashima"},
					{"000000002", "Seth Hinshaw"},
					{"000000003", "John Smith"},
					{"000000004", "Joe Schmoe"},
					{"000000005", "Mark Schuler"},
				},
				new String[] {
					"Ticket Number", "Customer Name"
				}
			)); 
		
		
		JTableHeader tHeader = table.getTableHeader();
		tHeader.setFont(new Font("Tahoma", Font.BOLD, 25));
		//table.getColumnModel().getColumn(0).setPreferredWidth(625);
		//table.getColumnModel().getColumn(1).setPreferredWidth(625);
		table.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
//		int row = 0;
//		for(Map.Entry<Integer,Ticket> entry: map.entrySet()) {
//			table.setValueAt(entry.getKey(), row, 0);
//			table.setValueAt(entry.getValue(), row, 1);
//			row++;
//		}
	}

}
