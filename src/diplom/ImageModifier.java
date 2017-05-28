/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.*;
import net.coobird.thumbnailator.filters.Colorize;
import net.coobird.thumbnailator.filters.Flip;
import net.coobird.thumbnailator.filters.ImageFilter;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.Resizers;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import net.coobird.thumbnailator.filters.Colorize;
import net.coobird.thumbnailator.filters.ImageFilter;
import net.coobird.thumbnailator.util.BufferedImages;

/**
 *
 * @author Алексей
 */
public class ImageModifier {

    private BufferedImage currentBufferedImage;

    public int rotate(int rotation) {
        try {

            currentBufferedImage = Thumbnails.of(currentBufferedImage)
                    .size(currentBufferedImage.getWidth(), currentBufferedImage.getHeight())
                    .rotate(rotation)
                    .asBufferedImage();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        }
        return 0;
    }

    public int flip(String type) {
        try {
            if (type.equals("HORIZONTAL")) {
                currentBufferedImage = Flip.HORIZONTAL.apply(currentBufferedImage);
            } else {
                currentBufferedImage = Flip.VERTICAL.apply(currentBufferedImage);
            }
            currentBufferedImage = Thumbnails.of(currentBufferedImage)
                    .size(currentBufferedImage.getWidth(), currentBufferedImage.getHeight()).asBufferedImage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        }
        // when
        return 0;
    }

    public void setWorkImage(BufferedImage im) {
        currentBufferedImage = im;
    }

    public BufferedImage getImage() {
        return currentBufferedImage;
    }

    public boolean isImage(File file) {
        /*
    // Solution 1 
    String mimeType = new MimetypesFileTypeMap().getContentType(file);
    log.info("MimeType Type = " + mimeType);
    String type = mimeType.split("/")[0].toLowerCase();
    log.info("File Type = " + type);
    return type.equals("image");
         */
        boolean b = false;
        try {
            b = (ImageIO.read(file) != null);
        } catch (IOException e) {
        }
        return b;
    }

    public int crop(String position, int x, int y, double scaleN) {
        try {
            
            Positions p = Positions.CENTER;
            if (position.equals("CENTER")) {
                p = Positions.CENTER;
            } else if (position.equals("BOTTOM_CENTER")) {
                p = Positions.BOTTOM_CENTER;
            } else if (position.equals("BOTTOM_RIGHT")) {
                p = Positions.BOTTOM_RIGHT;
            } else if (position.equals("BOTTOM_LEFT")) {
                p = Positions.BOTTOM_LEFT;
            } else if (position.equals("CENTER_LEFT")) {
                p = Positions.CENTER_LEFT;
            } else if (position.equals("CENTER_RIGHT")) {
                p = Positions.CENTER_RIGHT;
            } else if (position.equals("TOP_CENTER")) {
                p = Positions.TOP_CENTER;
            } else if (position.equals("TOP_LEFT")) {
                p = Positions.TOP_LEFT;
            } else if (position.equals("TOP_RIGHT")) {
                p = Positions.TOP_RIGHT;
            }
            //Positions p = Positions.
            /* Thumbnails.of("original.jpg")
                    .sourceRegion(Positions.CENTER, 500, 500)
                    .scale(1.5)
                    .resizer(Resizers.BICUBIC)
                    .asBufferedImage();*/
            currentBufferedImage = Thumbnails.of(currentBufferedImage)
                    .sourceRegion(p, x, y)
                    .scale(scaleN)
                    .resizer(Resizers.BICUBIC)
                    .asBufferedImage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        }

        // when
        return 0;
    }

    public int colorize(Color type, int alpha) {
        try {
            if (alpha < 0 || alpha > 255) {
                return 1;
            }

            ImageFilter filter = new Colorize(type, alpha);
            currentBufferedImage = filter.apply(currentBufferedImage);
            currentBufferedImage = Thumbnails.of(currentBufferedImage)
                    .size(currentBufferedImage.getWidth(), currentBufferedImage.getHeight()).asBufferedImage();
            // when
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 1;
        }
        // when
        return 0;
    }

}
