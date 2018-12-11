import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;

import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JList;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MainSplash {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSplash window = new MainSplash();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainSplash() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1440, 960);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewTicket = new JButton("New Ticket");
		btnNewTicket.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				TicketForm form = new TicketForm();
				form.setVisible(true);
			}
		});
		btnNewTicket.setBounds(288, 600, 288, 60);
		frame.getContentPane().add(btnNewTicket);
		Image mainSplash = new ImageIcon(this.getClass().getResource("/ocean2.jpg")).getImage();
		
		JButton btnExistingTicket = new JButton("Existing Ticket");
		btnExistingTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ExistingTickets form = new ExistingTickets();
				form.setVisible(true);
			}
		});
		btnExistingTicket.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnExistingTicket.setBounds(864, 600, 288, 60);
		frame.getContentPane().add(btnExistingTicket);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(mainSplash));
		image.setBounds(0, 0, 1514, 889);
		frame.getContentPane().add(image);
	}

}
