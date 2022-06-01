package model;

import java.sql.*;
import javax.swing.JOptionPane;
import model.ModelData;
import controller.ControllerData;
import view.ViewData;

public class ModelData {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/trans_db";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public ModelData() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] readContact(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][7];

            String query = "SELECT * FROM transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_trans"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getString("nama_barang"));
                data[jmlData][2] = String.valueOf(resultSet.getString("nama_kasir"));
                data[jmlData][3] = String.valueOf(resultSet.getInt("qty"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("price_per_qty"));
                data[jmlData][5] = String.valueOf(resultSet.getDouble("discount"));
                data[jmlData][6] = String.valueOf(resultSet.getDouble("price_total"));

                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }


    public void insertData(String id, String nama, String kasir, int jumlah, double harga, double diskon, double total){
        int jmlData=0;

        try {
            String query = "SELECT * FROM transactions WHERE id_trans = '" + id + "'";
            System.out.println(id + " " + nama + " " + kasir + " " + jumlah + " " + harga + " " + diskon + " " + total);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData == 0) {
                query = "INSERT INTO transactions VALUES('" + id + "','" + nama + "','" + kasir + "','" + jumlah + "','" + harga + "','" + diskon + "','" + total + "')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void updateData(String id, String nama, String kasir, int jumlah, double harga, double diskon, double total){
        int jmlData=0;
         try {
           String query = "SELECT * FROM transactions WHERE id_trans='" + id+"'";
           ResultSet resultSet = statement.executeQuery(query);

           while (resultSet.next()){
                jmlData++;
            }

             if (jmlData==1) {
                query = "UPDATE transactions SET id_trans='"+id+"', nama_barang='" + nama + "', nama_kasir='" + kasir + "', qty='"+ jumlah+"',price_per_qty='"+harga+"',discount='"+diskon+"',price_total='"+total+"' WHERE id_trans='" + id+"'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
             }
             else {
                 JOptionPane.showMessageDialog(null, "Data Tidak Ada");
             }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteContact (String ID) {
        try{
            String query = "DELETE FROM transactions WHERE id_trans = '"+ID+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
