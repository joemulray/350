import java.util.*;
import java.io.Serializable;

public abstract class Output implements Serializable{

	private static final double serialVersionUID = -1L;
	private static String type = "";

	public Output(){}

	public abstract void print(String text);



	public static void setOutput(String type){
			type = type;
	}

	public static Output getOutput(){

		if(type.equals("Console")){

			return Console.getOutput();
		}
		return Console.getOutput();
	}
}
