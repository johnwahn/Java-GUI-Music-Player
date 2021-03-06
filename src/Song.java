import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;

public class Song {
	int count;
	File fileSong;
	File songAlbumCover;
	String artist;
	String songTitle;
	long totalTime;
	boolean playing = false;

	Song(String fileName) {
		this.count = 0;
		this.fileSong = new File(fileName);
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(fileSong);
			AudioFormat format = stream.getFormat();
			long frames = stream.getFrameLength();
			totalTime = (long) ((frames) / format.getFrameRate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		//this.songAlbumCover = new File(songAlbumCover);
		//this.artist = artist;
		//this.songTitle = songTitle;
	}
}
