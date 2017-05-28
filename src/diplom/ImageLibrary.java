/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Алексей
 */
public class ImageLibrary {

    private String dir = System.getProperty("user.dir") + "\\library";
    private ArrayList<String> directories;

    public ImageLibrary() {
        directories = new ArrayList();
        getCategories(dir);
    }

    public ArrayList<String> getListDirectories() {
        return directories;
    }

    public void getCategories(String dire) {

        File[] files = new File(dire).listFiles(File::isDirectory);
        for (int i = 0; i < files.length; i++) {
            directories.add(files[i].getName());
            getCategories(dire + "\\" + files[i].getName());
        }
//        File file = new File(workingDir);
//        String[] names = file.list();
//        
//        for (String name : names) {
//            if (new File(workingDir + "\\" + name).isDirectory()) {
//                System.out.println(name);
//            }
//        }
//        
//        File file;
//        file = new File("/library");
//        String[] directories = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File current, String name) {
//                return new File(current, name).isDirectory();
//            }
//        });
//        System.out.println(Arrays.toString(directories));

    }

}
