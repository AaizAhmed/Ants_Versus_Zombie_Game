/**
 * This is the Game.java file posted in the Project4 project
 * description. It contains only the nextFight method. Students
 * must complete the remainder of the Game methods and add the
 * Game instance variables.
 */
/**
 * This class contains data to play the game of Ant vs Zombies.
 * @author Aaiz Ahmed <aaiza2@umbc.edu>
 * @version Nov 14, 2013
 * @project CMSC 202 - Fall 2013 - Project #4
 * @section 06
 */
package proj4;

import java.util.Vector;
import java.io.*;

public class Game implements GameInterface {

	private boolean gameOver;
	private int food, round = 1, armyCount;
	private String zombieString;
	private Vector<Zombie> horde; 
	private Vector <Ant> colony ;

	/**
	 * Constructor for the game class. It instantiates instance variables. 
	 */
	public Game () {

		horde = new Vector <Zombie>();
		colony = new Vector<Ant>();

		gameOver = false;
		food = 100;

	}

	/**
	 * Determine if the invasion is over. If the invasion is over, all
	 * remaining ants' health reset to full life.
	 * @return true if there are no ants or no zombies remaining.
	 */
	public void nextFight() {
		if (colony.size() > 0) {
			Ant a = colony.elementAt(0);
			a.attack(this);

			Zombie z = horde.elementAt(0);
			if ((a instanceof LeafcutterAnt) && (z.getLife() <= 0)) {
				// leafcutters have first strike, so opposing zombie gets no attack
			}
			else {
				z.attack(this);
			}

			// reap all things dead
			boolean keepReaping = true;
			while (keepReaping) {
				keepReaping = false;
				for (int i = 0; i < colony.size(); ) {
					a = colony.elementAt(i);
					if (a.getLife() > 0) {
						i++;
					}
					else {
						colony.remove(i);
						if (a instanceof CitronellaAnt) {
							for (Ant a2 : colony) {
								a2.takeDamage(2);
							}
							for (Zombie z2: horde) {
								z2.takeDamage(2);
							}
						}
						keepReaping = true;
					}
				}

				for (int i = 0; i < horde.size(); ) {
					z = horde.elementAt(i);
					if (z.getLife() > 0) {
						i++;
					}
					else {
						horde.remove(i);
						food += z.getReward();
					}
				}
			}
			if (colony.size() == 0 && horde.size() > 0) {
				gameOver = true;
			}	
		}
	}

	/**
	 * This method returns the colony of ants.
	 * @return colony
	 */
	public Vector<Ant> getColony() {

		return colony;
	}

	/**
	 * This method returns the horde of zombies. 
	 * @return horde
	 */
	public Vector<Zombie> getHorde() {

		return horde;
	}

	/**
	 * This method tells which round is it.
	 * @return round
	 */
	public int getRoundNumber() {

		return round;
	}

	/**
	 * This method changes the amount of the food and set a new value.
	 * @param i
	 */
	public void setFood (int i) {

		food += i;
	}

	/**
	 * This method returns the food that is available
	 * @return food
	 */
	public int getFood() {

		return food;
	}

	/**
	 * This method return the total number of army ants recruited in the game.
	 * @return armyCount
	 */
	public int getArmyCount () {

		return armyCount;
	}

	/**
	 * This method returns a string that shows the ants in the player's colony.
	 * @return ants in the colony
	 */
	public String getColonyDesc() {

		String str = "";

		for (int i = 0; i < colony.size(); i ++) {
			Ant a = colony.elementAt(i);
			str += a.getDesc() + " - remaining life: " + a.getLife() + "\n";
		}
		return str;
	}

	/**
	 * This method returns a string that shows the zombies in the horde. 
	 * @return zombies in the horde 
	 */
	public String getHordeDesc() {

		String str = "";
		for (int i = 0; i < horde.size(); i ++) {
			Zombie z = horde.elementAt(i);
			str += z.getDesc() + " - remaining life: " + z.getLife() + "\n";
		}
		return str;
	}

	/**
	 * This method checks what is the type of an ant and then returns a character associated with that ant.
	 * @param antType
	 * @return char representing an ant. 
	 */
	public char getType (String antType) {

		// Comparing the strings and then returning a char
		if (antType.equals("Army Ant"))			    return 'A';  
		if (antType.equals("Bullet Ant")) 			return 'B';
		if (antType.equals("Carpenter Ant"))	    return 'C';  
		if (antType.equals("Citronella Ant")) 		return 'D';
		if (antType.equals("Fire Ant"))			    return 'F';       
		if (antType.equals("Leafcutter Ant"))       return 'L';
		if (antType.equals("Pharaoh Ant"))          return 'P';    
		if (antType.equals("Sugar Ant"))            return 'S';
		if (antType.equals("Thief Ant"))            return 'T';       
		if (antType.equals("Weaver Ant"))           return 'W';

		else {
			return 0; 
		}  

	}

