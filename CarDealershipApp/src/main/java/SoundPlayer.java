import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.Clip;

public class SoundPlayer {

    public static void playSound(String soundFilePath) {

        try {
            File soundFile = new File(soundFilePath) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

                Thread.sleep(clip.getMicrosecondLength()/ 1000);

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println("Could not play sound");
            }

            }

    }




}
