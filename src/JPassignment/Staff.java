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
public class Staff {
    
  private static String DBFILENAME = "staff.txt";
  private static Path dbPath = Paths.get(DBFILENAME);
  
  private int staffID;
  private String name, email, position, password, icno, contno;

    public Staff(int staffID, String icno, String contno, String name, String email, String position, String password) {
        this.staffID = staffID;
        this.icno = icno;
        this.contno = contno;
        this.name = name;
        this.email = email;
        this.position = position;
        this.password = password;
    }

  public Staff(){
      
  }
  
  public String toTxtFormatString(){
      return this.staffID + "," +this.icno+ ","  +this.contno+ "," +this.name+ "," +this.email+ "," +this.position+ "," +this.password;
  }
  
  public int getstaffID() {
        return staffID;
    }

  public void setstaffID(int staffID) {
        this.staffID = staffID;
    }
  
  public String geticno() {
        return icno;
    }

  public void seticno(String icno) {
        this.icno = icno;
    }
  
  public String getcontno() {
        return contno;
    }

  public void setcontno(String contno) {
        this.contno = contno;
    }
  
  public String getname() {
        return name;
    }

  public void setname(String name) {
        this.name = name;
    }
  
  public String getemail() {
        return email;
    }

  public void setemail(String email) {
        this.email = email;
    }
  
    public String getposition() {
        return position;
    }

  public void setposition(String position) {
        this.position = position;
    }
  
  public String getpassword() {
        return password;
    }

  public void setpassword(String password) {
        this.password = password;
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
  
  public static Staff getstaffbyid(String id) {
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (id.equals(split[0])) {
                int staffID = Integer.valueOf(split[0]);
                String icno = split[1];
                String contno = split[2];
                String name = split[3];
                String email = split[4];
                String position = split[5];
                String password = split[6];
                
                return new Staff(staffID, icno, contno, name, email, position, password);
            }
        }
        return null;
    }
   
   public static ArrayList<Staff> getstaffbyname(String queryString) {
        ArrayList<Staff> tempStaff =new ArrayList();
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (split[3].toLowerCase().contains(queryString.toLowerCase())) {
                int staffID = Integer.valueOf(split[0]);
                String icno = split[1];
                String contno = split[2];
                String name = split[3];
                String email = split[4];
                String position = split[5];
                String password = split[6];

                tempStaff.add(new Staff(staffID, icno, contno, name, email, position, password));
            }
        }
        return tempStaff;
    }
   
   public boolean store() {
        String[] returnAll = returnAll();
        this.staffID = 0;
        if (returnAll.length == 1) {
            this.staffID =1;     
             return writeNewLineToFile(this.toTxtFormatString() + "\n");
        }else{
            String[] splited = returnAll[returnAll.length - 1].split(",");
        this.staffID = Integer.valueOf(splited[0]) + 1;
        return writeNewLineToFile(this.toTxtFormatString() + "\n");
        }
    }
    
    public boolean update() {
        String[] data = returnAll();
       String id = String.valueOf(this.staffID);
        int a ;
        for (a = 1; a < data.length; a++) {
            String[] split = data[a].split(",");
            if (id.equals(split[0])) {
                int staffID = Integer.valueOf(split[0]);
                String icno = split[1];
                String contno = split[2];
                String name = split[3];
                String email = split[4];
                String position = split[5];
                String password = split[6];
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
    
    public boolean delete() {
        String[] data = returnAll();
        String[] temp = new String[data.length - 1];
         String id = String.valueOf(this.staffID);
        int k = 0;
        for (int i = 0; i < data.length; i++) {
             String[] split = data[i].split(",");
            if (id.equals(split[0])) {
                int staffID = Integer.valueOf(split[0]);
                String icno = split[1];
                String contno = split[2];
                String name = split[3];
                String email = split[4];
                String position = split[5];
                String password = split[6];
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
    
    public static Staff login(String username, String password) {
        ArrayList<Staff> staffname = getstaffbyname(username);
        for (Staff staff : staffname) {
            if ((staff.name).equals(username)) 
            {
                if ((staff.password).equals(password)) 
                    {
                        return staff;
                    }
            }
        }
        return null;
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
    
    public void returnNewestID() {
        String[] returnAll = returnAll();
        String[] splited = returnAll[returnAll.length - 1].split(",");
        this.staffID = Integer.valueOf(splited[0]);
       
    }
    
    /*public static void main(String[] args) {
        Staff a = new Staff();
        a.setstaffID(1);
        a.seticno("020325010329");
        a.setcontno("0123456789");
        a.setname("Roy");
        a.setemail("Roy@mail.com");
        a.setposition("receptionist");
        a.setpassword("1");
//        Coach c = Coach.getCoachByid("1");
        //a.update();
        

        if(a.store()){
            System.out.println(a.getname());
        }

        a.getname();*/
        
        //getstaffbyid("1");
        //getstaffbyname("Roy");
        
        

        
         
}