	/**
	 * This method tells if the player can recruit an ant or not. If it can ant is added in the colony.
	 * @return true or false
	 */
	public boolean recruitAnt(String antType) {

		char c = getType(antType);
		Ant a = null;

		//Instantiating an ant so that it can be added in the colony if food is available. 
		switch (c) {
		case 'A': a = new ArmyAnt();         break;	    		 	
		case 'B': a = new BulletAnt();       break;
		case 'C': a = new CarpenterAnt();    break;
		case 'D': a = new CitronellaAnt();   break;
		case 'F': a = new FireAnt();         break;
		case 'L': a = new LeafcutterAnt();   break;
		case 'P': a = new PharaohAnt();      break;
		case 'S': a = new SugarAnt();        break;
		case 'T': a = new ThiefAnt();        break;
		case 'W': a = new WeaverAnt();       break;
		default:
		}

		int cost = getAntCost(antType);

		//Checking if food is enough to recruit/add the ant.
		if ( food - cost > 0  || food == cost) {

			colony.add(a);
			removeFood(cost);

			//Checking if the recruited ant is an Army Ant, if so incrementing the armyCount variable.
			if (a instanceof ArmyAnt) {
				armyCount++;
			}
			return true;
		}		
		return false;
	}

	/**
	 * This method return the types of the ants.
	 * @return array of string containing all the types of the ants.
	 */
	public String[] getAntTypes() {

		String [] str = new String[10];

		//Assigning types of ants to the string array.
		str[0] = "Army Ant";   str[1] = "Bullet Ant";          str[2] = "Carpenter Ant";        str[3] = "Citronella Ant"; 
		str[4] = "Fire Ant";   str[5] = "Leafcutter Ant";      str[6] = "Pharaoh Ant";          str[7] = "Sugar Ant"; 
		str[8] = "Thief Ant";  str[9] = "Weaver Ant"; 

		return str;
	}

	/**
	 * This method checks the ant type and returns what is the food cost to recruit that ant.
	 * @return foodCost
	 */
	public int getAntCost(String antType) {

		//Comparing string and returning the food cost of an ant type.
		if (antType.equals("Army Ant"))			    return 35;  
		if (antType.equals("Bullet Ant")) 			return 10;
		if (antType.equals("Carpenter Ant"))	    return 10;  
		if (antType.equals("Citronella Ant")) 		return 25;
		if (antType.equals("Fire Ant"))			    return 15;       
		if (antType.equals("Leafcutter Ant"))       return 20;
		if (antType.equals("Pharaoh Ant"))          return 15;    
		if (antType.equals("Sugar Ant"))            return 20;
		if (antType.equals("Thief Ant"))            return 15;       
		if (antType.equals("Weaver Ant"))           return 20;

		else {
			return 0;
		}
	}


	/**
	 * This method reads the file and make zombies. 
	 */
	public void readHordeFile(String filename) {

		//Dealing with exception by try and catch block.
		try {
			FileReader file = new FileReader(filename);
			BufferedReader buf = new BufferedReader(file);
			zombieString = buf.readLine();
		}
		catch(IOException e) {
			System.out.println ("Input problem, File not found");
		} 

		char[] c = new char[zombieString.length()];

		//Parsing the zombieString
		for (int i = 0; i < zombieString.length(); i++ ) {

			int value, b = 0;			
			c[i] = zombieString.charAt(i);	

			//Checking if the char is a digit. Only 1,2 and 9 are used in the horde data files. 
			if (c[i] == '1' || c[i] == '2' || c[i] == '9') {

				//Getting the numerical value of the char and storing it in value.
				value = Character.getNumericValue(c[i]);

				//If char is a number, this loop will add the last zombie type equals to the numeric value of the current char
				while (b < value) {
					horde.add(Zombie.makeZombie (c[i-1]));
					b++;
				}
			}

			else {
				horde.add(Zombie.makeZombie (c[i]));
			}

		}

	} 

	/**
	 * This methods checks if the invasion is over or not.
	 * @return true if it's over false otherwise.
	 */
	public boolean isInvasionOver() {

		if (colony.size() == 0 || horde.size() == 0) {

			for (Ant a : colony) {

			// Giving full life to every ant that survived the invasion
				a.setNewLife();				
			}

			round ++;
			return true;			
		}

		return false;
	}

	/**
	 * This method returns the state of game, is game over or not.
	 * @return true if game is over or false otherwise.
	 */
	public boolean isGameOver() {

		if (colony.isEmpty() == true && horde.size() > 0) {

			return true;
		} 

		if (round == 6) {

			return true;
		}

		return false;
	}

	/**
	 * This method returns a string if game ends, and displays the appropriate text.
	 * @return str 
	 */
	public String getEndingMessage() {
		String str = "";

		//Checking if game is over and if player won or lost and printing appropriate message.		
		if (isGameOver() == true && colony.isEmpty() == true) {
			str += "Game Over";
		}
		else {

			if (isGameOver() == true && colony.isEmpty() == false) {
				str += "You Won! Final Score: " + food;
			}
		}

		return str;
	}

	/**
	 * This method removes the food.
	 * @param i
	 */
	public void removeFood(int i) {

		if (food - i > 0) {
			food -= i;
		} 
		else {
			if (food == i)
				food = 0;
		}
	}

	// main method for unit testing.

	public static void main (String[] args) {

		Game g = new Game();
		g.removeFood(30);

		System.out.println(g.getFood());
	}

}
