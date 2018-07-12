package com.pokergame.pokergame;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicClip {
	File file;
	public MusicClip(File file) {
		this.file = file;
	}

	public Clip createClip() {
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(file)) {
			AudioFormat audioFormat = ais.getFormat();
			DataLine.Info dataLine = new DataLine.Info(Clip.class, audioFormat);
			Clip clip = (Clip)AudioSystem.getLine(dataLine); 
			clip.open(ais);
			return clip;
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
	}
}
