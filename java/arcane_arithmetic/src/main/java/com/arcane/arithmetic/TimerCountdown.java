package com.arcane.arithmetic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TimerCountdown extends Label{
	private int durationSeconds;
	private Timeline timeline;
	
	public void countdown(int durationSeconds) {
		this.durationSeconds = durationSeconds;
		setText(formatTime(durationSeconds));
		
		timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				updateCountdown();
			}
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	private void updateCountdown() {
		durationSeconds--;
		if (durationSeconds>=0) {
			setText(formatTime(durationSeconds));
		} else {
			timeline.stop();
			setText("Time's up!");
		}
	}
	private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d", minutes, secs);
    }
}
