package com.exercise.programs.designPattern.structural.adapter;

public class Testing {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("avi", "movie.avi");
    }
}
