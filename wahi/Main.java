public class Main
{
       public static void main(String[] args) {
        VoiceAssistant wahi = new VoiceAssistant();
        ColorfulCircles gui=new ColorfulCircles();
        Thread wahithread = new Thread(wahi);
        Thread guithread=new Thread(gui);
        wahithread.start();
        guithread.start();

    }
}