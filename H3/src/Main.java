import java.io.IOException;
import java.io.Serializable;
public class Main implements Serializable{

	private static final double serialVersionUID = -1L;
	


    /**
     * Main function creates new Starting process, 
     * continues til user quits the program.
     */
	public static void main(String[] args) throws IOException, ClassNotFoundException{

	System.out.println("****************");
	System.out.println("Welcome");
    System.out.println("****************");

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
