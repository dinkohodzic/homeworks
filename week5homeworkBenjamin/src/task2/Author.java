package task2;

public class Author {

	private String name;
	private String email;
	private String gender;

	// constructor
	public Author(String name, String email, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		String s = "";
		s += "\nName: " + name;
		s += "\nEmail: " + email;
		s += "\nGender: " + gender;
		return s;
	}

}
