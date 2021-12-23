package mode;

import java.util.ArrayList;

public class ManagerStudent {
    public static int ID = 1;

    private ArrayList<Student> listStudent;
    private String eventBegin;
    private String nameFile;

    public ManagerStudent(){
        nameFile = "E:/GameJava/GameMineSweeper/dataStudent.txt";
        eventBegin = "";
        listStudent = new ArrayList<>();
    }

    public ManagerStudent(ArrayList<Student> listStudent){
        this.listStudent = listStudent;
    }

    public void remove(Student student){

        listStudent.remove(student);
    }

    public void add(Student student){
        if(!listStudent.contains(student)) {
            listStudent.add(student);
            ID++;
        }
    }

    public void remove(int id){
        for (int i =0;i<listStudent.size();i++){
            if(listStudent.get(i).getId() == id){
                listStudent.remove(i);
                break;
            }
        }
        resetId();
        ID--;
    }

    public void resetId(){
        for(int i = 0;i<listStudent.size();i++){
            listStudent.get(i).setId(i+1);
        }
    }

    public void update(Student student){
        for (int i = 0;i<listStudent.size();i++) {
            if(listStudent.get(i).getId() == student.getId()){
                listStudent.set(i,student);
            }

        }
    }

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public String getEventBegin() {
        return eventBegin;
    }

    public void setEventBegin(String eventBegin) {
        this.eventBegin = eventBegin;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        ManagerStudent.ID = ID;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
}
