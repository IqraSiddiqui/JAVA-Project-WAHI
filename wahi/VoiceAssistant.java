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
    Process p;
    Desktop desk = Desktop.getDesktop();
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
            
            if(active==true) {
                if(command.equalsIgnoreCase("who are you")) {
                    intro();
                } else if(command.equalsIgnoreCase("good morning")) {
                    greetings();
                } 
            else if (command.equalsIgnoreCase("open chrome")) {
                    openChrome();
                } else if (command.equalsIgnoreCase("close chrome")) {
                	closeChrome();
                } else if (command.equalsIgnoreCase("open microsoft edge")) {
                    openEdge();
                } else if (command.equalsIgnoreCase("close microsoft edge")) {
                	closeEdge();
                } else if (command.equalsIgnoreCase("open word")) {
                    openWord();
                } else if (command.equalsIgnoreCase("close word")) {
                    closeWord();
                } else if (command.equalsIgnoreCase("open excel")) {
                    openExcel();
                } else if (command.equalsIgnoreCase("close excel")) {
                    closeExcel();
                } else if (command.equalsIgnoreCase("open power point")) {
                    openPowerPoint();
                } else if (command.equalsIgnoreCase("close power point")) {
                    closePowerPoint();
                } else if (command.equalsIgnoreCase("open paint")) {
                    openPaint();
                } else if (command.equalsIgnoreCase("close paint")) {
                    closePaint();
                } else if (command.equalsIgnoreCase("open notepad")) {
                    openNotePad();
                } else if (command.equalsIgnoreCase("close notepad")) {
                    closeNotePad();
                } else if (command.equalsIgnoreCase("open command prompt")) {
                    openCMD();
                } else if (command.equalsIgnoreCase("close command prompt")) {
                    closeCMD();
                } else if (command.equalsIgnoreCase("open control panel")) {
                    openCP();
                } else if (command.equalsIgnoreCase("close control panel")) {
                    closeCP();
                } else if (command.equalsIgnoreCase("open calculator")) {
                    openCal();
                } else if (command.equalsIgnoreCase("close calculator")) {
                    closeCal();
                } else if (command.equalsIgnoreCase("open player")) {
                    openPlayer();
                } else if (command.equalsIgnoreCase("close player")) {
                    closePlayer();
                }else if(command.equalsIgnoreCase("0")){ 
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
                else if(command.equalsIgnoreCase("Open lms"))
                    openLMS();
                else if(command.equalsIgnoreCase("Open pscs"))
                    openpscs(); 
                else if(command.equalsIgnoreCase("Open file manager"))
                    openExplorer();
                else if(command.equalsIgnoreCase("Open youtube"))
                    openyoutube();
                else if(command.equalsIgnoreCase("Open outlook"))
                    openoutlook();
                else if(command.equalsIgnoreCase("open google"))
                    opengoogle();
                else if(command.equalsIgnoreCase("start chatting"))
                    chat();

                  else {
                    work = null;
                }
                
                //In case command recognized is none of the above hence work might be null
                if(work != null) {
                    //Execute the command
                    try {
                        p = Runtime.getRuntime().exec(work);
                    } catch(IOException e){
                        System.out.println(e);
                    }
                } 
            }  
        }
    }
    
    //Operations

    public void openpscs(){
        try {
            speak("Opening PSCS");
            URI uri = new URI("https://pscs.habib.edu.pk/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void openLMS(){
        try {
            speak("Opening Habib LMS");
            URI uri = new URI("https://habib.edu.pk/hulms/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }

    public void openyoutube(){
        try {
            speak("Opening Youtube");
            URI uri = new URI("http://youtube.com/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void openoutlook(){
        try {
            speak("Opening Outlook");
            URI uri = new URI("www.outlook.com");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void opengoogle(){
        try {
            speak("opening google");
            URI uri = new URI("www.google.com");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void chat(){
        try {
            speak("Preparing your chatbot");
            System.out.println("Preparing your chatbot");
            URI uri = new URI("https://alejandro.app.fi/ai-chat");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void intro() {
        System.out.println("I am WAHI, your assistant, i am here to help you");
        speak("I am WAHI, your assistant, i am here to help you");
    }
    
    public void greetings() {
        System.out.println("Good Morning. How can i help?");
        speak("Good Morning. How can i help?");
    }
    
    public void openExplorer() {
        System.out.println("Opening FileManager");
        speak("Opening explorer");
        work="cmd /c start explorer.exe";
    }
    
    public void openChrome() {
        System.out.println("Opening chrome");
        speak("Opening chrome");
        work="cmd /c start chrome.exe";
    }
    public void closeChrome() {
        System.out.println("Closing chrome");
        speak("Closing chrome");
        work="cmd /c start taskkill /im chrome.exe /f";
    }
    
    public void openEdge() {
        System.out.println("Opening microsoft edge");
        speak("Opening microsoft edge");
        work="cmd /c start microsoft-edge:";
    }
    public void closeEdge() {
        System.out.println("Closing microsoft edge");
        speak("Closing microsoft edge");
        work="cmd /c start taskkill /im MicrosoftEdge.exe /f";
    }
    
    public void openWord(){
        System.out.println("Opening word");
        speak("Opening word");
        work="cmd /c start winword";
    }
    public void closeWord(){
        System.out.println("Closing word");
        speak("Closing word");
        work="cmd /c start taskkill /im winword.exe /f";
    }
    
    public void openExcel(){
        System.out.println("Opening excel");
        speak("Opening excel");
        work="cmd /c start excel";
    }
    public void closeExcel(){
        System.out.println("Closing excel");
        speak("Closing excel");
        work="cmd /c start taskkill /im excel.exe /f";
    }
    
    public void openPowerPoint(){
        System.out.println("Opening power point");
        speak("Opening power point");
        work="cmd /c start powerpnt";
    }
    public void closePowerPoint(){
        System.out.println("Closing power point");
        speak("Closing power point");
        work="cmd /c start taskkill /im powerpnt.exe /f";
    }
    
    public void openPaint(){
        System.out.println("Opening paint");
        speak("Opening paint");
        work="cmd /c start mspaint";
    }
    public void closePaint(){
        System.out.println("Closing paint");
        speak("Closing paint");
        work="cmd /c start taskkill /im mspaint.exe /f";
    }
    
    public void openNotePad(){
        System.out.println("Opening notepad");
        speak("Opening notepad");
        work="cmd /c start notepad";
    }
    public void closeNotePad(){
        System.out.println("Closing notepad");
        speak("Closing notepad");
        work="cmd /c start taskkill /im notepad.exe /f";
    }
    
    public void openCMD(){
        System.out.println("Opening command prompt");
        speak("Opening command prompt");
        work="cmd /c start cmd";
    }
    public void closeCMD(){
        System.out.println("Closing command prompt");
        speak("Closing command prompt");
        work="cmd /c start taskkill /im cmd.exe /f";
    }
    
    public void openCP(){
        System.out.println("Opening control panel");
        speak("Opening control panel");
        work="cmd /c start control";
    }
    public void closeCP(){
        System.out.println("Closing control panel");
        speak("Closing control panel");
        work="cmd /c start taskkill /im control.exe /f";
    }
    
    public void openCal(){
        System.out.println("Opening calculator");
        speak("Opening calculator");
        work="cmd /c start calc";
    }
    public void closeCal(){
        System.out.println("Closing calculator");
        speak("Closing calculator");
        work="cmd /c start taskkill /im calculator.exe /f";
    }
    
    public void openPlayer(){
        System.out.println("Opening media player");
        speak("Opening media player");
        work="cmd /c start wmplayer";
    }
    public void closePlayer(){
        System.out.println("Closing media player");
        speak("Closing media player");
        work="cmd /c start taskkill /im wmplayer.exe /f";
    }
    

    
    
    //voice function
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
    
}