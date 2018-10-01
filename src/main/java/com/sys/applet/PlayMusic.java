package com.sys.applet;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * applet 播放音乐 mid au  没完成..............
 * @author Administrator
 *
 */
public class PlayMusic extends Applet implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void start() {
		AudioClip clip = null;
		System.out.println(getDocumentBase());
		clip = getAudioClip(getDocumentBase(), "baga01.mid");
		clip.play();

	}

	public static void main(String[] args) {
		PlayMusic playMusic = new PlayMusic();
		playMusic.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
