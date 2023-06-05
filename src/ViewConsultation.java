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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.regex.PatternSyntaxException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ViewConsultation {
    String[][] consultationdata;
    String[] columnNames;
    JTable table;
    TableModel model;
    String pt_Id;
    String pt_name;
    String pt_surname;
    String pt_dob;
    String pt_phn;

    public ViewConsultation() {
        final JFrame consultationdetails = new JFrame();
        JPanel panelheader = new JPanel();
        panelheader.setLayout(new FlowLayout());
        panelheader.setBackground(Color.blue);
        panelheader.setBounds(0, 0, 1000, 60);
        JLabel header = new JLabel("Consultation Details");
        header.setForeground(Color.white);
        header.setFont(new Font("Arial", 0, 30));
        panelheader.add(header);
        consultationdetails.add(panelheader);
        consultationdetails.setLayout((LayoutManager)null);
        consultationdetails.setVisible(true);
        consultationdetails.setSize(1000, 600);
        consultationdetails.setDefaultCloseOperation(3);
        JButton menu = new JButton("Menu");
        menu.setBounds(100, 500, 300, 50);
        menu.setBackground(Color.red);
        menu.setForeground(Color.WHITE);
        consultationdetails.add(menu);
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new Menu();
                } catch (IOException var3) {
                    throw new RuntimeException(var3);
                }

                consultationdetails.dispose();
            }
        });
        this.consultationdata = new String[Booking.consultations.size()][];

        for(int i = 0; i < Booking.consultations.size(); ++i) {
            Consultation con = (Consultation)Booking.consultations.get(i);
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String pt = dateFormat.format(con.getDate());
            this.consultationdata[i] = new String[]{con.getPatient().getPatientId(), con.getDoctor(), String.valueOf(pt), con.getTimeSlot(), String.valueOf(con.getCost())};
        }

        this.columnNames = new String[]{"Patient Id", "Doctor", "Date", "Time", "Cost"};
        this.model = new DefaultTableModel(this.consultationdata, this.columnNames) {
            public Class getColumnClass(int column) {
                Class returnValue;
                if (column >= 0 && column < this.getColumnCount()) {
                    returnValue = this.getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }

                return returnValue;
            }
        };
        this.table = new JTable(this.model);
        final TableRowSorter<TableModel> sorter = new TableRowSorter(this.model);
        this.table.setRowSorter(sorter);
        this.table.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                int index = ViewConsultation.this.table.getSelectedRow();
                String id = ViewConsultation.this.table.getValueAt(index, 0).toString();
                Iterator var4 = Booking.patients.iterator();

                while(var4.hasNext()) {
                    Patient pt = (Patient)var4.next();
                    if (pt.patientId.equals(id)) {
                        ViewConsultation.this.pt_Id = pt.patientId;
                        ViewConsultation.this.pt_name = pt.name;
                        ViewConsultation.this.pt_surname = pt.surName;
                        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                        ViewConsultation.this.pt_dob = dateFormat.format(pt.getDOB());
                        ViewConsultation.this.pt_phn = String.valueOf(pt.mobNo);
                    }
                }

                ViewConsultation.this.patientPopUp();
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
        JScrollPane sp = new JScrollPane(this.table);
        sp.setBounds(100, 150, 800, 300);
        consultationdetails.add(sp);
        JPanel searchpanel = new JPanel();
        searchpanel.setLayout(new FlowLayout());
        searchpanel.setBounds(100, 100, 60, 20);
        JLabel searchlabel = new JLabel("Search");
        searchlabel.setFont(new Font("Arial", 0, 15));
        searchpanel.add(searchlabel);
        consultationdetails.add(searchpanel);
        final JTextField search = new JTextField();
        search.setBounds(250, 100, 200, 40);
        consultationdetails.add(search);
        JButton filter = new JButton("Filter");
        filter.setBounds(460, 100, 70, 40);
        filter.setBackground(Color.red);
        filter.setForeground(Color.white);
        filter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = search.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter((RowFilter)null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter(text, new int[0]));
                    } catch (PatternSyntaxException var4) {
                        System.out.println("Bad regex pattern");
                    }
                }

            }
        });
        consultationdetails.add(filter);
    }

    public void patientPopUp() {
        JFrame patientDetails = new JFrame();
        patientDetails.setLayout((LayoutManager)null);
        patientDetails.setVisible(true);
        patientDetails.setSize(500, 300);
        JPanel namep = new JPanel();
        namep.setLayout(new FlowLayout());
        namep.setBounds(100, 50, 80, 25);
        JLabel name = new JLabel("Patients name:");
        namep.add(name);
        patientDetails.add(namep);
        JPanel namedetailp = new JPanel();
        namedetailp.setLayout(new FlowLayout());
        namedetailp.setBounds(240, 50, 150, 25);
        JLabel namedetail = new JLabel();
        namedetailp.add(namedetail);
        patientDetails.add(namedetailp);
        namedetail.setText(this.pt_name);
        JPanel surnamep = new JPanel();
        surnamep.setLayout(new FlowLayout());
        surnamep.setBounds(100, 75, 100, 25);
        JLabel surname = new JLabel("Patients surname:");
        surnamep.add(surname);
        patientDetails.add(surnamep);
        JPanel surnamedetailp = new JPanel();
        surnamedetailp.setLayout(new FlowLayout());
        surnamedetailp.setBounds(240, 75, 150, 25);
        JLabel surnamedetail = new JLabel();
        surnamedetailp.add(surnamedetail);
        patientDetails.add(surnamedetailp);
        surnamedetail.setText(this.pt_surname);
        JPanel dobp = new JPanel();
        dobp.setLayout(new FlowLayout());
        dobp.setBounds(100, 100, 78, 25);
        JLabel dob = new JLabel("Patients DoB:");
        dobp.add(dob);
        patientDetails.add(dobp);
        JPanel dobdetailp = new JPanel();
        dobdetailp.setLayout(new FlowLayout());
        dobdetailp.setBounds(240, 100, 150, 25);
        JLabel dobdetail = new JLabel();
        dobdetailp.add(dobdetail);
        patientDetails.add(dobdetailp);
        dobdetail.setText(this.pt_dob);
        JPanel mobilep = new JPanel();
        mobilep.setLayout(new FlowLayout());
        mobilep.setBounds(100, 125, 137, 25);
        JLabel mobile = new JLabel("Patients mobile number:");
        mobilep.add(mobile);
        patientDetails.add(mobilep);
        JPanel mobiledetailp = new JPanel();
        mobiledetailp.setLayout(new FlowLayout());
        mobiledetailp.setBounds(240, 125, 150, 25);
        JLabel mobiledetail = new JLabel();
        mobiledetailp.add(mobiledetail);
        patientDetails.add(mobiledetailp);
        mobiledetail.setText(this.pt_phn);
        JPanel patientidp = new JPanel();
        patientidp.setLayout(new FlowLayout());
        patientidp.setBounds(100, 150, 65, 25);
        JLabel patientid = new JLabel("Patients ID:");
        patientidp.add(patientid);
        patientDetails.add(patientidp);
        JPanel patientiddetailp = new JPanel();
        patientiddetailp.setLayout(new FlowLayout());
        patientiddetailp.setBounds(240, 150, 150, 25);
        JLabel patientiddetail = new JLabel();
        patientiddetailp.add(patientiddetail);
        patientDetails.add(patientiddetailp);
        patientiddetail.setText(this.pt_Id);
    }
}
