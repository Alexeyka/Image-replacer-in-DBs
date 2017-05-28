/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Алексей
 */
public class ImageAnalyzer {

    public void func2() {
        try {
            Path path = Paths.get("test.jpg");
            byte[] array = Files.readAllBytes(path);
            File file = File.createTempFile("something-", ".binary", new File("."));
            FileOutputStream out = new FileOutputStream(file);
            out.write(array);
            out.close();
            String result = file.getPath();
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("wat");// Pass -- we can't handle all image types, warn about those we can
        }
        // }
    }

    
    public ImageData analyzeImage(String paths,String location,String po) {
        ImageData currentImage = new ImageData("", "", "", 0, 0, 0, "");
        try {
            File f = new File(paths);
            ImageInputStream input = ImageIO.createImageInputStream(f);
            if (input != null) {
                try {
                    Iterator<ImageReader> readers = ImageIO.getImageReaders(input);
                    while (readers.hasNext()) {
                        ImageReader reader = readers.next();
                        try {
                            reader.setInput(input);
                            // Check file extension
                            String formatName = reader.getFormatName();
                            if(formatName.equals("JPEG")){
                                formatName = "jpg";
                            }

                            int height = reader.getHeight(reader.getMinIndex());

                            int width = reader.getWidth(reader.getMinIndex());

                            String filen = f.getName();

                            long lengths = f.length();

                            if (formatName != null && !formatName.isEmpty()) {
                                String path = f.getPath();

                                int index = path.lastIndexOf('.');
                                String extension = path.substring(index + 1).toLowerCase(Locale.US);
                                String type = "";
                                if (extension.equals("binary")) {
                                    type = "binary";
                                } else {
                                    type = "image";
                                }
                                currentImage = new ImageData(filen, path, formatName, lengths, width, height, type);
                                currentImage.setPlacement(location);
                                currentImage.setSubjectArea(po);
                                if (!formatName.equalsIgnoreCase(extension)) {
                                    String message = String.format(
                                            "Misleading file extension; named `.%1$s` but the "
                                            + "file format is `%2$s`", extension, formatName);
                                }
                                break;
                            }
                        } finally {
                            reader.dispose();
                        }
                    }
                } finally {
                    input.close();
                }
               
            }
        } catch (IOException e) {
            // Pass -- we can't handle all image types, warn about those we can
        }
         return currentImage;
    }
    
}
