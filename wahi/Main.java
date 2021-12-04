public class Main
{
       public static void main(String[] args) {
        VoiceAssistant wahi = new VoiceAssistant();
        GUI gui=new GUI();
        Thread wahithread = new Thread(wahi);
        Thread guithread=new Thread(gui);
        wahithread.start();
        guithread.start();

    }
}