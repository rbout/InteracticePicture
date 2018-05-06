// Author			Robert Boutillier
// Date created		5/3/18
// Date updated		5/3/18
// Version			1.0
// All Rights Reserved©
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.css.*;
import javafx.scene.paint.*;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import java.util.*;


public class Main extends Application{
	private Text pleaseChooseColorText = new Text("Please Choose a color:");
	private Text creamText = new Text("C = Cream");
	private Text mistyGreenText = new Text("G = Misty Green");
	private Text lightBrownText = new Text("B = Light Brown");
	private Text creatorNameText = new Text("Created by Robert Boutillier");
	private Text instructionText = new Text("First click to place the Momma Duck, following clicks will place the baby ducks.");
	private Text secondInstructionText = new Text("Use the left and right arrow keys to move the ducks");
	private int sceneLength = 600;
	private int sceneHeight = 450;
	private Color backgroundColor;
	private Rectangle parkBackground = new Rectangle(sceneLength, sceneHeight);
	private Ellipse parkPond = new Ellipse(300, 325, 200, 100);
	private Ellipse mommaDuckBody = new Ellipse();
	private Circle mommaDuckHead = new Circle();
	private Arc mommaDuckBill = new Arc();
	private Circle mommaDuckWhiteEye = new Circle();
	private Circle mommaDuckBlackEye = new Circle();
	private Scene parkScene;
	private Color invisibleColor = new Color(1,1,1,0);
	private int clickCount = 0;
	private ArrayList<BabyDuck> babyDucks = new ArrayList<BabyDuck>();
	
	public void start(Stage stage) {
		parkPond.setFill(Color.BLUE);
		mommaDuckBody.setRadiusX(75);
		mommaDuckBody.setRadiusY(50);
		mommaDuckBody.setFill(invisibleColor);
		mommaDuckHead.setRadius(32);
		mommaDuckHead.setFill(invisibleColor);
		mommaDuckBill.setRadiusX(25);
		mommaDuckBill.setRadiusY(25);
		mommaDuckBill.setStartAngle(160);
		mommaDuckBill.setLength(35);
		mommaDuckBill.setType(ArcType.ROUND);
		mommaDuckBill.setFill(invisibleColor);
		mommaDuckWhiteEye.setRadius(10);
		mommaDuckWhiteEye.setFill(invisibleColor);
		mommaDuckBlackEye.setRadius(5);
		mommaDuckBlackEye.setFill(invisibleColor);
		
		creatorNameText.setX(425);
		creatorNameText.setY(440);
		
		instructionText.setX(15);
		instructionText.setY(15);
		secondInstructionText.setX(15);
		secondInstructionText.setY(30);
		
		Pane parkPane = new Pane();
		
		Scene startScene = new Scene(getStartPane(), sceneLength, sceneHeight);
		parkPane.getChildren().addAll(parkBackground, creatorNameText, instructionText, secondInstructionText, parkPond, mommaDuckBill, mommaDuckHead, mommaDuckWhiteEye, mommaDuckBlackEye, mommaDuckBody);
		
		startScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				String keyCode = event.getCode().toString();;
				if(keyCode.equals("C")) {
					backgroundColor = new Color(1, 0.87, 0.68, 1);
					parkScene = new Scene(parkPane, sceneLength, sceneHeight);
					parkBackground.setFill(backgroundColor);
					stage.setScene(parkScene);
					stage.show();
				}
				else if(keyCode.equals("G")) {
					backgroundColor = new Color(0.596, 0.98, 0.596, 1);
					parkScene = new Scene(parkPane, sceneLength, sceneHeight);
					parkBackground.setFill(backgroundColor);
					stage.setScene(parkScene);
					stage.show();
				}
				else if(keyCode.equals("B")) {
					backgroundColor = Color.BROWN;
					parkScene = new Scene(parkPane, sceneLength, sceneHeight);
					parkBackground.setFill(backgroundColor);
					stage.setScene(parkScene);
					stage.show();
				}
				
				parkScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						if(clickCount == 0) {
							setMommaDuckXY(event.getX(), event.getY());
							clickCount++;
						}
						else {
							BabyDuck babyDuck = new BabyDuck(event.getX(), event.getY());
							babyDucks.add(babyDuck);
							parkPane.getChildren().addAll(babyDuck.getBabyDuckBill(), babyDuck.getBabyDuckHead(), babyDuck.getBabyDuckWhiteEye(), babyDuck.getBabyDuckBlackEye(),
									babyDuck.getBabyDuckBody());
						}
					}
				});
				
				parkScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
					public void handle(KeyEvent event) {
						String keyCode = event.getCode().toString();
						if(keyCode.equals("LEFT")) {
							setMommaDuckXY(mommaDuckBody.getCenterX() - 8, mommaDuckBody.getCenterY());
							for(BabyDuck babyDuck : babyDucks) {
								babyDuck.setBabyDuckXY(babyDuck.getBabyDuckBody().getCenterX() - 8, babyDuck.getBabyDuckBody().getCenterY());
							}
						}
						if(keyCode.equals("RIGHT")) {
							setMommaDuckXY(mommaDuckBody.getCenterX() + 8, mommaDuckBody.getCenterY());
							for(BabyDuck babyDuck : babyDucks) {
								babyDuck.setBabyDuckXY(babyDuck.getBabyDuckBody().getCenterX() + 8, babyDuck.getBabyDuckBody().getCenterY());
							}
						}
					}
				});
			}
		});
		
		stage.getIcons().add(new Image("file:duck.png"));
		stage.setTitle("Ducks!");
		stage.setScene(startScene);
		stage.show();
	}
	
	public static void main(String[] args) {
		System.out.print("Program running...");
		launch(args);
		System.out.print("Program finished");
	}
	
	public Pane getStartPane() {
		VBox startSceneVbox = new VBox(8);
		startSceneVbox.getChildren().addAll(pleaseChooseColorText, creamText, mistyGreenText, lightBrownText);
		Pane startScenePane = new Pane();
		startScenePane.getChildren().addAll(startSceneVbox);
		startSceneVbox.setLayoutX(225);
		startSceneVbox.setLayoutY(50);
		return startScenePane;
	}
	
	public void setMommaDuckXY(double x, double y) {
		mommaDuckBody.setCenterX(x);
		mommaDuckBody.setCenterY(y);
		mommaDuckBody.setFill(Color.YELLOW);
		mommaDuckHead.setCenterX(x - 50);
		mommaDuckHead.setCenterY(y - 50);
		mommaDuckHead.setFill(Color.YELLOW);
		mommaDuckBill.setCenterX(mommaDuckHead.getCenterX() - 20);
		mommaDuckBill.setCenterY(mommaDuckHead.getCenterY());
		mommaDuckBill.setFill(Color.ORANGE);
		mommaDuckWhiteEye.setCenterX(mommaDuckHead.getCenterX() - 12);
		mommaDuckWhiteEye.setCenterY(mommaDuckHead.getCenterY());
		mommaDuckWhiteEye.setFill(Color.WHITE);
		mommaDuckBlackEye.setCenterX(mommaDuckWhiteEye.getCenterX() - 2);
		mommaDuckBlackEye.setCenterY(mommaDuckWhiteEye.getCenterY());
		mommaDuckBlackEye.setFill(Color.BLACK);
	}
}
