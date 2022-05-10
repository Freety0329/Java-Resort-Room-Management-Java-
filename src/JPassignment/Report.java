/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JPassignment;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Cell;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.datatable.DataTable;
import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Acer
 */
public class Report {
    
  private int bookID, room, duration;
  private BigDecimal fee, servicetax, tourismtax, total;
  private String name, icno, passno, contno, email, startdate, enddate, bookdate;

    public Report(int bookID, int room, int duration, BigDecimal fee, BigDecimal servicetax, BigDecimal tourismtax, BigDecimal total, String name, String icno, String passno, String contno, String email, String startdate, String enddate, String bookdate) {
        this.bookID = bookID;
        this.room = room;
        this.duration = duration;
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
        this.bookdate = bookdate;
    }
  
  public Report(){
      
  }
  
  public String toTxtFormatString() {
        return this.bookID + "," + this.fee + "," + this.servicetax + "," + this.tourismtax + "," + this.total + "," + this.name + "," + this.icno + "," + this.passno + "," + this.contno + "," + this.email+ "," + this.startdate+ "," + this.enddate + "," + this.room + "," + this.duration + "," + this.bookdate;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
    
   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now(); 
   
  
   
    

  
  public void generateReceipt(){
        System.out.println(dtf.format(now));;
        String PDFFILENAME = "Receipt.pdf";
        Path receiptPath = Paths.get(PDFFILENAME);
        PDDocument invoice = new PDDocument();
        duration= (int)ChronoUnit.DAYS.between(LocalDate.parse(getStartdate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse(getEnddate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))+1;
        
         PDPage myPage = new PDPage();
            invoice.addPage(myPage);
        try {
           
            try (PDPageContentStream cont = new PDPageContentStream(invoice, myPage)) {

                cont.beginText();

                cont.setFont(PDType1Font.TIMES_ROMAN, 24);
                cont.setLeading(14.5f);

                cont.newLineAtOffset(0, 700);
                cont.drawString("                                           Receipt");
                cont.newLine();
                cont.drawString("");
                
                cont.newLine();
                cont.drawString("______________________________________________________________________________________________");
                cont.newLine();
                cont.drawString("");
                cont.newLine();
                cont.drawString("");
                
                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                cont.newLine();
                cont.drawString("          Customer Name    :             "+getName()+"                                                              Date: " +getBookdate());
                
                cont.newLine();
                cont.drawString("");
                
                cont.newLine();
                cont.drawString("___________________________________________________________________________________________________________________");
               
                
                cont.newLine();
                cont.drawString("");
         
                cont.newLine();
                
                
                float margin = 25;
            // starting y position is whole page height subtracted by top and bottom margin
                float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
            // we want table across whole page width (subtracted by left and right margin ofcourse)
             float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);

            boolean drawContent = true;
            float yStart = yStartNewPage;
            float bottomMargin = 70;
        // y position is your coordinate of top left corner of the table
            float yPosition = 550;

             BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, invoice, myPage, true, drawContent);


            Row<PDPage> headerRow = table.createRow(15f);
            Cell<PDPage> cell = headerRow.createCell(17, "Room No: ");
            Cell<PDPage> cell2 = headerRow.createCell(17, "Start Date: ");
            Cell<PDPage> cell3 = headerRow.createCell(17, "End Date: ");
            Cell<PDPage> cell4 = headerRow.createCell(17, "Duration: ");
            Cell<PDPage> cell5 = headerRow.createCell(25, "Fee per night (RM): ");

            



            cell.setFont(PDType1Font.TIMES_ROMAN);
            cell.setFontSize(12);
            cell2.setFont(PDType1Font.TIMES_ROMAN);
            cell2.setFontSize(12);
            cell3.setFont(PDType1Font.TIMES_ROMAN);
            cell3.setFontSize(12);
            cell4.setFont(PDType1Font.TIMES_ROMAN);
            cell4.setFontSize(12);
            cell5.setFont(PDType1Font.TIMES_ROMAN);
            cell5.setFontSize(12);



          
            

            table.addHeaderRow(headerRow);


            Row<PDPage> row = table.createRow(12);
            
            cell = row.createCell(17, String.valueOf(getRoom()));
            cell.setFont(PDType1Font.TIMES_ROMAN);
	    cell.setFontSize(12);
            cell = row.createCell(17, getStartdate());
            cell.setFont(PDType1Font.TIMES_ROMAN);
	    cell.setFontSize(12);
            cell = row.createCell(17, getEnddate());
            cell.setFont(PDType1Font.TIMES_ROMAN);
	    cell.setFontSize(12);
            cell = row.createCell(17, String.valueOf(getDuration()));
            cell.setFont(PDType1Font.TIMES_ROMAN);
	    cell.setFontSize(12);
            cell = row.createCell(17, String.valueOf(getFee()));
            cell.setFont(PDType1Font.TIMES_ROMAN);
	    cell.setFontSize(12);

            

    
            table.removeAllBorders(true);
            table.draw();
            
            cont.newLine();
            cont.drawString("");
            
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            
            cont.newLine();
            cont.drawString("___________________________________________________________________________________________________________________");
            
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("                                                                                                                                                    Fees:          RM "+getFee());
            cont.newLine();
            cont.drawString("                                                                                                                                      Tourism Tax :          RM "+getTourismtax());
            cont.newLine();
            cont.drawString("                                                                                                                                       Service Tax :          RM "+getServicetax());
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("                                                                                                                                     ______________________________________________"
                    + "");
            cont.newLine();
            cont.drawString("                                                                                                                                                  Total :          RM "+getTotal());

            cont.endText();
            }
                
            
            invoice.save("src/JPassignment/Receipt.pdf");
            
            invoice.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
  public void openReceipt(){
        try {
            File file = new File("src/JPassignment/Receipt.pdf");
            if (file.exists()) {
                long startTime = System.currentTimeMillis();
                Desktop.getDesktop().open(file);
                long endTime = System.currentTimeMillis();
                System.out.println("Total time taken to open file -> "+ file.getName() +" in "+ (endTime - startTime) +" ms");              
            } else {
                System.out.println("File not exits -> "+ file.getAbsolutePath());
            }
        } catch (IOException e) {
        }
    
}
  
  public List<LocalDate> generateDate(){
          LocalDate strDate = LocalDate.parse(getStartdate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          LocalDate enDate = LocalDate.parse(getEnddate(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          
          List<LocalDate> listOfDates = strDate.datesUntil(enDate.plusDays(1))
                            .collect(Collectors.toList());
          
          return listOfDates;
      }
  
  public void generateSalesReport(){
        String PDFFILENAME = "Sales Report.pdf";
        Path SalesReportPath = Paths.get(PDFFILENAME);
        PDDocument SalesReport = new PDDocument();
        //duration= (int)ChronoUnit.DAYS.between(LocalDate.parse(getStartdate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse(getEnddate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))+1;
         PDPage myPage = new PDPage();
            SalesReport.addPage(myPage);
        try {
           
            try (PDPageContentStream cont = new PDPageContentStream(SalesReport, myPage)) {

                cont.beginText();

                cont.setFont(PDType1Font.TIMES_ROMAN, 24);
                cont.setLeading(14.5f);

                cont.newLineAtOffset(0, 700);
                cont.drawString("                                           Sales Report");
                cont.newLine();
                cont.drawString("");
                
                cont.newLine();
                cont.drawString("______________________________________________________________________________________________");
                cont.newLine();
                cont.drawString("");
                cont.newLine();
                cont.drawString("");
                
                cont.setFont(PDType1Font.TIMES_ROMAN, 12);
                cont.newLine();
                cont.drawString("           Sales Report from "+getStartdate()+" to "+  getEnddate());
                
                cont.newLine();
                cont.drawString("");
                
                cont.newLine();
                cont.drawString("___________________________________________________________________________________________________________________");
               
                
                cont.newLine();
                cont.drawString("");
         
                cont.newLine();
                
                
                float margin = 20;
            // starting y position is whole page height subtracted by top and bottom margin
                float yStartNewPage = myPage.getMediaBox().getHeight() - (2 * margin);
            // we want table across whole page width (subtracted by left and right margin ofcourse)
             float tableWidth = myPage.getMediaBox().getWidth() - (2 * margin);

            boolean drawContent = true;
            float yStart = yStartNewPage;
            float bottomMargin = 70;
        // y position is coordinate of top left corner of the table
            float yPosition = 550;

            List<List> data = new ArrayList();
            data.add(new ArrayList<>(
               Arrays.asList("Customer name", "Room No", "Booking Date", "Duration", "Total")));
            List<LocalDate> listOfDate = generateDate();
            total = BigDecimal.valueOf(0);

            for (int i = 0; i < listOfDate.size(); i++) {
                 ArrayList<Book> rentbyDate = Book.getbookingbybookdate(String.valueOf(listOfDate.get(i)));

                for (Book book : rentbyDate) {
            
                    duration= (int)ChronoUnit.DAYS.between(LocalDate.parse(book.getStartdate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.parse(book.getEnddate(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))+1;

        
              data.add(new ArrayList<>(  
                  Arrays.asList("                      "+book.getName()+"        " , "          " + book.getRoom()+"       ", "                   " + book.getBookdate()+ "       ", "          " + duration + " Days    ", " RM " + book.getTotal() + "        ")));
              
              total = total.add(book.getTotal());
             cont.newLine();
            cont.drawString("");
           

            }
               
            
            }
            BaseTable dataTable = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, SalesReport, myPage, true, true);
            DataTable t = new DataTable(dataTable, myPage);
            t.addListToTable(data, DataTable.HASHEADER);


    
            dataTable.removeAllBorders(true);
            dataTable.draw();
            
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("");
            
            cont.newLine();
            cont.drawString("___________________________________________________________________________________________________________________");
            
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("                                                                                                                                              Total Sales :         RM "+total);
             
            cont.newLine();
            cont.drawString("");
            cont.newLine();
            cont.drawString("                                                                                                                           ________________________________________________________"
                    + "");
            

            cont.endText();
            }
                
            
            SalesReport.save("src/JPassignment/SalesReport.pdf");
            
            SalesReport.close();
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
}
  
  public void openSalesReport(){
        try {
            File file = new File("src/JPassignment/SalesReport.pdf");
            if (file.exists()) {
                long startTime = System.currentTimeMillis();
                Desktop.getDesktop().open(file);
                long endTime = System.currentTimeMillis();
                System.out.println("Total time taken to open file -> "+ file.getName() +" in "+ (endTime - startTime) +" ms");              
            } else {
                System.out.println("File not exits -> "+ file.getAbsolutePath());
            }
        } catch (IOException e) {
        }
           }
  
  public static void main(String[] args) {
        Report Report = new Report();
        Report.setBookID(1);
        Report.setBookdate("2022-03-01");
        Report.setStartdate("2022-03-01");
        Report.setEnddate("2022-03-30");
        Report.setContno("1");
        Report.setDuration(5);
        Report.setEmail("@mail");
        Report.setFee(BigDecimal.valueOf(11111111));
        Report.setName("qwerty");
        Report.setPassno("123");
        Report.setTourismtax(BigDecimal.valueOf(11111111));
        Report.setServicetax(BigDecimal.valueOf(11111111));
        Report.setTotal(BigDecimal.valueOf(11111111));
        Report.setRoom(0);
        
        Report.generateSalesReport();
           List<LocalDate> listOfDate = Report.generateDate();
           
Report.generateSalesReport();
Report.openSalesReport();
        
  }
  
  /*public static void main(String[] args) {
        Report Report = new Report();
        Report.setBookID(1);
        Report.setBookdate("2022-03-01");
        Report.setStartdate("2022-03-01");
        Report.setEnddate("2022-03-30");
        Report.setContno("1");
        Report.setDuration(5);
        Report.setEmail("@mail");
        Report.setFee(BigDecimal.valueOf(11111111));
        Report.setName("qwerty");
        Report.setPassno("123");
        Report.setTourismtax(BigDecimal.valueOf(11111111));
        Report.setServicetax(BigDecimal.valueOf(11111111));
        Report.setTotal(BigDecimal.valueOf(11111111));
        Report.setRoom(0);
        Report.setIcno("1");
        
        Report.generateReceipt();
           List<LocalDate> listOfDate = Report.generateDate();
           
Report.generateReceipt();
Report.openReceipt();
        
  }*/
    
}
