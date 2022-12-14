package com.codegym.exammd3.controller;

import com.codegym.exammd3.model.Student;
import com.codegym.exammd3.model.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    StudentService service = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                viewAdd(req, resp);
                break;
            case "edit":
                viewEdit(req, resp);
                break;
            case "remove":
                removeStudent(req, resp);
                break;
            case "search":
                searchStudent(req, resp);
                break;
            default:
                listStudent(req, resp);
                break;
        }
    }

    private void searchStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("search");
        List<Student> students = service.findByNameAll(name);
        req.setAttribute("students", students);
        req.getRequestDispatcher("listStudent.jsp").forward(req, resp);
    }

    private void viewEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<Student> studentsC = service.findAllC();
        req.setAttribute("studentsC", studentsC);
        Student student = service.findById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentsC = service.findAllC();
        req.setAttribute("studentsC", studentsC);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    private void listStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students = service.findAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("listStudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addStudent(req, resp);
                break;
            case "edit":
                editStudent(req, resp);
                break;
            case "search":
                searchStudent(req,resp);
                break;
        }

    }

    private void removeStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.delete(id);
        resp.sendRedirect("/students");
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("dateOfBirth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        int classroom_id = Integer.parseInt(req.getParameter("classroom_id"));

        Student student = new Student(name, date, address, phone, email, classroom_id);
        if (service.edit(id, student)) {
            req.setAttribute("message", "edit success");
        } else {
            req.setAttribute("message", "edit failed");
        }
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }


    private void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        LocalDate date = LocalDate.parse(req.getParameter("dateOfBirth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        int classroom_id = Integer.parseInt(req.getParameter("classroom_id"));

        Student student = new Student(name, date, address, phone, email, classroom_id);
        if (service.add(student)) {
            req.setAttribute("message", "add success");
        } else {
            req.setAttribute("message", "add failed");
        }
        List<Student> studentsC = service.findAllC();
        req.setAttribute("studentsC", studentsC);
        req.setAttribute("student", student);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
}
