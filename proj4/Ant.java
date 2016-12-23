/**
 * This class contains all the basic instance variables and methods required for an ant.
 * @author Aaiz Ahmed <aaiza2@umbc.edu>
 * @version Nov 14, 2013
 * @project CMSC 202 - Fall 2013 - Project #4
 * @section 06
 */
package proj4;

public class Ant {

	private int life;
	private String desc;
    private int foodCost;
    
	public Ant (int life, int foodCost, String desc) {

		this.life = life;
		this.foodCost = foodCost;
		this.desc = desc;
	}
	
	
	/**
	 * This method returns the foodCost that a type of ant has.
	 * @return
	 */
	public int getfoodCost () {
		return foodCost;
	}
	
	/**
	 * This methods gives full life to the ant after an invasion.
	 */
	 public void setNewLife() {
		 setLife(life);
	 }
	 
	/**
	 * This method set the life of the ant.
	 * @param i
	 */
	 public void setLife (int i) {
		life = i; 
	 }
	 
	/**
	 * This methods returns the number of lives
	 * @return life
	 */
	public int getLife() {
		return life;
	}
	
	/**
	 * This method returns the type of an ant.
	 * @return desc
	 */
	public String getDesc () {

		return desc;
	}	
	
/**
 * This method is used by different types of ants to attack in their specific style.
 * @param game
 */
public void attack(Game game) { } 

/**
 * This method calculates the result of the fight and updates the life. 
 * @param amount
 */
 public void takeDamage(int amount) {
	
		if (life - amount > 0) {
		    life -= amount;
		}
		else 
			life = 0;
		
	    }
 
/**
 * This method is used by sub classes of ants to use it for taking damage specifically. 	    
 * @param i
 * @param zombie
 */
public void takeDamage(int i, Zombie zombie) { }


// main method for unit testing.

public static void main (String[] args) {
	
	Ant a = new Ant(10, 10, "Testing Ant");
	System.out.println(a.desc);
	
	a.takeDamage(5);
	System.out.println(a.getLife());
	Game g = new Game();
	Zombie z = Zombie.makeZombie('A');
	z.attack(g);
	
	System.out.println (a.getLife());
}

}
