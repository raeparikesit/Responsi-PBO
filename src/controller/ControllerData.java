package controller;

import view.ViewData;
import model.ModelData;
import java.awt.event.*;
import javax.swing.*;
import model.ModelData;
import controller.ControllerData;
import view.ViewData;

/**
 *
 * @author Agil
 */
public class ControllerData {
    ModelData modelContact;
    ViewData movieView;
    public String data;
    public ControllerData(ModelData modelContact, ViewData movieView){
        this.modelContact = modelContact;
        this.movieView = movieView;
        
        if (modelContact.getBanyakData()!=0) {
            String dataMovie[][] = modelContact.readContact();
            movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
         movieView.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String ID = movieView.getId();
                String Barang = movieView.getBrg();
                String Kasir = movieView.getKsr();
                int Qty = Integer.parseInt(movieView.getQuantity());
                double Harga = Double.parseDouble(movieView.getHarga());
                double Diskon = Double.parseDouble(movieView.getDiskon());
                double Total = Harga-(Harga*Diskon/100);

                modelContact.insertData(ID, Barang, Kasir, Qty, Harga, Diskon, Total);
         
                String dataMovie[][] = modelContact.readContact();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            }
        });
         
          movieView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String ID = movieView.getId();
                String Barang = movieView.getBrg();
                String Kasir = movieView.getKsr();
                int Qty = Integer.parseInt(movieView.getQuantity());
                double Harga = Double.parseDouble(movieView.getHarga());
                double Diskon = Double.parseDouble(movieView.getDiskon());
                double Total = Harga-(Harga*Diskon/100);

                modelContact.updateData(ID, Barang, Kasir, Qty, Harga, Diskon, Total);

                String dataMovie[][] = modelContact.readContact();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            }
        });
         
          movieView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                movieView.tfId.setText("");
                movieView.tfBrg.setText("");
                movieView.tfKsr.setText("");
                movieView.tfQuantity.setText("");
            }
        });
        
    
          movieView.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                
                int baris = movieView.tabel.getSelectedRow();
                data = movieView.tabel.getValueAt(baris, 0).toString();
                String dataUpdate[] = new String[7];
                dataUpdate[0] = movieView.tabel.getValueAt(baris, 0).toString();
                dataUpdate[1] = movieView.tabel.getValueAt(baris, 1).toString();
                dataUpdate[2] = movieView.tabel.getValueAt(baris, 2).toString();
                dataUpdate[3] = movieView.tabel.getValueAt(baris, 3).toString();
                dataUpdate[4] = movieView.tabel.getValueAt(baris, 4).toString();
                dataUpdate[5] = movieView.tabel.getValueAt(baris, 5).toString();
                dataUpdate[6] = movieView.tabel.getValueAt(baris, 6).toString();
                
                System.out.println(data);
                 
                
                
            }
           });
                  
          movieView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               int input = JOptionPane.showConfirmDialog(null,
                "Apa anda ingin menghapus ID " + data + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

            if (input == 0) {
                modelContact.deleteContact(data);
                String dataMovie[][] = modelContact.readContact();
                movieView.tabel.setModel((new JTable(dataMovie, movieView.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
                }
        });

    }
    
}