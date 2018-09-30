package com.internshala.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyMain extends Application
{
	public static void main(String args[])
	{
		 launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}
	private MenuBar createMenu()
	{
		//File Menu
		Menu fileMenu=new Menu("File");
		MenuItem newMenuItem=new MenuItem("New");
		newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("New Menu Item Clicked");
			}
		});

		MenuItem quitMenuItem=new MenuItem("Quit");
		fileMenu.getItems().addAll(newMenuItem,quitMenuItem);
		quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				System.exit(0);
			}
		});

		//Help Menu
		Menu helpMenu=new Menu("Help");
		MenuItem aboutApp=new MenuItem("About");
		helpMenu.getItems().addAll(aboutApp);
		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				aboutApp();
			}
		});

		//Menu Bar
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	public static void aboutApp()
	{
		Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am just a beginner but soon I will become a pro and start developing awesome Java Games");
		alertDialog.show();
	}
}
