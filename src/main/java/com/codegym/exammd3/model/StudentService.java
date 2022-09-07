package com.codegym.exammd3.model;

import com.codegym.exammd3.connection.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static final String SELECT_BY_ID = "select student.id,name,dateOfBirth,address, phone, email, classroom.id,classroom.className from student join classroom on classroom.id=student.classroom_id where student.id=?;";
    private static final String INSERT_STUDENT = "INSERT INTO student(name, dateOfBirth, address, phone, email, classroom_id) VALUE (?,?,?,?,?,?)";
    private static final String UPDATE_STUDENT = "UPDATE STUDENT SET NAME=?,dateOfBirth=?,address=?,phone=?,email=?,classroom_id=? WHERE ID=?";
    private static final String DELETE_STUDENT = "DELETE FROM student WHERE id=?";
    private static final String SELECT_ALL_BY_NAME = "SELECT student.id,name,dateOfBirth,address, phone, email, classroom.className FROM STUDENT join classroom on classroom.id=student.classroom_id where student.name=?";
    private final String SELECT_ALL = "SELECT * FROM STUDENT";
    private final String SELECT_ALL_S = "SELECT student.id,name,dateOfBirth,address, phone, email, classroom.className FROM STUDENT join classroom on classroom.id=student.classroom_id order by student.id ASC ";
    private final String SELECT_ALL_C = "SELECT classroom.id, classroom.className FROM classroom; ";
    Connection connection = new ConnectionJDBC().getConnect();

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_S)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id= rs.getInt(1);
                String name = rs.getString(2);
                String dateOfBirth =(rs.getString(3));
                String address = rs.getString(4);
                String phoneNumber = rs.getString(5);
                String email = rs.getString(6);
                String classroom = rs.getString(7);
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
            System.out.println(pstmt);
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
   public List<Student> findAllC(){
       List<Student> students = new ArrayList<>();
       try (PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_C)) {
           ResultSet rs = pstmt.executeQuery();

           while (rs.next()) {
               int id= rs.getInt(1);
               String classroom = rs.getString(2);
               students.add(new Student(id ,classroom));
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return students;
   }
   public Student findById(int id){
        Student student=null;
        try(PreparedStatement ptmt= connection.prepareStatement(SELECT_BY_ID)) {
            ptmt.setInt(1,id);
            ResultSet rs= ptmt.executeQuery();
            if(rs.next()){
                String name= rs.getString(2);
                LocalDate date= LocalDate.parse(rs.getString(3));
                String address= rs.getString(4);
                String phone= rs.getString(5);
                String email=rs.getString(6);
                String className=rs.getString(8);
                int classid = Integer.parseInt(rs.getString(7));
                student= new Student(id,name,date,address,phone,email,className,classid);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
   }
   public List<Student> findByNameAll(String name){
        List<Student> students= new ArrayList<>();
        try(PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_BY_NAME)) {
            preparedStatement.setString(1,name);
            System.out.println(preparedStatement);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id= rs.getInt(1);
                String name1= rs.getString(2);
                String date= rs.getString(3);
                String address= rs.getString(4);
                String phone= rs.getString(5);
                String email= rs.getString(6);
                String classname= rs.getString(7);
                students.add(new Student(id,name1,date,address,phone,email,classname));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
   }
}
