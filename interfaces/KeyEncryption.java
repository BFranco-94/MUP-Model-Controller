package org.MyUniversityProject.interfaces;
/**
* @author bryan franco velez	
* 
*/
public interface KeyEncryption {
	final public String STR_KEY="/###/"; //String_key -> String to encrypt an specific keypassword
	final public String HASH="#"; //string to replace (#) to string null by -> ""
	
	
	/**
	 * @param String KeyPassword: receive a string to encrypt the password
	 * */
	public String EncryptPasswordSHA256(String keyPassword);
	/**
	 * @param String keyPassword: key Encrypted to Descrypt the keyPassword
	 * @param String STR_KEY : key type Hash to Descrypt the keyPassword
	 * */
	public String DesencryptPassword(String keyPassword, String STR_KEY);
	
	/**
	 * @param String keyPasswordHash: insert on data base with a key false
	 * */
	public String EncryptPasswordHash(String keyPasswordHash);
	
	/**
	 * @param String keyPasswordHash: this value is the data to get on data base
	 * */
	public String WithoutHashPassword(String keyPasswordHash);

}
