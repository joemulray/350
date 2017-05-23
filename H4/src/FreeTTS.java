import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import java.io.IOException;
import java.io.Serializable;



public class FreeTTS extends Output implements Serializable{

	private static final double serialVersionUID = -1L;
	private String voiceName = "kevin16";


	public void print(String text){

		        
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(this.voiceName);

        voice.allocate();
        voice.speak(text);
        voice.deallocate();
	}


	public static Output getOutput(){

		return new FreeTTS();
	}



}
