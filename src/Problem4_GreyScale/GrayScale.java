package Problem4_GreyScale;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**Picture must be just out of the src dir**/
public class GrayScale {
    public static void main(String[] args){
        BufferedImage jpg = null;
        File img = new File("picture.jpg");
        try {
            jpg = ImageIO.read(img);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
        /**get image size**/
        int width = jpg.getWidth();
        int height = jpg.getHeight();
        /**turn grey**/
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                int p = jpg.getRGB(x,y);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                int avg = (r+g+b)/3;
                p=(a<<24)|(avg<<16)|(avg<<8)|(avg);
                jpg.setRGB(x,y,p);
            }
        }
        try {
            ImageIO.write(jpg, "jpg", new File("grey.jpeg"));
        } catch (IOException e){}
    }
}