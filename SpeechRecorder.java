import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;



public class SpeechRecorder {

	
	public static void main (String[] args) throws LineUnavailableException {
		
		
		
		
		
		
		try {
			AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
			
			DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
			if (!AudioSystem.isLineSupported(info)) {
			      // Handle the error ... 
				}
			final TargetDataLine targetline = (TargetDataLine) AudioSystem.getLine(info);
			targetline.open();
			
			System.out.println("start recording");
			
			targetline.start();
			
			Thread thread = new Thread()
			{
				@Override public void run(){
					AudioInputStream audioStream = new AudioInputStream(targetline);
					File audioFile = new File("record.wav");
					try {
						AudioSystem.write(audioStream, AudioFileFormat.Type.WAVE, audioFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			
			thread.start();
			Thread.sleep(5000);
			targetline.stop();
			targetline.close();

		} 
		catch (LineUnavailableException lue) {}
		catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
}
