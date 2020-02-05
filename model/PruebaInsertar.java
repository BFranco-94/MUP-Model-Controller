package org.MyUniversityProject.model;

import java.sql.SQLException;

public class PruebaInsertar {

	public static void main(String[] args) {
		String data_1="BryanFranco";
		String data_2="bryan.franco94@hotmail.com";
		String password="bryan123";
		String terms="1";
		InsertQuery iq= new InsertQuery();
		Object []values={
				data_1, 
				data_2, 
				password,
				terms
		};
		iq.setValues(values);
		Object resultObjects[]=new Object[iq.getValues().length];
		for(int i=0; i < iq.getValues().length ; i++) {
			resultObjects[i]=iq.getValues()[i];
		}
		boolean answer = false;
		try {
			answer = iq.QueryPrepare(data_1, data_2, password, "1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(answer);
	}

}
