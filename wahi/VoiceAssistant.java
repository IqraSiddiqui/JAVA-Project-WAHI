import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.AWTException;
import java.io.*;
import java.awt.Desktop;
import java.net.URI;


public class VoiceAssistant implements Runnable {
    
    private LiveSpeechRecognizer recognizer;
    
    boolean active=false;
    CommandInventory cmdinvent=new CommandInventory();
    wahispeak speaking=new wahispeak(); 

    public void InitAssistant() {
        
        //Configuration Object
        Configuration configuration = new Configuration();
 
        // Set path to the acoustic model.
        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        // Set path to the language model (vocabulary model).
        configuration.setDictionaryPath("src\\dic.dic");
        configuration.setLanguageModelPath("src\\lm.lm");
        
        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            System.out.println(e);
        }
         
        //Start speech recognition 
        startSpeechRecognition();
    }
    
    public void startSpeechRecognition() {
        
        //Start Recognition Process (The boolean parameter clears the previous cache if true)
        recognizer.startRecognition(true);
        
        //Creating SpeechResult object
        SpeechResult result;
 
        //Check if recognizer recognized the speech
        while ((result = recognizer.getResult()) != null) {
 
            //Get the recognized speech
            String command = result.getHypothesis();
            
            System.out.println(result.getHypothesis());
            if (command.equalsIgnoreCase("Wake Up")) {
                active=true;
                System.out.println("I am ready to help");
                speaking.speak("I am ready to help");
            } else if(command.equalsIgnoreCase("Sleep")) {
                active=false;
                System.out.println("I am sleepy! Bye");
                speaking.speak("I am sleepy! Bye");
                break;
            }
            if(active==true)
                cmdinvent.checkCommands(command);
            }  
        }
    
    public void run(){
        VoiceAssistant va = new VoiceAssistant();
        va.InitAssistant();
    }
}