import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.IOException;
import java.io.Serializable;



public class FreeTTS extends Output{

	private static final double serialVersionUID = -1L;
	private String voiceName = "kevin16";
    private Voice voice;


    public FreeTTS(){

    	VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(voiceName);
        this.voice.allocate();
    }



	public void print(String text){
		        

        //For this case printing text as well as speech
	    System.out.println(text);

        this.voice.speak(text);
	}


	public static Output getOutput(){

		return new FreeTTS();
	}



}
