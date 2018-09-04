package application; 

import java.lang.Math;
import java.util.ArrayList;

/**
 * This class manages all of the Simon Says Game. It will create a starting sequence, and 
 * check the sequence that the user inputs to check if correct. It will end the game
 * when needed, and keep track of variables such as the amount of turns. 
 * @author Jessica Lee
 */
public class SimonSays{
	private int currentIndex;
	private final int STARTTURNS = 3;
	private ArrayList<String> sequence;
	private final String[] COLORS = {"g", "r", "y", "b"};
	private boolean gameOn; 
	
	/**
	 * This is a constructor to create the SimonSays Object
	 * It sets the currentIndex to zero, creates arrayList for sequence, and sets GameOn to false.
	 */
	public SimonSays(){
		currentIndex = 0;
		sequence = new ArrayList<String>();
		setGameOn(false); 
	}
	
	/**
	 * This mutator method starts the game by generating a random sequence and setting
	 * GameOn to true. 
	 */
	public void start(){
		sequence.clear();
		generateRandomSequence();
		setGameOn(true);
		currentIndex = 0;
	}
	/**
	 * This method generates a random sequence that is as long as the variable STARTTURNS
	 * and will add random colors from g, r, y, and b to the ArrayList. 
	 */
	private void generateRandomSequence(){
		for(int i = 0; i < STARTTURNS; i++){
			sequence.add(randomColor()); 
		}
	}
	/**
	 * This will check to see if the userInput for the color is correct or not
	 * If it is, the game will continue, and if it's the last one in the sequence, 
	 * it will add a new random color to the sequence. If it is wrong, the game will end. 
	 * @param color user input for the color they guess in accordance to the sequence
	 * @return true or false depending on if color is correct or not. 
	 */
	public boolean checkSequence(String color){
		if((sequence.get(currentIndex)).equals(color)){
			if(currentIndex == (sequence.size()-1)){
				addToSequence();
				currentIndex =0;
				return true;
			}
			currentIndex++;
			return true; 
		}
		else{
			endGame();
			return false; 
		}
	}
	/**
	 * This mutator method ends the game. It sets the game to false,
	 * currentIndex back to zero, and the ArrayList will clear.
	 */
	public void endGame(){
		currentIndex = 0;
		sequence.clear();
		setGameOn(false); 
	}
	
	/**
	 * This mutator method will add a random color (r, g, y, b) to the sequence
	 */
	public void addToSequence(){
		sequence.add(randomColor());
	}
	
	/**
	 * This method will return a random color (g, r, y, b)
	 * @return color (g, r, y, b) from the COLORS String array. 
	 */
	private String randomColor(){
		return COLORS[(int) (Math.random()*4)]; 
	}

	/**
	 * This returns the currentIndex
	 * @return currentIndex
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}

	/**
	 * This is a setter method for the currentIndex.
	 * @param currentIndex This keeps track on which color we are checking
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	/**
	 * This is a getter method for the ArrayList
	 * @return sequence ArrayList that contains the sequence of colors. 
	 */
	public ArrayList<String> getSequence() {
		return sequence;
	}
	/**
	 * This sets the sequence to a certain Array of colors. 
	 * @param sequence array of colors
	 */
	public void setSequence(ArrayList<String> sequence) {
		this.sequence = sequence;
	}

	/**
	 * This returns the value of GameOn
	 * @return true or false 
	 */
	public boolean isGameOn() {
		return gameOn;
	}
	
	/**
	 * Sets the gameOn variable to a boolean 
	 * @param gameOn this is a boolean value 
	 */
	public void setGameOn(boolean gameOn) {
		this.gameOn = gameOn;
	}
	
}