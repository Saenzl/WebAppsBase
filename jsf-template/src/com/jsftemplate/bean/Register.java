package com.jsftemplate.bean;

import com.jsftemplate.db.AppUser;
import com.jsftemplate.hibernate.HibernateSession;
import com.jsftemplate.utils.SHAHash;

public class Register extends Form{

	/**
	 * Register bean
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String lastName;
	
	private String email;
	
	private String password;

	private String confirmPassword;
	
	
	
	
	public void register(){
		AppUser user = new AppUser();
		if(password.equals(confirmPassword)){
			String hashedpassword = SHAHash.hash(password);
			user.setName(name);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(hashedpassword);
			HibernateSession.saveObject(user);
			redirect("/index.xhtml");
		}else{
			System.out.println("Las contraseñas no coinciden");
		}
	}
	
	public void goBack(){
		redirect("/index.xhtml");
	}
	
	/*Getters % Setters*/	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
