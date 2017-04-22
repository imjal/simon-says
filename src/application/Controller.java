package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * This class links the Java Code and the UI together, from the FXML attributes. 
 * It handles all actions from the user interface, and links them with the 
 * Somon Says Class. 
 * @author Jessica Lee
 * @author Shannon Park
 * @author Robert Lou
 * @author Amy Liu
 *
 */
public class Controller implements Initializable{
	//create Simon Says Object
	SimonSays ss = new SimonSays();
	//creates ArrayList from SimonSays object
	ArrayList<String> sequence = ss.getSequence();
	
	
    @FXML
    private Rectangle greenBtn;

    @FXML
    private Rectangle redBtn;

    @FXML
    private Rectangle yellowbtn;

    @FXML
    private Rectangle blueBtn;

    @FXML
    private Button startBtn;
    
    @FXML
    private Button instructBtn;
    
    /**
     *This method handles button actions from the Start and Instructions Button. 
     *STart button will start the game, and instructions will bring up an alert 
     *that informs you on how to play the game
     * @param e any button press will trigger this event
     */
    @FXML
    private void handleButtonAction(ActionEvent e) {
    	if(e.getSource() == startBtn){
    		ss.start();
    		for(String help: ss.getSequence()){
    			System.out.println(help);
    		}
    		displayColors(ss.getSequence());
    	}
    	if(e.getSource()== instructBtn){
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Simon Says Game Alert");
    		alert.setHeaderText("How to Play Simon Says");
    		alert.setContentText("Click the Start Button, and certain pieces will light up. Click in the sequence they light up,"
    				+ "and the game will continue until you make a mistake.");
    		alert.show();
    	}
    }
    /**
     *  This method will process the user clicks in relations to the colors,
     *  and check if they are correct according to the sequence. If not, it
     *  will alert the user the game is over.
     * @param e Button Click from User
     */
    @FXML
    private void userInput(MouseEvent e){
    	if(ss.isGameOn()){	
    		if(e.getSource()==greenBtn){
    			if(!ss.checkSequence("g")){
    				alertGameOver();
    			}
    		}
    		if(e.getSource()==redBtn){
	    		if(!ss.checkSequence("r")){
	    			alertGameOver();
	    		}
	    	}
    		if(e.getSource()==yellowbtn){
    			if(!ss.checkSequence("y")){
    				alertGameOver();
    			}
    		}
    		if(e.getSource()==blueBtn){
    			if(!ss.checkSequence("b")){
    				alertGameOver();
    			}
    		}
    		if(ss.getIndex() == 0){
    			displayColors(ss.getSequence());
    		}
    		
    	}
    	else{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Simon Says Game Alert");
    		alert.setHeaderText("Please Click Start Button");
    		alert.setContentText("Please click on the button to the right of the screen labeled Start to start the Game.");
    		alert.show();

    	}
    }
    

    /**
     * This method alerts the user that the game is over. 
     */
    private void alertGameOver(){
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Simon Says Game Alert");
		alert.setHeaderText("Game Over");
		alert.setContentText("Please click on the button to the right of the screen labeled Start to start another Game.");
		alert.show();
    }
    
    /**
     * This displays the colors as flashes of white to signal the sequence
     * @param sequence the color sequence that is randomized from the SimonSays object. Only takes strings g, r, y, and b. 
     */
    public void displayColors(ArrayList<String> sequence){
    	SequentialTransition s = new SequentialTransition();
    	s.setCycleCount(1);
    	s.setAutoReverse(false);
    	for(int i = 0; i < sequence.size(); i++){
    		switch(sequence.get(i)){
    		case "g":
    		   FadeTransition greenft = new FadeTransition(Duration.millis(300), greenBtn);
    			greenft.setAutoReverse(true);
    			greenft.setFromValue(1.0);
    			greenft.setToValue(0.1);
    			greenft.setCycleCount(2);
    			s.getChildren().add(greenft);
    			break;
    		case "r":
    		    FadeTransition redft = new FadeTransition(Duration.millis(300), redBtn);
    			redft.setAutoReverse(true);
    			redft.setFromValue(1.0);
    			redft.setToValue(0.1);
    			redft.setCycleCount(2);
    			s.getChildren().add(redft);
    			break;
    		case "y":
    		    FadeTransition yellowft = new FadeTransition(Duration.millis(300), yellowbtn);
    			yellowft.setAutoReverse(true);
    			yellowft.setFromValue(1.0);
    			yellowft.setToValue(0.1);
    			yellowft.setCycleCount(2);
    			s.getChildren().add(yellowft);

    			break;
    		case "b":
    		    FadeTransition blueft = new FadeTransition(Duration.millis(300), blueBtn);
    			blueft.setAutoReverse(true);
    			blueft.setFromValue(1.0);
    			blueft.setToValue(0.1);
    			blueft.setCycleCount(2);
    			s.getChildren().add(blueft);
    			break;
    		}
    	}
    	s.play();
    }
    /**
     * Method to initialize the FXML attributes.
     */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	

}
