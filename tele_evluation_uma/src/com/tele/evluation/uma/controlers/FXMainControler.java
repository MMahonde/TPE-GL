/**
 * 
 */
package com.tele.evluation.uma.controlers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author -
 *
 */
public class FXMainControler implements Initializable{
	@FXML
	public Button btnConnexion;
	

	/**
	 * 
	 */
	public FXMainControler() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	protected void ActionConnexionButton(ActionEvent e) throws IOException {
		Stage myStage;
		Parent root;
		if(e.getSource() == (btnConnexion)) {
			myStage = (Stage) btnConnexion.getScene().getWindow();
			myStage.setMinHeight(720);
			myStage.setMinWidth(1200);
			myStage.setResizable(true);
			myStage.centerOnScreen();
			root = FXMLLoader.load(getClass().getResource("/resources/fxml/Epreuve.fxml"));
			Scene scene = new Scene(root);
			myStage.setScene(scene);
			
			System.out.println("bon");
		}
		System.out.println("ok");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
