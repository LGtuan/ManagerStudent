package view;

import controller.ManagerStudentController;
import mode.City;
import mode.ManagerStudent;
import mode.Student;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class View extends JFrame {
    private JTable jTable;
    private ManagerStudent managerStudent;
    private JPanel contentPanel;
    private JButton jButton_cancel;
    private JButton jButton_add;
    private JButton jButton_render;
    private JButton jButton_save;
    private JButton jButton_remove;
    private JTextField jTextField_id;
    private JTextField jTextField_date;
    private JTextField jTextField_name;
    private JTextField jTextField_mon2;
    private JTextField jTextField_mon1;
    private JTextField jTextField_mon3;
    private ButtonGroup buttonGroup;
    private JRadioButton jRadioButton_man;
    private JRadioButton jRadioButton_woman;
    private JComboBox<String> jComboBox_city;
    private ManagerStudentController managerStudentController;
    private JButton jButtonSearch;
    private JTextField jTextFieldNameFind;
    private JComboBox<String> jComboBoxCityFind;
    private JButton jButtonEndSearch;
    private int indexRowSelected = -1;

    public View() {
        managerStudent = new ManagerStudent();
        this.setTitle("Manager Student");
        this.setBounds(0, 0, 795, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(null);

        this.setContentPane(contentPanel);
        managerStudentController = new ManagerStudentController(this);

        init();

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void init() {

        createJMenuBar();
        createPanel();
    }

    public void createPanel() {
        createPanelInfo();
        createPanelTable();
        createPanelOperation();
    }

    public void createPanelTable() {

        JPanel panelTable = new JPanel();
        panelTable.setBorder(BorderFactory.createEtchedBorder());
        panelTable.setLayout(null);
        panelTable.setBounds(10, 80, 760, 260);

        JLabel jLabelListStudent = new JLabel("List student ");
        jLabelListStudent.setFont(new Font("Arial", Font.BOLD, 15));
        jLabelListStudent.setBounds(10, 5, 150, 25);

        jTable = new JTable();
        jTable.setModel(new DefaultTableModel(new Object[][]{},
                new String[]{"ID", "Name", "City", "Date", "Sex", "Point1", "Point2", "Point3"}));

        jTable.setRowHeight(25);

        JScrollPane jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(10, 30, 740, 220);

        panelTable.add(jLabelListStudent);
        panelTable.add(jScrollPane);

        contentPanel.add(panelTable);
    }

    public void createPanelInfo() {
        JPanel panelInfo = new JPanel();
        panelInfo.setBorder(BorderFactory.createEtchedBorder());
        panelInfo.setLayout(null);
        panelInfo.setBounds(10, 10, 760, 60);

        JLabel jLabelCity = new JLabel("City : ");
        jLabelCity.setBounds(10, 10, 40, 30);
        jComboBoxCityFind = new JComboBox<>(City.list_tinh);
        jComboBoxCityFind.setSelectedIndex(-1);
        jComboBoxCityFind.setBounds(50, 12, 120, 30);

        JLabel jLabelName = new JLabel("Name : ");
        jLabelName.setBounds(200, 10, 100, 30);

        jTextFieldNameFind = new JTextField();
        jTextFieldNameFind.setBounds(250, 14, 130, 30);

        jButtonSearch = new JButton("Find Student");
        jButtonSearch.addActionListener(managerStudentController);
        jButtonSearch.setBounds(450, 10, 120, 30);

        jButtonEndSearch = new JButton("End search");
        jButtonEndSearch.addActionListener(managerStudentController);
        jButtonEndSearch.setBounds(580, 10, 100, 30);

        panelInfo.add(jLabelCity);
        panelInfo.add(jComboBoxCityFind);
        panelInfo.add(jLabelName);
        panelInfo.add(jTextFieldNameFind);
        panelInfo.add(jButtonSearch);
        panelInfo.add(jButtonEndSearch);

        contentPanel.add(panelInfo);

    }

    public void createPanelOperation() {
        JPanel panelOperation = new JPanel();
        panelOperation.setBorder(BorderFactory.createEtchedBorder());
        panelOperation.setLayout(null);
        panelOperation.setBounds(10, 350, 760, 180);

        JLabel jLabel_InfoStudent = new JLabel("INFO STUDENT");
        jLabel_InfoStudent.setFont(new Font("Arial", Font.BOLD, 15));
        jLabel_InfoStudent.setBounds(10, 0, 200, 40);

        JLabel jLabel_id = new JLabel("ID ");
        jLabel_id.setBounds(30, 40, 100, 20);

        JLabel jLabel_name = new JLabel("Name ");
        jLabel_name.setBounds(30, 60, 100, 20);

        JLabel jLabel_city = new JLabel("City");
        jLabel_city.setBounds(30, 80, 100, 20);

        JLabel jLabel_date = new JLabel("Date");
        jLabel_date.setBounds(30, 100, 100, 20);

        JLabel jLabel_sex = new JLabel("Sex");
        jLabel_sex.setBounds(400, 40, 100, 20);

        JLabel jLabel_mon1 = new JLabel("Mon1");
        jLabel_mon1.setBounds(400, 60, 100, 20);

        JLabel jLabel_mon2 = new JLabel("Mon2");
        jLabel_mon2.setBounds(400, 80, 100, 20);

        JLabel jLabel_mon3 = new JLabel("Mon3");
        jLabel_mon3.setBounds(400, 100, 100, 20);

        jTextField_id = new JTextField(ManagerStudent.ID + "");
        jTextField_id.setEditable(false);
        jTextField_id.setBounds(110, 40, 100, 20);

        jTextField_name = new JTextField();
        jTextField_name.setBounds(110, 60, 100, 20);

        jTextField_date = new JTextField();
        jTextField_date.setBounds(110, 100, 100, 20);

        jTextField_mon1 = new JTextField();
        jTextField_mon1.setBounds(470, 60, 100, 20);

        jTextField_mon2 = new JTextField();
        jTextField_mon2.setBounds(470, 80, 100, 20);

        jTextField_mon3 = new JTextField();
        jTextField_mon3.setBounds(470, 100, 100, 20);

        jComboBox_city = new JComboBox<>(City.list_tinh);
        jComboBox_city.setBounds(110, 80, 100, 20);

        jButton_add = new JButton("Add");
        jButton_add.addActionListener(managerStudentController);
        jButton_add.setBounds(20, 140, 90, 30);

        jButton_remove = new JButton("Remove");
        jButton_remove.addActionListener(managerStudentController);
        jButton_remove.setBounds(120, 140, 90, 30);

        jButton_render = new JButton("Render");
        jButton_render.addActionListener(managerStudentController);
        jButton_render.setBounds(220, 140, 90, 30);

        jButton_save = new JButton("Save");
        jButton_save.addActionListener(managerStudentController);
        jButton_save.setBounds(320, 140, 90, 30);

        jButton_cancel = new JButton("Cancel");
        jButton_cancel.addActionListener(managerStudentController);
        jButton_cancel.setBounds(420, 140, 90, 30);

        jRadioButton_man = new JRadioButton("Man");
        jRadioButton_man.setBounds(450, 40, 60, 20);
        jRadioButton_woman = new JRadioButton("Woman");
        jRadioButton_woman.setBounds(520, 40, 100, 20);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton_man);
        buttonGroup.add(jRadioButton_woman);

        panelOperation.add(jComboBox_city);

        panelOperation.add(jButton_add);
        panelOperation.add(jButton_remove);
        panelOperation.add(jButton_render);
        panelOperation.add(jButton_save);
        panelOperation.add(jButton_cancel);

        panelOperation.add(jLabel_id);
        panelOperation.add(jLabel_name);
        panelOperation.add(jLabel_city);
        panelOperation.add(jLabel_date);
        panelOperation.add(jLabel_sex);
        panelOperation.add(jLabel_mon1);
        panelOperation.add(jLabel_mon2);
        panelOperation.add(jLabel_mon3);
        panelOperation.add(jLabel_InfoStudent);

        panelOperation.add(jTextField_name);
        panelOperation.add(jTextField_id);
        panelOperation.add(jTextField_date);
        panelOperation.add(jTextField_mon1);
        panelOperation.add(jTextField_mon2);
        panelOperation.add(jTextField_mon3);

        panelOperation.add(jRadioButton_man);
        panelOperation.add(jRadioButton_woman);

        contentPanel.add(panelOperation);
    }

    public void createJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu jMenu_file = new JMenu("File");
        JMenuItem jMenuItem_open = new JMenuItem("Open");
        jMenuItem_open.addActionListener(managerStudentController);
        JMenuItem jMenuItem_save = new JMenuItem("SaveFile");
        jMenuItem_save.addActionListener(managerStudentController);
        JMenuItem jMenuItem_exit = new JMenuItem("Exit");
        jMenuItem_exit.addActionListener(managerStudentController);

        jMenu_file.add(jMenuItem_open);
        jMenu_file.add(jMenuItem_save);
        jMenu_file.addSeparator();
        jMenu_file.add(jMenuItem_exit);

        jMenuBar.add(jMenu_file);

        JMenu jMenu_about = new JMenu("About");
        JMenuItem jMenuItem_about = new JMenuItem("About me");
        jMenuItem_about.addActionListener(managerStudentController);
        jMenu_about.add(jMenuItem_about);

        jMenuBar.add(jMenu_about);

        this.setJMenuBar(jMenuBar);
    }

    public void openFile() {
        if(managerStudent.getNameFile().length()<=0) {
            JFileChooser fc = new JFileChooser();
            int value = fc.showOpenDialog(this);

            if (value == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                open(file);
            }
        }
        else{
            open(new File(managerStudent.getNameFile()));
        }
        cancelFindStudent();
    }

    public void open(File file) {
        ArrayList<Student> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student s = null;
            while ((s = (Student) ois.readObject()) != null) {
                list.add(s);
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        managerStudent.setListStudent(list);
    }

    public void exitProgram() {
        int value = JOptionPane.showConfirmDialog(this,
                "Version 1.0", "Exit", JOptionPane.YES_NO_OPTION);
        if (value == JOptionPane.YES_OPTION) System.exit(0);
    }

    public void aboutProgram() {
        JOptionPane.showConfirmDialog(this, "Version 1.0", "About", JOptionPane.OK_OPTION);
    }

    public void saveFile() {

        if (managerStudent.getNameFile().length() > 0) {
            save(managerStudent.getNameFile());
        } else {
            JFileChooser fc = new JFileChooser();

            int value = fc.showSaveDialog(this);
            if (value == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                save(file.getAbsolutePath());
            }
        }

    }

    public void save(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Student student : managerStudent.getListStudent()) {
                oos.writeObject(student);
            }
            oos.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void addStudentToTable(Student student) {
        this.managerStudent.add(student);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        String sDate = dateFormat.format(student.getDate());

        DefaultTableModel model_table = (DefaultTableModel) jTable.getModel();
        model_table.addRow(new Object[]{
                student.getId() + "",
                student.getName(),
                student.getCity().getNameCity(),
                sDate,
                (student.isSex()) ? "Man" : "Woman",
                student.getPoint1() + "",
                student.getPoint2() + "",
                student.getPoint3() + ""
        });
    }

    public void setStudentToTable(Student student) {

        this.managerStudent.update(student);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sDate = dateFormat.format(student.getDate());

        DefaultTableModel model_table = (DefaultTableModel) jTable.getModel();
        model_table.setValueAt(student.getId(), indexRowSelected, 0);
        model_table.setValueAt(student.getName(), indexRowSelected, 1);
        model_table.setValueAt(student.getCity().getNameCity(), indexRowSelected, 2);
        model_table.setValueAt(sDate, indexRowSelected, 3);
        if (student.isSex()) model_table.setValueAt("Man", indexRowSelected, 5);
        else model_table.setValueAt("Woman", indexRowSelected, 5);
        model_table.setValueAt(student.getPoint1(), indexRowSelected, 5);
        model_table.setValueAt(student.getPoint2(), indexRowSelected, 6);
        model_table.setValueAt(student.getPoint3(), indexRowSelected, 7);

    }

    public void addStudent(String s) {
        try {
            int id = Integer.parseInt(this.getjTextField_id().getText());
            String name = this.getjTextField_name().getText();
            City city = new City(this.getjComboBox_city().getSelectedIndex(),
                    City.getCity().get(this.getjComboBox_city().getSelectedIndex()).getNameCity());
            float point1 = Float.parseFloat(this.getjTextField_mon1().getText());
            float point2 = Float.parseFloat(this.getjTextField_mon2().getText());
            float point3 = Float.parseFloat(this.getjTextField_mon3().getText());
            Date date = new Date(this.getjTextField_date().getText());
            boolean isMan = true;
            System.out.println(getButtonGroup().getSelection());
            if (jRadioButton_woman.isSelected()) isMan = false;
            Student student = new Student(id, name, city, point1, point2, point3, date, isMan);

            if (this.getManagerStudent().getEventBegin().equals("Render")) {
                this.setStudentToTable(student);
            } else {
                this.addStudentToTable(student);
            }
            this.setIndexCurrentOfTable();
            this.removeAllForm();
            this.getManagerStudent().setEventBegin(s);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(this, "Can not " + s, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayStudent() {
        indexRowSelected = jTable.getSelectedRow();
        DefaultTableModel model_table = (DefaultTableModel) jTable.getModel();

        int id = Integer.parseInt(model_table.getValueAt(indexRowSelected, 0) + "");
        String name = model_table.getValueAt(indexRowSelected, 1) + "";
        City city = new City(City.getCityForName(model_table.getValueAt(indexRowSelected, 2) + ""),
                model_table.getValueAt(indexRowSelected, 2) + "");
        Date date = new Date(model_table.getValueAt(indexRowSelected, 3) + "");
        boolean sex = model_table.getValueAt(indexRowSelected, 4).equals("Man");
        float point1 = Float.parseFloat(model_table.getValueAt(indexRowSelected, 5) + "");
        float point2 = Float.parseFloat(model_table.getValueAt(indexRowSelected, 6) + "");
        float point3 = Float.parseFloat(model_table.getValueAt(indexRowSelected, 7) + "");

        jTextField_id.setText(id + "");
        jTextField_name.setText(name);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String s = dateFormat.format(date);
        jTextField_date.setText(s);
        jComboBox_city.setSelectedIndex(city.getIdCity());
        if (sex) jRadioButton_man.setSelected(true);
        else jRadioButton_woman.setSelected(true);
        jTextField_mon1.setText(point1 + "");
        jTextField_mon2.setText(point2 + "");
        jTextField_mon3.setText(point3 + "");
    }

    public void removeAllForm() {
        jTextField_date.setText("");
        jTextField_id.setText(ManagerStudent.ID + "");
        jTextField_mon1.setText("");
        jTextField_mon2.setText("");
        jTextField_mon3.setText("");
        jTextField_name.setText("");
        buttonGroup.clearSelection();
        jComboBox_city.setSelectedIndex(-1);
    }

    public void remoStudent() {
        DefaultTableModel model_table = (DefaultTableModel) jTable.getModel();
        int id = Integer.parseInt(model_table.getValueAt(indexRowSelected, 0) + "");
        managerStudent.remove(id);
        model_table.removeRow(indexRowSelected);
        for (; id < ManagerStudent.ID; id++) {
            model_table.setValueAt(id + "", id - 1, 0);
        }
        indexRowSelected = -1;
    }

    public void findStudent() {
        cancelFindStudent();
        int indexCity = jComboBoxCityFind.getSelectedIndex();
        ArrayList<Integer> listMustRemove = new ArrayList<>();

        DefaultTableModel model_table = (DefaultTableModel) jTable.getModel();
        String nameStudent = jTextFieldNameFind.getText();

        String nameCity = (indexCity >= 0) ? City.getCityForId(indexCity) : "";

        for (int i = model_table.getRowCount() - 1; i >= 0; i--) {
            if (nameCity.equals("") && nameStudent.equals("")) listMustRemove.add(i);
            else if (nameCity.equals("")) {
                if ((model_table.getValueAt(i, 1) + "").indexOf(nameStudent) == -1)
                    listMustRemove.add(i);
            } else if (nameStudent.equals("")) {
                if (!nameCity.equals("" + model_table.getValueAt(i, 2)))
                    listMustRemove.add(i);
            }
        }

        for (Integer integer : listMustRemove) {
            model_table.removeRow(integer);
        }
    }

    public void removeAllElementOfTable() {
        DefaultTableModel model_table = (DefaultTableModel) jTable.getModel();
        while (true) {
            int row = model_table.getRowCount();
            if (row == 0) break;
            else model_table.removeRow(0);
        }
    }

    public void cancelFindStudent() {
        removeAllElementOfTable();
        for (int i = 0; i < managerStudent.getListStudent().size(); i++) {
            addStudentToTable(managerStudent.getListStudent().get(i));
        }
    }

    public void setIndexCurrentOfTable() {
        indexRowSelected = -1;
    }

    public JRadioButton getjRadioButton_man() {
        return jRadioButton_man;
    }

    public JRadioButton getjRadioButton_woman() {
        return jRadioButton_woman;
    }

    public int getIndexRowSelected() {
        return indexRowSelected;
    }

    public JTable getjTable() {
        return jTable;
    }

    public ManagerStudent getManagerStudent() {
        return managerStudent;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JButton getjButton_cancel() {
        return jButton_cancel;
    }

    public JButton getjButton_add() {
        return jButton_add;
    }

    public JButton getjButton_render() {
        return jButton_render;
    }

    public JButton getjButton_save() {
        return jButton_save;
    }

    public JButton getjButton_remove() {
        return jButton_remove;
    }

    public JTextField getjTextField_id() {
        return jTextField_id;
    }

    public JTextField getjTextField_date() {
        return jTextField_date;
    }

    public JTextField getjTextField_name() {
        return jTextField_name;
    }

    public JTextField getjTextField_mon2() {
        return jTextField_mon2;
    }

    public JTextField getjTextField_mon1() {
        return jTextField_mon1;
    }

    public JTextField getjTextField_mon3() {
        return jTextField_mon3;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public JComboBox<String> getjComboBox_city() {
        return jComboBox_city;
    }
}
