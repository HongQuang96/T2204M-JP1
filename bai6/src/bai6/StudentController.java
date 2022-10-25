package bai6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.Comparator;

public class StudentController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ListView listView;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    public void addStudent(String name, String email, int mark) {
        for (Student s: studentList) {
            if (s.getName().equals(name)) {
                s.setEmail(email);
                s.setMark(mark);
                return;
            }
        }
        studentList.add(new Student(name, email, mark));
    }

    public void submit(ActionEvent actionEvent) {
        String name = txtName.getText();
        String email = txtEmail.getText();
        int mark = Integer.parseInt(txtMark.getText());

        addStudent(name, email, mark);
        print();
    }

    public void print() {
        listView.setItems(studentList);
        listView.refresh();
    }

    public boolean sortOrder = false;
    public void sortByAlphabet(ActionEvent actionEvent) {
        Comparator<Student> cp;
        if(sortOrder) {
            cp = (o1, o2) -> {
                return o1.getName().compareTo(o2.getName());
            };
        } else {
            cp = (o1, o2) -> {
                return o2.getName().compareTo(o1.getName());
            };
        }
        Collections.sort(studentList, cp);
        sortOrder = !sortOrder;
    }

    public void sortByMark(ActionEvent actionEvent) {
        Comparator<Student> cp;
        if(sortOrder) {
            cp = (o1, o2) -> {
                return o1.getMark() - o2.getMark();
            };
        } else {
            cp = (o1, o2) -> {
                return o2.getMark() - o1.getMark();
            };
        }
        Collections.sort(studentList, cp);
        sortOrder = !sortOrder;
    }
}