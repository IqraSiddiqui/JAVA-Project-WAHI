import java.io.IOException;
/*
This class launches the local applications that needs to be open. It contains methods for launching all applications that WAHI can launch
*/

public class Launch {
    String work;
    Process p;

    public void openExplorer() { //method to launch file manager
        System.out.println("Opening FileManager");
        work="cmd /c start explorer.exe";
        run(work);
    }
    
    public void openChrome() { //method to launch google chrome
        System.out.println("Opening chrome");
        work="cmd /c start chrome.exe";
        run(work);
    }

    public void openEdge() { //method to launch microsoft edge
        System.out.println("Opening microsoft edge");
        work="cmd /c start microsoft-edge:";
        run(work);
    }

    public void openWord(){ //method to launch microsoft word
        System.out.println("Opening word");
        work="cmd /c start winword";
        run(work);
    }

    public void openExcel(){ //method to launch microsoft excel
        System.out.println("Opening excel");
        work="cmd /c start excel";
        run(work);
    }

    public void openPowerPoint(){ //method to launch microsoft powerpoint
        System.out.println("Opening power point");
        work="cmd /c start powerpnt";
        run(work);
    }

    public void openPaint(){ //method to launch paint
        System.out.println("Opening paint");
        work="cmd /c start mspaint";
        run(work);
    }

    public void openNotePad(){ //method to launch notepad
        System.out.println("Opening notepad");
        work="cmd /c start notepad";
        run(work);
    }

    public void openCMD(){//method to launch command prompt
        System.out.println("Opening command prompt");
        work="cmd /c start cmd";
        run(work);
    }

    public void openPlayer(){//method to launch media player
        System.out.println("Opening media player");
        work="cmd /c start wmplayer";
        run(work);
    }

    public void openCal(){//method to launch calculator
        System.out.println("Opening calculator");
        work="cmd /c start calc";
        run(work);
    }
    public void openCP(){//method to launch control panel
        System.out.println("Opening control panel");
        work="cmd /c start control";
        run(work);
    }
    public void run(String work){//method to run the work and hence launch the applications
        if(work != null) {//if work is equal to null then hence no application is need to be close
            try {
                p = Runtime.getRuntime().exec(work);
            } catch(IOException e){
                System.out.println(e);
            }
        }
    }
}
