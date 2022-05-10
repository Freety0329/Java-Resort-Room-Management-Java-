/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPassignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class Room {
    
  private static String DBFILENAME = "room.txt";
  private static Path dbPath = Paths.get(DBFILENAME);
  
  private int ID;
  private String status, view;

  public Room(int ID, String status, String view) {
      this.ID = ID;
      this.status = status;
      this.view = view;

  }
  
  public Room(){
      
  }
    
  public String toTxtFormatString(){
      return this.ID + "," +this.status + "," +this.view;
  }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
    
    
    
    public static String[] returnAll() {
        List<String> data = null;
        try {
            data = Files.readAllLines(dbPath);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // populate the data from list into String[]
        String[] container = new String[data.size()];
        container = data.toArray(container);
        return container;
    }
  
    public static Room getroombyid(String id) {
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (id.equals(split[0])) {
                int ID = Integer.valueOf(split[0]);
                String status = split[1];
                String view = split[2];

                return new Room(ID, status, view);
            }
        }
        return null;
    }
    
    public static ArrayList<Room> getroombystatus(String queryString) {
        ArrayList<Room> tempRoom =new ArrayList();
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (split[1].toLowerCase().contains(queryString.toLowerCase())) {
                int ID = Integer.valueOf(split[0]);
                String status = split[1];
                String view = split[2];


                tempRoom.add(new Room(ID, status, view));
            }
        }
        return tempRoom;
    }
    
    public static ArrayList<Room> getroombyview(String queryString) {
        ArrayList<Room> tempRoom =new ArrayList();
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (split[2].toLowerCase().contains(queryString.toLowerCase())) {
                int ID = Integer.valueOf(split[0]);
                String status = split[1];
                String view = split[2];


                tempRoom.add(new Room(ID, status, view));
            }
        }
        return tempRoom;
    }
    
    public boolean store() {
        String[] returnAll = returnAll();
        this.ID = 0;
        if (returnAll.length == 1) {
            this.ID =1;     
             return writeNewLineToFile(this.toTxtFormatString() + "\n");
        }else{
            String[] splited = returnAll[returnAll.length - 1].split(",");
        this.ID = Integer.valueOf(splited[0]) + 1;
        return writeNewLineToFile(this.toTxtFormatString() + "\n");
        }
    }
    
    public boolean update() {
        String[] data = returnAll();
       String id = String.valueOf(this.ID);
        int a ;
        for (a = 1; a < data.length; a++) {
            String[] split = data[a].split(",");
            if (id.equals(split[0])) {
                int ID = Integer.valueOf(split[0]);
                String status = split[1];
                String view = split[2];
                break;
            }
        }
        data[a] = this.toTxtFormatString();
        String info = "";
        for (int i = 0; i < data.length; i++) {
            info += data[i] + "\n";
        }
        return rewritefile(info);
    }
    
    public void returnNewestID() {
        String[] returnAll = returnAll();
        String[] splited = returnAll[returnAll.length - 1].split(",");
        this.ID = Integer.valueOf(splited[0]);
       
    }

    public boolean delete() {
        String[] data = returnAll();
        String[] temp = new String[data.length - 1];
         String id = String.valueOf(this.ID);
        int k = 0;
        for (int i = 0; i < data.length; i++) {
             String[] split = data[i].split(",");
            if (id.equals(split[0])) {
                int ID = Integer.valueOf(split[0]);
                String status = split[1];
                String view = split[2];
                continue;
            }
            temp[k] = data[i];
            k++;
        }
        String info = "";
        for (int i = 0; i < temp.length; i++) {
            info += temp[i] + "\n";
        }
        return rewritefile(info);
    }
    
    private static boolean writeNewLineToFile(String data) {
        boolean status = true;
        try {
            Files.write(dbPath, data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            status = false;
        }
        return status;
    }
    
    private static boolean rewritefile(String data) {
        boolean status = true;
        try {
            Files.write(dbPath, data.getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            status = false;
        }
        return status;
    }
    
    public static void main(String[] args) {
        Room a = new Room();
        a.setID(20);
        a.setStatus("Vacant");
        a.setView("Sea");


//        Coach c = Coach.getCoachByid("1");
        //a.update();
        

        if(a.store()){
            System.out.println(a.getID());
        }
        
        //getstaffbyid("1");
        //getstaffbyname("Roy");
        
        

        
         
    }
    
}
