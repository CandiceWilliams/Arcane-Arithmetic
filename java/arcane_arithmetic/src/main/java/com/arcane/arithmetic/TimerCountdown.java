package com.arcane.arithmetic;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;


/**
 * This is a helper class to help keep track of time remaining in the game
 * This class extends {@link javafx.scene.control.Labeled}</a>
 * @author Ming Chun Chan
 * @author Justin Xu
 * @see TimerCountdown
 */
public class TimerCountdown extends Label{
	private static int minutes, seconds;

	/**
	 * Returns the remianing seconds left on user countdown
	 * @return seconds remaining
	 * @see TimerCountdown
	 */
	public static int getRemainingSeconds(){
		return minutes * 60 + seconds;
	}

	/**
	 * Returns current time
	 * @return string format of time
	 * @see TimerCountdown
	 */
	public static String getCurrentTime() {
		return String.format("%02d:%02d", minutes, seconds);
	}

	/**
	 * Sets the current timer
	 * @param durationSecond how long the timer should be set for
	 * @see TimerCountdown
	 */
	public static void setCurrentTime(int durationSecond){
		minutes = durationSecond / 60;
		seconds = durationSecond % 60;
	}

	/**
	 * Updates the time
	 * @see TimerCountdown
	 */
	public static void updateTime(){
		// -1 total seconds is the minimum (the value -1 is checked in initTime() in FillInTheBlanksController)
		if (getRemainingSeconds() == -1) return;
		if (seconds > 0){
			seconds--;
		}
		else {
			minutes--;
			seconds = 59;
		}
	}

	/**
	 * Adds extra time to current time
	 * @param v time to be added
	 * @see TimerCountdown
	 */
	public static void addTime(int v){
		seconds += v;
	}
}
