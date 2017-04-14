package Participant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Random;

public class Athlete extends Participant implements Comparable <Athlete>,Comparator<Athlete> {
	
	public Athlete(String Athleteid, String Athletename, int Athleteage, String Atheletestate) {
		super(Athleteid, Athletename, Athleteage, Atheletestate);
			}
	
	
	
	private char athleteType;     //type of Athlete
	private int finishTimer; 
private int totalPoints;     //total points of Athletes



	
	public int getTotalPoints() {
	return totalPoints;
}

public void setTotalPoints(int totalPoints) {
	this.totalPoints = totalPoints;
}

public char getAthleteType() {
	return athleteType;
}

public void setAthleteType(char athleteType) {
	this.athleteType = athleteType;
}

public int getFinishTimer() {
	return finishTimer;
}

public void setFinishTimer(int finishTimer) {
	this.finishTimer = finishTimer;
}

public void compete(int minTimer, int maxTimer){
	Random random = new Random();
	int finishTimer = random.nextInt(maxTimer-minTimer)+minTimer;
	this.setFinishTimer(finishTimer);
	
}

/**
 * @description comparing the two different Athlete objects
 * @param athlete passing athlete objects
 * @return 1,0,-1 based on result
 */


@Override
public int compareTo(Athlete athlete) {
	// TODO Auto-generated method stub
	return this.compareTo(athlete);
}


/**
 * @description comparing the Athletes
 * @param firstAthlete Object of first Athlete
 * @param secondAthlete Object of second Athlete
 * @return difference of firstAthlete finish time and second Athlete finish time
 */

@Override
public int compare(Athlete firstAthlete, Athlete secondAthlete) {
	// TODO Auto-generated method stub
	return firstAthlete.getFinishTimer()-secondAthlete.getFinishTimer();
}

	

	

}
