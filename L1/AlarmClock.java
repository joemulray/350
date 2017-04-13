public class AlarmClock{
	int timeHour;
	int timeMin;
	int timeSec;
	String timePer;	
	
	int alarmHour;
	int alarmMin;
	int alarmSec
	
	public  AlarmClock(int timeHour, int timeMin,int timeSec, String timePer, 
	int alarmHour, int alarmMin, int alarmSecond, String alarmPer){
		
		/*Assuming standart times given and no values:
		hour > 12, min > 60, sec > 60 in this case not handling those values*/

		this.timeHour = timeHour;
		this.timeMin = timeMin;
		this.timeSec = timeSec;
		this.timePer = timePer;
		this.alarmHour = alarmHour;
		this.alarmMin = alarmMin;
		this.alarmSec = alarmSec;
		this.alarmPer = alarmPer;

	}
	
	public void showTime(){
	
	System.out.println("TIME: " + this.timeHour + ":" + this.timeMin + this.timeSec);

	}
	
	public boolean checkTime(){
		
		if(timeHour == alarmHour && timeMin == alarmMin && timeSec == alarmSec)
			return true;
		
		return false;
	
	}
	
	public void tick(){

		this.timeSec++;
		
		switch(60){
		case timeSec:
			this.timeMin++;
			this.timeSec = 0;
			break;
		
		case timeMin:
			this.timeHour++;
			this.timeMin = 0;
			break;

		}

		if(this.timeHour > 12){
		
		this.timeHour = 1;
		
			if(this.timePer.equals("AM")
				this.timePer = "PM";
			else
				this.timePer = "AM";		
	
		}
	
	}

	/*TODO:
		SNOOZE:
		OFF:
		BUZZ:
		SET WAKE UP TUNE:
	*/			

}
