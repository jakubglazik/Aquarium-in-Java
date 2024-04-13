import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame{
	private static Frame frame;

	public static Frame getFrame() {		//creating frame using private constructor
		if (frame == null) {
			frame = new Frame();
		}
		return frame;
	}

	private Frame(){
		InsideContainer container = InsideContainer.getInsideContainer();	//create main aquarium panel by using InsideContainer private constructor
		addPanel panel = new addPanel();		//creating new addPanel object
		this.setSize(container.getWidth(),container.getHeight()); // set size of the main panel
        this.setTitle("Aquarium");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.add(container, BorderLayout.CENTER);		//setting panels location in frame
		this.add(panel, BorderLayout.NORTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
