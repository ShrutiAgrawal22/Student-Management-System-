package org.example;

import java.sql.*;

public class StudentDao {
    static Connection con;  //connection build to dbconnection
    static int createStudent(StudentInfo student) throws SQLException {
        String query = "insert into students values(?, ?, ?)";
        con = DBConnection.createConnection();
        PreparedStatement pr = con.prepareStatement(query);
        pr.setInt(1, student.getId());
        pr.setInt(2, student.getAge());
        pr.setString(3, student.getName());
        int res = pr.executeUpdate(); //if this will give 0 means insert nhi hua and if give other than 0 means inserted.
        if(res!=0) System.out.println("---------------------------------------------" +
                "INSERT SUCCESSFULLY" +
                "---------------------------------------------");
        return res;
    }
    static void getAllStudents(){
        con = DBConnection.createConnection();
        String query = "select * from students";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt(1) + " " +
                        rs.getInt(2) + " " +
                        rs.getString(3));
            }
            System.out.println("---------------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static void getStudentById(int id){
        con = DBConnection.createConnection();
        String query = "select * from students where id =" + id;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getInt(1) + " " +
                        rs.getInt(2) + " " +
                        rs.getString(3));
            }
            System.out.println("---------------------------------------------");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    static void updateStudentById(int id, String updatedName){
        con = DBConnection.createConnection();
        String query = "update students set stu_name = ? where id = ?";
        try{
            PreparedStatement pr = con.prepareStatement(query);
            pr.setString(1, updatedName);
            pr.setInt(2, id);
            int a = pr.executeUpdate();
            if(a!=0) System.out.println("---------------------------------------------" +
                    "UPDATED SUCCESSFULLY" +
                    "---------------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    static void deleteStudentById(int id){
        con = DBConnection.createConnection();
        String query = "delete from students where id = ?";
        try{
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, id);
            int a = pr.executeUpdate();
            if(a!=0) System.out.println("---------------------------------------------" +
                    "DELETED SUCCESSFULLY" +
                    "---------------------------------------------");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
