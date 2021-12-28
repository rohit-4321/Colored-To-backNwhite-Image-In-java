import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
public class GrayScale {
    public static void main(String args[])
    {
        BufferedImage image  = null;
        File file  = null;
        try
        {

            file = new File("C:\\Users\\Dell\\Desktop\\icon.png"); // Your Own Image path..
            image = ImageIO.read(file);

        } catch (IOException e )
        {
            System.out.println(e);
        }
        int width = image.getWidth();
        int height  = image.getHeight();

        for(int y = 0; y< height;y++)
        {
            for(int x =0 ; x < width;x++)
            {
                int p = image.getRGB(x , y);
                int b =  p & 0xff;
                int g = (p>> 8) & 0xff;
                int r  = (p>>16) & 0xff;
                int a  = (p>> 24) & 0xff;
                int avg = (r+g+b)/3;
                p  = (a<<24) | (avg << 16) | (avg << 8) | avg;
                image.setRGB(x , y , p);
            }
        }


        try {

            file  = new File("C:\\Users\\Dell\\Desktop\\gggicon.png");// Your own destination path.

            ImageIO.write(image , "png" , file);
            System.out.println("Successfully Converted.");
        }catch (IOException e )
        {
            System.out.println(e);
        }
    }
}
