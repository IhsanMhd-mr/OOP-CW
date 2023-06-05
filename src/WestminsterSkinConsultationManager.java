//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public static ArrayList doctors;
    private final Scanner scanner;
    private static final int Max_Doctors = 10;

    public WestminsterSkinConsultationManager() {
        doctors = new ArrayList();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loaddata();

        while(true) {
            while(true) {
                boolean stop = false;
                System.out.println("\n------------------------MENU-----------------------\n---------------------------------------------------\n A: Add a new doctor\n D: Delete a doctor\n P: Print the list of the doctors\n S: Save in a file\n G: Open GUI\n Q: Quit\n---------------------------------------------------\n");
                System.out.print("Select option : ");
                String optionMenu = input.nextLine().toUpperCase();
                if (optionMenu.equals("A")) {
                    manager.addDoctor();
                } else if (optionMenu.equals("D")) {
                    manager.removeDoctor();
                } else if (optionMenu.equals("P")) {
                    manager.printDoctor();
                } else if (optionMenu.equals("S")) {
                    manager.savedata();
                } else if (optionMenu.equals("G")) {
                    new Menu();
                } else {
                    if (optionMenu.equals("Q")) {
                        return;
                    }

                    System.out.println("Entered input is not valid");
                }
            }
        }
    }

    public void addDoctor() {
        if (doctors.size() >= 10) {
            System.out.println("Sorry, Max reach");
        } else {
            System.out.println("ENTER NEW DOCTOR DETAILS");
            System.out.println("First name: ");
            String name = this.scanner.nextLine().toUpperCase();
            System.out.println("Surname: ");
            String sName = this.scanner.nextLine().toUpperCase();

            Date dob;
            while(true) {
                System.out.println("Date of Birth (MM/dd/yyyy) : ");
                String dateString = this.scanner.nextLine();
                SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

                try {
                    dob = dateFormatter.parse(dateString);
                    break;
                } catch (ParseException var10) {
                    System.out.println("Error : Invalid date format.");
                }
            }

            while(true) {
                Pattern mobileNumberPattern = Pattern.compile("^[0-9]{9}$");
                System.out.println("Mobile Number : ");
                String docSpecialisation = this.scanner.nextLine();
                Matcher matcher = mobileNumberPattern.matcher(docSpecialisation);
                if (matcher.matches()) {
                    long mobNo = Long.parseLong(docSpecialisation);

                    String mLicence;
                    boolean mLicenceAvailable;
                    do {
                        System.out.println("Medical Licence Number : ");
                        mLicence = this.scanner.nextLine();
                        mLicenceAvailable = true;
                        Iterator var14 = doctors.iterator();

                        while(var14.hasNext()) {
                            Doctor dIndex = (Doctor)var14.next();
                            if (dIndex.getLicenceNumber().equals(mLicence)) {
                                System.out.println("This Medical Licence Number is Already Used");
                                mLicenceAvailable = false;
                                break;
                            }
                        }
                    } while(!mLicenceAvailable);

                    System.out.println("Specialisation  : ");
                    docSpecialisation = this.scanner.nextLine();
                    Doctor doctorDetails = new Doctor(name, sName, dob, mobNo, mLicence, docSpecialisation);
                    doctors.add(doctorDetails);
                    System.out.println("data added");
                    return;
                }

                System.out.println("Error : Invalid Mobile Number Format. ");
            }
        }
    }

    public void removeDoctor() {
        System.out.println("ENTER DOCTOR'S DETAILS TO REMOVE");
        System.out.println("Medical Licence Number : ");
        String dmLicence = this.scanner.nextLine();
        Doctor doctorDelete = null;
        Iterator var4 = doctors.iterator();

        label35:
        while(var4.hasNext()) {
            Doctor dIndex = (Doctor)var4.next();
            if (dIndex.getLicenceNumber().equals(dmLicence)) {
                System.out.println("VERIFY DOCTOR'S DETAILS TO DELETE");
                System.out.println("First name: " + dIndex.getName());
                System.out.println("Surname: " + dIndex.getSurName());
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String dobSimple = dateFormat.format(dIndex.getDOB());
                System.out.println("Date of Birth : " + dobSimple);
                System.out.println("Mobile Number : " + dIndex.getMobNo());
                System.out.println("Specialisation  : " + dIndex.getSpecialisation());

                while(true) {
                    System.out.println();
                    System.out.println("DO YOU WANT TO DELETE THIS DOCTOR :\n        ---------------------------------------------------\n         Y: Yes\n         N: No\n        ---------------------------------------------------\n");
                    System.out.print("Select option : ");
                    String yORn = this.scanner.next().toUpperCase();
                    if (yORn.equals("Y") || yORn.equals("N")) {
                        if (yORn.equals("Y")) {
                            doctorDelete = dIndex;
                        }
                        break label35;
                    }

                    System.out.println("Wrong input... Try again...");
                }
            }
        }

        if (doctorDelete == null) {
            System.out.println("No doc found");
        } else {
            doctors.remove(doctorDelete);
            System.out.println("Deleted");
        }

    }

    public void printDoctor() {
        Iterator var1 = doctors.iterator();

        while(var1.hasNext()) {
            Doctor dn = (Doctor)var1.next();
            System.out.println("Name: " + dn.getName());
            System.out.println("Surname: " + dn.getSurName());
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String dobSimple = dateFormat.format(dn.getDOB());
            System.out.println("Date of birth: " + dobSimple);
            System.out.println("Mobile Number : " + dn.getMobNo());
        }

    }

    public void savedata() throws IOException {
        File file = new File("cw.txt");
        FileOutputStream fout = new FileOutputStream(file, false);
        ObjectOutputStream objout = new ObjectOutputStream(fout);
        Iterator it = doctors.iterator();

        while(it.hasNext()) {
            Doctor doctornew = (Doctor)it.next();
            objout.writeObject(doctornew);
        }

    }

    public void loaddata() throws IOException {
        try {
            FileInputStream fin = new FileInputStream("cw.txt");
            ObjectInputStream objin = new ObjectInputStream(fin);

            while(true) {
                try {
                    Doctor d = (Doctor)objin.readObject();
                    doctors.add(d);
                } catch (ClassNotFoundException | IOException var4) {
                    break;
                }
            }
        } catch (EOFException var5) {
            System.out.println("Save data not available");
        }

    }
}
