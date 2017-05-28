/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diplom;

import static diplom.DBconnector.c;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Алексей
 */
public class TableWorker {

    String[] listOfTables;
    ArrayList<String> listOfFields;
    ArrayList<String> usedFields;
    String currentTable = "";

    public TableWorker() {
        listOfFields = new ArrayList();
        usedFields = new ArrayList();
    }

    public void setCurrentTable(String s) {
        currentTable = s;
    }

    public String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
    
    

    public void setList(String[] l) {
        listOfTables = l;
    }

    public String[] getListOfTables() {
        return listOfTables;
    }

    public void getData(String table, String field, String po, ImageAnalyzer a, ImageList b) {
        try {
            Statement stmt = DBconnector.c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT " + field + " FROM " + table);
            int i = 0;
            while (rs.next()) {
                i++;
                String path = rs.getString(field);
                String location = table + " " + field + " row " + i;
                ImageData res = a.analyzeImage(path, location, po);
                b.addImage(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getFieldsWithImages() {

        try {
            for (int i = 0; i < listOfTables.length; i++) {
                Statement stmt = DBconnector.c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + listOfTables[i]);
                ResultSetMetaData rsmd = rs.getMetaData();
                int cCount = rsmd.getColumnCount();
                for (int j = 1; j <= cCount; j++) {
                    String name = rsmd.getColumnName(j);
                    Statement stmt1 = DBconnector.c.createStatement();
                    ResultSet rs1 = stmt1.executeQuery("SELECT " + name + " FROM " + listOfTables[i]);

                    while (rs1.next()) {
                        String data = rs1.getString(name);
                        if (data.contains(".jpg") || data.contains(".png")) {
                            listOfFields.add(listOfTables[i] + "/" + name);
                            break;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfFields;
    }
}
