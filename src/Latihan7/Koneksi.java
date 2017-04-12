/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Latihan7;

import java.sql.*;
import javax.swing.JOptionPane;
public class Koneksi {
  private static Connection con;
  
  public static Connection getConnection(){
      try{
          con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/praktikumvisual","root","");
          JOptionPane.showMessageDialog(null, "Berhasil wal");
      }catch(SQLException e){
          JOptionPane.showMessageDialog(null, "Gagal wal "
                  +e.getMessage());
      }
      return con;
  }
}
