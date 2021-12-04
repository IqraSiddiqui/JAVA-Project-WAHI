import java.io.IOException;

public class Launch {
    String work;
    Process p;

    public void openExplorer() {
        System.out.println("Opening FileManager");
        work="cmd /c start explorer.exe";
        run(work);
    }
    
    public void openChrome() {
        System.out.println("Opening chrome");
        work="cmd /c start chrome.exe";
        run(work);
    }

    public void openEdge() {
        System.out.println("Opening microsoft edge");
        work="cmd /c start microsoft-edge:";
        run(work);
    }

    public void openWord(){
        System.out.println("Opening word");
        work="cmd /c start winword";
        run(work);
    }

    public void openExcel(){
        System.out.println("Opening excel");
        work="cmd /c start excel";
        run(work);
    }

    public void openPowerPoint(){
        System.out.println("Opening power point");
        work="cmd /c start powerpnt";
        run(work);
    }

    public void openPaint(){
        System.out.println("Opening paint");
        work="cmd /c start mspaint";
        run(work);
    }

    public void openNotePad(){
        System.out.println("Opening notepad");
        work="cmd /c start notepad";
        run(work);
    }

    public void openCMD(){
        System.out.println("Opening command prompt");
        work="cmd /c start cmd";
        run(work);
    }

    public void openPlayer(){
        System.out.println("Opening media player");
        work="cmd /c start wmplayer";
        run(work);
    }

    public void openCal(){
        System.out.println("Opening calculator");
        work="cmd /c start calc";
        run(work);
    }
    public void openCP(){
        System.out.println("Opening control panel");
        work="cmd /c start control";
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
