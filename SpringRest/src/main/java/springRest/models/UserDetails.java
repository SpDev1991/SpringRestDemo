package springRest.models;

public class UserDetails {
	
	private Integer id;
	private String name;
	private String password;
	
	
	public UserDetails(Integer id) {
		super();
		this.id = id;
	}
	public UserDetails() {
		super();
	}
	
	
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
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
