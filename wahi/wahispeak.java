import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class wahispeak {
    private static final String voiceNAME = "kevin16";

    public void speak(String speechText) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(voiceNAME);
        voice.allocate();
        voice.speak(speechText);
    }
    
}
