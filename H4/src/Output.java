import java.util.*;
import java.io.Serializable;

public abstract class Output implements Serializable{

	private static final double serialVersionUID = -1L;
	protected static String out = "";

	public Output(){}

	//abstract method for subclasses
	public abstract void print(String text);


	public static void setOutput(String opt){
		//set variable to output
			out = opt;
	}

	public static Output getOutput(){

		//check output and return object
		if(out.equals("FreeTTS")){
			return FreeTTS.getOutput();
		}
		else{
			return Console.getOutput();
		}
	}
}
