/*
Joseph Mulray
CS 350
Lab 1: Alarm Clock
*/


public class AlarmClock{

	int timeHour;
	int timeMin;
	int timeSec;
	String timePer;	
	
	int alarmHour;
	int alarmMin;
	String alarmPer;
	boolean radio = true;
	int volNum = 0;
	String station = "1060 AM";

	public  AlarmClock(int timeHour, int timeMin,int timeSec, String timePer, 
	int alarmHour, int alarmMin, String alarmPer){
		
		/*Assuming standart times given and no values:
		hour > 12, min > 60, sec > 60 in this case not handling those values*/

		this.timeHour = timeHour;
		this.timeMin = timeMin;
		this.timeSec = timeSec;
		this.timePer = timePer;
		this.alarmHour = alarmHour;
		this.alarmMin = alarmMin;
		this.alarmPer = alarmPer;


		//temporary string for time formatting min is not 8:2 and 8:02
		String tempMin = Integer.toString(this.timeMin);
		if(this.timeMin < 10)
			tempMin = "0" + this.timeMin;

		//Initial AlarmClock Message
		System.out.println("Initial Time: " + timeHour + ":" + tempMin + ".");
		System.out.print("The radio was turned on and is playing " + this.station + ".\n");

	}
	
	public String showTime(){
		//return string to show classes.
		String tempMin = Integer.toString(this.timeMin);
		if(this.timeMin < 10)
			//for formatting purposess create temp string.
			tempMin = "0" + this.timeMin;

		String show = (this.timeHour + ":" + tempMin);

	return show;

	}
	
	public void checkAlarm(){
		//return staus of alarm whether alarm is reached or not.

		if((this.timeHour == this.alarmHour) && (this.timeMin == this.alarmMin))
			System.out.print("THE RADIO IS PLAYING " + this.station + ". ");
	}
	
	public void tick(){
		//increment seconds for AlarmClock.

		this.timeSec++;

		//seconds greater than 60 increase minute reset sec.
		if(this.timeSec >= 60){
			this.timeMin++;
			this.timeSec = 0;
		}
		//if time greater than 60 reset minute and increase hour
		if(this.timeMin >= 60){
			this.timeHour++;
			this.timeMin = 0;
		}

		//if hour greater than 12 reset to 1, and switch AM, PM.
		if(this.timeHour > 12){
			this.timeHour = 1;
		
			if(this.timePer.equals("AM"))
				this.timePer = "PM";
			else
				this.timePer = "AM";		
		}
	
	}

	public void snooze(){
		//Snooze function add 9 mintues to the Alarm Minutes.
		System.out.println("Snooze was pressed.");
		this.alarmMin += 9;
	}

	public void AlarmOff(){
		//Print alarm was shut off, exit program
		System.out.println("The alarm was shut off.");
		System.exit(0);
	}

	public void radioOff(boolean isOff){
		//function to turn radio on or off.
		if(isOff)
			System.out.println("Radio was turned off.");
		else
			System.out.println("Radio was turned on.");

		this.radio = isOff;
	}

	public void volume(int volNum){
		//function to set current volume of Clock
		this.volNum = volNum;
	}


	public void setStation(String station){
		//function to set current station of radio.
		this.station = station;
	}

}
