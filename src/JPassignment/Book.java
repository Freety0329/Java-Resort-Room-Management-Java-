/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPassignment;

import java.io.IOException;
import java.math.BigDecimal;
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
public class Book {
    
    private static String DBFILENAME = "book.txt";
  private static Path dbPath = Paths.get(DBFILENAME);
  
  private int bookID, room;
  private BigDecimal fee, servicetax, tourismtax, total;
  private String name, icno, passno, contno, email, startdate, enddate, bookdate;

    public Book(int bookID, BigDecimal fee, BigDecimal servicetax, BigDecimal tourismtax, BigDecimal total, String name, String icno, String passno, String contno, String email, String startdate, String enddate, int room, String bookdate) {
        this.bookID = bookID;
        this.fee = fee;
        this.servicetax = servicetax;
        this.tourismtax = tourismtax;
        this.total = total;
        this.name = name;
        this.icno = icno;
        this.passno = passno;
        this.contno = contno;
        this.email = email;
        this.startdate = startdate;
        this.enddate = enddate;
        this.room = room;
        this.bookdate=bookdate;

    }
  
  public Book(){
      
  }
  
    public String toTxtFormatString() {
        return this.bookID + "," + this.fee + "," + this.servicetax + "," + this.tourismtax + "," + this.total + "," + this.name + "," + this.icno + "," + this.passno + "," + this.contno + "," + this.email+ "," + this.startdate+ "," + this.enddate + "," + this.room+ "," + this.bookdate;
    }

    public static String getDBFILENAME() {
        return DBFILENAME;
    }

    public static void setDBFILENAME(String DBFILENAME) {
        Book.DBFILENAME = DBFILENAME;
    }

    public static Path getDbPath() {
        return dbPath;
    }

