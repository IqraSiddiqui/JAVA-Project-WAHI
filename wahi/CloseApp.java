import java.io.IOException;

public class CloseApp {
    String work;
    Process p;

    public void closeChrome() {
        System.out.println("Closing chrome");
        work="cmd /c start taskkill /im chrome.exe /f";
        run(work);
    }
    
   
    public void closeEdge() {
        System.out.println("Closing microsoft edge");
        work="cmd /c start taskkill /im MicrosoftEdge.exe /f";
        run(work);
    }
    
    public void closeWord(){
        System.out.println("Closing word");
        work="cmd /c start taskkill /im winword.exe /f";
        run(work);
    }
    
    
    public void closeExcel(){
        System.out.println("Closing excel");
        work="cmd /c start taskkill /im excel.exe /f";
        run(work);
    }
    
    
    public void closePowerPoint(){
        System.out.println("Closing power point");
        work="cmd /c start taskkill /im powerpnt.exe /f";
        run(work);
    }
    
    
    public void closePaint(){
        System.out.println("Closing paint");
        work="cmd /c start taskkill /im mspaint.exe /f";
        run(work);
    }
    
    
    public void closeNotePad(){
        System.out.println("Closing notepad");
        work="cmd /c start taskkill /im notepad.exe /f";
        run(work);
    }
    
    public void closeCMD(){
        System.out.println("Closing command prompt");
        work="cmd /c start taskkill /im cmd.exe /f";
        run(work);
    }
    
    public void closeCP(){
        System.out.println("Closing control panel");
        work="cmd /c start taskkill /im control.exe /f";
        run(work);
    }
    
    
    public void closeCal(){
        System.out.println("Closing calculator");
        work="cmd /c start taskkill /im calculator.exe /f";
        run(work);
    }
    
    public void closePlayer(){
        System.out.println("Closing media player");
        work="cmd /c start taskkill /im wmplayer.exe /f";
        run(work);
    }

    public void run(String work){
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
