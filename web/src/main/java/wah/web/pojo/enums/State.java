package wah.web.pojo.enums;

public enum State {
	Disabled(0, "禁用"), 
	Enabled(1, "启用");

	private int code;
	private String desc;

	State(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
