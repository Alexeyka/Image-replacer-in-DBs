/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import javax.imageio.ImageIO;
import org.imgscalr.Scalr;

/**
 *
 * @author Алексей
 */
public class ImageEqualizer {

    private File changer;
    private BufferedImage workImage;
    private String type;
    private ImageData imageInfo;

    public void prepareWork(ImageData id,File changers) {
        imageInfo = id;
        type = id.getFormat();
        changer = changers;
    }

    public void equalizeWidthHeight() {
        try {
            int width = (int) imageInfo.getWidth();
            int height = (int) imageInfo.getHeight();
            BufferedImage originalImage = ImageIO.read(changer);
            workImage = resizeImage(originalImage, width, height);
        } catch (Exception e) {
            System.out.println("equalizeWidthHeight");
        }
    }

    private void createPath(byte[] bytes) {

        try {
            String imageType = imageInfo.getImageType();
            if (imageType.equals("binary")) {
                String path = "/result/binary/test.jpg";
                File file = new File(path);
                file.getParentFile().mkdirs();
                file.mkdirs();
                String temp = file.getAbsolutePath();
                int index = temp.indexOf(".") - 4;
                temp = temp.substring(0, index);
                temp = temp.replace('\\', '/');
                RandomAccessFile f = new RandomAccessFile(temp + imageInfo.getName(), "rw");
                f.setLength(imageInfo.getLength());
                f.write(bytes);
                f.close();
            } else {
                String path = imageInfo.getPath();
                path = path.replace(":", "");
                System.out.println("path->" + path);
                String path2 = "/result/" + path;
                System.out.println("path2->" + path2);
                File file = new File(path2);
                file.getParentFile().mkdirs();
                String temp = file.getAbsolutePath();
                temp = temp.replace('\\', '/');
                String result = temp;
                System.out.println(result);
                RandomAccessFile f = new RandomAccessFile(result, "rw");
                f.setLength(imageInfo.getLength());
                f.write(bytes);
                f.close();
            }
        } catch (Exception e) {

        }
    }

    public static BufferedImage resizeImage(BufferedImage inputImage, int resultWidth, int resultHeight) {
        int originWidth = inputImage.getWidth();
        int originHeight = inputImage.getHeight();

        if (originWidth <= resultWidth && originHeight <= resultHeight) {
           
            BufferedImage thumbImage = Scalr.resize(inputImage, Scalr.Method.BALANCED, resultWidth, resultHeight); 
            return thumbImage;
        }

        // Scale in respect to width or height? 
        Scalr.Mode scaleMode = Scalr.Mode.AUTOMATIC;

        // find out which side is the shortest 
        int maxSize = 0;
        if (originHeight > originWidth) {
            // scale to width 
            scaleMode = Scalr.Mode.FIT_TO_WIDTH;
            maxSize = resultWidth;
        } else if (originWidth >= originHeight) {
            scaleMode = Scalr.Mode.FIT_TO_HEIGHT;
            maxSize = resultHeight;
        }

        // Scale the image to given size 
        BufferedImage outputImage = Scalr.resize(inputImage, Scalr.Method.QUALITY, scaleMode, maxSize);

        // okay, now let us check that both sides are fitting to our result scaling 
        if (scaleMode.equals(Scalr.Mode.FIT_TO_WIDTH) && outputImage.getHeight() > resultHeight) {
            // the height is too large, resize again 
            outputImage = Scalr.resize(outputImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_HEIGHT, resultHeight);
        } else if (scaleMode.equals(Scalr.Mode.FIT_TO_HEIGHT) && outputImage.getWidth() > resultWidth) {
            // the width is too large, resize again 
            outputImage = Scalr.resize(outputImage, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH, resultWidth);
        }

        // now we have an image that is definitely equal or smaller to the given size 
        // Now let us check, which side needs black lines 
        int paddingSize = 0;
        if (outputImage.getWidth() != resultWidth) {
            // we need padding on the width axis 
            paddingSize = (resultWidth - outputImage.getWidth()) / 2;
        } else if (outputImage.getHeight() != resultHeight) {
            // we need padding on the height axis 
            paddingSize = (resultHeight - outputImage.getHeight()) / 2;
        }

        // we need padding? 
        if (paddingSize > 0) {
            // add the padding to the image 
            outputImage = Scalr.pad(outputImage, paddingSize);

            // now we have to crop the image because the padding was added to all sides 
            int x = 0, y = 0, width = 0, height = 0;
            if (outputImage.getWidth() > resultWidth) {
                // set the correct range 
                x = paddingSize;
                y = 0;
                width = outputImage.getWidth() - (2 * paddingSize);
                height = outputImage.getHeight();
            } else if (outputImage.getHeight() > resultHeight) {
                // set the correct range 
                x = 0;
                y = paddingSize;
                width = outputImage.getWidth();
                height = outputImage.getHeight() - (2 * paddingSize);
            }

            // Crop the image  
            if (width > 0 && height > 0) {
                outputImage = Scalr.crop(outputImage, x, y, width, height);
            }
        }

        // flush both images 
        inputImage.flush();
        outputImage.flush();
        return outputImage;
    }

    public void equalizeSize() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(workImage, type, baos);
            byte[] bytes = baos.toByteArray();
            createPath(bytes);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
