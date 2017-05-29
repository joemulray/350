import java.util.*;
import java.io.Serializable;

public class Console extends Output implements Serializable{

	private static final double serialVersionUID = -1L;

	public void print(String text){
		//Print text to console
		System.out.println(text);
	}


	public static Output getOutput(){
		//return new Console Output
		return new Console();
	}


}
