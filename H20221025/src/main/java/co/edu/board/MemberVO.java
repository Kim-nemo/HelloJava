package co.edu.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String resposibility;
	
	public MemberVO(String id, String passwd, String name, String email, String resposibility) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.resposibility = resposibility;
	}
	
	public MemberVO(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}
	
	public String getResposibility() {
		return resposibility;
	}
	
	public void setResposibility(String resposibility) {
		this.resposibility = resposibility;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

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
	
	

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}

	
	
}
