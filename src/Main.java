
import java.awt.EventQueue;
/**
 * 
 */

/**
 * @author Soylis
 *
 */
public class Main {
	/*private Window1 wind1;
	private Window2 wind2;
	private Window3 wind3;*/
	//private CommandExec exc=null;
    public Main() {
		//exc=new CommandExec();
	}

	
	
	
	public static void main(String[] args) {
		// main method
		System.out.println("start....");
		//Main mobj=new Main();
		//mobj.exc.ExecCMD("mmc devmgmt.msc");//open device manager
		/*System.out.println("\n@********************test..............\n");
		System.out.println(mobj.exc.lines);
		System.out.println("--**************************************---\n");*/
		
		//Window w1 =new Window();
		//w1.setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window1 fr1 =new Window1();
					
					fr1.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		System.out.println("End..");

	}

}
