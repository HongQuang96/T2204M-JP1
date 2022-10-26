package addStudent;

import bai7.Main;
import bai7.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import static studentList.StudentListController.ls;

public class AddStudentController {

    public void backToListPage(ActionEvent event) throws Exception{
        Parent listScene = FXMLLoader.load(getClass().getResource("../studentList/studentList.fxml"));
        Scene sc = new Scene(listScene,800,600);
        Main.rootStage.setScene(sc);
    }

    public TextField txtName;
    public TextField txtEmail;
    public TextField txtMark;



    public void submit(ActionEvent event) throws Exception{
        // thêm sinh viên
        try{
            String name = txtName.getText();
            String email = txtEmail.getText();
            int mark = Integer.parseInt(txtMark.getText());
            if(mark < 0 || mark > 10)
                throw new Exception("Vui lòng nhập điểm trong khoảng 0 -> 10");
            Student ms = new Student(name,email,mark);
            for (Student mark_student : ls){
                if (mark_student.getName().equals(name)){
                    throw new Exception("bạn nhập trùng tên");

                }
            }
            ls.add(ms);
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!!");
            alert.setHeaderText(e.getMessage());
            alert.show();
        };

        backToListPage(null);

    }

}
