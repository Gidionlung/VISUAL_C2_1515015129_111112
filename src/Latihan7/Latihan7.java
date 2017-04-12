/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latihan7;

import Latihan7.Koneksi;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gidion
 */
public class Latihan7 extends javax.swing.JFrame {
    private DefaultTableModel model;
    private Connection con = Koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;


    /**
     * Creates new form Latihan7
     */
    public Latihan7() {
        initComponents();
    }
    
         private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("Judul");
        model.addColumn("Penulis");
        model.addColumn("Harga");
        
        Tabel.setModel(model);
    } 
  
             private boolean validasidatasama(String judul, String penulis){ //method untuk validasi data agar tidak boleh sama
        try {
            stt = con.createStatement(); //untuk konek ke database
            String sql = "SELECT * FROM buku WHERE judul='"+judul+"'"; //mendeklarasikan variabel sql dengan query untuk menampilkan data sesuai kondisi judul yang ditentukan
            rss = stt.executeQuery(sql); //untuk mengeksekusi query
            //kondisi untuk menampilkan hasil dan nilai pengembaliannya
            if(rss.next()) 
                return true; 
            else 
                return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

  private void TampilData(){
      try{
          String sql = "SELECT * FROM buku";
          stt = con.createStatement();
          rss = stt.executeQuery(sql);
          while(rss.next()){
              Object[] o = new Object[4];
              o[0] = rss.getString("id");
              o[1] = rss.getString("Judul");
              o[2] = rss.getString("Penulis");
              o[3] = rss.getInt("Harga");
              model.addRow(o);
          }
      }catch(SQLException e){
          System.out.println(e.getMessage());
      }
  }
  
  
        public boolean Ubah(String id, String Judul, String Penulis, String Harga){
            try{
                String sql = "Update buku set Judul = '"+Judul
                        +"', Penulis = '"+Penulis+"',Harga = "+Harga
                        +", Where id = "+id+";";
                stt = con.createStatement();
                stt.executeUpdate(sql);
                return true;
            }catch (SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
        
        public boolean Hapus(String id){
            try{
                String sql = "Delete from buku where id = "+id+";";
                stt = con.createStatement();
                stt.executeUpdate(sql);
                return true;
         
            }catch(SQLException e){
                 System.out.println(e.getMessage());
                 return false;
        }
        }
   public void TambahData(String Judul, String Penulis, String Harga){
        try{
            
            String sql = "INSERT INTO buku VALUES (NULL,'"+Judul+"','"+Penulis+"',"+Harga+")"; //mendeklarasikan variabel sql dengan query untuk menginsert data judul, penulis, harga
            stt = con.createStatement();//pembuatan statement
            stt.executeUpdate(sql);//eksekusi query
            
            //mengosongkan teksfield
            txtJudul.setText("");
            cbPenulis.setSelectedItem(0);
            txtHarga.setText("");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void UbahData(String id, String Judul, String Penulis, String Harga){
       try {
            int baris = Tabel.getSelectedRow();
            String sql = "update buku set judul='"+Judul+"', penulis='"+Penulis+"', harga="+Harga+" where id="+id+";";//mendeklarasikan variabel sql dengan query untuk mengupdate data judul, penulis, harga dari kondisi yang ditentukan
            stt = con.createStatement();//pembuatan statement
            stt.executeUpdate(sql);//eksekusi query
            
            //Mengosongkan Teksfield
            txtJudul.setText("");
            cbPenulis.setSelectedItem(0);
            txtHarga.setText("");
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbPenulis = new javax.swing.JComboBox<>();
        txtJudul = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbBy = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        Simpan = new javax.swing.JButton();
        Tambah = new javax.swing.JButton();
        Ubah = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        Keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 102, 0));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Penulis");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Harga");

        cbPenulis.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbPenulis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gidion Lung Tumanan", "Tere Liye", "W.S Rendra", "Masashi Kisimoto", "Eichiro Oda" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHarga, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(txtJudul)
                    .addComponent(cbPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbPenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("FORM DATA BUKU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(178, 178, 178))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        Tabel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id_Buku", "Judul", "Penulis", "Harga"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Search");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("By");

        cbBy.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Judul", "Penulis" }));
        cbBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbByActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(51, 102, 0));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        Simpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });
        jPanel4.add(Simpan);

        Tambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });
        jPanel4.add(Tambah);

        Ubah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Ubah.setText("Ubah");
        Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahActionPerformed(evt);
            }
        });
        jPanel4.add(Ubah);

        Hapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Hapus.setText("Hapus");
        Hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HapusMouseExited(evt);
            }
        });
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });
        jPanel4.add(Hapus);

        Keluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Keluar.setText("Keluar");
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });
        jPanel4.add(Keluar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbBy, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        int baris = Tabel.getSelectedRow();

        txtJudul.setText(Tabel.getValueAt(baris, 1).toString());
        cbPenulis.setSelectedItem(Tabel.getValueAt(baris, 2).toString());
        txtHarga.setText(Tabel.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_TabelMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        
        DefaultTableModel jTable2 = new DefaultTableModel();
        jTable2.addColumn("Judul");
        jTable2.addColumn("Penulis");
        jTable2.addColumn("Harga");
        try{
            String sql = "Select * from buku where "+cbBy.getSelectedItem().toString()+" like '%"+txtSearch.getText()+"%'";
            stt =con.createStatement();
            rss = stt.executeQuery(sql);
            while (rss.next()) {
                jTable2.addRow(new Object[]{
                    rss.getString(2),
                    rss.getString(3),
                    rss.getString(4),
                });
            }
            Tabel.setModel(jTable2);

        }catch (Exception e){
        }
    }//GEN-LAST:event_txtSearchKeyTyped

    private void cbByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbByActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbByActionPerformed

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
        // TODO add your handling code here:
            if (txtJudul.getText().length()!=0 && txtHarga.getText().length()!=0) { //penyeleksian kondisijika textfield txtJudul dan txtHarga tidak kosong
            String Judul = txtJudul.getText(); //mendeklarasikan judul sesuai dengan texfield txtJudul
            String Penulis = cbPenulis.getSelectedItem().toString();//mendeklarasikan penulis sesuai dengan combobox combopenulis
            String Harga = txtHarga.getText(); //mendeklarasikan harga sesuai dengan texfield txtHarga
            
            if(validasidatasama(Judul,Penulis)){ //penyeleksian kondisi yang diambil dari fungsi validasi dengan parameter judul
                JOptionPane.showMessageDialog(null, "Jangan sama mas bro !!");
            }
            else{
            TambahData(Judul,Penulis,Harga); //menjalankan fungsi TambahData sesuai dengan parameter judul, penulis, harga
            InitTable();//menampilkan ulang model dari table buku
            TampilData();
            JOptionPane.showMessageDialog(this, "Weeeediiaaaan. Joooss !!");
            }
        } 
        else {
        JOptionPane.showMessageDialog(this, "Diisi dulu bro !!");    
        
        }
    }//GEN-LAST:event_SimpanActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        // TODO add your handling code here:
        txtJudul.setText("");
        txtHarga.setText("");

    }//GEN-LAST:event_TambahActionPerformed

    private void UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahActionPerformed
        // TODO add your handling code here:
        int baris = Tabel.getSelectedRow();
        String id = Tabel.getValueAt(baris, 0).toString();
        String judul = txtJudul.getText();//mendeklarasikan judul sesuai dengan texfield txtJudul
        String penulis = cbPenulis.getSelectedItem().toString();//mendeklarasikan penulis sesuai dengan combobox combopenulis
        String harga = txtHarga.getText();//mendeklarasikan harga sesuai dengan texfield txtHarga
        
        int ok=JOptionPane.showConfirmDialog(this,"Dipilih dulu wal ?","Confirmation Update",JOptionPane.YES_NO_OPTION);
         try
            {
                if(ok==0)
                {
                try
                    {
                        UbahData(id,judul,penulis,harga); //menjalankan fungsi UpdateData tadi dengan parameter yang ada
                        InitTable(); //untuk menampilkan ulang model yang ada sehingga akan update ketika ada perubahan setelah dilakukan UpdateData di database
                        TampilData();//untuk menampilkan ulang fungsi TampilData
                        
                        JOptionPane.showMessageDialog(this,"Aman wal");
                    }
                catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(this, "Gagal wal");
                    }
                }
                
           }catch (Exception e){}
       

    }//GEN-LAST:event_UbahActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
       int baris = Tabel.getSelectedRow(); //mendekarasikan variabel baris sesuai data yang dipilih di tabel
       String id = Tabel.getValueAt(baris, 0).toString(); //Mendeklarasikan variabel id yang bernilai dari baris ke-0 dari tabel yang di konversi ke string
       String judul = Tabel.getValueAt(baris, 0).toString(); //mendeklarasikan variabel judul yang bernilai dari baris ke-0 dari tabel yang di konversi ke string
  
       int ya = JOptionPane.showConfirmDialog(this, "Yakin kah wal ?","Confirm Hapus",JOptionPane.YES_NO_OPTION);
   
       if (ya==0) //penyeleksian kondisi
       {
        try
         {
            Hapus(judul);//menjalankan fungsi HapusData dengan parameter judul berdasarkan baris yang di pilih
            InitTable();//menampilkan ulang model dari table buku
            TampilData();//menampilkan ulang dari model table buku
            
            JOptionPane.showMessageDialog(this, "Data Akan dihapus wal, dengan : "+"\nJudul : "+txtJudul.getText()+"\nPenulis : "+cbPenulis.getSelectedItem()+"\nHarga : "+txtHarga.getText()+"\nBerhasil Dihapus");
         }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Gagal wal");
        }
       }
    }//GEN-LAST:event_HapusActionPerformed

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_KeluarActionPerformed

    private void HapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusMouseEntered
        // TODO add your handling code here:
        Hapus.setBackground(Color.getHSBColor(655,675,725));
    }//GEN-LAST:event_HapusMouseEntered

    private void HapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HapusMouseExited
        // TODO add your handling code here:
        Hapus.setBackground(Color.getHSBColor(655,675,725));
    }//GEN-LAST:event_HapusMouseExited

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
            java.util.logging.Logger.getLogger(Latihan7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Latihan7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Latihan7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Latihan7.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Latihan7().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JButton Keluar;
    private javax.swing.JButton Simpan;
    private javax.swing.JTable Tabel;
    private javax.swing.JButton Tambah;
    private javax.swing.JButton Ubah;
    private javax.swing.JComboBox<String> cbBy;
    private javax.swing.JComboBox<String> cbPenulis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
