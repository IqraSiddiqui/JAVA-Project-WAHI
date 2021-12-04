
import java.net.URI;
import java.util.concurrent.TimeUnit;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import java.io.*;
import java.awt.Desktop;


public class App {
    
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\dic.dic");
        config.setLanguageModelPath("src\\lm.lm");
        try {
            LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            rec.startRecognition(true);
            Desktop desk = Desktop.getDesktop();
            //Bandicam Recorder
            ProcessBuilder ChromeProcess = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    
    // create process to kill bandicam
            ProcessBuilder killChromerProcess = new ProcessBuilder("taskkill", "/f", "/im", "chrome.exe");
    
    //TeamViewer
            ProcessBuilder TeamViewerProcess = new ProcessBuilder("C:\\Program Files (x86)\\TeamViewer\\TeamViewer.exe");    
    
    // create process to kill team viewer
            ProcessBuilder killTeamViewerProcess = new ProcessBuilder("taskkill", "/f", "/im", "TeamViewer.exe"); 

            //File Manager

            ProcessBuilder explorerProcess = new ProcessBuilder("explorer.exe");
    
            // create process to kill explorer
            ProcessBuilder killExplorerProcess = new ProcessBuilder("taskkill", "/f", "/im", "explorer.exe");

            while (rec.getResult() != null) {
                String result = rec.getResult().getHypothesis();
                if (result.toLowerCase().equals("start chatting")){
                    System.out.println("Preparing your chatbot");
                    URI uri = new URI("https://alejandro.app.fi/ai-chat");
                    desk.browse(uri);
                }
                else if (result.toLowerCase().equals("open google")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://google.com/");
                    desk.browse(uri);
                }else if(result.toLowerCase().equals("open youtube")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://youtube.com/");
                    desk.browse(uri);
                }
                else if(result.toLowerCase().equals("open lms")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("https://habib.edu.pk/hulms/");
                    desk.browse(uri);
                }
                else if(result.toLowerCase().equals("open pscs")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("https://pscs.habib.edu.pk/");
                    desk.browse(uri);
                }
                else if(result.toLowerCase().equals("open outlook")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("www.outlook.com");
                    desk.browse(uri);
                }
                else if(result.equalsIgnoreCase("File manager")) {
        
                    // execute the process
                    explorerProcess.start() ;
                      
                    System.out.println("File Manager Opened!");
            
                  }  else if (result.equalsIgnoreCase("close manager")) {
                    
                    killExplorerProcess.start() ;
                    
                    System.out.println("File Manager Closed!");

                    try {
                        TimeUnit.SECONDS.sleep(1);
                      }catch(InterruptedException e) {
                          
                      }
              
                      // restart explorer, otherwise your desktop will be gone
                      explorerProcess.start();
                    
                  } 
                      
                    
                    // wait a second so finish executing the taskkill (it need's a moment to empty the cache)
                   
                else if (result.equalsIgnoreCase("browser")) {
          
                    // open firefox, that should take a few seconds
                    ChromeProcess.start() ;
                    
                    System.out.println("Chrome Opened!");
                  } else if (result.equalsIgnoreCase("close browser")) {
                    
                    killChromerProcess.start() ;
                    
                    System.out.println("chrome Closed!");
                    
                  } else if (result.equalsIgnoreCase("Team viewer")) {
          
                    // open firefox, that should take a few seconds
                    TeamViewerProcess.start() ;
                    
                    System.out.println("Team Viewer Opened!");
                  }else if (result.equalsIgnoreCase("close Team")) {
                    
                    killTeamViewerProcess.start() ;
                    
                    System.out.println("Team Viewer Closed!");
                    
                  }else if(result.equalsIgnoreCase("Retreive commands")){
                    AccessJDBC aj=new AccessJDBC();
                    aj.access();
                    File file=new File("WAHICommands.txt");
                    desk.open(file);

                  }
                  else if (result.equalsIgnoreCase("exit voice assistant")) {
                    System.out.println("Exiting Program! Bye!");
                    break;
                  }
                     
                
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}