package org.MyUniversityProject.model;

import java.sql.SQLException;

import org.MyUniversityProject.interfaces.Querys;

public abstract class QueryManagment implements Querys {
	public String query;
	public Object []values;
	
	//Sobre carga de constructores
	public QueryManagment(){}
	/**
	 * @param String query: set a string to process information on an data base
	 * */
	public QueryManagment(String query) {
		this.query=query;
	}
	/**
	 *  @param Object []values: set Objects to process information on an data base
	 * */
	public QueryManagment(Object []values) {
		this.values=values;
	}
	
	//Setters
	public void setQuery(String query){ this.query=query; }
	public void setValues(Object []valuesObjects){ this.values=valuesObjects; }
	
	//Getters
	public String getQuery(){ return query; }
	public Object[] getValues(){ return values; }
	
	
	//Insert data on data base with the method PrepareStatement, to reject action inyection SQL
	/**
	 * @author bryan
	 * @param String query: recive data on data base with the method PrepareStatement, to reject action inyection SQL
	 * @throws SQLException 
	 * 
	 * */
	abstract public boolean QueryPrepare(String usrName, String email, String password, String terms) throws SQLException;
	
	//Insert data on data base without the method PrepareStatement, to reject action inyection SQL
	/**
	 * @author bryan
	 * @param String query: recive data on data base without the method PrepareStatement, to reject action inyection SQL
	 * 
	 * */
	abstract public String QueryWPrepare(String query);
	

}
