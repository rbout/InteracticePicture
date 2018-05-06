import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;

public class BabyDuck {
	private double centerX;
	private double centerY;
	private Ellipse babyDuckBody;
	private Circle babyDuckHead;
	private Arc babyDuckBill;
	private Circle babyDuckWhiteEye;
	private Circle babyDuckBlackEye;
	
	public BabyDuck(double x, double y) {
		babyDuckBody = new Ellipse();
		babyDuckHead = new Circle();
		babyDuckBill = new Arc();
		babyDuckWhiteEye = new Circle();
		babyDuckBlackEye = new Circle();
		babyDuckBody.setRadiusX(38);
		babyDuckBody.setRadiusY(20);
		babyDuckHead.setRadius(15);
		babyDuckBill.setRadiusX(20);
		babyDuckBill.setRadiusY(14);
		babyDuckBill.setStartAngle(160);
		babyDuckBill.setLength(35);
		babyDuckBill.setType(ArcType.ROUND);
		babyDuckBody.setFill(Color.YELLOW);
		babyDuckHead.setFill(Color.YELLOW);
		babyDuckBill.setFill(Color.ORANGE);
		
		babyDuckWhiteEye.setRadius(8);
		babyDuckBlackEye.setRadius(4);
		babyDuckWhiteEye.setFill(Color.WHITE);
		babyDuckBlackEye.setFill(Color.BLACK);
		
		babyDuckBody.setCenterX(x);
		babyDuckBody.setCenterY(y);
		babyDuckHead.setCenterX(x - 25);
		babyDuckHead.setCenterY(y - 23);
		babyDuckBill.setCenterX(babyDuckHead.getCenterX());
		babyDuckBill.setCenterY(babyDuckHead.getCenterY());
		babyDuckWhiteEye.setCenterX(babyDuckHead.getCenterX() - 5);
		babyDuckWhiteEye.setCenterY(babyDuckHead.getCenterY());
		babyDuckBlackEye.setCenterX(babyDuckWhiteEye.getCenterX() - 2);
		babyDuckBlackEye.setCenterY(babyDuckWhiteEye.getCenterY());
	}
	
	public Ellipse getBabyDuckBody() {
		return babyDuckBody;
	}
	
	public Circle getBabyDuckHead() {
		return babyDuckHead;
	}
	
	public Arc getBabyDuckBill() {
		return babyDuckBill;
	}
	
	public Circle getBabyDuckWhiteEye() {
		return babyDuckWhiteEye;
	}
	
	public Circle getBabyDuckBlackEye() {
		return babyDuckBlackEye;
	}
	
	public void setBabyDuckXY(double x, double y) {
		babyDuckBody.setCenterX(x);
		babyDuckBody.setCenterY(y);
		babyDuckHead.setCenterX(x - 25);
		babyDuckHead.setCenterY(y - 23);
		babyDuckBill.setCenterX(babyDuckHead.getCenterX());
		babyDuckBill.setCenterY(babyDuckHead.getCenterY());
		babyDuckWhiteEye.setCenterX(babyDuckHead.getCenterX() - 5);
		babyDuckWhiteEye.setCenterY(babyDuckHead.getCenterY());
		babyDuckBlackEye.setCenterX(babyDuckWhiteEye.getCenterX() - 2);
		babyDuckBlackEye.setCenterY(babyDuckWhiteEye.getCenterY());
	}
}
