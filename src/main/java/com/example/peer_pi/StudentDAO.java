package com.example.peer_pi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentDAO {

    public static StudentInfo searchStudent(String email) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM new_table WHERE email='" + email + "'";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsStudent = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getStudentFromResultSet method and get student object
            StudentInfo student = getStudentFromResultSet(rsStudent);

            //Return student object
            return student;
        } catch (SQLException e) {
            System.out.println("While searching a student with " + email + " email, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    //Use ResultSet from DB as parameter and set Student Object's attributes and return student object.
    private static StudentInfo getStudentFromResultSet(ResultSet rs) throws SQLException {
        StudentInfo std = null;
        if (rs.next()) {
            std = new StudentInfo();
            std.setParticipant_no(rs.getInt("Participant_no"));
            std.setFirstName(rs.getString("FIRST_NAME"));
            std.setLastName(rs.getString("LAST_NAME"));
            std.setEmail(rs.getString("EMAIL"));
            std.setPassword(rs.getString("PASSWORD"));

        }
        return std;
    }

    public static ObservableList<StudentInfo> searchStudents() throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM new_table";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsStudents = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getStudentList method and get student list
            ObservableList<StudentInfo> studentList = getStudentList(rsStudents);

            //Return student list
            return studentList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    //Select * from students operation
    private static ObservableList<StudentInfo> getStudentList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare an observable List which comprises of Student objects
        ObservableList<StudentInfo> stdList = FXCollections.observableArrayList();

        while (rs.next()) {
            StudentInfo st = new StudentInfo();
            st.setParticipant_no(rs.getInt("Participant_no"));
            st.setFirstName(rs.getString("FIRST_NAME"));
            st.setLastName(rs.getString("LAST_NAME"));
            st.setEmail(rs.getString("EMAIL"));
            st.setPassword(rs.getString("PASSWORD"));
            //Add student to the ObservableList
            stdList.add(st);
        }
        //return stdList (ObservableList of Students)
        return stdList;
    }

    //*************************************
    //UPDATE a student's email address
    //*************************************
    public static void updateStudentEmail(String firstName, String stdEmail) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE StudentInfo\n" +
                        "      SET EMAIL = '" + stdEmail + "'\n" +
                        "    WHERE FIRST_NAME  = '" + firstName + "';\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }
}


