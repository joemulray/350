import java.io.IOException;
import java.io.Serializable;


public class Main implements Serializable{

	private static final double serialVersionUID = -1L;
	public transient static Output out;


    /**
     * Main function creates new Starting process, 
     * continues til user quits the program.
     * @throws IOException
     * @throws ClassNotFoundException
     */
	public static void main(String[] args) throws IOException, ClassNotFoundException{

	Output.setOutput("FreeTTS");
	out = Output.getOutput();


	out.print("|                WELCOME                |");

    Start start = new Start();
    int option = start.menu();
    
	while(true){
		if(option == 1)
			start.surveyMenu();
		else
			start.testMenu();
		}	

	}
}
