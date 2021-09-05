package db;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcManage {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    private Connection getConnection() {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getResourceAsStream("/db.properties");
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Class jdbcDriverClass;

        try {
            jdbcDriverClass = Class.forName(properties.getProperty("jdbc.driver"));
            Driver driver = (Driver) jdbcDriverClass.newInstance();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(properties.getProperty("jdbc.url"),
                    properties.getProperty("jdbc.username"), properties.getProperty("jdbc.password"));
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                ;
            }
        }
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
        System.out.println("Connection close");
    }

    public void insertStudent(String id, String name){
        String sql="insert into ml_student(id,name) values('"+ id +"','"+name+"')";
        try{
            PreparedStatement preStmt=(PreparedStatement)this.connection.prepareStatement(sql);
            preStmt.executeUpdate();
            System.out.println("Insert data into table ml_student！");
            preStmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void selectStudent(){
        String sql="select * from ml_student";
        try{
            Statement stmt=(Statement)this.connection.createStatement();
            ResultSet rs=(ResultSet)stmt.executeQuery(sql);
            System.out.println("\n--------------------------------");
            System.out.println("id"+"\t"+"name");
            System.out.println("--------------------------------");
            while(rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("name");
                System.out.println(id+"\t"+name);
            }
            System.out.println("--------------------------------\n");
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateStudent(String id,String name){
        String sql="update ml_student set name=? where id=?";
        try{
            PreparedStatement prestmt=(PreparedStatement)this.connection.prepareStatement(sql);
            prestmt.setString(1, name);
            prestmt.setString(2,id);
            prestmt.executeUpdate();
            System.out.println("Updated student table！");
            prestmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(String id){
        String sql="delete from ml_student where id=?";
        try{
            PreparedStatement prestmt=(PreparedStatement)this.connection.prepareStatement(sql);
            prestmt.setString(1, id);
            prestmt.executeUpdate();
            System.out.println("Deleted data from student table！");
            prestmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            JdbcManage jdbcManage = new JdbcManage();
            jdbcManage.getConnection();
            jdbcManage.insertStudent("1100", "student1");
            jdbcManage.selectStudent();
            jdbcManage.updateStudent("1100", "student1_1");
            jdbcManage.selectStudent();
            jdbcManage.deleteStudent("1100");
            jdbcManage.selectStudent();
            jdbcManage.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
