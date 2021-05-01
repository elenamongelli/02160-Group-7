package application.model;

public final class Session {

	private User user;
	private String role;

	public void setRole() {
		if (user.getUsername().equals("admin")) {
			this.role = "Admin";
		} else if (user.getUsername().equals("client")) {
			this.role = "Client";
		}
	}

	public void setUser(User user) {
		this.user = user;
		setRole();
	}

	public String getUsername() {
		return user.getUsername();
	}

	public String getRole() {
		return this.role;
	}
}
