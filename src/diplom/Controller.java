/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;


import java.nio.file.*;
import java.io.*;
import javax.activation.MimetypesFileTypeMap;
import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import static java.rmi.server.LogStream.log;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author Алексей
 */
public class Controller {

    public ImageEqualizer ie;
    public ImageAnalyzer ia;
    public ImageModifier im;
    public ImageLibrary iml;
    public ImageList il;
    public DBconnector dbc;
    public TableWorker tw;
    public MainFrame m;

    public Controller() {
        ie = new ImageEqualizer();
        ia = new ImageAnalyzer();
        im = new ImageModifier();
        iml = new ImageLibrary();
        il = new ImageList();
        dbc = new DBconnector();
        tw = new TableWorker();
    }

    /**
     * @param args the command line arguments
     */
    public void func2() {
        try {
            //PreparedStatement pstmt = connection.prepareStatement("select BINARY from MYTABLE");
            //ResultSet rs = pstmt.executeQuery();
            //while (rs.next()) {
            // //    Blob blob = rs.getBlob("BINARY");
            //System.out.println("Read " + blob.length() + " bytes ");
            //   byte[] array = blob.getBytes(1, (int) blob.length());
            Path path = Paths.get("test.jpg");
            byte[] array = Files.readAllBytes(path);
            File file = File.createTempFile("something-", ".binary", new File("."));
            FileOutputStream out = new FileOutputStream(file);
            out.write(array);
            out.close();
            String result = file.getPath();
            func(result);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println("wat");// Pass -- we can't handle all image types, warn about those we can
        }
        // }
    }

    public void func(String paths) {
        try {
//        String path = "test.jpg";
//        String path2 = "testovoe.png";
            // String filepath = "/the/file/path/image.jpg";
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
                            System.out.printf("formatName: %s%n", reader.getFormatName());
                            int height = reader.getHeight(reader.getMinIndex());
                            System.out.println(height);
                            int width = reader.getWidth(reader.getMinIndex());
                            System.out.println(width);
                            String filen = f.getName();
                            System.out.println(filen);
                            long lengths = f.length();
                            System.out.println(lengths);
                            if (formatName != null && !formatName.isEmpty()) {
                                String path = f.getPath();
                                System.out.println(path);
                                int index = path.lastIndexOf('.');
                                String extension = path.substring(index + 1).toLowerCase(Locale.US);
                                System.out.println("extension->" + extension);
                                String type = "";
                                if (extension.equals("binary")) {
                                    type = "binary";
                                } else {
                                    type = "image";
                                }
                                if (!formatName.equalsIgnoreCase(extension)) {
                                    String message = String.format(
                                            "Misleading file extension; named `.%1$s` but the "
                                            + "file format is `%2$s`", extension, formatName);
                                    System.out.println(message);

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
    }

    //public static void main(String[] args) {
    //new MainFrame();
    //Diplom a = new Diplom();
//        ImageEqualizer b = new ImageEqualizer();
//        ImageAnalyzer ia = new ImageAnalyzer();
//        ImageModifier e = new ImageModifier();
//        DBconnector g = new DBconnector();
//        ImageList il = new ImageList();
//        TableWorker tw = new TableWorker();
//        //e.setFlip("", "");
//        try {
////            g.connect();
////           String string = tw.readFileAsString("tables.txt");
////            String[] parts = string.split(" ");
////            tw.setList(parts);
////            ArrayList<String> res = tw.getFieldsWithImages();
////            for(String s : res){
////                 String[] path = s.split("/");
////                 tw.getData(path[0], path[1],"Мужчины",ia , il);
////            }
////            ArrayList<ImageData> l = il.getImageList();
////              ArrayList<String> result = new ArrayList();
////            for(int i = 0; i < l.size(); i++){
////                String intoFile = il.imToString(l.get(i));
////                result.add(intoFile);
////            }
//            il.setImageListFromFile("suprise.txt", tw);
//            //il.writeToFile("supris2e.txt", result);
////            BufferedImage img = null;
////             img = ImageIO.read(new File("original.jpg"));
////             e.setWorkImage(img);
////             //e.crop("BOTTOM_RIGHT", 300, 300, 1.0);
////             Color cs = Color.BLUE;
////             e.colorize(cs, 30);
////             e.rotate(90);
////             e.flip("s");
////           img =  e.getImage();
////             Thumbnails.of(img)
////        .size(img.getWidth(), img.getHeight())
////        .toFile(new File("resultFile345.jpg"));
//        } catch (Exception se) {
//            System.out.println("prolbme");
//        }
////        e.crop("", "");
//        e.colorize("", "");
//        String path = "test.jpg";
//        ImageData i = c.getData(path);
//        ImageLibrary d = new ImageLibrary();
    //d.getCategories(System.getProperty("user.dir") + "\\library");
    // b.prepareWork(i);
    //b.equalizeWidthHeight();
    //b.equalizeSize();
//        String path2 = "fold/testovoe.png";
    // String filepath = "/the/file/path/image.jpg";
    //File f = new File(path2);
    //a.func2();
    //a.func(path2);
//    
//        long length = f.length();
//        MimetypesFileTypeMap mtftp = new MimetypesFileTypeMap();
//        mtftp.addMimeTypes("image png jpg jpeg");
//        String mimetype = mtftp.getContentType(f);
//        System.out.println(mimetype);
//        String type = mimetype.split("/")[0];
//        if (type.equals("image") && length != 0) {
//            System.out.println("It's an image");
//            System.out.println(length);
//        } else {
//           // IOException es = new IOException();
//           // throw es; throw new Exception();
//        }
//
//        try {
//            ImageInputStream iis = ImageIO.createImageInputStream(f);
//            Iterator<ImageReader> imageReaders = ImageIO.getImageReaders(iis);
//            while (imageReaders.hasNext()) {
//                ImageReader reader = (ImageReader) imageReaders.next();
//                reader.getHeight(0);
//                
//                System.out.printf("formatName: %s%n", reader.getFormatName());
//                
//            }
//            
//            
////        image = new File(path);
////        String name = image.getName();
////        System.out.println(name);
////        long length = image.length();
////        System.out.println(length);
//        } catch (Exception e) {
//            System.out.println("posos");
//        }

    /*
    // Convert the string to a
    // byte array.
    String s = "Hello World! ";
    byte data[] = s.getBytes();
    Path p = Paths.get("./logfile.txt");

    try (OutputStream out = new BufferedOutputStream(
      Files.newOutputStream(p, CREATE, APPEND))) {
      out.write(data, 0, data.length);
    } catch (IOException x) {
      System.err.println(x);
    }*/
//    }

    /*  Path file = ...;
byte[] fileArray;
fileArray = Files.readAllBytes(file);*/
}
