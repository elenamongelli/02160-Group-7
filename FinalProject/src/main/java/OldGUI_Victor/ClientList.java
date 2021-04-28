package OldGUI_Victor;

public class ClientList {
	
	public static String userName;
	
	public static void main(String[] args) {	
		
		
		
		userName = LoginPage.getUserName();
		
	}
	
	public static boolean isAdmin(String userName) {
		
		if (userName.equals("Oscar")) {
			return true;
		} else if (userName.equals("Victor")) {
			return true;
		} else if (userName.equals("Daniel")) {
			return true;
		} else if (userName.equals("Oscar")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isClient(String userName) {
		if (userName.equals("Kirsten")) {
			return true;
		} else if (userName.equals("Antonio")) {
			return true;
		} else if (userName.equals("Oliver")) {
			return true;
		} else if (userName.equals("Theis")) {
			return true;
		} else {
			return false;
		}
	}

}

