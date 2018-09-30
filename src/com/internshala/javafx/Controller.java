package com.internshala.javafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
	public Label welcomeLabel;
	public TextField textField;
	public ChoiceBox choiceBox;
	public Button buttonText;

	boolean isC_TO_F=true;
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{

		buttonText.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				convert();
			}
		});

		final String C_TO_F="Celsius to Fahrenheit";
		final String F_TO_C="Fahrenheit to Celsius";
		choiceBox.getItems().add(C_TO_F);
		choiceBox.getItems().add(F_TO_C);
		choiceBox.setValue(C_TO_F);

		choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				if(newValue.equals(C_TO_F))
					isC_TO_F=true;
				else
					isC_TO_F=false;
			}
		});
	}

	private void convert()
	{
		String input=textField.getText();
		float enteredTemperature = 0.0f;
		try {
			enteredTemperature = Float.parseFloat(input);
		}
		catch (Exception e)
		{
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error Occurred");
			alert.setHeaderText("Invalid Input");
			alert.setContentText("Enter Valid Temperature!");
			alert.show();
			return;
		}
		float newTemperature=0.0f;
		if(isC_TO_F)
		{
			newTemperature=(enteredTemperature*9/5)+32;
		}
		else {
			newTemperature = (enteredTemperature - 32) * 5 / 9;
		}
		display(newTemperature);
	}

	private void display(float newTemperature)
	{
		String unit=isC_TO_F?"F":"C";
		System.out.println("The New Temperature is: "+newTemperature+unit);
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The New Temperature is: "+newTemperature+unit);
		alert.show();
	}
}
