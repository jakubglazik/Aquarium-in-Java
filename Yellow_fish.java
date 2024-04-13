import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Yellow_fish extends Fish{
    private static BufferedImage Left_image;
    private static BufferedImage Right_image;
    
    static{
        try {
            Left_image = ImageIO.read(new File("img/left_yellow.png"));
            Right_image = ImageIO.read(new File("img/right_yellow.png"));
            System.out.println("Grafiki yellow_fish zostały wczytane pomyślnie.");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania grafik: " + e.getMessage());
        }
    }

    public Yellow_fish(){
        super(2);
    }

    
    public BufferedImage getRightImage(){
        return Right_image;
    }

    public BufferedImage getLeftImage(){
        return Left_image;
    }
}
