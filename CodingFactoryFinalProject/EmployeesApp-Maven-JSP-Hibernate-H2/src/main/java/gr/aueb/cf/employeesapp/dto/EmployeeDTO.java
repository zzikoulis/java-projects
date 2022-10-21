package gr.aueb.cf.employeesapp.dto;

public class EmployeeDTO {

	private Long id;
	private String lastname;
	private String firstname;
	
	public EmployeeDTO() {}

	public Long getId() {
		return id;
	}

	public EmployeeDTO(Long id, String lastname, String firstname) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
