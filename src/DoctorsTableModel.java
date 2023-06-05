//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DoctorsTableModel extends AbstractTableModel {
    private List<Doctor> doctors;
    private final String[] columnNames = new String[]{"Name", "Surname", "Date of Birth", "Mobile Number", "Medical License Number", "Specialisation"};

    public DoctorsTableModel(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void updateDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
        this.fireTableDataChanged();
    }

    public Doctor getDoctorAt(int row) {
        return (Doctor)this.doctors.get(row);
    }

    public int getRowCount() {
        return this.doctors.size();
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public String getColumnName(int columnIndex) {
        return this.columnNames[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor doctor = (Doctor)this.doctors.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return doctor.getName();
            case 1:
                return doctor.getSurName();
            case 2:
                return doctor.getDOB();
            case 3:
                return doctor.getMobNo();
            case 4:
                return doctor.getLicenceNumber();
            case 5:
                return doctor.getSpecialisation();
            default:
                return null;
        }
    }
}
