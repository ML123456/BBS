package entity;

public class Pinglun extends IdEntity {

	// 评论id
	private int pid;
	// 评论的内容
	private String pcontent;
	// 被评论的人的id
	private int byid;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}

	public int getByid() {
		return byid;
	}

	public void setByid(int byid) {
		this.byid = byid;
	}

	@Override
	public String toString() {
		return "Pinglun [pid=" + pid + ", pcontent=" + pcontent + ", byid=" + byid + ", userid=" + userid + "]";
	}
}
