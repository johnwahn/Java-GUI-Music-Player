import java.awt.event.ActionEvent;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioManager extends Thread {
	ArrayList<Song> songList;
	static Clip clip;
	AudioInputStream stream;
	Song activeSong;
	long currClipPosition;
	boolean repeat;
	boolean shuffle;
	static long preTime = 0;
	static long time = 0;
	static long preTimePause = 0;
	static long pausedTime = 0;
	boolean currPlaying = false; // used to play one song at a time
	boolean paused = false;
	static ActionEvent action;
	static long recordTotalPauseTime = 0;
	int index = 0;

	AudioManager() {
		songList = new ArrayList<>();
		currClipPosition = 0;
		repeat = false;
		shuffle = false;
	}

	// get all prepared songs
	public void getAllSongs() {
		songList.add(new Song("IU - Eight.wav"));
		songList.add(new Song("Downtown Baby.wav"));
		songList.add(new Song("SUNMI (선미) - 보라빛 밤 (pporappippam) AUDIO.wav"));
		songList.add(new Song("화사 (Hwa Sa)마리아 (Maria).wav"));
		songList.add(new Song("BLACKPINK - 'How You Like That' (Official Audio).wav"));
	}

	public Song getActiveSong() {
		return this.activeSong;
	}

	public void run() {
		preTime = System.currentTimeMillis();
		while (true) {
			System.out.println(time);
			activeSong = songList.get(index);
			time = System.currentTimeMillis() - preTime;
			if (!currPlaying && !activeSong.playing) {
				currPlaying = true;
				try {
					stream = AudioSystem.getAudioInputStream(activeSong.fileSong);
					clip = AudioSystem.getClip();
					clip.open(stream);
					clip.setMicrosecondPosition(currClipPosition);
					clip.start();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// Keep track of time
			if (time - recordTotalPauseTime == songList.get(index).totalTime * 1000) {
				System.out.println("in first if");
				index = (index + 1) % songList.size();
				preTime = System.currentTimeMillis();
				currClipPosition = 0;
				currPlaying = false;
				pausedTime = 0;
			}
			// pause track
			if (activeSong.playing) {
				if (currPlaying) {
					//System.out.println("pausedTime " + pausedTime);
					currClipPosition = clip.getMicrosecondPosition();
					pausedTime = System.currentTimeMillis();
					clip.stop();
					currPlaying = false;
				} else {
					recordTotalPauseTime = System.currentTimeMillis() - pausedTime;
					//System.out.println(recordTotalPauseTime);
				}

			}
		}
	}

}
