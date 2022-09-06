package com.codegym.exammd3.model;

import com.codegym.exammd3.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final String SELECT_BY_ID = "select * from student where id=?;";
    private static final String INSERT_STUDENT = "INSERT INTO student(name, dateOfBirth, address, phone, email, classroom_id) VALUE (?,?,?,?,?,?)";
    private static final String UPDATE_STUDENT = "UPDATE STUDENT SET NAME=?,dateOfBirth=?,address=?,phone=?,email=?,classroom_id=? WHERE ID=?";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE id=?";
    private final String SELECT_ALL = "SELECT * FROM STUDENT";
    Connection connection = new ConnectionJDBC().getConnect();

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id= rs.getInt(1);
                String name = rs.getString(2);
                String dateOfBirth = rs.getString(3);
                String address = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String email = rs.getString(6);
                int classroom = rs.getInt(7);
                students.add(new Student(id ,name, dateOfBirth, address, phoneNumber, email, classroom));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public boolean add(Student student) {
        boolean a;
        try (PreparedStatement pstmt = connection.prepareStatement(INSERT_STUDENT)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getDateOfBirth());
            pstmt.setString(3, student.getAddress());
            pstmt.setString(4, student.getPhone());
            pstmt.setString(5, student.getEmail());
            pstmt.setInt(6, student.getClassroom_id());
            a = pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
   public boolean edit(int id, Student student){
        boolean a;
       try (PreparedStatement pstmt = connection.prepareStatement(UPDATE_STUDENT)) {
           pstmt.setString(1, student.getName());
           pstmt.setString(2, student.getDateOfBirth());
           pstmt.setString(3, student.getAddress());
           pstmt.setString(4, student.getPhone());
           pstmt.setString(5, student.getEmail());
           pstmt.setInt(6, student.getClassroom_id());
           pstmt.setInt(7,id);
           a = pstmt.executeUpdate() > 0;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return a;
   }
   public boolean delete(int id){
        boolean a;
        try(PreparedStatement pstmt=connection.prepareStatement(DELETE_STUDENT)){
            pstmt.setInt(1,id);
            a=pstmt.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
   }
}