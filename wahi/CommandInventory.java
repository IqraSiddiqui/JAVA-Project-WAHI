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
    wahispeak speaking=new wahispeak(); //speaker object
    TasksFactory tasksFactory=new TasksFactory(); //generatin task factory
    //Use the task Factory to get object of concrete class by passing a tasktype.
    Tasks localapp=tasksFactory.getTask("Launch");
    Tasks bot=tasksFactory.getTask("Chat");
    Tasks app=tasksFactory.getTask("Browse");
    Tasks closelocalapp=tasksFactory.getTask("Close");

    public void checkCommands(String command){ //method to check commands and call respective functions
            if(command.equalsIgnoreCase("who are you")) { 
                speaking.speak("I am WAHI, your assistant, i am here to help you");
            } else if(command.equalsIgnoreCase("good morning")) {
                speaking.speak("Good Morning. How can i help?");
            } 

            //local apps hence execute local app function to open corresponding applications

        else if (command.equalsIgnoreCase("open chrome")) {
            speaking.speak("Opening Google Chrome");
                localapp.performTask("openChrome", desk);
            } else if (command.equalsIgnoreCase("open microsoft edge")) {
                speaking.speak("Opening Microsoft Edge");
                localapp.performTask("openEdge", desk);
            }  else if (command.equalsIgnoreCase("open word")) {
                speaking.speak("Opening Microsoft Word");
                localapp.performTask("openWord", desk);
            }else if (command.equalsIgnoreCase("open excel")) {
                speaking.speak("Opening Microsoft Excel");
                localapp.performTask("openExcel", desk);
            }else if (command.equalsIgnoreCase("open power point")) {
                speaking.speak("Opening Microsoft Powerpoint");
                localapp.performTask("openPowerPoint", desk);
            }else if (command.equalsIgnoreCase("open notepad")) {
                speaking.speak("Opening Notepad");
                localapp.performTask("openNotepad", desk);
            } else if (command.equalsIgnoreCase("open command prompt")) {
                speaking.speak("Opening Command Prompt");
                localapp.performTask("openCMD", desk);
            } else if (command.equalsIgnoreCase("open control panel")) {
                speaking.speak("Opening control Panel");
                localapp.performTask("openCP", desk);
            }else if (command.equalsIgnoreCase("open calculator")) {
                speaking.speak("Opening Calculator");
                localapp.performTask("openCal", desk);
            }else if(command.equalsIgnoreCase("Open file manager")){
                speaking.speak("Opening explorer");
                localapp.performTask("openExplorer", desk);
            }else if (command.equalsIgnoreCase("open player")) {
                speaking.speak("Opening Media Player");
                localapp.performTask("openPlayer", desk);
            }else if (command.equalsIgnoreCase("open paint")) {
                speaking.speak("Opening Paint");
                localapp.performTask("openPaint", desk);
            }

            //local apps hence execute local app function to close corresponding applications

            else if (command.equalsIgnoreCase("close chrome")) {
                speaking.speak("Closing google Chrome");
                closelocalapp.performTask("closeChrome", desk);
            } else if (command.equalsIgnoreCase("close microsoft edge")) {
                speaking.speak("Closing Microsoft Edge");
                closelocalapp.performTask("closeEdge", desk);
            } else if (command.equalsIgnoreCase("close word")) {
                speaking.speak("Closing Microsft Word");
                closelocalapp.performTask("closeWord", desk);
            }  else if (command.equalsIgnoreCase("close excel")) {
                speaking.speak("Closing microsoft excel");
                closelocalapp.performTask("closeExcel", desk);
            }  else if (command.equalsIgnoreCase("close power point")) {
                speaking.speak("Closing Powerpoint");
                closelocalapp.performTask("closePowerPoint", desk);
            }  else if (command.equalsIgnoreCase("close paint")) {
                speaking.speak("Closing Paint");
                closelocalapp.performTask("closePaint", desk);
            } else if (command.equalsIgnoreCase("close notepad")) {
                speaking.speak("Closing Notepad");
                closelocalapp.performTask("closeNotepad", desk);
            }else if (command.equalsIgnoreCase("close command prompt")) {
                speaking.speak("Closing command prompt");
                closelocalapp.performTask("closeCMD", desk);
            }  else if (command.equalsIgnoreCase("close control panel")) {
                speaking.speak("Closing control Panel");
                closelocalapp.performTask("closeCP", desk);
            } else if (command.equalsIgnoreCase("close calculator")) {
                speaking.speak("Closing Calculator");
                closelocalapp.performTask("closeCal", desk);
            }  else if (command.equalsIgnoreCase("close player")) {
                speaking.speak("Closing Media Player");
                closelocalapp.performTask("closePlayer", desk);
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
                app.performTask("openLMS", desk);
            }
            else if(command.equalsIgnoreCase("Open pscs")){
                speaking.speak("Opening PSCS");
                app.performTask("openPscs", desk);
            }
            else if(command.equalsIgnoreCase("Open youtube")){
                speaking.speak("Opening Youtube");
                app.performTask("openYoutube", desk);
            }
            else if(command.equalsIgnoreCase("Open outlook")){
                speaking.speak("Opening Outlook");
                app.performTask("openOutlook", desk);
            }
            else if(command.equalsIgnoreCase("open google")){
                speaking.speak("Opening Google");
                app.performTask("openGoogle", desk);
            }
            else if(command.equalsIgnoreCase("start chatting")){
                speaking.speak("Preparing your chatbot");
                bot.performTask("Chat", desk);
            }

            //other wise no work has to be done 
            
              else {
                work = null;
            }
}
}
