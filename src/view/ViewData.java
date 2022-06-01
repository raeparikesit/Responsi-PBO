package view;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.ModelData;
import controller.ControllerData;
import view.ViewData;

public class ViewData extends JFrame{
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    
    JLabel lApp = new JLabel("DATA TRANSAKSI");
    JLabel lId = new JLabel("ID");
    JLabel lBrg = new JLabel("Nama Barang");
    JLabel lKsr = new JLabel("Nama Kasir");
    JLabel lQuantity = new JLabel("Quantity");
    JLabel lHarga = new JLabel("Harga");
    JLabel lDiskon = new JLabel("Diskon");
    
    public JTextField tfId = new JTextField();
    public JTextField tfBrg = new JTextField();
    public JTextField tfKsr = new JTextField();
    public JTextField tfQuantity = new JTextField();
    public JTextField tfHarga = new JTextField();
    public JTextField tfDiskon = new JTextField();
    
    public JButton btnAdd = new JButton("Add");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");
    

    public Object namaKolom[] = {"ID", "Nama Barang", "Nama Kasir", "Quantity", "Harga","Diskon","Total"};

    public ViewData() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Movie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,700);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 600, 300);
        
        add(lId);
        lId.setBounds(20, 350, 90, 30);
        add(tfId);
        tfId.setBounds(120, 350, 120, 30);
        
        add(lApp);
        lApp.setBounds(400,400,200,150);
        add(lBrg);
        lBrg.setBounds(20, 400, 90, 30);
        add(tfBrg);
        tfBrg.setBounds(120, 400, 120, 30);
        
        add(lKsr);
        lKsr.setBounds(20, 450, 90, 30);
        add(tfKsr);
        tfKsr.setBounds(120, 450, 120, 30);
        
        add(lQuantity);
        lQuantity.setBounds(20, 500, 90, 30);
        add(tfQuantity);
        tfQuantity.setBounds(120, 500, 120, 30);

        add(lHarga);
        lHarga.setBounds(20,550,90,30);
        add(tfHarga);
        tfHarga.setBounds(120,550,120,30);

        add(lDiskon);
        lDiskon.setBounds(20,600,90,30);
        add(tfDiskon);
        tfDiskon.setBounds(120,600,120,30);

        //button
        add(btnAdd);
        btnAdd.setBounds(250, 600, 90, 30);
        
        add(btnUpdate);
        btnUpdate.setBounds(350, 600, 90, 30);
        
        add(btnDelete);
        btnDelete.setBounds(450, 600, 90, 30);
        
        add(btnReset);
        btnReset.setBounds(550, 600, 90, 30);
    }
    
    public String getId() { return tfId.getText(); }
    public String getBrg() { return tfBrg.getText() ; }
    public String getKsr() { return tfKsr.getText(); }
    public String getQuantity() { return tfQuantity.getText(); }
    public String getHarga() { return tfHarga.getText(); }
    public String getDiskon() { return tfDiskon.getText(); }
}