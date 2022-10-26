package studentList;

import bai7.Main;
import bai7.Student;
import editStudent.EditStudentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {

    public ListView<Student> listView;

    public static ObservableList<Student> ls = FXCollections.observableArrayList();

    public static ObservableList<Student> getLs() {
        return ls;
    }

    public static void setLs(ObservableList<Student> ls) {
        StudentListController.ls = ls;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(ls);
        listView.refresh();
    }

    public void addStudent(ActionEvent actionEvent) throws Exception {
        Parent createForm = FXMLLoader.load(getClass().getResource("../addStudent/addStudent.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }

    private boolean status = false;
    public void sortByName(ActionEvent actionEvent) {
        status = !status;
        Collections.sort(getLs(), new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (!status) {
                    return o1.getName().compareTo(o2.getName());
                }
                return o2.getName().compareTo(o1.getName());
            }
        });
    }

    public void sortByMark(ActionEvent actionEvent) {
        status = !status;
        Collections.sort(getLs(), new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (!status) {
                    return o1.getMark() - o2.getMark();
                }
                return o2.getMark() - o1.getMark();
            }
        });
    }

    public void edit(ActionEvent actionEvent) throws Exception{

        EditStudentController.editedStudent = listView.getSelectionModel().getSelectedItem();

        Parent createForm = FXMLLoader.load(getClass().getResource("../editStudent/editStudent.fxml"));
        Scene sc = new Scene(createForm,800,600);
        Main.rootStage.setScene(sc);
    }
}
