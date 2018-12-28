package wah.web.pojo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SystemLog {
	private Integer id;

	private String name;

	private String detail;

	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail == null ? "" : detail.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", detail=" + detail + ", createDate=" + createDate + "]";
	}
}