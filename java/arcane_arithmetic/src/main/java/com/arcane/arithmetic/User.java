package com.arcane.arithmetic;

/**
 * A user class to save username, password, id, name and privilege
 * @author Ming Chun Chan
 *
 */
public class User{
	private String username;
	private String password;
	private String id;
	private String name;
	private String privilege;
	//Constructor for user
	public User(String username, String password, String id, String name, String privilege) {
		this.username = username;
		this.password = password;
		this.id = id;
		this.name = name;
		this.privilege = privilege;
	}
	//Setter for user
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	//Getter for user
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		return this.password;
	}
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getPrivilege() {
		return this.privilege;
	}
}