package com.exercise.programs.designPattern.structural.adapter;

public class MediaAdapter implements MediaPlayer {
    VideoPlayer videoPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            videoPlayer = new VideoPlayer();
        }
    }

    @Override
    public void play(String play, String filename) {
        if (play.equalsIgnoreCase("mp4")) {
            videoPlayer.playVideo("mp4", filename);
        }
    }
}
