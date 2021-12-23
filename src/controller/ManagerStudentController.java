package controller;

import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerStudentController implements ActionListener {

    private View view;

    public ManagerStudentController(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Remove")) {
            if(view.getIndexRowSelected()!=-1) {
                int option = JOptionPane.showConfirmDialog(view,"You sure want remove this student","REMOVE",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION) view.remoStudent();
                view.removeAllForm();
                view.getManagerStudent().setEventBegin(s);
            }
        } else if (s.equals("Add")) {
            view.removeAllForm();
            view.getManagerStudent().setEventBegin(s);
        } else if (s.equals("Save")) {
            view.addStudent(s);

        } else if (s.equals("Cancel")) {
            view.removeAllForm();
            view.getManagerStudent().setEventBegin(s);
        } else if (s.equals("Render")) {
            if(view.getjTable().getSelectedRow()!=-1) {
                view.displayStudent();
                view.getManagerStudent().setEventBegin(s);
            }
        }
        else if(s.equals("Find Student")){
            view.findStudent();
        }else if(s.equals("End search")){
            view.cancelFindStudent();
        }
        else if(s.equals("Open")){
            view.openFile();
        }else if(s.equals("Exit")){
            view.exitProgram();
        }else if(s.equals("About me")){
            view.aboutProgram();
        }else if(s.equals("SaveFile")){
            view.saveFile();
        }

    }
}
