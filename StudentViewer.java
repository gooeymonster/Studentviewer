/*@author Daniel Ali
@version 1.0
@since 4/7/2019
@param main
Instructor: Dr. Macpherson
Class: Programming II, RSU
Program: In this program, a file called students.bin has data about a certain student read to it. Code is then
added that allows the user to write new student data to the .bin file, along with modifying current data and
scrolling through the file. Much of this is done using a graphical user interface created with JavaFX.*/

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.*;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.util.Scanner;



public class StudentViewer extends Application {
    //Textfield variables for different data are created.
    private TextField tffname = new TextField();
    private TextField tflname = new TextField();
    private TextField tfmajor = new TextField();
    private TextField tfgpa = new TextField();
    private TextField tfid = new TextField();
    private TextField tfcredits = new TextField();
    private TextField tfage = new TextField();
    static int entry;



    @Override
    /**Start method for javafx GUI.**/
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        //Text fields for various data are added here, to proper columns and rows.
        pane.add(new Label("First name "), 0, 0);
        pane.add(tffname, 1, 0);
        pane.add(new Label("Last name "), 0, 1);
        pane.add(tflname,1, 1);
        pane.add(new Label("GPA"), 0, 2);
        pane.add(tfgpa, 1, 2);
        pane.add(new Label("id"), 0, 3);
        pane.add(tfid, 1, 3);
        pane.add(new Label("credits"), 0, 4);
        pane.add(tfcredits, 1, 4);
        pane.add(new Label("Age "), 0, 5);
        pane.add(tfage, 1, 5);
        pane.add(new Label("Major "), 0, 6);
        pane.add(tfmajor, 1, 6);
        Button btnSave = new Button("Save");
        btnSave.setTranslateX(70); //Coordinates on X axis for save button.
        btnSave.setTranslateY(205); //Y axis coordinate for save button.
        //Adds action event for the save button.
        btnSave.setOnAction(e-> writeNewStudent());
        Button btnMod = new Button("Modify");
        btnMod.setTranslateX(125); //X axis coordinate for modify button.
        btnMod.setTranslateY(205); //Y Axis coordinate for modify button.
        btnMod.setOnAction(e-> modifyStudent());
        pane.getChildren().add(btnMod);
        pane.getChildren().add(btnSave);
        ListView<String> list = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (
                "Student1", "Student2", "Student3", "Student4");
        list.setPrefWidth(100);
        list.setPrefHeight(70);
        list.setTranslateX(250);
        list.setTranslateY(0);
        pane.getChildren().add(list);
        list.setItems(items);
        Scene scene = new Scene(pane, 375, 250);
        primaryStage.setTitle("StudentViewer"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage


    }
    /**This method allows me to write to the students file, using bufferedwriter.**/
    public void writeNewStudent(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("./students.tx", true))){
            bw.write(entry);
            bw.newLine();
            bw.write(tffname.getText());
            bw.newLine();
            bw.write(tflname.getText());
            bw.newLine();
            bw.write(tfgpa.getText());
            bw.newLine();
            bw.write(tfid.getText());
            bw.newLine();
            bw.write(tfcredits.getText());
            bw.newLine();
            bw.write(tfage.getText());
            bw.newLine();
            bw.write(tfmajor.getText());
            bw.newLine();
            entry++;
            //Catches IOException that was preventing code from compiling properly.
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    /**Modifies the entries.**/
    public void modifyStudent(){
        File f = new File("./students.txt");
        String old = "";
        String content1 = "";
        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            String line = r.readLine(); // reads lines one by one and inputs it to old content
            while (line != null) {
                content1 = content1 + line + System.lineSeparator();
                line = r.readLine();
            }

            //String content2 = content1.replaceAll(old, ""); //  //

            FileWriter writer = new FileWriter("./students.txt");


        }catch (IOException e) {
            System.out.println("Caught!");
        }
        }

    /**Reads the data in the file to the console.**/
    public static void readStudent(){
        try {
            FileReader fr = new FileReader("./students.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null){
                System.out.println(str + "\n");
            }
            br.close();
        } catch (IOException e){

        }
    }
    /**Main method**/
    public static void main(String[] args) {
        //Calling read student.
        readStudent();
        launch(args);
    }
    /**Student class with setters/getters.**/
    public class Student implements java.io.Serializable {
        String lname;
        String fname;
        String major;
        int id;
        int credits;
        int age;
        double gpa;

        public Student(String fname,String lname,String major,int id, int credits,int age,double gpa) {
            this.fname=fname;
            this.lname=lname;
            this.major=major;
            this.id=id;
            this.credits=credits;
            this.age=age;
            this.gpa=gpa;



        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCredits() {
            return credits;
        }

        public void setCredits(int credits) {
            this.credits = credits;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getGpa() {
            return gpa;
        }

        public void setGpa(double gpa) {
            this.gpa = gpa;
        }

    }
}


