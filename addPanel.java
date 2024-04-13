import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class addPanel extends JPanel implements ActionListener{
    JButton buttonAddFish = new JButton("Add Fish");
	JComboBox<String> fishType = new JComboBox<String>();

	public addPanel() {
		fishType.addItem("Red");			//adding combo type option for all allow fish types
        fishType.addItem("Yellow");
		fishType.addItem("Blue");
		buttonAddFish.addActionListener(this);		//listening for button click
        add(fishType);
		add(buttonAddFish);
	}

	public void actionPerformed(ActionEvent e) {
		String type = (String) fishType.getSelectedItem();
		if(type == "Red"){																	//create new selected fish and add it to fish_container
			InsideContainer.getInsideContainer().fish_collection.add(new Red_fish());
		}else if(type == "Yellow"){
			InsideContainer.getInsideContainer().fish_collection.add(new Yellow_fish());
		}else if(type == "Blue"){
			InsideContainer.getInsideContainer().fish_collection.add(new Blue_fish());
		}
	}


}
