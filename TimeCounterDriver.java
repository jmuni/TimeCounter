package testing;

public class TimeCounterDriver {
	
	public static void main(String[] args) {
		
		//System.out.println("Initialize the Clock in the format: hour,minute,second");
		
		TimeCounter clock = new TimeCounter(11,59,59);
		
		
		
		
		//clock.getHour();
		//clock.getMinute();
		//clock.getSecond();
		//clock.addHour();
		//clock.addMinute();
		clock.addSecond();
		//clock.displayStandard();
		//clock.displayMilitary();
		//System.out.println(clock.getHour());
		System.out.println("Military time is " + clock.displayMilitary());
		System.out.println("Standard time is " + clock.displayStandard());
	}

}
