/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

/**
 *
 * @author Алексей
 */
public class ImageData {

    private String name;
    private String path;
    private String subjectArea;
    private String format;
    private long width;
    private long height;
    private long length;
    private String imageType;
    private String placementDB;

    public ImageData(String m_name, String m_path, String f, long le, long w, long h, String iT) {
        name = m_name;
        path = m_path;
        subjectArea = "";
        format = f;
        length = le;
        width = w;
        height = h;
        imageType = iT;
        placementDB = "";
    }

    public ImageData(String m_name, String m_path, String sa, String f, long le, long w, long h, String iT,String db) {
        name = m_name;
        path = m_path;
        subjectArea = sa;
        format = f;
        length = le;
        width = w;
        height = h;
        imageType = iT;
        placementDB = db;
    }

    public void setPlacement(String s) {
        placementDB = s;
    }

    public void setSubjectArea(String s) {
        subjectArea = s;
    }

    public String getFormat(){
        return format;
    }
    

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public long getWidth() {
        return width;
    }

    public int getLength() {
        return (int) length;
    }

    public long getHeight() {
        return height;
    }

    public String getImageType() {
        return imageType;
    }

    public String getPlacementDB() {
        return placementDB;
    }
}
