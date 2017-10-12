

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class Window2 implements ActionListener,DocumentListener {

	private static int NUM_OF_CHARS=15;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnSet;
	private JButton btnHelp;
	private JTextPane textPane;
	private String btn1name="SET";
	private String btn2name="Help";
	private String ssid;
	private String password;
	private CommandExec cmdExc;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
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
	public Window2() {
		initialize();
		cmdExc=new CommandExec();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField(NUM_OF_CHARS);
		textField.setBounds(127, 53, 215, 28);
		textField.getDocument().addDocumentListener(this);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSsid = new JLabel("SSID:");
		lblSsid.setFont(new Font("BankGothic Md BT", Font.BOLD | Font.ITALIC, 12));
		lblSsid.setBounds(34, 53, 56, 28);
		frame.getContentPane().add(lblSsid);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("BankGothic Md BT", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(34, 108, 83, 14);
		frame.getContentPane().add(lblPassword);
		
		btnHelp = new JButton(btn2name);
		btnHelp.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		btnHelp.setBounds(126, 227, 89, 23);
		frame.getContentPane().add(btnHelp);
		
		btnSet = new JButton(btn1name);
		btnSet.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		btnSet.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnSet);
		
		passwordField = new JPasswordField(NUM_OF_CHARS);
		passwordField.setBounds(127, 105, 215, 28);
		passwordField.getDocument().addDocumentListener(this);
		frame.getContentPane().add(passwordField);
		
		JLabel lblHotwispot = DefaultComponentFactory.getInstance().createTitle("HotWiSpot");
		lblHotwispot.setForeground(Color.DARK_GRAY);
		lblHotwispot.setFont(new Font("Harlow Solid Italic", Font.BOLD, 16));
		lblHotwispot.setBounds(166, 11, 117, 31);
		frame.getContentPane().add(lblHotwispot);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(new Color(34, 139, 34));
		textPane.setBackground(new Color(173, 216, 230));
		textPane.setBounds(127, 161, 215, 55);
		frame.getContentPane().add(textPane);
		
		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("BankGothic Lt BT", Font.BOLD | Font.ITALIC, 11));
		lblMessage.setBounds(116, 144, 76, 14);
		frame.getContentPane().add(lblMessage);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(325, 161, 17, 55);
		frame.getContentPane().add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(127, 202, 215, 14);
		frame.getContentPane().add(scrollBar_1);
	}
	
	public void actionPerformed(ActionEvent e) {
		try
		{
			ssid=textField.getText();
			password=String.valueOf( passwordField.getPassword() );
			String action = e.getActionCommand();
			if(action.equals("SET"))
			{
				//netsh command execution
				cmdExc.ExecCMD("netsh wlan set hostednetwork mode=allow "+"ssid="+ssid+" key="+password);
				System.out.println("netsh wlan set hostednetwork mode=allow "+"ssid="+ssid+" key="+password);
				textPane.setText(this.cmdExc.lines);
			}
			else if (action.equals(btn2name))
			{
				//print help msg
				this.printHelpMsg();
			}
			else
			{
				//print error msg
				textPane.setText("\n\n @@ERROR:Something went wrong dude..in window2 --contact with the hackerman!");
			}
		}catch(NullPointerException exc)
		{
			System.out.println(exc.getMessage());
		}
		
	}
	/**
	 * getter for the frame of the window
	 * @return
	 */
	public JFrame getFrame(){
		return this.frame;
	}
	
	//yourJTextField.getDocument().addDocumentListener(new DocumentListener() {
	 public void changedUpdate(DocumentEvent e) 
	 {
	    changed();		
	  }
	public void removeUpdate(DocumentEvent e)
	{
		    changed();
	}
	public void insertUpdate(DocumentEvent e) 
	{
		    changed();
	}
	/**
	 * look if a change in fields was occured
	 * if not you cant vlick on set
	 */
	public void changed() 
	{
		try
		{ 
			if ( textField.getText().equals("")|| passwordField.getPassword().equals("") )
			{
				btnSet.setEnabled(false);	  
			}
			else 
			{
		    	 btnSet.setEnabled(true);
			}
		}catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	private void printHelpMsg(){
		textPane.setText("\n");
		textPane.setText("||Enter a name for your network in ssid field\n");
		textPane.setText(" |Enter a password for your network\n");
		textPane.setText(" |Maximum 15 characters in both fields..\n\n");
	}
}
