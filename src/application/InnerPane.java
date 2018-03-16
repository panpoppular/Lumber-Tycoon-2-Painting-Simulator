package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Random;


public class InnerPane extends VBox{
	
	private Canvas canvas;
	private Button generateButton;
	private Button credits;
	private GraphicsContext gc;
	
	public InnerPane() {
		canvas = new Canvas(500,500);
		generateButton = new Button("Generate Painting!");
		credits = new Button("Credit");
		gc = canvas.getGraphicsContext2D();
		this.getChildren().add(canvas);
		this.getChildren().add(generateButton);
		this.getChildren().add(credits);
		this.setWidth(500);
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		addEvent();
	}
	
	private void drawCommand() {
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		drawARandomRect();
		drawARandomRect();
		drawARandomRect();
	}
	
	private void drawARandomRect() {
		Random rand = new Random();
		
		int x = rand.nextInt(400);
		int y = rand.nextInt(400);
		int w = rand.nextInt(400-x)+100;
		int h = rand.nextInt(400-y)+100;
		gc.setFill(new Color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(),1));
		gc.fillRect(x, y, w, h);
	}
	
	private void addEvent() {
		generateButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				drawCommand();		
			}
		});
		
		credits.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Credits");
				alert.setHeaderText("Lumber Tycoon 2 \"06 In Full Context\" simulator ");
				alert.setContentText("Made by: Panpoppular");

				alert.showAndWait();
			}
		});
	}

}
