import java.io.IOException;
import java.awt.Desktop;

/*
CloseApp class closes the local applications that have been open. It contains methods for closing all applications that WAHI cn launch
*/
public class CloseApp implements Tasks {
    String work;
    Process p;

    @Override
    public void performTask(String what,Desktop desk){
        if(what.equalsIgnoreCase("closeChrome")){
            System.out.println("Closing chrome");
            work="cmd /c start taskkill /im chrome.exe /f";
        }else if(what.equalsIgnoreCase("closeEdge")){
            System.out.println("Closing microsoft edge");
            work="cmd /c start taskkill /im MicrosoftEdge.exe /f";
        }else if(what.equalsIgnoreCase("closeWord")){
            System.out.println("Closing word");
            work="cmd /c start taskkill /im winword.exe /f";
        }else if(what.equalsIgnoreCase("closeExcel")){
            System.out.println("Closing excel");
            work="cmd /c start taskkill /im excel.exe /f";
        }else if(what.equalsIgnoreCase("closePowerPoint")){
            System.out.println("Closing power point");
            work="cmd /c start taskkill /im powerpnt.exe /f";
        }else if(what.equalsIgnoreCase("closePaint")){
            System.out.println("Closing paint");
            work="cmd /c start taskkill /im mspaint.exe /f";
        }else if(what.equalsIgnoreCase("closeNotepad")){
            System.out.println("Closing notepad");
            work="cmd /c start taskkill /im notepad.exe /f";
        }else if(what.equalsIgnoreCase("closeCMD")){
            System.out.println("Closing command prompt");
            work="cmd /c start taskkill /im cmd.exe /f";
        }else if(what.equalsIgnoreCase("closeCP")){
            System.out.println("Closing control panel");
            work="cmd /c start taskkill /im control.exe /f";
        }else if(what.equalsIgnoreCase("closeCal")){
            System.out.println("Closing calculator");
            work="cmd /c start taskkill /im calculator.exe /f";
        }else if(what.equalsIgnoreCase("closePlayer")){
            System.out.println("Closing media player");
            work="cmd /c start taskkill /im wmplayer.exe /f";
        }
        run(work);
    }

   
    public void run(String work){ //method to run the work and hence close the applications
        if(work != null) { //if work is equal to null then hence no application is need to be close
            try {
                p = Runtime.getRuntime().exec(work);
            } catch(IOException e){
                System.out.println(e);
            }
        }
    }
}
