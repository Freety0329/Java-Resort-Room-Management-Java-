/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JPassignment;

import static JPassignment.Book_Add.r;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class Book_Edit extends javax.swing.JFrame {

    /**
     * Creates new form Receipt_Detail
     */
    
    DefaultTableModel model;
    private static  int striterator=0;
    private static  int enditerator=0;

    
   private void initializedTableViewRooms() {
       model = (DefaultTableModel) roomtbl.getModel();
        String[] data = Room.returnAll();
        Room newID = new Room();
        newID.returnNewestID();
        int latestID = newID.getID()+1;
        List<LocalDate> listOfDate = generateDatesFromDTP();
        Boolean flag = true;
        ArrayList<Room> rooms = new ArrayList<>();
       
        
        for (int i = 1; i < latestID; i++) {
            String id = String.valueOf(i);
            Room room = Room.getroombyid(id);
            ArrayList<Book> booking = Book.getbookingbyRoom(id);
            if(booking.isEmpty()){
               rooms.add(room);
            }else if(id.equals(String.valueOf(Book_List.book.getRoom()))){
                rooms.add(room);
            }
            else{
                for(Book b : booking) {
                    List<LocalDate> listOfDateFromRecord=generateDatesFromRecord(b.getStartdate(),b.getEnddate());
                    for(LocalDate ld:listOfDateFromRecord){
                        if (listOfDate.contains(ld)){
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag){
                    rooms.add(room);
                    
                }
            }
        }
        
        for (Room r : rooms){
            if (r == null){

                } else{
                    r.setStatus("Vacant");
                        model.insertRow(model.getRowCount(), new Object[] {
                             r.getID(), r.getStatus(),r.getView()
                            });
                    if (r.getID()==Book_List.book.getRoom()){
                        int row = rooms.indexOf(r);
                        roomtbl.setRowSelectionInterval(row,0);
                    }
            
                }
            
        }
    }
    
    public List<LocalDate> generateDatesFromRecord(String startDate, String endDate){
          LocalDate strDate = LocalDate.parse(startDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          LocalDate enDate = LocalDate.parse(endDate,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          
          List<LocalDate> listOfDates = strDate.datesUntil(enDate.plusDays(1))
                            .collect(Collectors.toList());
          
          return listOfDates;
    }

     public List<LocalDate> generateDatesFromDTP(){
          
          LocalDate strdate = (LocalDate)startdate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
          LocalDate edate = (LocalDate)enddate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
          
          List<LocalDate> listOfDates = strdate.datesUntil(edate.plusDays(1))
                            .collect(Collectors.toList());
          
          return listOfDates;
    }
    
    public Book_Edit() {
        try {
            initComponents();
            
            namefield.setText(String.valueOf(Book_List.book.getName()));
            icfield.setText(String.valueOf(Book_List.book.getIcno()));
            passnofield.setText(String.valueOf(Book_List.book.getPassno()));
            contnofield.setText(String.valueOf(Book_List.book.getContno()));
            emailfield.setText(Book_List.book.getEmail());
            startdate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(Book_List.book.getStartdate()));
            enddate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(Book_List.book.getEnddate()));
            feefield.setText(String.valueOf(Book_List.book.getFee()));
            servicefield.setText(String.valueOf(Book_List.book.getServicetax()));
            tourismfield.setText(String.valueOf(Book_List.book.getTourismtax()));
            totalfield.setText(String.valueOf(Book_List.book.getTotal()));
            DefaultTableModel resetTable = (DefaultTableModel) roomtbl.getModel();
                       resetTable.setRowCount(0);
            initializedTableViewRooms();
           
        } catch (ParseException ex) {
            Logger.getLogger(Book_Edit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date tdy = new Date();
        startdate.setMinSelectableDate(tdy);
        enddate.setMinSelectableDate(tdy);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        totalfield = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        feefield = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tourismfield = new javax.swing.JTextField();
        servicefield = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        updatebtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();
        icfield = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        contnofield = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        namefield = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        passnofield = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        emailfield = new javax.swing.JTextField();
        startdate = new com.toedter.calendar.JDateChooser();
        enddate = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomtbl = new javax.swing.JTable();
        pernight = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel14.setText("Fees (RM): ");

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setText(" Total: ");

        totalfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalfieldActionPerformed(evt);
            }
        });

        jLabel8.setText("Start Date: ");

        jLabel12.setText("Service Tax (10%): ");

        feefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feefieldActionPerformed(evt);
            }
        });

        jLabel13.setText("Tourism Tax : ");

        tourismfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourismfieldActionPerformed(evt);
            }
        });

        servicefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicefieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Edit Booking");

        jLabel18.setText("End Date: ");

        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        icfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icfieldActionPerformed(evt);
            }
        });

        jLabel16.setText("Customer Name: ");

        jLabel17.setText(" Contact No: ");

        contnofield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contnofieldActionPerformed(evt);
            }
        });

        jLabel19.setText("Customer IC: ");

        namefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namefieldActionPerformed(evt);
            }
        });

        jLabel20.setText("Customer Passport No: ");

        jLabel21.setText(" Email: ");

        emailfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailfieldActionPerformed(evt);
            }
        });

        startdate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startdatePropertyChange(evt);
            }
        });

        enddate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                enddatePropertyChange(evt);
            }
        });

        roomtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Status", "View"
            }
        ));
        jScrollPane2.setViewportView(roomtbl);
        if (roomtbl.getColumnModel().getColumnCount() > 0) {
            roomtbl.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        pernight.setText("350.00");
        pernight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pernightActionPerformed(evt);
            }
        });

        jLabel22.setText("Per Night (RM): ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel16)
                                        .addGap(39, 39, 39)
                                        .addComponent(namefield, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel21)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel17))
                                                .addGap(60, 60, 60))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(emailfield, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(contnofield, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(passnofield, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(icfield, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 48, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel15)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(cancelbtn)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(servicefield)
                                            .addComponent(startdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enddate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(feefield)
                                            .addComponent(tourismfield)
                                            .addComponent(totalfield)
                                            .addComponent(pernight, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updatebtn)
                                        .addGap(22, 22, 22)))))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(namefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19)
                                    .addComponent(icfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(passnofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17)
                                    .addComponent(contnofield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(startdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(enddate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pernight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(feefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(servicefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(tourismfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGap(18, 18, 18)
                                        .addComponent(totalfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(updatebtn)
                                            .addComponent(cancelbtn))))))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void servicefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicefieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        striterator=0;
        enditerator=0;
        Book_List m = new Book_List();
        this.hide();
        m.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void totalfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalfieldActionPerformed

    private void feefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feefieldActionPerformed

    private void icfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icfieldActionPerformed

    private void contnofieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contnofieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contnofieldActionPerformed

    private void namefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namefieldActionPerformed

    private void emailfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailfieldActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
        striterator=0;
        enditerator=0;
        Book_List m = new Book_List();
        this.hide();
        m.setVisible(true);
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        // TODO add your handling code here:
        
        boolean flag = true;
        
        if(enddate.getDate()==null){
            
            JOptionPane.showMessageDialog(null, "Please select end date of booking");
             flag = false;
        }else if(startdate.getDate()==null){
            
            JOptionPane.showMessageDialog(null, "Please select start date of booking");
             flag = false;
        }else{
            
              LocalDate strdate = (LocalDate)startdate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              LocalDate edate = (LocalDate)enddate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              LocalDate now = LocalDate.now();
              
              /*System.out.println(strdate);
              System.out.println(edate);
              System.out.println(now);*/

              if (edate.isBefore(strdate)){
               JOptionPane.showMessageDialog(null, "End date cannot be ealier than start date.");
               flag = false;
              }
              
             if (strdate.isBefore(now)){
               JOptionPane.showMessageDialog(null, "Start date cannot be ealier than today.");
               flag = false;
              }
         
        
        }
        
        LocalDate strdate = (LocalDate)startdate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate edate = (LocalDate)enddate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        int ID =0 ;
        String view = "";
        String status ="";
        
        long duration = ChronoUnit.DAYS.between(strdate, edate)+1;
         
        //private static final DecimalFormat df = new DecimalFormat("0.00");
        
        String strnight = pernight.getText();
        
        double pnight = Double.parseDouble(strnight); 
        
        BigDecimal night = BigDecimal.valueOf(pnight);
        
        String tourismt = "10";
        
        double tourismta = Double.parseDouble(tourismt); 
        
        BigDecimal tourismtax = BigDecimal.valueOf(tourismta);
        
       
        BigDecimal fee = night.multiply(BigDecimal.valueOf(duration));      
        BigDecimal service = fee.multiply(BigDecimal.valueOf(0.1));
        BigDecimal tourism = tourismtax.multiply(BigDecimal.valueOf(duration));
        
        BigDecimal sum1=fee.add(service);
        BigDecimal total=sum1.add(tourism);
        fee = fee.setScale(2,BigDecimal.ROUND_HALF_UP);
        service = service.setScale(2,BigDecimal.ROUND_HALF_UP);
        tourism = tourism.setScale(2,BigDecimal.ROUND_HALF_UP);
        total = total.setScale(2,BigDecimal.ROUND_HALF_UP);
        
        feefield.setText("RM "+String.valueOf(fee)); 
        servicefield.setText("RM "+String.valueOf(service)); 
        tourismfield.setText("RM "+String.valueOf(tourism)); 
        totalfield.setText("RM "+String.valueOf(total));
        
        String regex = "[0-9]+";
        String regex2 = "^[a-zA-Z ]*$";
        String regex3 = "^[0-9A-Z]+$";
        Pattern p = Pattern.compile(regex);
        Pattern namechk = Pattern.compile(regex2);
        Pattern passnochk = Pattern.compile(regex3);
        Matcher m = namechk.matcher(this.namefield.getText());
        Matcher b = p.matcher(this.icfield.getText());
        Matcher d = p.matcher(this.contnofield.getText());
        Matcher a = passnochk.matcher(this.passnofield.getText());

        
        int column = 0;
        int row = roomtbl.getSelectedRow();
         if (row == -1){
             JOptionPane.showMessageDialog(null, "Please select a room");
             flag = false;
        }else{
              String nameString = roomtbl.getModel().getValueAt(row, column).toString();
        //System.out.println(nameString);
            r= Room.getroombyid(nameString);
            ID =Integer.valueOf(String.valueOf(r.getID())) ;
            view = r.getView();
            status =r.getStatus();
         }
         
       
        
        
        /*System.out.println(ID);
        System.out.println(view);
        System.out.println(status);*/
        
        
        
        if ("Vacant".equals(status)){}
        else{
        JOptionPane.showMessageDialog(null, "This room is booked. Please choose another room");
           flag = false;

        }
        
        

        
          if (this.namefield.getText().isEmpty() && this.icfield.getText().isEmpty() && this.passnofield.getText().isEmpty() && this.contnofield.getText().isEmpty()&& this.emailfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            flag = false;
        } else {
              
            if (m.matches() == false ) {
                JOptionPane.showMessageDialog(null, "Name can only consist of alphaberts");
                flag = false;
            }
            if (a.matches()== false ){
                JOptionPane.showMessageDialog(null, "Passport number can only have numbers and capital letters");
                flag = false;
            }
            
              if (b.matches()== false || this.icfield.getText().length() != 12){
                JOptionPane.showMessageDialog(null, "IC number should only consist of numbers and only consists of 12 digits");
                flag = false;
            }
              if (d.matches()== false || this.contnofield.getText().length() < 10){
                JOptionPane.showMessageDialog(null, "Contact number should only consist of numbers and the digits should be equal or more than 10");
                flag = false;
            }
              if (!emailfield.getText().contains("@") || emailfield.getText().contains(" ") || !emailfield.getText().contains(".com")) {
                JOptionPane.showMessageDialog(null, "Please ensure correct format of email");
                flag = false;
            }
           
            if(enddate.getDate()==null){
            
            JOptionPane.showMessageDialog(null, "Please select end date of booking");
             flag = false;
        }else if(startdate.getDate()==null){
            
            JOptionPane.showMessageDialog(null, "Please select start date of booking");
             flag = false;
        }
        }
        
       
    
          
        if (flag == true) {
        String name = namefield.getText();
        String icno = icfield.getText();
        String passno = passnofield.getText();
        String contno = contnofield.getText();
        String email = emailfield.getText();
        
        fee = fee.setScale(2,BigDecimal.ROUND_HALF_UP);
        service = service.setScale(2,BigDecimal.ROUND_HALF_UP);
        tourism = tourism.setScale(2,BigDecimal.ROUND_HALF_UP);
        total = total.setScale(2,BigDecimal.ROUND_HALF_UP);
        
        int bID =Integer.valueOf(String.valueOf(Book_List.book.getBookID())) ;
        String bookdate=String.valueOf(Book_List.book.getBookdate());
        
        


        
        Book book = new Book();
        book.setBookID(bID);
        book.setName(name);
        book.setIcno(icno);
        book.setPassno(passno);
        book.setContno(contno);
        book.setEmail(email);
        book.setStartdate(strdate.toString());
        book.setEnddate(edate.toString());
        //book.setRoom(roomcombox.getSelectedIndex() == 0) ?"Staff":"Manager";
        book.setRoom(ID);
        book.setFee(fee);
        book.setServicetax(service);
        book.setTourismtax(tourismtax);
        book.setTotal(total);
        book.setBookdate(bookdate);
        
        Room room = new Room();
        room.setID(Integer.valueOf(ID));
        room.setView(view);
        room.setStatus("Occupied");
        
        Report report = new Report();
        report.setBookID(ID);
        report.setBookdate(bookdate);
        report.setContno(contno);
        report.setStartdate(strdate.toString());
        report.setEnddate(edate.toString());
        report.setName(name);
        report.setBookdate(bookdate.toString());
        report.setRoom(Integer.valueOf(ID));
        report.setFee(fee);
        report.setServicetax(service);
        report.setTourismtax(tourism);
        report.setTotal(total);
        
        System.out.println(strdate);
        if (book.update()){
            if (room.update()){
                report.generateReceipt();
                report.openReceipt();
            JOptionPane.showMessageDialog(this, "Booking is updated");          
            dispose();
            striterator=0;
            enditerator=0;
            Book_List e = new Book_List();
            this.hide();
            e.setVisible(true);
            
            //new Book_List().setVisible(true);
            }
        }
      }
    }//GEN-LAST:event_updatebtnActionPerformed

    private void tourismfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourismfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tourismfieldActionPerformed

    private void pernightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pernightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pernightActionPerformed

    private void startdatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startdatePropertyChange
        // TODO add your handling code here:
         Boolean flag = true;
       
        striterator = striterator+1;
        if(striterator>3){
             if(enddate.getDate()==null){
            
                JOptionPane.showMessageDialog(null, "Please select end date of booking");
                 flag = false;
            }else if(startdate.getDate()==null){

                JOptionPane.showMessageDialog(null, "Please select start date of booking");
                 flag = false;
            }else{

                  LocalDate strdate = (LocalDate)startdate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                  LocalDate edate = (LocalDate)enddate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                  LocalDate now = LocalDate.now();

                  if (edate.isBefore(strdate)){
                   JOptionPane.showMessageDialog(null, "End date cannot be ealier than start date.");
                   flag = false;
                  }

                 if (strdate.isBefore(now)){
                   JOptionPane.showMessageDialog(null, "Start date cannot be ealier than today.");
                   flag = false;
                  }


            }

            if(flag){
                DefaultTableModel resetTable = (DefaultTableModel) roomtbl.getModel();
                       resetTable.setRowCount(0);            

                initializedTableViewRooms();
            }
        }
    }//GEN-LAST:event_startdatePropertyChange

    private void enddatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_enddatePropertyChange
        // TODO add your handling code here:
        
         Boolean flag = true;
       
        enditerator = enditerator+1;
        System.out.println(enditerator);
        if(enditerator>3){
             if(enddate.getDate()==null){
            
                JOptionPane.showMessageDialog(null, "Please select end date of booking");
                 flag = false;
            }else if(startdate.getDate()==null){

                JOptionPane.showMessageDialog(null, "Please select start date of booking");
                 flag = false;
            }else{

                  LocalDate strdate = (LocalDate)startdate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                  LocalDate edate = (LocalDate)enddate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                  LocalDate now = LocalDate.now();

                  if (edate.isBefore(strdate)){
                   JOptionPane.showMessageDialog(null, "End date cannot be ealier than start date.");
                   flag = false;
                  }

                 if (strdate.isBefore(now)){
                   JOptionPane.showMessageDialog(null, "Start date cannot be ealier than today.");
                   flag = false;
                  }


            }

            if(flag){
                DefaultTableModel resetTable = (DefaultTableModel) roomtbl.getModel();
                       resetTable.setRowCount(0);            

                initializedTableViewRooms();
            }
        }
       
    }//GEN-LAST:event_enddatePropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book_Edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book_Edit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JTextField contnofield;
    private javax.swing.JTextField emailfield;
    private com.toedter.calendar.JDateChooser enddate;
    private javax.swing.JTextField feefield;
    private javax.swing.JTextField icfield;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField namefield;
    private javax.swing.JTextField passnofield;
    private javax.swing.JTextField pernight;
    private javax.swing.JTable roomtbl;
    private javax.swing.JTextField servicefield;
    private com.toedter.calendar.JDateChooser startdate;
    private javax.swing.JTextField totalfield;
    private javax.swing.JTextField tourismfield;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
