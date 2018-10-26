package entity;

public class Fatie extends IdEntity {

	// 发帖id
	private int fid;
	// 帖子内容
	private String titles;
	// 发帖内容
	private String fcontent;
	// 发帖的图片
	private String photo;
	//发帖人姓名
	private String username;

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Fatie [fid=" + fid + ", titles=" + titles + ", fcontent=" + fcontent + ", photo=" + photo
				+ ", username=" + username + ", userid=" + userid + "]";
	}
}
