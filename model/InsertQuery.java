package org.MyUniversityProject.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.PreparedStatement;

public class InsertQuery extends QueryManagment{
	
	public InsertQuery(){}
	public InsertQuery(Object []values) {
		super(values);
	}
	public InsertQuery(String query) {
		super(query);
	}
	@Override
	public boolean ToInsertQuery(String query) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean AfterInsertQuery(Object[] values) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	/**
	 * @param Object[]value: 
	 * @throws SQLException 
	 * */
	@Override
	public boolean QueryPrepare(String usrName, String email, String password, String terms) throws SQLException {
		Conection conn = new Conection();
		PreparedStatement ps;
		conn.Conexion();
		
		Calendar calendar = Calendar.getInstance();
		// create a sql date object so we can use it in our INSERT statement
		Date newDate = new Date(calendar.getTime().getTime());
		String query="INSERT INTO users ( UserName, Email , Password, DateRegister, TermsAcepted ) VALUES (?, ? , ?, ?, ?)";
		boolean res=false;
		KeyPassword kp = new KeyPassword();
		//Object []objects = new Object[values.length]; 
		/*for(int i=0; i < objects.length; i++) {
			objects[i]=this.values[i];
			System.out.println("val["+this.values[i]+"]");
		}*/
		kp.setValNameToEncrypt(password);
		String passwordEncrypted= kp.EncryptPasswordSHA256(kp.getValNameToEncrypt());
		boolean resp=false;
		try {
			 ps = (PreparedStatement) Conection.conec.prepareStatement(query);
			 ps.setString(1, usrName);
			 ps.setString(2, email );
			 ps.setString(3, passwordEncrypted);
			 ps.setDate(4, newDate);
			 ps.setString(5, terms);
			 res = ps.execute();
			 resp=(!res)? true : false ;
		} catch (SQLException e) {
			System.out.println(	e.getMessage());
			resp=false;
		}finally {
			if(Conection.conec != null) {
				Conection.conec.close();
			}
		}
		return resp;
	}
	
	
	@Override
	public String QueryWPrepare(String query) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
