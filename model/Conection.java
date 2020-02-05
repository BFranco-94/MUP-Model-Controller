package org.MyUniversityProject.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Conection {
	public static PreparedStatement prest=null;
    public static CallableStatement cllst=null;
    public static Connection conec=null;
    public static Statement st=null;
    public static ResultSet rt=null;
    public static String usu;
    public static String contra;
    public static String host;
    public static String db;
    public static String driver;
    public void Conexion(){
        try{
            usu="root";
            contra="";
            host="localhost";
            db="bd-mup";
            driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://"+host+"/"+db;
            Class.forName(driver).newInstance();
            conec=(Connection) DriverManager.getConnection(url,usu,contra);
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
