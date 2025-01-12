package com.exercise.programs.designPattern.structural.adapter;

public class AudioPlayer implements MediaPlayer {


    @Override
    public void play(String audioType, String fileName) {
        MediaAdapter mediaAdapter;
        // Built-in support for mp3 music files
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        }
        // MediaAdapter provides support for mp4 video files
        else if (audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

