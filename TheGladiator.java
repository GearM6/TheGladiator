package TheGladiator;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * TheGladiator - a robot by (your name here)
 */
public class TheGladiator extends Robot
{
	/**
	 * run: TheGladiator's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		Color purple = new Color(99, 11, 193);

		setColors(purple,Color.white,Color.white); // body,gun,radar
		setBodyColor(purple);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(30);
			turnRight(40);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double degrees = getRadarHeading() - getHeading();
		if(degrees >= 180.0){
			turnLeft(degrees);
		}
		else{
			turnRight(degrees);
		}
		ahead(20);
		// Replace the next line with any behavior you would like
	}
	
	public void onHitRobot(HitRobotEvent e){
		fire(5);
		back(200);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		turnLeft(50);
		ahead(getRoundNum()*4.5);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		double x, y;
		x = getX();
		y = getY();
		if(y < 6 || y > (getBattleFieldHeight()-6)){
			if(90 < getHeading() && getHeading() < 270){
				back(20);
			}
			else {
				ahead(20);
			}
		}
		else if(x < 6 || x > (getBattleFieldWidth()-6)){
			if(getHeading() > 180){
				back(20);
			}
			else {
				ahead(20);
			}
		}
	}
}
