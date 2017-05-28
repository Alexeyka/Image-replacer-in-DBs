/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Алексей
 */
public class ImageList {

    private ArrayList<ImageData> imageToDo;
    private int arraySize;

    ImageList() {
        imageToDo = new ArrayList();
        arraySize = imageToDo.size();
    }

    public void updateSize() {
        arraySize = imageToDo.size();
    }
    
    public int getSize(){
        return imageToDo.size();
    }

    public String imToString(ImageData i) {
        StringBuilder a = new StringBuilder();
        a.append(i.getName()).append(" ");
        a.append(i.getPath()).append(" ");
        a.append(i.getSubjectArea()).append(" ");
        a.append(i.getFormat()).append(" ");
        a.append(i.getLength()).append(" ");
        a.append(i.getWidth()).append(" ");
        a.append(i.getHeight()).append(" ");
        a.append(i.getImageType()).append(" ");
        a.append(i.getPlacementDB()).append(" ");
        return a.toString();
    }

    public void addImage(ImageData i) {
        imageToDo.add(i);
    }

    public int writeToFile(String filename, ArrayList<String> data) {
        try (PrintWriter out = new PrintWriter(filename)) {
            for (int i = 0; i < data.size(); i++) {
                out.println(data.get(i));
            }
        } catch (Exception e) {
            return 1;
        }
        return 0;
    }

    public int setImageListFromFile(String filename, TableWorker w) {
        try {
            imageToDo.clear();
            String result = w.readFileAsString(filename);
            String[] parts = result.split("\n"); 
            for(int i = 0; i < parts.length; i++){
                String[] parts9 = parts[i].split(" ");
                if(parts9.length != 13) return 1;
                String path = parts9[8] + "/" + parts9[9] +"->" +parts9[10]+" " +parts9[11];
                System.out.println(path);
                ImageData id = new ImageData(
                        parts9[0],
                        parts9[1],
                        parts9[2],
                        parts9[3],
                        Long.parseLong(parts9[4]),
                        Long.parseLong(parts9[5]),
                        Long.parseLong(parts9[6]),
                        parts9[7],
                        path);
                        imageToDo.add(id);
            }
        } catch (Exception e) {
            System.out.println("something");
            return 1;
        }
        return 0;

    }

    public ArrayList<ImageData> getImageList() {
        return imageToDo;
    }
}
