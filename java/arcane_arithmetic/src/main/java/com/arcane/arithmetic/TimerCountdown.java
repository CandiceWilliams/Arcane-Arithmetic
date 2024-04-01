package com.arcane.arithmetic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class TimerCountdown extends Label{
	private static int minutes, seconds;

	public static int getRemainingSeconds(){
		return minutes * 60 + seconds;
	}

	public static String getCurrentTime() {
		return String.format("%02d:%02d", minutes, seconds);
	}

	public static void setCurrentTime(int durationSecond){
		minutes = durationSecond / 60;
		seconds = durationSecond % 60;
	}

	public static void updateTime(){
		if (seconds == 0 && minutes == 0) return;
		if (seconds > 0){
			seconds--;
		}
		else {
			minutes--;
			seconds = 59;
		}
	}

	public static void addTime(int v){
		seconds += v;
	}
}
