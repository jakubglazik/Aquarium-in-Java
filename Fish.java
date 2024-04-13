import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.*;

abstract class Fish extends JLabel{
    protected int step;
    private int currX;
    private int currY;
    private int minTop;
    private int maxBottom;
    private int maxRight;
    private int minLeft;
    private int HDirect;
    private int VDirect;
    private BufferedImage CurrentImage;

    public Fish(int speed){         //fish class constructor that set necessary parameters
        this.step = speed;
        randomHDirect();
        randomVDirect();
        startPosition();
        randomMaxRight();
        randomMinLeft();
        randomMinTop();
        randomMaxBottom();
    }

    private void startPosition(){
        int startX = (int) (Math.random() * ((InsideContainer.getInsideContainer().getWidth() - CurrentImage.getWidth())));         //set random start position of every fish
		int startY = (int) (Math.random() * ((InsideContainer.getInsideContainer().getHeight() - CurrentImage.getHeight())));
        this.currX = startX;
        this.currY = startY;
    }

    private void randomHDirect(){                   //setting horizontal direction and proper fish icon
        int h = (int)Math.round(Math.random());
        if(h==0){ //0 - left and 1 - right
            this.HDirect = h;
            setCurrImage(getLeftImage());
        }else{
            this.HDirect = h;
            setCurrImage(getRightImage());
        }
    };

    private void randomVDirect(){       //setting vertical direction
        int v = (int) (Math.random() * 10);
        if(v<=3){               //0 - down or 1 - up or 2 - none
            this.VDirect = 0;
        }else if(v>=4 && v<=7){
            this.VDirect = 1;
        }else{
            this.VDirect = 2;
        }
    };

    private void randomMinTop(){
        this.minTop = (int) (Math.random() * currY);        //setting temporary borders of movemant area
    }

    private void randomMaxBottom(){
        this.maxBottom = (int) (Math.random() * ((InsideContainer.getInsideContainer().getHeight())-(currY+CurrentImage.getHeight())))+(currY+CurrentImage.getHeight());
    }

    private void randomMaxRight(){
        this.maxRight = (int) (Math.random() * ((InsideContainer.getInsideContainer().getWidth())-(currX+CurrentImage.getWidth())))+(currX+CurrentImage.getWidth());
    }

    private void randomMinLeft(){
        this.minLeft = (int) (Math.random() * currX);
    }

    public void moveRight(){                                                //making move from current location to border
        if(HDirect == 1 && currX+CurrentImage.getWidth() <= maxRight){
            currX+=step;

            if(currX + CurrentImage.getWidth() + step > maxRight || currX+CurrentImage.getWidth() >= maxRight){
                HDirect = 0;
                randomVDirect();        //chosing new vertical direction to make fish movemant more dynamic
                randomMinLeft();        //when fish reach the right border, new left border is set
                setCurrImage(getLeftImage());
            }
        }
    }

    public void moveLeft(){
        if(HDirect == 0 && currX >= minLeft){
            currX-=step;

            if(currX - step < minLeft || currX <= minLeft){
                HDirect = 1;
                randomVDirect();
                randomMaxRight();       //when fish reach the left border, new right border is set
                setCurrImage(getRightImage());
            }
        }
    }

    public void moveUp(){
        if(VDirect == 1 && currY >= minTop){
            currY-=(step-2);

            if(currY - step-2 < minTop || currY <= minTop){
                randomVDirect();
                randomMaxBottom();
            }
        }
    }

    public void moveDown(){
        if(VDirect == 0 && currY+CurrentImage.getHeight() <= maxBottom){
            currY+=(step-2);

            if((currY+CurrentImage.getHeight()) + step-2 > maxBottom || currY+CurrentImage.getHeight() >= maxBottom){
                randomVDirect();
                randomMinTop();
            }
        }
    }


    public void setCurrImage(BufferedImage image){          //useful getters and setters that allow user to get access to private variables
        CurrentImage = image;
    }
   
    public Image getCurrImage(){
         return this.CurrentImage;
    }

    public void setX(int x){
        this.currX = x;
    }

    public int getX(){
        return this.currX;
    }

    public void setY(int y){
        this.currY = y;
    }

    public int getY(){
        return this.currY;
    }

    protected abstract BufferedImage getLeftImage();        //initialize abstract methods that get each fish type images
    protected abstract BufferedImage getRightImage();
}
