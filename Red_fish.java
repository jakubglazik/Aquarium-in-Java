import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Red_fish extends Fish{
    private static BufferedImage Left_image;
    private static BufferedImage Right_image;
    
    static{
        try {
            Left_image = ImageIO.read(new File("img/left_red.png"));                //load left and right fish images
            Right_image = ImageIO.read(new File("img/right_red.png"));
            System.out.println("Grafiki red_fish zostały wczytane pomyślnie.");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania grafik: " + e.getMessage());       //print error if fail to load
        }
    }

    public Red_fish(){
        super(4);       //call fish constructor with diffrent speed
    }

    
    public BufferedImage getRightImage(){           //methods that get access to both left and right images
        return Right_image; 
    }

    public BufferedImage getLeftImage(){
        return Left_image;
    }

}
