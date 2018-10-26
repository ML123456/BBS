package entity;

public class User extends IdEntity {

	//用户姓名
	private String name;
	//用户密码
	private String password;
	//用户邮箱
	private String email;
	//用户住址
	private String family;
	//个人简介
	private String intro;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", family=" + family + ", intro="
				+ intro + ", userid=" + userid + "]";
	}
}
