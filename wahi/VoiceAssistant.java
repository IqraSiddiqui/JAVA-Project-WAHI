import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.AWTException;
import java.io.*;
import java.awt.Desktop;
import java.net.URI;


public class VoiceAssistant implements Runnable {
    
    private LiveSpeechRecognizer recognizer;
    
    boolean active=false;
    String work = null;
    Desktop desk = Desktop.getDesktop();
    Browse app=new Browse();
    Chat bot=new Chat();
    Launch localapp=new Launch();
    CloseApp closelocalapp=new CloseApp();

    private static final String voiceNAME = "kevin16";
    
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
                speak("I am ready to help");
            } else if(command.equalsIgnoreCase("Sleep")) {
                active=false;
                System.out.println("I am sleepy! Bye");
                speak("I am sleepy! Bye");
                break;
            }
            checkCommands(command);
            }  
        }
    
    public void speak(String speechText) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(voiceNAME);
        voice.allocate();
        voice.speak(speechText);
    }
    
    public void run(){
        VoiceAssistant va = new VoiceAssistant();
        va.InitAssistant();
    }
    
    public void checkCommands(String command){
        if(active==true) {
            if(command.equalsIgnoreCase("who are you")) {
                speak("I am WAHI, your assistant, i am here to help you");
            } else if(command.equalsIgnoreCase("good morning")) {
                speak("Good Morning. How can i help?");
            } 
        else if (command.equalsIgnoreCase("open chrome")) {
            speak("Opening Google Chrome");
                localapp.openChrome();
            } else if (command.equalsIgnoreCase("open microsoft edge")) {
                speak("Opening Microsoft Edge");
                localapp.openEdge();
            }  else if (command.equalsIgnoreCase("open word")) {
                speak("Opening Microsoft Word");
                localapp.openWord();
            }else if (command.equalsIgnoreCase("open excel")) {
                speak("Opening Microsoft Excel");
                localapp.openExcel();
            }else if (command.equalsIgnoreCase("open power point")) {
                speak("Opening Microsoft Powerpoint");
                localapp.openPowerPoint();
            }else if (command.equalsIgnoreCase("open notepad")) {
                speak("Opening Notepad");
                localapp.openNotePad();
            } else if (command.equalsIgnoreCase("open command prompt")) {
                speak("Opening Command Prompt");
                localapp.openCMD();
            } else if (command.equalsIgnoreCase("open control panel")) {
                speak("Opening control Panel");
                localapp.openCP();
            }else if (command.equalsIgnoreCase("open calculator")) {
                speak("Opening Calculator");
                localapp.openCal();
            }else if(command.equalsIgnoreCase("Open file manager")){
                speak("Opening explorer");
                localapp.openExplorer();
            }else if (command.equalsIgnoreCase("open player")) {
                speak("Opening Media Player");
                localapp.openPlayer();
            }else if (command.equalsIgnoreCase("open paint")) {
                speak("Opening Paint");
                localapp.openPaint();
            }
            else if (command.equalsIgnoreCase("close chrome")) {
                speak("Closing google Chrome");
                closelocalapp.closeChrome();
            } else if (command.equalsIgnoreCase("close microsoft edge")) {
                speak("Closing Microsoft Edge");
                closelocalapp.closeEdge();
            } else if (command.equalsIgnoreCase("close word")) {
                speak("Closing Microsft Word");
                closelocalapp.closeWord();
            }  else if (command.equalsIgnoreCase("close excel")) {
                speak("Closing microsoft excel");
                closelocalapp.closeExcel();
            }  else if (command.equalsIgnoreCase("close power point")) {
                speak("Closing Powerpoint");
                closelocalapp.closePowerPoint();
            }  else if (command.equalsIgnoreCase("close paint")) {
                speak("Closing Paint");
                closelocalapp.closePaint();
            } else if (command.equalsIgnoreCase("close notepad")) {
                speak("Closing Notepad");
                closelocalapp.closeNotePad();
            }else if (command.equalsIgnoreCase("close command prompt")) {
                speak("Closing command prompt");
                closelocalapp.closeCMD();
            }  else if (command.equalsIgnoreCase("close control panel")) {
                speak("Closing control Panel");
                closelocalapp.closeCP();
            } else if (command.equalsIgnoreCase("close calculator")) {
                speak("Closing Calculator");
                closelocalapp.closeCal();
            }  else if (command.equalsIgnoreCase("close player")) {
                speak("Closing Media Player");
                closelocalapp.closePlayer();
            }                    
            else if(command.equalsIgnoreCase("0")){ 
                try {
                    AccessJDBC aj=new AccessJDBC();
                    aj.access("0");
                    File file=new File("grocessory_lst.txt");
                    desk.open(file);
                    System.out.println("Grocery List");
                } catch (Exception e) {
                    System.err.println(e);
                }
            }else if(command.equalsIgnoreCase("1")){ 
                try {
                    AccessJDBC aj=new AccessJDBC();
                    aj.access("1");
                    File file=new File("filteredgrocessory_lst.txt");
                    desk.open(file);
                    System.out.println("Filetered Grocery");
                } catch (Exception e) {
                    System.err.println(e);
                }
            } else if(command.equalsIgnoreCase("2")){ 
                try {
                    AccessJDBC aj=new AccessJDBC();
                    aj.access("1");
                    File file=new File("WAHICommands.txt");
                    desk.open(file);
                    System.out.println("Commands retrieved");
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            else if(command.equalsIgnoreCase("Open lms")){
                speak("Opening Habib LMS");
                app.openLMS(desk);
            }
            else if(command.equalsIgnoreCase("Open pscs")){
                speak("Opening PSCS");
                app.openpscs(desk); 
            }
            else if(command.equalsIgnoreCase("Open youtube")){
                speak("Opening Youtube");
                app.openyoutube(desk);
            }
            else if(command.equalsIgnoreCase("Open outlook")){
                speak("Opening Outlook");
                app.openoutlook(desk);
            }
            else if(command.equalsIgnoreCase("open google")){
                speak("Opening Google");
                app.opengoogle(desk);
            }
            else if(command.equalsIgnoreCase("start chatting")){
                speak("Preparing your chatbot");
                bot.startChat(desk);
            }

              else {
                work = null;
            }
            
        
    }
}
}