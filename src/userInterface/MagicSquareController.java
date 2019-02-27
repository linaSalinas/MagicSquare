package userInterface;

import javafx.fxml.FXML;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.MagicSquare;
import exception.NotOddNumberException;
public class MagicSquareController {

	@FXML
	private TextField txtOrder;

	@FXML
	private ComboBox<String> combLocation;

	@FXML
	private GridPane gridPane;

	@FXML
	private ComboBox<String> combDirection;

	@FXML
	private Button txtMScreate;

	@FXML
	private BorderPane borderContainer;

	private Label matrixInicial[][];

	private MagicSquare magicS;

	@FXML
	public void initialize() {
		magicS = new MagicSquare(); 

	}
//____________________________________________________________________________________________________________________________________
	
	@FXML
	public void createMatrix(ActionEvent createMatrix) {

		int order = 0;

		try {
			order =	Integer.parseInt(txtOrder.getText());

			if(order % 2 == 0 ) {

				throw new NotOddNumberException(order);
			}
		}

		catch(NumberFormatException numberException) {

			System.err.println("Message the exception :"+numberException.getMessage());

		}catch(NotOddNumberException oddException) {
			System.err.println("Message the excepcion :"+oddException.getMessage());
			
		
		}

			
		magicS.setOrder(order);
		directionMatrix();

		if(matrixInicial != null) {
			clearMatrix();
		}

		matrixInicial = new Label[order][order];


		for (int i = 0; i < matrixInicial.length; i++) {

			for (int j = 0; j < matrixInicial[i].length; j++) {

				matrixInicial[i][j] = new Label(String.valueOf(magicS.getMatrix()[i][j]));
				gridPane.setAlignment(Pos.CENTER);
				gridPane.setVgap(10);
				gridPane.setHgap(10);
				gridPane.add(matrixInicial[i][j], j, i);

			}
		}
	}
//___________________________________________________________________________________________________________________________
	
	public void clearMatrix(){

		for (int i = 0; i < matrixInicial.length; i++) {

			for (int j = 0; j < matrixInicial[i].length; j++) {
				if(matrixInicial[i][j] != null) {
					matrixInicial[i][j].setText("");
				}

			}
		}

	}

	//_______________________________________________________________________________________________________________________
	
	public void directionMatrix() {

		String location = combLocation.getSelectionModel().getSelectedItem();
		String direction = combDirection.getSelectionModel().getSelectedItem();

		try {

			if (location.equals("Upper Central") && direction.equalsIgnoreCase(MagicSquare.N_O)) {
				magicS.fillMatrix(MagicSquare.N_O, MagicSquare.UPPER_CENTRAL);
			} 
			else if (location.equals("Upper Central") && direction.equalsIgnoreCase(MagicSquare.S_O)) {
				magicS.fillMatrix(MagicSquare.S_O, MagicSquare.UPPER_CENTRAL);
			}

			if (location.equals("Left Central Right") && direction.equalsIgnoreCase(MagicSquare.N_E)) {
				magicS.fillMatrix(MagicSquare.N_E, MagicSquare.CENTRAL_RIGHT);
			} 
			else if (location.equals("Left Central Right") && direction.equalsIgnoreCase(MagicSquare.S_E)) {
				magicS.fillMatrix(MagicSquare.S_E, MagicSquare.CENTRAL_RIGHT);
			}
			if (location.equals("Left Central Side") && direction.equalsIgnoreCase(MagicSquare.N_O)) {
				magicS.fillMatrix(MagicSquare.N_O, MagicSquare.CENTRAL_SIDE);
			} 
			else if (location.equals("Left Central Side") && direction.equalsIgnoreCase(MagicSquare.S_O)) {
				magicS.fillMatrix(MagicSquare.S_O, MagicSquare.CENTRAL_SIDE);
			}

			if (location.equals("Lower Central") && direction.equalsIgnoreCase(MagicSquare.S_O)) {
				magicS.fillMatrix(MagicSquare.S_O, MagicSquare.LOWER_CENTRAL);
			}
			else if (location.equals("Lower Central") && direction.equalsIgnoreCase(MagicSquare.S_E)) {
				magicS.fillMatrix(MagicSquare.S_E, MagicSquare.LOWER_CENTRAL);
			}
//_______________________________________________________________________________________________________________________________________
		}
		
		catch(NullPointerException nullPointer) {
			System.err.println(nullPointer.getMessage());
		}
	}

}
