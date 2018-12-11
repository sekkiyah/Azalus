import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.beans.PropertyChangeListener;
import java.sql.PreparedStatement;
import java.beans.PropertyChangeEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TicketForm extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTextField textField;
	private TicketApplication app = new TicketApplication();
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField creationDate;
	private String[] statusChoices = { "", "Open", "Pending", "Completed" };
	private String[] urgencyLevel = { "", "High", "Medium", "Low" };
	private String[] categoryList = { "", "Hardware", "Software", "Setup/Installation", "Question" };
	private JTextField textField_2;
	private JTextField textField_8;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketForm frame = new TicketForm();
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
	public TicketForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 960);
		app.createTicket();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		setJMenuBar(menuBar);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainSplash.main(null);
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		menuBar.add(btnHome);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 25));
		menuBar.add(btnSave);
		
//		JButton btnCloseTicket = new JButton("Close Ticket");
//		btnCloseTicket.setFont(new Font("Tahoma", Font.PLAIN, 25));
//		menuBar.add(btnCloseTicket);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String fullTicketNum = "000000000" + String.valueOf(app.getTicket().getTicketNum());
		fullTicketNum = fullTicketNum.substring((fullTicketNum.length() - 9),(fullTicketNum.length()));
		JLabel lblTicketNumber = new JLabel("Ticket Number: " + fullTicketNum);
		lblTicketNumber.setBounds(10, 0, 590, 31);
		contentPane.add(lblTicketNumber);
		lblTicketNumber.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(21, 40, 340, 60);
		lblCustomer.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblCustomer);
		
		textField = new JTextField();
		textField.setBounds(21, 90, 300, 32);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFirst = new JLabel("First");
		lblFirst.setBounds(21, 121, 300, 26);
		lblFirst.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblFirst);
		
		textField_1 = new JTextField();
		textField_1.setBounds(340, 90, 300, 32);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLast = new JLabel("Last");
		lblLast.setBounds(342, 121, 298, 26);
		lblLast.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblLast);
		
		JLabel lblTicketInfo = new JLabel("Ticket Info");
		lblTicketInfo.setBounds(740, 40, 340, 60);
		lblTicketInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblTicketInfo);
		
		JLabel lblDateCreated = new JLabel("Date Created");
		lblDateCreated.setBounds(1059, 121, 300, 26);
		lblDateCreated.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblDateCreated);
		
		textField_3 = new JTextField();
		textField_3.setBounds(21, 160, 300, 32);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_3.setColumns(10);
		contentPane.add(textField_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(21, 190, 300, 26);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblPhoneNumber);
		
		textField_4 = new JTextField();
		textField_4.setBounds(340, 160, 300, 32);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_4.setColumns(10);
		contentPane.add(textField_4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(340, 190, 300, 26);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblEmail);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_5.setColumns(10);
		textField_5.setBounds(740, 160, 300, 32);
		contentPane.add(textField_5);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDueDate.setBounds(740, 190, 300, 26);
		contentPane.add(lblDueDate);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_6.setColumns(10);
		textField_6.setBounds(1059, 160, 300, 32);
		contentPane.add(textField_6);
		
		creationDate = new JTextField();
		creationDate.setEditable(false);
		creationDate.setText(app.getTicket().getDateCreatedString());
		creationDate.setFont(new Font("Tahoma", Font.PLAIN, 24));
		creationDate.setColumns(10);
		creationDate.setBounds(1059, 90, 300, 32);
		contentPane.add(creationDate);
		
		JLabel lblDateClosed = new JLabel("Date Closed");
		lblDateClosed.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDateClosed.setBounds(1058, 190, 250, 26);
		contentPane.add(lblDateClosed);
		
		JComboBox statusList = new JComboBox(statusChoices);
		statusList.setFont(new Font("Tahoma", Font.PLAIN, 24));
		statusList.setSelectedIndex(0);
		statusList.setBounds(740, 90, 300, 32);
		contentPane.add(statusList);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblStatus.setBounds(740, 120, 300, 26);
		contentPane.add(lblStatus);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_2.setColumns(10);
		textField_2.setBounds(21, 440, 1338, 32);
		contentPane.add(textField_2);
		
		JLabel lblIssueDescription = new JLabel("Short Description");
		lblIssueDescription.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblIssueDescription.setBounds(21, 414, 300, 26);
		contentPane.add(lblIssueDescription);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblDescription.setBounds(21, 484, 300, 26);
		contentPane.add(lblDescription);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_8.setColumns(10);
		textField_8.setBounds(21, 230, 619, 32);
		contentPane.add(textField_8);
		
		JLabel lblUrgency = new JLabel("Urgency");
		lblUrgency.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblUrgency.setBounds(740, 260, 300, 26);
		contentPane.add(lblUrgency);
		
		JComboBox comboBox = new JComboBox(urgencyLevel);
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox.setBounds(740, 230, 300, 32);
		contentPane.add(comboBox);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblCategory.setBounds(21, 344, 300, 26);
		contentPane.add(lblCategory);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblAddress.setBounds(21, 260, 300, 26);
		contentPane.add(lblAddress);
		
		JComboBox comboBox_1 = new JComboBox(categoryList);
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_1.setBounds(21, 370, 619, 32);
		contentPane.add(comboBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(21, 648, 1338, 179);
		contentPane.add(scrollPane);
		
//		ArrayList<String> items = new ArrayList<String>();
//		for(int i=0; i<4; i++) {
//			items.add("Note " + i);
//		}
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Note 1", "Note 2", "Note 3", "Note 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		list.setForeground(Color.BLACK);
		list.setBackground(Color.WHITE);
		list.setFont(new Font("Tahoma", Font.PLAIN, 24));
		

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for(int n=0; n<app.getTicket().getNotes().listSize(); n++) {
			listModel.addElement(app.getTicket().getNotes().displayNoteAt(n));
		}
		
		JLabel lblNotes = new JLabel("Notes List");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNotes.setBounds(21, 616, 300, 26);
		contentPane.add(lblNotes);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textArea.setBounds(21, 510, 1338, 96);
		contentPane.add(textArea);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDelete.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 try {
					 int selectedIndex = list.getSelectedIndex();
					 list.remove(selectedIndex);
				 } catch(Exception ex) {
					 ex.printStackTrace();
				 }
			}
		});
		btnDelete.setBounds(1218, 612, 141, 35);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnEdit.setBounds(1068, 612, 141, 35);
		contentPane.add(btnEdit);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAdd.setBounds(917, 612, 141, 35);
		contentPane.add(btnAdd);
	}
}
