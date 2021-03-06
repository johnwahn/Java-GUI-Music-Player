import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MP3_Gui extends  JPanel implements ActionListener{
		JButton playButton; // play/pause songs
		JButton pauseButton;
		JButton randomButton;
		JButton repeatButton;
		JButton addButton; // add songs to playlist 
		JButton forwardBtn;
		JButton backwardBtn;
		JButton showFavroite;
		JButton logoButton;
		JLabel albumCover; 
		JLabel artistName;
		JLabel songLabel;
		//PriorityQueue<Song> maxHeap;
		
		//private BufferedImage albumCover;
		
		final int MARGIN = 50;
		final int START_X_OFFSET = 250;
		final int START_Y_OFFSET = 525;
		
		boolean paused = false;
		boolean random = false;
		boolean repeat = false;
		
		Icon playIcon = new ImageIcon("playButton.png");
		Icon pauseIcon = new ImageIcon("pauseButton.png");
		
		Icon turnOnRandomIcon = new ImageIcon("turnOnRandom.png");
		Icon turnOffRandomIcon = new ImageIcon("turnOffRandom.png");
		
		Icon turnOnRepeatIcon = new ImageIcon("turnOnRepeat.png");
		Icon turnOffRepeatIcon = new ImageIcon("turnOffRepeat.png");
		Song currSong;
		AudioManager manager;
		
		MP3_Gui() {
			this.setLayout(null);
			this.setBackground(Color.gray);
			manager = new AudioManager();
			manager.getAllSongs(); //get all the songs to songList
			currSong = manager.songList.get(0);
			
			
			Icon albumIcon = new ImageIcon("albumCover.jpeg");
			albumCover = new JLabel(albumIcon);
			albumCover.setSize(250,250);
			albumCover.setLocation(55,200);
			add(albumCover);
			
			songLabel = new JLabel();
			songLabel.setText("Eight");
			songLabel.setSize(50,50);
			songLabel.setLocation(170,80);
			add(songLabel);
			
			artistName = new JLabel();
			artistName.setText("IU(아이유)");
			artistName.setSize(80,80);
			artistName.setLocation(160,85);
			add(artistName);
			
			Icon logoIcon = new ImageIcon("logo.png");
			logoButton = new JButton(logoIcon);
			logoButton.setBorderPainted(false);
			logoButton.setFocusPainted(false);
			logoButton.setContentAreaFilled(false);
			logoButton.setSize(70, 70);
			logoButton.setLocation(20, 20);
			add(logoButton);
				
			playButton = new JButton(pauseIcon);
			playButton.setBorderPainted(false);
			playButton.setFocusPainted(false);
			playButton.setContentAreaFilled(false);
			playButton.setSize(50, 50);
			playButton.setLocation(START_X_OFFSET-95, START_Y_OFFSET);
			playButton.addActionListener(this);
			add(playButton); 
			
			
			Icon fwdIcon = new ImageIcon("forwardButton.png");
			forwardBtn = new JButton(fwdIcon);
			forwardBtn.setBorderPainted(false);
			forwardBtn.setFocusPainted(false);
			forwardBtn.setContentAreaFilled(false);
			forwardBtn.setSize(50, 50);
			forwardBtn.setLocation(START_X_OFFSET+MARGIN-95, START_Y_OFFSET);
			forwardBtn.addActionListener(this);
			add(forwardBtn); 
			
			Icon bwdIcon = new ImageIcon("backwardButton.png");
			backwardBtn = new JButton(bwdIcon);
			backwardBtn.setBorderPainted(false);
			backwardBtn.setFocusPainted(false);
			backwardBtn.setContentAreaFilled(false);
			backwardBtn.setSize(50, 50);
			backwardBtn.setLocation(START_X_OFFSET-MARGIN-95, START_Y_OFFSET);
			backwardBtn.addActionListener(this);
			add(backwardBtn);
			
			
			randomButton = new JButton(turnOnRandomIcon);
			randomButton.setBorderPainted(false);
			randomButton.setFocusPainted(false);
			randomButton.setContentAreaFilled(false);
			randomButton.setSize(50, 50);
			randomButton.setLocation(START_X_OFFSET-3*MARGIN-40, START_Y_OFFSET);
			randomButton.addActionListener(this);
			add(randomButton);
			
			repeatButton = new JButton(turnOnRepeatIcon);
			repeatButton.setBorderPainted(false);
			repeatButton.setFocusPainted(false);
			repeatButton.setContentAreaFilled(false);
			repeatButton.setSize(50, 50);
			repeatButton.setLocation(START_X_OFFSET-4*MARGIN-40, START_Y_OFFSET);
			repeatButton.addActionListener(this);
			add(repeatButton);
			
		}
		
		public void repeatPlay() {
			if (repeat) {
				repeatButton.setIcon(turnOnRepeatIcon);
			}
			else {
				repeatButton.setIcon(turnOffRepeatIcon);
				
			}	
			repeat = !repeat;
		}
		
		public void shufflePlay() {
			if (random) {
				randomButton.setIcon(turnOnRandomIcon);
			}
			
			else {
				randomButton.setIcon(turnOffRandomIcon);
			}		
			random = !random;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == playButton) {
				if (paused) {
					playButton.setIcon(pauseIcon); 
					manager.activeSong.playing = false;
				}
				else {
					playButton.setIcon(playIcon);
					manager.activeSong.playing = true;
				}
				paused = !paused;
			}
			if (e.getSource() == repeatButton) {
				repeatPlay();
			}
			
			if (e.getSource() == randomButton) {
				shufflePlay();
			}
			if (e.getSource() == forwardBtn) {

			}
			if (e.getSource() == backwardBtn) {

			}
		}

	}