    public static void setDbPath(Path dbPath) {
        Book.dbPath = dbPath;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getServicetax() {
        return servicetax;
    }

    public void setServicetax(BigDecimal servicetax) {
        this.servicetax = servicetax;
    }

    public BigDecimal getTourismtax() {
        return tourismtax;
    }

    public void setTourismtax(BigDecimal tourismtax) {
        this.tourismtax = tourismtax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcno() {
        return icno;
    }

    public void setIcno(String icno) {
        this.icno = icno;
    }

    public String getPassno() {
        return passno;
    }

    public void setPassno(String passno) {
        this.passno = passno;
    }

    public String getContno() {
        return contno;
    }

    public void setContno(String contno) {
        this.contno = contno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getBookdate() {
        return bookdate;
    }

    public void setBookdate(String bookdate) {
        this.bookdate = bookdate;
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
  
  public static Book getbookingbyid(String id) {
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (id.equals(split[0])) {
                int bookID = Integer.valueOf(split[0]);
                String fee1 = split[1];
                BigDecimal BigDecimalfee = new BigDecimal(fee1);
                BigDecimal fee = BigDecimalfee;
                String servicetax1 = split[2];
                BigDecimal BigDecimalservicetax1 = new BigDecimal(servicetax1);
                BigDecimal servicetax = BigDecimalservicetax1;
                String tourismtax1 = split[3];
                BigDecimal BigDecimaltourismtax1 = new BigDecimal(tourismtax1);
                BigDecimal tourismtax = BigDecimaltourismtax1;
                String total1 = split[4];
                BigDecimal BigDecimaltotal1 = new BigDecimal(total1);
                BigDecimal total = BigDecimaltotal1;
                String name = split[5];
                String icno = split[6];
                String passno = split[7];
                String contno = split[8];
                String email = split[9];
                String startdate = split[10];
                String enddate = split[11];
                int room = Integer.valueOf(split[12]);
                String bookdate = split[13];

                return new Book(bookID, fee, servicetax, tourismtax, total, name, icno, passno, contno, email, startdate, enddate, room, bookdate);
            }
        }
        return null;
    }
  
  public static ArrayList<Book> getbookingbyname(String queryString) {
        ArrayList<Book> tempBook =new ArrayList();
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (split[5].toLowerCase().contains(queryString.toLowerCase())) {
                int bookID = Integer.valueOf(split[0]);
                String fee1 = split[1];
                BigDecimal BigDecimalfee = new BigDecimal(fee1);
                BigDecimal fee = BigDecimalfee;
                String servicetax1 = split[2];
                BigDecimal BigDecimalservicetax1 = new BigDecimal(servicetax1);
                BigDecimal servicetax = BigDecimalservicetax1;
                String tourismtax1 = split[3];
                BigDecimal BigDecimaltourismtax1 = new BigDecimal(tourismtax1);
                BigDecimal tourismtax = BigDecimaltourismtax1;
                String total1 = split[4];
                BigDecimal BigDecimaltotal1 = new BigDecimal(total1);
                BigDecimal total = BigDecimaltotal1;
                String name = split[5];
                String icno = split[6];
                String passno = split[7];
                String contno = split[8];
                String email = split[9];
                String startdate = split[10];
                String enddate = split[11];
                int room = Integer.valueOf(split[12]);
                String bookdate = split[13];


                tempBook.add(new Book(bookID, fee, servicetax, tourismtax, total, name, icno, passno, contno, email, startdate, enddate, room, bookdate));
            }
        }
        return tempBook;
    }
  
  public static ArrayList<Book> getbookingbyRoom(String queryString) {
        ArrayList<Book> tempBook =new ArrayList();
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (split[12].toLowerCase().contains(queryString.toLowerCase())) {
                int bookID = Integer.valueOf(split[0]);
                String fee1 = split[1];
                BigDecimal BigDecimalfee = new BigDecimal(fee1);
                BigDecimal fee = BigDecimalfee;
                String servicetax1 = split[2];
                BigDecimal BigDecimalservicetax1 = new BigDecimal(servicetax1);
                BigDecimal servicetax = BigDecimalservicetax1;
                String tourismtax1 = split[3];
                BigDecimal BigDecimaltourismtax1 = new BigDecimal(tourismtax1);
                BigDecimal tourismtax = BigDecimaltourismtax1;
                String total1 = split[4];
                BigDecimal BigDecimaltotal1 = new BigDecimal(total1);
                BigDecimal total = BigDecimaltotal1;
                String name = split[5];
                String icno = split[6];
                String passno = split[7];
                String contno = split[8];
                String email = split[9];
                String startdate = split[10];
                String enddate = split[11];
                int room = Integer.valueOf(split[12]);
                String bookdate = split[13];


                tempBook.add(new Book(bookID, fee, servicetax, tourismtax, total, name, icno, passno, contno, email, startdate, enddate, room, bookdate));
            }
        }
        return tempBook;
    }
  
  public static ArrayList<Book> getbookingbybookdate(String queryString) {
        ArrayList<Book> tempBook =new ArrayList();
        String[] data = returnAll();
        for (int i = 1; i < data.length; i++) {
            String[] split = data[i].split(",");
            if (queryString.equals(split[13])) {
                int bookID = Integer.valueOf(split[0]);
                String fee1 = split[1];
                BigDecimal BigDecimalfee = new BigDecimal(fee1);
                BigDecimal fee = BigDecimalfee;
                String servicetax1 = split[2];
                BigDecimal BigDecimalservicetax1 = new BigDecimal(servicetax1);
                BigDecimal servicetax = BigDecimalservicetax1;
                String tourismtax1 = split[3];
                BigDecimal BigDecimaltourismtax1 = new BigDecimal(tourismtax1);
                BigDecimal tourismtax = BigDecimaltourismtax1;
                String total1 = split[4];
                BigDecimal BigDecimaltotal1 = new BigDecimal(total1);
                BigDecimal total = BigDecimaltotal1;
                String name = split[5];
                String icno = split[6];
                String passno = split[7];
                String contno = split[8];
                String email = split[9];
                String startdate = split[10];
                String enddate = split[11];
                int room = Integer.valueOf(split[12]);
                String bookdate = split[13];
                
                tempBook.add(new Book(bookID, fee, servicetax, tourismtax, total, name, icno, passno, contno, email, startdate, enddate, room, bookdate));
            }
        }
        return tempBook;
    } 
  
  public boolean store() {
        String[] returnAll = returnAll();
        this.bookID = 0;
        if (returnAll.length == 1) {
            this.bookID =1;     
             return writeNewLineToFile(this.toTxtFormatString() + "\n");
        }else{
            String[] splited = returnAll[returnAll.length - 1].split(",");
        this.bookID = Integer.valueOf(splited[0]) + 1;
        return writeNewLineToFile(this.toTxtFormatString() + "\n");
        }
    }
  
  public boolean update() {
        String[] data = returnAll();
       String id = String.valueOf(this.bookID);
        int a ;
        for (a = 1; a < data.length; a++) {
            String[] split = data[a].split(",");
            if (id.equals(split[0])) {
                int bookID = Integer.valueOf(split[0]);
                String fee1 = split[1];
                BigDecimal BigDecimalfee = new BigDecimal(fee1);
                BigDecimal fee = BigDecimalfee;
                String servicetax1 = split[2];
                BigDecimal BigDecimalservicetax1 = new BigDecimal(servicetax1);
                BigDecimal servicetax = BigDecimalservicetax1;
                String tourismtax1 = split[3];
                BigDecimal BigDecimaltourismtax1 = new BigDecimal(tourismtax1);
                BigDecimal tourismtax = BigDecimaltourismtax1;
                String total1 = split[4];
                BigDecimal BigDecimaltotal1 = new BigDecimal(total1);
                BigDecimal total = BigDecimaltotal1;
                String name = split[5];
                String icno = split[6];
                String passno = split[7];
                String contno = split[8];
                String email = split[9];
                String startdate = split[10];
                String enddate = split[11];
                int room = Integer.valueOf(split[12]);
                String bookdate = split[13];

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
         String id = String.valueOf(this.bookID);
        int k = 0;
        for (int i = 0; i < data.length; i++) {
             String[] split = data[i].split(",");
            if (id.equals(split[0])) {
                int bookID = Integer.valueOf(split[0]);
                String fee1 = split[1];
                BigDecimal BigDecimalfee = new BigDecimal(fee1);
                BigDecimal fee = BigDecimalfee;
                String servicetax1 = split[2];
                BigDecimal BigDecimalservicetax1 = new BigDecimal(servicetax1);
                BigDecimal servicetax = BigDecimalservicetax1;
                String tourismtax1 = split[3];
                BigDecimal BigDecimaltourismtax1 = new BigDecimal(tourismtax1);
                BigDecimal tourismtax = BigDecimaltourismtax1;
                String total1 = split[4];
                BigDecimal BigDecimaltotal1 = new BigDecimal(total1);
                BigDecimal total = BigDecimaltotal1;
                String name = split[5];
                String icno = split[6];
                String passno = split[7];
                String contno = split[8];
                String email = split[9];
                String startdate = split[10];
                String enddate = split[11];
                int room = Integer.valueOf(split[12]);
                String bookdate = split[13];

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
  
  public void returnNewestID() {
        String[] returnAll = returnAll();
        String[] splited = returnAll[returnAll.length - 1].split(",");
        this.bookID = Integer.valueOf(splited[0]);
       
    }
  
  //public static void main(String[] args) {
        /*Book a = new Book();
        a.setBookID(1);
        a.setFee(350);
        a.setServicetax(35);
        a.setTourismtax(10);
        a.setTotal(395); 
        a.setName("Dio");
        a.setIcno("020325010329");
        a.setPassno("123ab");
        a.setContno("0123456789");
        a.setEmail("Roy@mail.com");
        a.setStartdate("001234567894");
        a.setEnddate("001234567894");
        a.setRoom(1);

//        Coach c = Coach.getCoachByid("1");
        //a.update();
        

        if(a.store()){
            System.out.println(a.getName());
        }

        a.getName();}*/
        
        

        
         
    
  

}

