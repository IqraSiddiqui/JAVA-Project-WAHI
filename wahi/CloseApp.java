import java.io.IOException;
import java.awt.Desktop;
import java.util.*;

///change
/*
CloseApp class closes the local applications that have been open. It contains methods for closing all applications that WAHI cn launch
*/

public class CloseApp implements Tasks {
    String work;
    Process p;

    @Override
    public void performTask(String what,Desktop desk){
        TreeMap<String, String> tmap= new TreeMap<>();
        

        tmap.put("closeChrome","cmd /c start taskkill /im chrome.exe /f") ;
        tmap.put("closeEdge","cmd /c start taskkill /im MicrosoftEdge.exe /f") ;
        tmap.put("closeWord","cmd /c start taskkill /im winword.exe /f") ;
        tmap.put("closeExcel","cmd /c start taskkill /im excel.exe /f") ;
        tmap.put("closePowerpoint","cmd /c start taskkill /im powerpnt.exe /f") ;
        tmap.put("closePaint","cmd /c start taskkill /im mspaint.exe /f") ;
        tmap.put("closeNotepad","cmd /c start taskkill /im notepad.exe /f") ;
        tmap.put("closeCMD","cmd /c start taskkill /im cmd.exe /f") ;
        tmap.put("closeCP","cmd /c start taskkill /im control.exe /f") ;
        tmap.put("closeCal","cmd /c start taskkill /im calculator.exe /f") ;
        tmap.put("closePlayer","cmd /c start taskkill /im wmplayer.exe /f") ;
        // for(Map.Entry m:tmap.entrySet()){  
        //     String key=m.getKey();  
        //     if(what.equalsIgnoreCase(key)){
        //         work=m.getValue();
        //     } 
        // }  
        Set<Map.Entry<String, String>> entrySet = tmap.entrySet();
        // Convert entrySet to Array using toArray method
        Map.Entry<String, String>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);
        for (int i=0;i<11;i++){
            if(what.equalsIgnoreCase(entryArray[i].getKey())){
                        work=entryArray[i].getValue();
                    } 

        }

        // if(what.equalsIgnoreCase("closeChrome")){
        //     System.out.println("Closing chrome");
        //     work="cmd /c start taskkill /im chrome.exe /f";
        // }else if(what.equalsIgnoreCase("closeEdge")){
        //     System.out.println("Closing microsoft edge");
        //     work="cmd /c start taskkill /im MicrosoftEdge.exe /f";
        // }else if(what.equalsIgnoreCase("closeWord")){
        //     System.out.println("Closing word");
        //     work="cmd /c start taskkill /im winword.exe /f";
        // }else if(what.equalsIgnoreCase("closeExcel")){
        //     System.out.println("Closing excel");
        //     work="cmd /c start taskkill /im excel.exe /f";
        // }else if(what.equalsIgnoreCase("closePowerPoint")){
        //     System.out.println("Closing power point");
        //     work="cmd /c start taskkill /im powerpnt.exe /f";
        // }else if(what.equalsIgnoreCase("closePaint")){
        //     System.out.println("Closing paint");
        //     work="cmd /c start taskkill /im mspaint.exe /f";
        // }else if(what.equalsIgnoreCase("closeNotepad")){
        //     System.out.println("Closing notepad");
        //     work="cmd /c start taskkill /im notepad.exe /f";
        // }else if(what.equalsIgnoreCase("closeCMD")){
        //     System.out.println("Closing command prompt");
        //     work="cmd /c start taskkill /im cmd.exe /f";
        // }else if(what.equalsIgnoreCase("closeCP")){
        //     System.out.println("Closing control panel");
        //     work="cmd /c start taskkill /im control.exe /f";
        // }else if(what.equalsIgnoreCase("closeCal")){
        //     System.out.println("Closing calculator");
        //     work="cmd /c start taskkill /im calculator.exe /f";
        // }else if(what.equalsIgnoreCase("closePlayer")){
        //     System.out.println("Closing media player");
        //     work="cmd /c start taskkill /im wmplayer.exe /f";
        // }






            
        
        //createTMAP();
        // if(what.equalsIgnoreCase("closeChrome")){
        //     System.out.println("Closing chrome");
        //     work="cmd /c start taskkill /im chrome.exe /f";
        // }else if(what.equalsIgnoreCase("closeEdge")){
        //     System.out.println("Closing microsoft edge");
        //     work="cmd /c start taskkill /im MicrosoftEdge.exe /f";
        // }else if(what.equalsIgnoreCase("closeWord")){
        //     System.out.println("Closing word");
        //     work="cmd /c start taskkill /im winword.exe /f";
        // }else if(what.equalsIgnoreCase("closeExcel")){
        //     System.out.println("Closing excel");
        //     work="cmd /c start taskkill /im excel.exe /f";
        // }else if(what.equalsIgnoreCase("closePowerPoint")){
        //     System.out.println("Closing power point");
        //     work="cmd /c start taskkill /im powerpnt.exe /f";
        // }else if(what.equalsIgnoreCase("closePaint")){
        //     System.out.println("Closing paint");
        //     work="cmd /c start taskkill /im mspaint.exe /f";
        // }else if(what.equalsIgnoreCase("closeNotepad")){
        //     System.out.println("Closing notepad");
        //     work="cmd /c start taskkill /im notepad.exe /f";
        // }else if(what.equalsIgnoreCase("closeCMD")){
        //     System.out.println("Closing command prompt");
        //     work="cmd /c start taskkill /im cmd.exe /f";
        // }else if(what.equalsIgnoreCase("closeCP")){
        //     System.out.println("Closing control panel");
        //     work="cmd /c start taskkill /im control.exe /f";
        // }else if(what.equalsIgnoreCase("closeCal")){
        //     System.out.println("Closing calculator");
        //     work="cmd /c start taskkill /im calculator.exe /f";
        // }else if(what.equalsIgnoreCase("closePlayer")){
        //     System.out.println("Closing media player");
        //     work="cmd /c start taskkill /im wmplayer.exe /f";
        // }
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
    //public void createTMAP()
}
