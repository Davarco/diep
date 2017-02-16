import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public abstract class GameObject implements MovingObject{
	protected String imagePath;
	protected double speed;
	protected double direction;
	protected double rotation,
			x, y,
			size,
			health;
	protected Image img;

<<<<<<< HEAD
public abstract class GameObject implements MovingObject{
	private String imagePath;
	private double speed;// 0 - 10
	private double direction, // degrees or radians
		x, y, // >= 0
		size, // 10 might be a good size   
		health; // 0 - 100
	 private Image img;

	public GameObject(double speed,double direction,double size,double health){
=======
    protected Dimension screenDim;

	public GameObject(double speed, double direction, double size, double health, Dimension dim){
>>>>>>> origin/Andrew
		this.speed = speed;
		this.direction = direction;
		this.size = size;
		this.health = health;
        screenDim = dim;
		setImagePath();
		openImage();
	}

	public abstract void setImagePath();

	@Override
	public void move() {
        x += speed*Math.cos(Math.toRadians(direction));
		y += speed*Math.sin(Math.toRadians(direction));

		checkOffScreen();
	}

	public ArrayList<Double> getPos(){
		ArrayList<Double> l = new ArrayList<>();
		l.add(x);
		l.add(y);
		return l;
	}

	public void openImage(){
		try {
			URL cardImgURL = getClass().getResource(imagePath);
			if (cardImgURL != null) {
				setImage(ImageIO.read(cardImgURL));
			}
		} catch (IOException e) {
			System.err.println("Could not open image ( " + imagePath+ " )");
			e.printStackTrace();
		}
	}
	
	public int getX(){
		return (int) Math.round(x);
	}
	public int getY(){
		return (int) Math.round(y);
	}

	private void setImage(BufferedImage read) {
		img = read;
	}
	
	public int getSize(){
		return (int) size;
	}

	public Image getImage(){
		return img;
	}
<<<<<<< HEAD

	public abstract void checkOffScreen();
=======
	

	public void checkOffScreen() {
        if (x < 0.0) x = 0.0;
        if (y < 0.0) y = 0.0;
        if (x > screenDim.getWidth() - size) x = screenDim.getWidth() - size;
        if (y > screenDim.getHeight() - size) y = screenDim.getHeight() - size;
    }
>>>>>>> origin/Andrew

	@Override
	public Rectangle getBoundingRect() {
		return new Rectangle((int)x,(int)y,(int)size,(int)size);
	}
<<<<<<< HEAD
}
=======

    public void setDirection(int dir) {
        direction = (dir) * 90;
    }

    public void setRotation(double rot){
    	
    	rotation = rot;
    }
   
    public void setDirection(double dir) {
		direction = dir;
	}

	public void hit(Bullet obj) {
		//if ((int) obj.direction/4 == (int) this.direction/4 && ((int) x == (int) obj.x || (int) y == (int) obj.y)) {
            health -= obj.damage;
        if (health <= 0 && this.getClass().equals(Tank.class)) {
            endGame();
        }
        //}
	}

	public void endGame() {
        JOptionPane.showMessageDialog(null, "You lost!");
        System.exit(0);
    }
}
>>>>>>> origin/Andrew
