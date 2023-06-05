//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import jcalendar.jcalendar.src.com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

public class Booking {
    public static ArrayList<Consultation> consultations = new ArrayList();
    public static ArrayList<Patient> patients = new ArrayList();
    DoctorDetails doctorDetails = new DoctorDetails();

    public Booking() {
        final JFrame appointmentdetails = new JFrame();
        JPanel panelheader = new JPanel();
        panelheader.setLayout(new FlowLayout());
        panelheader.setBackground(Color.blue);
        panelheader.setBounds(0, 0, 1000, 60);
        JLabel header = new JLabel("Appointment Details");
        header.setForeground(Color.white);
        header.setFont(new Font("Arial", 0, 30));
        panelheader.add(header);
        appointmentdetails.add(panelheader);
        JButton menu = new JButton("Menu");
        menu.setBounds(100, 500, 300, 50);
        menu.setBackground(Color.red);
        menu.setForeground(Color.WHITE);
        appointmentdetails.add(menu);
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new Menu();
                } catch (IOException var3) {
                    throw new RuntimeException(var3);
                }

                appointmentdetails.dispose();
            }
        });
        JPanel namep = new JPanel();
        namep.setLayout(new FlowLayout());
        namep.setBounds(100, 150, 80, 60);
        JLabel name = new JLabel("Patients name:");
        namep.add(name);
        appointmentdetails.add(namep);
        JPanel namelabelp = new JPanel();
        namelabelp.setLayout(new FlowLayout());
        namelabelp.setBounds(250, 180, 130, 30);
        final JLabel namelabel = new JLabel();
        namelabel.setFont(new Font("Arial", 0, 10));
        namelabel.setForeground(Color.red);
        namelabelp.add(namelabel);
        appointmentdetails.add(namelabelp);
        JPanel surnamep = new JPanel();
        surnamep.setLayout(new FlowLayout());
        surnamep.setBounds(100, 210, 100, 60);
        JLabel surname = new JLabel("Patients surname:");
        surnamep.add(surname);
        appointmentdetails.add(surnamep);
        JPanel surnamelabelp = new JPanel();
        surnamelabelp.setLayout(new FlowLayout());
        surnamelabelp.setBounds(250, 240, 130, 30);
        final JLabel surnamelabel = new JLabel();
        surnamelabel.setFont(new Font("Arial", 0, 10));
        surnamelabel.setForeground(Color.red);
        surnamelabelp.add(surnamelabel);
        appointmentdetails.add(surnamelabelp);
        JPanel DoBp = new JPanel();
        DoBp.setLayout(new FlowLayout());
        DoBp.setBounds(100, 270, 120, 60);
        JLabel DoB = new JLabel("Patients date of birth:");
        DoBp.add(DoB);
        appointmentdetails.add(DoBp);
        JPanel doblabelp = new JPanel();
        doblabelp.setLayout(new FlowLayout());
        doblabelp.setBounds(250, 300, 130, 30);
        final JLabel doblabel = new JLabel();
        doblabel.setFont(new Font("Arial", 0, 10));
        doblabel.setForeground(Color.red);
        doblabelp.add(doblabel);
        appointmentdetails.add(doblabelp);
        JPanel nump = new JPanel();
        nump.setLayout(new FlowLayout());
        nump.setBounds(100, 330, 135, 60);
        JLabel num = new JLabel("Patients phone number:");
        nump.add(num);
        appointmentdetails.add(nump);
        JPanel numlabelp = new JPanel();
        numlabelp.setLayout(new FlowLayout());
        numlabelp.setBounds(250, 360, 130, 30);
        final JLabel numlabel = new JLabel();
        numlabel.setFont(new Font("Arial", 0, 10));
        numlabel.setForeground(Color.red);
        numlabelp.add(numlabel);
        appointmentdetails.add(numlabelp);
        JPanel idp = new JPanel();
        idp.setLayout(new FlowLayout());
        idp.setBounds(100, 390, 65, 60);
        JLabel id = new JLabel("Patients ID:");
        idp.add(id);
        appointmentdetails.add(idp);
        JPanel idlabelp = new JPanel();
        idlabelp.setLayout(new FlowLayout());
        idlabelp.setBounds(250, 410, 130, 30);
        final JLabel idlabel = new JLabel();
        idlabel.setFont(new Font("Arial", 0, 10));
        idlabel.setForeground(Color.red);
        idlabelp.add(idlabel);
        appointmentdetails.add(idlabelp);
        final JTextField patientName = new JTextField();
        patientName.setBounds(250, 150, 200, 40);
        final JTextField patientSurname = new JTextField();
        patientSurname.setBounds(250, 210, 200, 40);
        final JDateChooser patientDob = new JDateChooser();
        patientDob.setBounds(250, 270, 200, 40);
        final JTextField patientMobNo = new JTextField();
        patientMobNo.setBounds(250, 330, 200, 40);
        final JTextField patientId = new JTextField();
        patientId.setBounds(250, 390, 200, 40);
        appointmentdetails.add(patientName);
        appointmentdetails.add(patientSurname);
        appointmentdetails.add(patientDob);
        appointmentdetails.add(patientMobNo);
        appointmentdetails.add(patientId);
        JPanel Docp = new JPanel();
        Docp.setLayout(new FlowLayout());
        Docp.setBounds(500, 150, 80, 60);
        JLabel docNamelabel = new JLabel("Doctors name:");
        Docp.add(docNamelabel);
        appointmentdetails.add(Docp);
        JPanel DocSurnamep = new JPanel();
        DocSurnamep.setLayout(new FlowLayout());
        DocSurnamep.setBounds(500, 210, 100, 60);
        JLabel DocSurnamelabel = new JLabel("Appointment Date:");
        DocSurnamep.add(DocSurnamelabel);
        appointmentdetails.add(DocSurnamep);
        JPanel appointmentlabelp = new JPanel();
        appointmentlabelp.setLayout(new FlowLayout());
        appointmentlabelp.setBounds(650, 240, 150, 30);
        final JLabel appointmentlabel = new JLabel();
        appointmentlabel.setFont(new Font("Arial", 0, 10));
        appointmentlabel.setForeground(Color.red);
        appointmentlabelp.add(appointmentlabel);
        appointmentdetails.add(appointmentlabelp);
        JPanel timep = new JPanel();
        timep.setLayout(new FlowLayout());
        timep.setBounds(495, 270, 120, 60);
        JLabel time = new JLabel("Appointment Time:");
        timep.add(time);
        appointmentdetails.add(timep);
        JPanel detailp = new JPanel();
        detailp.setLayout(new FlowLayout());
        detailp.setBounds(490, 330, 120, 60);
        JLabel detail = new JLabel("Patients details:");
        detailp.add(detail);
        appointmentdetails.add(detailp);
        JPanel detailslabelp = new JPanel();
        detailslabelp.setLayout(new FlowLayout());
        detailslabelp.setBounds(650, 360, 150, 30);
        final JLabel detailslabel = new JLabel();
        detailslabel.setFont(new Font("Arial", 0, 10));
        detailslabel.setForeground(Color.red);
        detailslabelp.add(detailslabel);
        appointmentdetails.add(detailslabelp);
        List<String> s1 = new ArrayList();

        for(int i = 0; i < this.doctorDetails.data.length; ++i) {
            String var10001 = this.doctorDetails.data[i][0];
            s1.add(var10001 + " " + this.doctorDetails.data[i][1]);
        }

        String[] names = new String[this.doctorDetails.data.length];

        for(int i = 0; i < s1.size(); ++i) {
            names[i] = (String)s1.get(i);
        }

        final JComboBox docName = new JComboBox(names);
        docName.setBounds(650, 150, 200, 40);
        appointmentdetails.add(docName);
        final JDateChooser consultationDate = new JDateChooser();
        consultationDate.setBounds(650, 210, 200, 40);
        appointmentdetails.add(consultationDate);
        String[] s2 = new String[]{"9:00AM", "10:00AM", "11:00AM", "12:00AM", "02:00PM", "03:00PM", "04:00PM", "05:00PM"};
        final JComboBox consultationTime = new JComboBox(s2);
        consultationTime.setBounds(650, 270, 200, 40);
        appointmentdetails.add(consultationTime);
        final JTextField patientDetails = new JTextField();
        patientDetails.setBounds(650, 330, 200, 40);
        appointmentdetails.add(patientDetails);
        JButton submit = new JButton("Request");
        submit.setBounds(650, 400, 100, 30);
        submit.setBackground(Color.blue);
        submit.setForeground(Color.WHITE);
        appointmentdetails.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (patientName.getText().length() <= 0 & patientSurname.getText().length() <= 0 & patientDob.getDate() == null & patientMobNo.getText().length() <= 0 & patientId.getText().length() <= 0 & patientDetails.getText().length() <= 0 & consultationDate.getDate() == null) {
                    namelabel.setText("name field is empty");
                    surnamelabel.setText("surname field is empty");
                    doblabel.setText("DoB field is empty");
                    numlabel.setText("Number field is empty");
                    idlabel.setText("patient id field is empty");
                    appointmentlabel.setText("appointment date field is empty");
                    detailslabel.setText("Details field is empty");
                } else if (patientSurname.getText().length() <= 0 & patientDob.getDate() == null & patientMobNo.getText().length() <= 0 & patientId.getText().length() <= 0 & patientDetails.getText().length() <= 0 & consultationDate.getDate() == null) {
                    surnamelabel.setText("surname field is empty");
                    doblabel.setText("DoB field is empty");
                    numlabel.setText("Number field is empty");
                    idlabel.setText("patient id field is empty");
                    appointmentlabel.setText("appointment date field is empty");
                    detailslabel.setText("Details field is empty");
                } else if (patientDob.getDate() == null & patientMobNo.getText().length() <= 0 & patientId.getText().length() <= 0 & patientDetails.getText().length() <= 0 & consultationDate.getDate() == null) {
                    doblabel.setText("DoB field is empty");
                    numlabel.setText("Number field is empty");
                    idlabel.setText("patient id field is empty");
                    appointmentlabel.setText("appointment date field is empty");
                    detailslabel.setText("Details field is empty");
                } else if (patientMobNo.getText().length() <= 0 & patientId.getText().length() <= 0 & patientDetails.getText().length() <= 0 & consultationDate.getDate() == null) {
                    numlabel.setText("Number field is empty");
                    idlabel.setText("patient id field is empty");
                    appointmentlabel.setText("appointment date field is empty");
                    detailslabel.setText("Details field is empty");
                } else if (patientId.getText().length() <= 0 & patientDetails.getText().length() <= 0 & consultationDate.getDate() == null) {
                    idlabel.setText("patient id field is empty");
                    appointmentlabel.setText("appointment date field is empty");
                    detailslabel.setText("Details field is empty");
                } else if (patientDetails.getText().length() <= 0 & consultationDate.getDate() == null) {
                    appointmentlabel.setText("appointment date field is empty");
                    detailslabel.setText("Details field is empty");
                } else if (consultationDate.getDate() == null) {
                    detailslabel.setText("Details field is empty");
                } else {
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
                    int cost = 15;
                    Iterator var4 = Booking.patients.iterator();

                    while(var4.hasNext()) {
                        Patient pat = (Patient)var4.next();
                        if (pat.getPatientId().equals(patientId.getText())) {
                            cost = 25;
                        }
                    }

                    Date conDate = consultationDate.getDate();
                    String consultationDateString = dateFormatter.format(conDate);

                    Date parsedConsultationDate;
                    try {
                        parsedConsultationDate = dateFormatter.parse(consultationDateString);
                    } catch (ParseException var27) {
                        throw new RuntimeException(var27);
                    }

                    Date patientDobS = patientDob.getDate();
                    String dateString = dateFormatter.format(patientDobS);

                    Date parsedPatientDob;
                    try {
                        parsedPatientDob = dateFormatter.parse(dateString);
                    } catch (ParseException var26) {
                        throw new RuntimeException(var26);
                    }

                    Patient patient = new Patient(patientName.getText(), patientSurname.getText(), parsedPatientDob, Long.parseLong(patientMobNo.getText()), patientId.getText());
                    boolean patientAvailable = false;
                    if (Booking.patients.size() == 0) {
                        Booking.patients.add(patient);
                        System.out.println("hello");
                    } else {
                        Iterator var12 = Booking.patients.iterator();

                        while(var12.hasNext()) {
                            Patient patx = (Patient)var12.next();
                            if (!patx.getPatientId().equals(patientId.getText())) {
                                patientAvailable = true;
                                System.out.println("Helllo - hello - hello");
                            }
                        }

                        if (patientAvailable) {
                            Booking.patients.add(patient);
                            System.out.println("Helllo - hello");
                        }
                    }

                    Object selectedDocName = docName.getSelectedItem();
                    String selectedDoctorString = (String)selectedDocName;
                    Object selectedTime = consultationTime.getSelectedItem();
                    String selectedTimeString = (String)selectedTime;
                    Consultation consultation = new Consultation(parsedConsultationDate, selectedTimeString, (double)cost, patientDetails.getText(), selectedDoctorString, patient);
                    if (Booking.consultations.size() == 0) {
                        Booking.consultations.add(consultation);
                    } else {
                        Iterator<Consultation> iterator = Booking.consultations.iterator();
                        boolean shouldAdd = true;
                        boolean shouldRandom = false;
                        String doctorName = null;
                        String availableDoctorName = null;

                        while(iterator.hasNext()) {
                            Consultation con = (Consultation)iterator.next();
                            if (con.getDoctor().equals(docName.getSelectedItem()) & con.getDate().equals(parsedConsultationDate) & con.getTimeSlot().equals(consultationTime.getSelectedItem())) {
                                shouldAdd = false;
                                List<String> availableDoctors = Booking.this.getAvailableDoctors(parsedConsultationDate, selectedTimeString);
                                if (availableDoctors.size() == 0) {
                                    System.out.println("no doc");
                                } else {
                                    Random random = new Random();
                                    int index = random.nextInt(availableDoctors.size());
                                    availableDoctorName = (String)availableDoctors.get(index);
                                    shouldRandom = true;
                                }
                                break;
                            }
                        }

                        if (shouldAdd) {
                            Booking.consultations.add(consultation);
                        }

                        if (shouldRandom) {
                            Booking.consultations.add(new Consultation(parsedConsultationDate, selectedTimeString, (double)cost, patientDetails.getText(), availableDoctorName, patient));
                        }
                    }
                }

            }
        });
        appointmentdetails.setLayout((LayoutManager)null);
        appointmentdetails.setVisible(true);
        appointmentdetails.setSize(1000, 600);
        appointmentdetails.setDefaultCloseOperation(3);
    }

    public List<String> getAvailableDoctors(Date date, String time) {
        List<String> availableDoctors = new ArrayList();
        Iterator var4 = WestminsterSkinConsultationManager.doctors.iterator();

        while(var4.hasNext()) {
            Doctor doctor = (Doctor)var4.next();
            boolean available = true;
            Iterator var7 = consultations.iterator();

            while(var7.hasNext()) {
                Consultation consultation = (Consultation)var7.next();
                if (consultation.getDoctor().equals(doctor.name + " " + doctor.surName) & consultation.getDate().equals(date) & consultation.getTimeSlot().equals(time)) {
                    available = false;
                    break;
                }
            }

            if (available) {
                availableDoctors.add(doctor.name + " " + doctor.surName);
            }
        }

        return availableDoctors;
    }
}
