package testing;
/* This class counter library which utilizes a time based format, in which 60 seconds
 * comprises a minute, 60 minutes comprises an hours and 24 hours a full day. The class 
 * allows the user to easily increment or decrement each specific unit of time. It also
 * has the capability to display the time in either standard or military format
 * 
 * @author Jerry Zhang
 * 
 */
public class TimeCounter {

	private int hour;
	private int minute;
	private int second;
	
	private int maxHour = 23; //hour does not reach 24, as day resets
	private int minHour = 0;
	private int maxMinute = 59; //once you reach 60 minutes, it becomes an hour
	private int minMinute = 0;
	private int maxSecond = 59; //once you reach 60 seconds it becomes a minute
	private int minSecond = 0;
	
	public TimeCounter(int hour, int minute, int second) { //initializes time within proper parameters
		
		this.hour = hour;
		if(hour > maxHour || hour < minHour) {
		//	throw new Exception("Invalid Hours Entered");
		System.out.println("Invalid Hours Entered"); 
		System.exit(0);
		//do not print errors, instead focus on proper exception handling
		}
		
		this.minute = minute;
		if(minute > maxMinute || minute < minMinute) {
		//	throw new Exception("Invalid Minutes Entered");
		System.out.println("Invalid Minutes Entered");
		System.exit(0);
		}
		
		this.second = second;
		if(second > maxSecond || second < minSecond) {
		//	throw new Exception("Invalid Seconds Entered");
		System.out.println("Invalid Seconds Entered");
		System.exit(0);
		}
		
	}
	
	public int getHour() { //simple getter method for hours
		return hour;
	}
	
	public int getMinute() { //simple getter method for minutes	
		return minute;
	}

	public int getSecond() { //simple getter method for seconds	
		return second;
	}
		
	/*public void addHours(int addH) { //setter method to add hours
		
		hour += addH;
		
		while(hour > 24) { 	//while loop to check if added hours exceed 24 hours
			hour -= 24;		//if so, the clock is reset, since we're not counting days		
		}
	}
	*/
	
	/*public void subHours(int subH) {
		
		while(subH > 24) { //
			subH -= 24;
		}
		
		int total = hour - subH; //set a temp variable in case subtracted yields negative result
		
		if(total < 0) 			//negative total means backtracking into "previous day" 
			hour = 24 + total; 	//subtracts extra hours from 24 or "midnight" to yield appropriate hours
		else
			hour = total;
		
	}
	*/
	
	public void addHour() {
		
		hour++; //increments hour
		
		if(hour > maxHour) //check if counter passes maxHour or "midnight" which would reset the clock
			hour = 0; 
	}
	
	public void subHour() {
		
		hour--; //decrements hour
		
		if(hour < minHour) //checks if counter backs into "yesterday" which sets the clock back
			hour = 23;
	}
	
	public void addMinute() {
		
		minute++;
		
		if(minute > maxMinute) { //if incremented when at 59 minutes, reset minute and add 1 hour
			minute = 0;
			addHour();
		}
		/*if(hour == 24) //edge case if one minute adds to midnight, hours reset.
			hour = 0; 
		*/ //this part is redundant, and can call addHour method.
	}	
	
	public void subMinute() {
		
		minute--;
		
		if(minute < minMinute) {
			minute = 59;
			subHour();
		}
		/*if(hour == -1) //edge case if one minute backs into "yesterday" which sets the clock back
			hour = 23;
		*/
	}
	
	public void addSecond() {
		
		second++;
		
		if(second > maxSecond) { 
			second = 0;
			addMinute();
		}
		
		/*if(minute == 60) { //edge case
				minute = 0;
				hour++;
		}
		
		if(hour == 24) //edge case if one second adds to midnight, hours reset.
				hour = 0; 
		*/
	}	
	
	public void subSecond() {
		
		second--;
		
		if(second < minSecond) { //if at 0 seconds, set to 59 seconds while decrementing minute
			second = 59;
			subMinute();
		}
		/*if(minute == -1) { //edge case
			minute = 59;
			hour--;
		}
		if(hour == -1) //edge case at 0:00:00 time
			hour = 23;
		*/
	}
	
	public String displayStandard() {
		
		String AMPM;
		int afternoonChange = 12; //this variable signifies when AM becomes PM ie 11:59AM --> 12:00 PM
		int standardHour = hour;
		
		if(hour < afternoonChange) { 
			AMPM = "AM";
			if(hour == 0) {
				standardHour += afternoonChange; //edge case if military time is 0:0:0 it SHOULD display 12:0:0 AM
			}
		}else {
			standardHour = hour - afternoonChange;
			AMPM = "PM";
			if(hour == 12) { //edge case if military time is 12:0:0 it should display 12:0:0 PM
				standardHour = afternoonChange;
			}
		}
			
		
		String standardTime = Integer.toString(standardHour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second) + " " + AMPM;
		
		return standardTime;
	}
		
	//this method should return a string of time NOT a print statement
	/*public void displayStandard() { //prints out the standard time with AM or PM respectively 
		
		/*if(hour > 12) {
			hour -= 12;
			System.out.println("Time " + hour + ":" + minute + ":" + second + " PM");
		} else if(hour == 12) {
			System.out.println("Time " + hour + ":" + minute + ":" + second + " PM");
		} else if(hour == 0) {
			System.out.println("Time " + "12" + ":" + minute + ":" + second + " AM");
		} else {
			System.out.println("Time " + hour + ":" + minute + ":" + second + " AM");
		}
		
	}
	*/

	public String displayMilitary() { //prints out 24 hour military time
	
		String militaryTime = Integer.toString(hour) + ":" + Integer.toString(minute) + ":" + Integer.toString(second);
		
		return militaryTime;

	}

}
