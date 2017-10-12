import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExec {
	
	public String lines;
	/**
	 * constructor
	 */
	public CommandExec(){
		this.lines="";
	}
	/**
	 * method to execute cmd commands on windows terminal
	 */
	public void ExecCMD(String comm){
		try{
			Runtime rt=Runtime.getRuntime();
			Process pr=rt.exec("cmd /c "+comm);
			BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
			 
            String line=null;
            //prints what terminal show ups
            while((line=input.readLine()) != null) {
                System.out.println(line);
                this.lines=this.lines +"\n"+line;
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);
		}
		catch(IOException e ){
			e.printStackTrace();
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
	}
}
