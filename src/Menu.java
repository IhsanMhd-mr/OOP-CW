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
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
    public Menu() throws IOException {
        final JFrame menuFrame = new JFrame();
        menuFrame.setLayout((LayoutManager)null);
        menuFrame.setVisible(true);
        menuFrame.setSize(1000, 600);
        menuFrame.getContentPane().setBackground(Color.BLUE);
        menuFrame.setDefaultCloseOperation(3);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBounds(25, 50, 900, 40);
        panel.setBackground(Color.yellow);
        JLabel header = new JLabel("Westminster Skin Consultation Center");
        header.setForeground(Color.red);
        header.setFont(new Font("Arial", 0, 30));
        panel.add(header);
        JButton viewDoctor = new JButton("View Doctor details");
        viewDoctor.setBounds(350, 200, 300, 50);
        viewDoctor.setBackground(Color.red);
        viewDoctor.setForeground(Color.WHITE);
        viewDoctor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DoctorDetails();
                menuFrame.dispose();
            }
        });
        JButton Book = new JButton("Book an Appointment");
        Book.setBounds(350, 300, 300, 50);
        Book.setBackground(Color.red);
        Book.setForeground(Color.WHITE);
        Book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Booking();
                menuFrame.dispose();
            }
        });
        JButton viewConsult = new JButton("View Consultation Details");
        viewConsult.setBounds(350, 400, 300, 50);
        viewConsult.setBackground(Color.red);
        viewConsult.setForeground(Color.WHITE);
        viewConsult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ViewConsultation();
                menuFrame.dispose();
            }
        });
        menuFrame.add(panel);
        menuFrame.add(viewDoctor);
        menuFrame.add(Book);
        menuFrame.add(viewConsult);
    }

    public void loadconsultationdata() throws IOException {
        try {
            FileInputStream fin = new FileInputStream("cwconsultation.txt");
            ObjectInputStream objin = new ObjectInputStream(fin);

            while(true) {
                try {
                    Consultation d = (Consultation)objin.readObject();
                    Booking.consultations.add(d);
                } catch (ClassNotFoundException | IOException var4) {
                    break;
                }
            }
        } catch (EOFException var5) {
            System.out.println("Save data not available");
        }

    }

    public void loadpatientdata() throws IOException {
        try {
            FileInputStream fin = new FileInputStream("cwpatient.txt");
            ObjectInputStream objin = new ObjectInputStream(fin);

            while(true) {
                try {
                    Patient d = (Patient)objin.readObject();
                    Booking.patients.add(d);
                } catch (ClassNotFoundException | IOException var4) {
                    break;
                }
            }
        } catch (EOFException var5) {
            System.out.println("Save data not available");
        }

    }
}
