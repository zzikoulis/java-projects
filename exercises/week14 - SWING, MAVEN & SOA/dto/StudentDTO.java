package gr.aueb.cf.schoolapp.dto;

public class StudentDTO {
	private int id;
	private String fname;
	private String sname;
	
	public StudentDTO() {}

	public StudentDTO(int id, String fname, String sname) {
		this.id = id;
		this.fname = fname;
		this.sname = sname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
