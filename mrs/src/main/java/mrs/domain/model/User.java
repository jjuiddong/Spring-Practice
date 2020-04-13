package mrs.domain.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="usr")
public class User implements Serializable {

	private static final long serialVersionUID = -8739935870568178798L;

	@Id
	public String userId;
	public String password;	
	public String firstName;
	public String lastName;
	
	@Enumerated(EnumType.STRING)
	public RoleName roleName;
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public RoleName getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	
	
}
