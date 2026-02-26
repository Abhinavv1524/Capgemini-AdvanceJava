package model;

public class Member {
	private long id;
	private String name;
	private String email;
	public Member(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
    public Long getId() { 
    	return id; 
    }
    public String getName() { 
    	return name; 
    }
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
