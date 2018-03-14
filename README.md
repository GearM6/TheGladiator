# TheGladiator
A Robocode robot for Cal Poly's CS141
Robocode Report: Team Gladiator

Robot Design:
We designed our robot to be defensive and to avoid other opponent robots. This was effective when testing against the pre-built bots as they would typically expend their energy early. The problem we ran into with this design however was that it is not remotely aggressive enough. Our maneuvers were designed to avoid direct contact with opponent robots and their bullets and the walls. Our robot works best in a larger environment or battling ground. The robot was inefficient in small battling grounds as when it went through it aversion maneuvers it would move a ridiculous amount of pixels forward or backwards. If we could make any adjustment, we would make it shoot more frequently as this was the reason it did not last long in the battle royale situations. Another adjustment we would make is to alter the amount of movement based on the size of the battling grounds instead, and be more flexible with area in general rather than having hardcoded values of movement in our code and design. 
Our default actions were to have the robot move sporadically across the stage. We preserved some energy by moving the robot more than moving the gun. When we moved in our default patterns the robot would move forward then turn to the right twice 90 degrees and then move backwards if it is not interrupted by other methods or opponent robots. 

Method onScannedRobot()
	We determined which way the robot was facing relative to the opponent robot. If the angle we calculated were to be above 180 degrees we wanted our robot to switch and turn to the Left the calculated number of degrees. If it were below 180 degrees we were to turn to the right instead. After turning to the left or the right based on the calculation, the robot would then be prompted to move forward 50 spaces. After moving forwards towards the direction of this opponent, our robot would fire bullets of strength 2. To reassess the location of the scanned robot, we also called the scan method again at the end of the method. 
 
Method onHitRobot()
We used the getBearing() method to find the angle of the robot that our robot hit. Based on this information we used the method to determine whether it hit our robot from the front or from behind as determined in degrees as (-90 to 90) being forward and everything else being a hit from the back angle. If the opponent robot is determined to be ahead of our robot, the robot will move backwards several spaces and then turn left 90 degrees to avoid further collision with the opponent. If the opponent is towards the rear end of our robot, then the robot will move forward and then turn left 90 degrees to attempt avoiding the opponent.  

Method onHitByBullet()
With this method we attempted to analyze where the bullets came from and based on their direction attempt to avoid the direction of the bullet. Similarly to the onHitRobot() method this method uses the getBearing() to analyze the direction of the bullet relative to the robot. Based on that information our robot will attempt to avoid the previous bullet and move away from the direction it was shot from. To do so it analyzes the side it was shot from(the bullet) and will in turn turnLeft 90 degrees and then move ahead a specified amount. This specified amount will vary by the current round number. It uses the getRoundNum() method to determine which round number is the current round then it will multiply by 4.5, this is then the amount that it will move forward. Or backward based on the situation and the position of the analyzed bullets. 
 
Method onHitWall()
	On the event that this robot hit a wall, we wanted to make sure it creates as much distance as possible. One of the core principles of this robot was to keep it moving and therefore as hard to hit as possible. So once it hit a wall we had to calculate which wall it hit and move it 20 pixels away from whatever wall it hit. We made sure to implement code that would move it away from the wall regardless of which direction it was facing. This was done by determining if it either backed into the wall or ran directly into the wall and then moving in the respective direction.

If people would like to utilize and implement our robot they should follow the following instructions to properly do so. 

How to Implement TheGladiator robot:

Download and install Robocode from this link: https://sourceforge.net/projects/robocode/
Download and extract TheGladiator robot from our GitHub repository:
https://github.com/GearM6/TheGladiator
Navigate a Finder/Explorer window to C:\robocode\robots\
Drag the “TheGladiator” folder from the folder you downloaded from GitHub to the robots folder
From there you will be able to launch a new battle using The Gladiator in battle!

