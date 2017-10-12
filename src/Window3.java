


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;

public class Window3 extends JFrame implements ActionListener{

	private static final long serialVersionUID=0;
	private JPanel contentPane;
	private JTextPane textPane;
	private String btn1 ="START";
	private String btn2="STOP";
	private String btn3="Help";
	private CommandExec cmdExc;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window3 frame = new Window3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Window3() {
		cmdExc=new CommandExec();//create object of class CommandExec
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEnable = new JButton(btn1);
		btnEnable.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		btnEnable.setBounds(152, 63, 110, 39);
		btnEnable.addActionListener(this);
		contentPane.add(btnEnable);

		JButton btnStop = new JButton(btn2);
		btnStop.setFont(new Font("Gill Sans MT", Font.BOLD, 11));
		btnStop.addActionListener(this);
		btnStop.setBounds(152, 125, 110, 30);
		contentPane.add(btnStop);

		JButton btnHelp = new JButton(btn3);
		btnHelp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHelp.addActionListener(this );
		btnHelp.setBounds(167, 227, 89, 23);
		contentPane.add(btnHelp);

		JLabel lblHotwispot = new JLabel("HotWiSpot");
		lblHotwispot.setForeground(Color.DARK_GRAY);
		lblHotwispot.setFont(new Font("Harlow Solid Italic", Font.BOLD, 16));
		lblHotwispot.setBounds(152, 11, 99, 23);
		contentPane.add(lblHotwispot);

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(new Color(0, 0, 128));
		textPane.setBackground(new Color(230, 230, 250));
		textPane.setBounds(309, 63, 104, 187);
		contentPane.add(textPane);

		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("BankGothic Lt BT", Font.BOLD | Font.ITALIC, 11));
		lblMessage.setBounds(320, 38, 77, 14);
		contentPane.add(lblMessage);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 63, 17, 187);
		contentPane.add(scrollBar);

		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(320, 236, 104, 14);
		contentPane.add(scrollBar_1);


	}

	public void actionPerformed(ActionEvent e) {
		String action =e.getActionCommand();
		if(action.equals(btn1))//if start clicked
		{
			//netsh start
			cmdExc.ExecCMD("netsh wlan start hostednetwork");
			textPane.setText(this.cmdExc.lines);
		}
		else if(action.equals(btn2))//stop clicked
		{
			//netsh stop
			cmdExc.ExecCMD("netsh wlan stop hostednetwork");
			textPane.setText(this.cmdExc.lines);
		}
		else if(action.equals(btn3))//help clicked
		{
			//help msg
			HelpMsg();
		}
		else{
			//print error msg
			textPane.setText("\n\n@@ERROR: Something went wrong in window3..\n->FIX IT IF YOU CAN..;)");
		}
	}

	private void HelpMsg(){
		textPane.setText("\n");
		textPane.setText("||Click start, to enable your hostednetwork\n");
		textPane.setText(" |Click stop,to disable it..\n\n");
	}

}
