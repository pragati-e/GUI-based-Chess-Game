package chess;

/*
 * Name: Pragati Makani
 * Id: 920821704
 * File Name: Time.java
 * 
 * Description: It utilizes a Timer Class and contains all of the necessary variables and functions for the timer on the main GUI.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;


public class Time {
    private JLabel label;
    Timer countdownTimer;
    int Timerem;
    public Time(JLabel passedLabel) {
       countdownTimer = new Timer(1000, new CountdownTimerListener());
       this.label = passedLabel;
       Timerem=Main.timeRemaining;
    }
    
    //starting the timer
    public void start() {
    	countdownTimer.start();
    }
    
    //resetting the timer
    public void reset() {
    	Timerem=Main.timeRemaining;
    }
    
    //after every second, a function is called
    //it adjusts the timing and does other essential tasks
    class CountdownTimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
       	    int min,sec;
       	    if (Timerem > 0) {
           	    min=Timerem/60;
           	    sec=Timerem%60;
                label.setText(String.valueOf(min)+":"+(sec>=10?String.valueOf(sec):"0"+String.valueOf(sec)));
                Timerem--;
            }
       	    else {
                label.setText("Time's up!");
                reset();
                start();
                Main.Mainboard.changechance();
		    }
        }
    }
}
