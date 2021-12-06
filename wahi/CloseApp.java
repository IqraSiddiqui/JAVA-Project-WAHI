import java.io.IOException;

/*
CloseApp class closes the local applications that have been open. It contains methods for closing all applications that WAHI cn launch
*/
public class CloseApp {
    String work;
    Process p;

    public void closeChrome() { //method to close google chrome
        System.out.println("Closing chrome");
        work="cmd /c start taskkill /im chrome.exe /f";
        run(work);
    }
    
   
    public void closeEdge() { //method to close microsft edge
        System.out.println("Closing microsoft edge");
        work="cmd /c start taskkill /im MicrosoftEdge.exe /f";
        run(work);
    }
    
    public void closeWord(){ //method to close Microsoft word
        System.out.println("Closing word");
        work="cmd /c start taskkill /im winword.exe /f";
        run(work);
    }
    
    
    public void closeExcel(){ //method to close Microsoft Excel
        System.out.println("Closing excel");
        work="cmd /c start taskkill /im excel.exe /f";
        run(work);
    }
    
    
    public void closePowerPoint(){ //method to close Microsoft Powerpoint
        System.out.println("Closing power point");
        work="cmd /c start taskkill /im powerpnt.exe /f";
        run(work);
    }
    
    
    public void closePaint(){ //method to close Paint
        System.out.println("Closing paint");
        work="cmd /c start taskkill /im mspaint.exe /f";
        run(work);
    }
    
    
    public void closeNotePad(){ //method to close Notepad
        System.out.println("Closing notepad");
        work="cmd /c start taskkill /im notepad.exe /f";
        run(work);
    }
    
    public void closeCMD(){ //method to close Command Prompt
        System.out.println("Closing command prompt");
        work="cmd /c start taskkill /im cmd.exe /f";
        run(work);
    }
    
    public void closeCP(){ //method to close Control panel
        System.out.println("Closing control panel");
        work="cmd /c start taskkill /im control.exe /f";
        run(work);
    }
    
    
    public void closeCal(){ //method to close calculator
        System.out.println("Closing calculator");
        work="cmd /c start taskkill /im calculator.exe /f";
        run(work);
    }
    
    public void closePlayer(){ //method to close Media player
        System.out.println("Closing media player");
        work="cmd /c start taskkill /im wmplayer.exe /f";
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
