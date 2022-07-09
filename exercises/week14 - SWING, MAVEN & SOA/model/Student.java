package gr.aueb.cf.schoolapp.model;

public class Student {
	private int id;
	private String fname;
	private String sname;
	
	public Student() {}

	public Student(int id, String fname, String sname) {
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

	@Override
	public String toString() {
		return id + "\t" + fname + "\t" + sname;
	}
}
