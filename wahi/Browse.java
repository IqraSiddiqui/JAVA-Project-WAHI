import java.awt.Desktop;
import java.net.URI;

public class Browse {
    
    public void openpscs(Desktop desk){
        try {
            URI uri = new URI("https://pscs.habib.edu.pk/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void openLMS(Desktop desk){
        try {
            URI uri = new URI("https://habib.edu.pk/hulms/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }

    public void openyoutube(Desktop desk){
        try {
            URI uri = new URI("http://youtube.com/");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void openoutlook(Desktop desk){
        try {
            URI uri = new URI("www.outlook.com");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    public void opengoogle(Desktop desk){
        try {
            URI uri = new URI("www.google.com");
            desk.browse(uri);
        } 
        catch (Exception e) {
                System.err.println(e);
            }
        
    }
    
}
