import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Blue_fish extends Fish{
    private static BufferedImage Left_image;
    private static BufferedImage Right_image;
    
    static{
        try {
            Left_image = ImageIO.read(new File("img/left_blue.png"));
            Right_image = ImageIO.read(new File("img/right_blue.png"));
            System.out.println("Grafiki blue_fish zostały wczytane pomyślnie.");
        } catch (IOException e) {
            System.err.println("Błąd podczas wczytywania grafik: " + e.getMessage());
        }
    }

    public Blue_fish(){
        super(3);
    }

    
    public BufferedImage getRightImage(){
        return Right_image;
    }

    public BufferedImage getLeftImage(){
        return Left_image;
    }
}
