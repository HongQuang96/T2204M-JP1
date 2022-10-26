package bai6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Collections;
import java.util.Comparator;

public class StudentController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;
    public ListView<Student> listView;
    private boolean sortOrder = true;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    public void addStudent(String name, String email, Integer mark) {
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
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            Integer mark = Integer.parseInt(txtMark.getText());
            if(mark < 0 || mark > 10) throw new Exception("Invalid mark");

            addStudent(name, email, mark);
            //Clear textField after submit
            txtName.clear();
            txtEmail.clear();
            txtMark.clear();

            listView.setItems(studentList);
            listView.refresh();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }

    public void sortByName(ActionEvent actionEvent) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortOrder? o1.getName().compareTo(o2.getName()) : o2.getName().compareTo(o1.getName());
            }
        });
        sortOrder = !sortOrder;
    }

    public void sortByMark(ActionEvent actionEvent) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return sortOrder? o1.getMark() - o2.getMark() : o2.getMark() - o1.getMark();
            }
        });
        sortOrder = !sortOrder;
    }
}