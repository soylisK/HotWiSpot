

import javax.swing.JFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollBar;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTextArea;



public class Window1 implements ActionListener {

	private JFrame frame;
	private String btn1="Alredy Set Hotspot";
	private String btn2="Set Hotspot";
	private String btn3="Help";
	private JTextArea textPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 window = new Window1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public Window1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel CentralPanel = new JPanel();
		CentralPanel.setBounds(201, 0, 354, 321);
		frame.getContentPane().add(CentralPanel);
		CentralPanel.setLayout(null);
		
		
		JButton btnHelp = new JButton(btn3);
		btnHelp.setBounds(25, 287, 57, 23);
		CentralPanel.add(btnHelp);
		btnHelp.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		btnHelp.addActionListener(this);
		
		
		JButton btnAlreadySetHotspot = new JButton(btn1);
		btnAlreadySetHotspot.setBounds(38, 86, 133, 23);
		CentralPanel.add(btnAlreadySetHotspot);
		btnAlreadySetHotspot.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		btnAlreadySetHotspot.addActionListener(this);
		
		JButton btnSetHotspot = new JButton(btn2);
		btnSetHotspot.setBounds(58, 136, 95, 23);
		CentralPanel.add(btnSetHotspot);
		btnSetHotspot.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		
		JLabel lblHotwispot = new JLabel("HotWiSpot");
		lblHotwispot.setBounds(25, 0, 124, 49);
		CentralPanel.add(lblHotwispot);
		lblHotwispot.setForeground(Color.DARK_GRAY);
		lblHotwispot.setFont(new Font("Harlow Solid Italic", Font.BOLD, 16));
		btnSetHotspot.addActionListener(this);
		
		JPanel Msg_panel = new JPanel();
		Msg_panel.setBounds(0, 0, 191, 321);
		frame.getContentPane().add(Msg_panel);
		Msg_panel.setLayout(null);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(0, 282, 164, 17);
		Msg_panel.add(scrollBar_1);
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setBounds(16, 38, 62, 12);
		Msg_panel.add(lblMessage);
		lblMessage.setFont(new Font("BankGothic Lt BT", Font.BOLD | Font.ITALIC, 11));
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(164, 61, 17, 238);
		Msg_panel.add(scrollBar);
		
	    textPane = new JTextArea();
	    textPane.setEditable(false);
		textPane.setBackground(new Color(173, 216, 230));
		textPane.setForeground(new Color(0, 128, 0));
		textPane.setBounds(16, 61, 165, 238);
		Msg_panel.add(textPane);
		frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frame.getContentPane(), btnAlreadySetHotspot, btnSetHotspot, btnHelp, lblHotwispot, textPane, lblMessage, scrollBar, scrollBar_1}));
		
		
	}
	/**
	 * getter for frame of the window
	 * @return
	 */
	public JFrame getFrame(){
		return this.frame;
	}
	
	public void actionPerformed(ActionEvent e) {
		String action =  e.getActionCommand();
		
		if (action.equals(btn1)) //already set a hotspot
		{
			Window3 finalwind=new Window3();  
			finalwind.setVisible(true);
		}
		else if(action.equals(btn2))//set new hotspot
		{
			Window2 setwind =new Window2();
			setwind.getFrame().setVisible(true);
		}
		else if(action.equals(btn3))//help btn
		{
			this.printHelpMsg();
		}
		else
		{
			textPane.setText("\n\n@@ERROR:Some went wrong during of window1's run..\n--->Fix it your self dude..\n");
		}
	}
	
	private void printHelpMsg(){
		textPane.setText("\n");
		textPane.setText("||Your options..\n");
		textPane.setText(" |Click 'AlreadySetHostednetwork', if you have created a hotspot network .. \n");
		textPane.setText(" |Or,click 'SET' to create a new hostedNetwork..\n");
		System.out.println(" |more infos at hotWiSpot_support@gmail.com");//not yet
		textPane.setText("||That's all Folks!!....;)\n\n");
	}
}
