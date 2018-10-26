package entity;

public class Via extends IdEntity {
	String photo;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Via [photo=" + photo + ", userid=" + userid + "]";
	}
}
