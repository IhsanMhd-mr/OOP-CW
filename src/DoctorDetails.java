//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DoctorDetails {
    String[][] data;
    JTable table;
    JScrollPane sp;

    public DoctorDetails() {
        final JFrame details = new JFrame();
        JPanel panelheader = new JPanel();
        panelheader.setLayout(new FlowLayout());
        panelheader.setBackground(Color.blue);
        panelheader.setBounds(0, 0, 1000, 60);
        JLabel header = new JLabel("Doctors' Details");
        header.setForeground(Color.white);
        header.setFont(new Font("Arial", 0, 30));
        panelheader.add(header);
        details.add(panelheader);
        details.setLayout((LayoutManager)null);
        details.setVisible(true);
        details.setSize(1000, 600);
        details.setDefaultCloseOperation(3);
        this.data = new String[WestminsterSkinConsultationManager.doctors.size()][];

        for(int i = 0; i < WestminsterSkinConsultationManager.doctors.size(); ++i) {
            Doctor dn = (Doctor)WestminsterSkinConsultationManager.doctors.get(i);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String dobSimple = dateFormat.format(dn.getDOB());
            this.data[i] = new String[]{dn.getName(), dn.getSurName(), dobSimple, String.valueOf(dn.getMobNo()), dn.getLicenceNumber(), dn.getSpecialisation()};
        }

        final String[] columnNames = new String[]{"Name", "Surname", "date of Birth", "Mobile No", "medical license No", "Specialisation"};
        this.table = new JTable(this.data, columnNames);
        this.sp = new JScrollPane(this.table);
        this.sp.setBounds(100, 100, 800, 300);
        details.add(this.sp);
        JButton menu = new JButton("Menu");
        menu.setBounds(100, 500, 300, 50);
        menu.setBackground(Color.red);
        menu.setForeground(Color.WHITE);
        details.add(menu);
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new Menu();
                } catch (IOException var3) {
                    throw new RuntimeException(var3);
                }

                details.dispose();
            }
        });
        JButton sort = new JButton("sort");
        sort.setBounds(800, 425, 100, 30);
        sort.setBackground(Color.blue);
        sort.setForeground(Color.WHITE);
        sort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Arrays.sort(DoctorDetails.this.data, (a, b) -> {
                    return a[1].compareTo(b[1]);
                });
                new JTable(DoctorDetails.this.data, columnNames);
                DoctorDetails.this.sp.setVisible(false);
                DoctorDetails.this.table = new JTable(DoctorDetails.this.data, columnNames);
                JScrollPane sp1 = new JScrollPane(DoctorDetails.this.table);
                sp1.setBounds(100, 100, 800, 300);
                details.add(sp1);
            }
        });
        details.add(sort);
    }
}
