package org.MyUniversityProject.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.MyUniversityProject.interfaces.KeyEncryption;

public  class KeyPassword implements KeyEncryption {
	protected String valNameToEncrypt; //here we can encrypt the passwords
	protected String valNameToDesencrypt; //to Desencrypt any password from data base
	public KeyPassword(){ }
	public KeyPassword(String keyPassword){
		this.valNameToEncrypt=KeyEncryption.STR_KEY+keyPassword+KeyEncryption.STR_KEY;
	}
	
	//setters
	public void setValNameToEncrypt(String key){ 
		this.valNameToEncrypt=
				KeyEncryption.STR_KEY+ /*first hash*/
									key+ /* value of key password*/
										KeyEncryption.STR_KEY; /*second hash*/ 
	}
	public void setValNameToDesencrypt(String key){ this.valNameToDesencrypt=key; }
	
	//getters
	public String getValNameToEncrypt(){ return valNameToEncrypt; }
	public String getValNameToDesencrypt(){ return valNameToDesencrypt; }
	
	
	@Override
	public String EncryptPasswordSHA256(String keyPassword) {
		MessageDigest md = null;
		try{
			md = MessageDigest.getInstance("SHA-256");
		}catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(keyPassword.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		String valToSHA = sb.toString(); //get data encrypted 
		String keyToHash = EncryptPasswordHash(valToSHA); //convert with hash '#' and divide the length
		String wHash = WithoutHashPassword(keyToHash); //quit hash 
		return wHash;
	}
	
	@Override
	public String DesencryptPassword(String keyPassword, String STR_KEY) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String EncryptPasswordHash(String keyPasswordHash) {
		String result = keyPasswordHash;
		int tam=result.length();
		tam/=3;	tam-=1;
		String cadActual="";
		for(int i=0; i<=tam; i++) {
			cadActual+=(i==0)? "###":"";
			cadActual+=result.charAt(i);
			cadActual+=(i==tam)? "###":"";
		}
		return cadActual;
	}
	
	
	@Override
	public String WithoutHashPassword(String keyPasswordHash) {
		String valNewWithoutHash="";
		valNewWithoutHash=keyPasswordHash.replace("#", "");
		return valNewWithoutHash;
	}
	
	//3b1e98471682b3491eb5e173b442d4ceb691fb97cebf5cf5bc989139d3530992
	public static void main(String[]args) {
		KeyPassword kp = new KeyPassword();
		String cadena="bryan123";
		kp.setValNameToEncrypt(cadena);
		String encriptado=kp.EncryptPasswordSHA256(kp.getValNameToEncrypt());
		
		
		
		System.out.println(encriptado);
		/*
		String wHash=kp.EncryptPasswordHash(encriptado);
		System.out.println(wHash);
		String withoutHash = kp.WithoutHashPassword(wHash);
		System.out.println(withoutHash);
		*/
	}
	

}
