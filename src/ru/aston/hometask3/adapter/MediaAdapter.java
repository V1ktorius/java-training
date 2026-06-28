package ru.aston.hometask3.adapter;

public class MediaAdapter implements SmartMediaPlayer {
    private final MediaPlayer advancedPlayer = new MediaPlayer();
    @Override
    public void play(String filename) {
        if (filename.endsWith(".wav")) {
            advancedPlayer.playWav(filename);
        } else if (filename.endsWith(".mp3")) {
            advancedPlayer.playMp3(filename);
        } else if (filename.endsWith(".mp4")) {
            advancedPlayer.playMp4(filename);
        } else {
            throw new IllegalArgumentException("Unsupported format: " + filename);
        }
    }
}
