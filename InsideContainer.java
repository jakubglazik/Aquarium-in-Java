import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.*;

public class InsideContainer extends JPanel implements ActionListener {

	private static InsideContainer aquarium;
	public BufferedImage background;
	public Vector<Fish> fish_collection = new Vector<Fish>();	//vector that store fishes
	Timer timer;

	public static InsideContainer getInsideContainer() {		//public method to get access to constructor
		if (aquarium == null) {
			aquarium = new InsideContainer();
		}
		return aquarium;
	}

	private InsideContainer(){
		try {
            background = ImageIO.read(new File("img/sea2.png"));		//load background image form file and setting frame size as background image size
			this.setPreferredSize(new Dimension(background.getWidth(),background.getHeight()));
            System.out.println("Zdjęcie zostało wczytane pomyślnie.");
			timer = new Timer(30, this);		//creating new Timer object to make infitine loop
			timer.start();
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania zdjęcia: " + e.getMessage());		//error if background image can't load
        }
	}

	public void paint(Graphics g) {			// method that will paint our background and every fish in vector when it's called
		super.paint(g);	
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.drawImage(background, 0, 0, null);
		for (Fish fish : fish_collection) {
			g2D.drawImage(fish.getCurrImage(), fish.getX(), fish.getY(), null);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {			//override method of actionListener which will perform with Timer object (every 20ms)
		for (Fish fish : fish_collection) {					//making moves for all fishes in fish_container
            	fish.moveRight();
				fish.moveLeft();
				fish.moveUp();
				fish.moveDown();
			}	
		repaint();
	}
}
