import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.awt.AWTException;
import java.io.*;
import java.awt.Desktop;

/*
This class contains all commands that WAHI can understand and takes the respective actions for every command. It creates corresponing class object and call respective functions for its execution
*/
public class CommandInventory {
    private static final String voiceNAME = "kevin16"; //the speaker voice
    String work = null;
    Desktop desk = Desktop.getDesktop(); //desktop object
    Browse app=new Browse(); //browser object
    Chat bot=new Chat(); //chatter object
    Launch localapp=new Launch();  //launch app object
    CloseApp closelocalapp=new CloseApp(); //closeapp object
    wahispeak speaking=new wahispeak(); //speaker object

    public void checkCommands(String command){ //method to check commands and call respective functions
            if(command.equalsIgnoreCase("who are you")) { 
                speaking.speak("I am WAHI, your assistant, i am here to help you");
            } else if(command.equalsIgnoreCase("good morning")) {
                speaking.speak("Good Morning. How can i help?");
            } 

            //local apps hence execute local app function to open corresponding applications

        else if (command.equalsIgnoreCase("open chrome")) {
            speaking.speak("Opening Google Chrome");
                localapp.openChrome();
            } else if (command.equalsIgnoreCase("open microsoft edge")) {
                speaking.speak("Opening Microsoft Edge");
                localapp.openEdge();
            }  else if (command.equalsIgnoreCase("open word")) {
                speaking.speak("Opening Microsoft Word");
                localapp.openWord();
            }else if (command.equalsIgnoreCase("open excel")) {
                speaking.speak("Opening Microsoft Excel");
                localapp.openExcel();
            }else if (command.equalsIgnoreCase("open power point")) {
                speaking.speak("Opening Microsoft Powerpoint");
                localapp.openPowerPoint();
            }else if (command.equalsIgnoreCase("open notepad")) {
                speaking.speak("Opening Notepad");
                localapp.openNotePad();
            } else if (command.equalsIgnoreCase("open command prompt")) {
                speaking.speak("Opening Command Prompt");
                localapp.openCMD();
            } else if (command.equalsIgnoreCase("open control panel")) {
                speaking.speak("Opening control Panel");
                localapp.openCP();
            }else if (command.equalsIgnoreCase("open calculator")) {
                speaking.speak("Opening Calculator");
                localapp.openCal();
            }else if(command.equalsIgnoreCase("Open file manager")){
                speaking.speak("Opening explorer");
                localapp.openExplorer();
            }else if (command.equalsIgnoreCase("open player")) {
                speaking.speak("Opening Media Player");
                localapp.openPlayer();
            }else if (command.equalsIgnoreCase("open paint")) {
                speaking.speak("Opening Paint");
                localapp.openPaint();
            }

            //local apps hence execute local app function to close corresponding applications

            else if (command.equalsIgnoreCase("close chrome")) {
                speaking.speak("Closing google Chrome");
                closelocalapp.closeChrome();
            } else if (command.equalsIgnoreCase("close microsoft edge")) {
                speaking.speak("Closing Microsoft Edge");
                closelocalapp.closeEdge();
            } else if (command.equalsIgnoreCase("close word")) {
                speaking.speak("Closing Microsft Word");
                closelocalapp.closeWord();
            }  else if (command.equalsIgnoreCase("close excel")) {
                speaking.speak("Closing microsoft excel");
                closelocalapp.closeExcel();
            }  else if (command.equalsIgnoreCase("close power point")) {
                speaking.speak("Closing Powerpoint");
                closelocalapp.closePowerPoint();
            }  else if (command.equalsIgnoreCase("close paint")) {
                speaking.speak("Closing Paint");
                closelocalapp.closePaint();
            } else if (command.equalsIgnoreCase("close notepad")) {
                speaking.speak("Closing Notepad");
                closelocalapp.closeNotePad();
            }else if (command.equalsIgnoreCase("close command prompt")) {
                speaking.speak("Closing command prompt");
                closelocalapp.closeCMD();
            }  else if (command.equalsIgnoreCase("close control panel")) {
                speaking.speak("Closing control Panel");
                closelocalapp.closeCP();
            } else if (command.equalsIgnoreCase("close calculator")) {
                speaking.speak("Closing Calculator");
                closelocalapp.closeCal();
            }  else if (command.equalsIgnoreCase("close player")) {
                speaking.speak("Closing Media Player");
                closelocalapp.closePlayer();
            }   
            
            //Executing sql query hence generate accessjdbc object and call access on the user provided sql command id to execute it

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

            //online apps hence execute online app function to open corresponding applications

            else if(command.equalsIgnoreCase("Open lms")){
                speaking.speak("Opening Habib LMS");
                app.openLMS(desk);
            }
            else if(command.equalsIgnoreCase("Open pscs")){
                speaking.speak("Opening PSCS");
                app.openpscs(desk); 
            }
            else if(command.equalsIgnoreCase("Open youtube")){
                speaking.speak("Opening Youtube");
                app.openyoutube(desk);
            }
            else if(command.equalsIgnoreCase("Open outlook")){
                speaking.speak("Opening Outlook");
                app.openoutlook(desk);
            }
            else if(command.equalsIgnoreCase("open google")){
                speaking.speak("Opening Google");
                app.opengoogle(desk);
            }
            else if(command.equalsIgnoreCase("start chatting")){
                speaking.speak("Preparing your chatbot");
                bot.startChat(desk);
            }

            //other wise no work has to be done 
            
              else {
                work = null;
            }
}
}
