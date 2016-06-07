package fre.mmm.databases;

public class DataBaseResources {

	public static String selectUsers(){
		String req = "SELECT * FROM t_users;";
		return req;
	}

	public static String selectUsersWhereID(){
		String req = "SELECT * FROM t_users "
				+ "WHERE id_user = ?;";
		return req;
	}
	
	public static String selectUsersWhereLogin(){
		String req = "SELECT * FROM t_users "
				+ "WHERE user_login = ?;";
		return req;
	}
	
	public static String updateUser(){
		String req = "UPDATE t_users "
				+ "SET user_login = ?, user_firstname = ?, user_lastname = ?, user_email = ?, user_phone = ?, user_comp = ?, is_staffer = ?"
				+ "WHERE id_user = ?;";
		return req;
	}
	
	public static String addUser(){
		String req = "INSERT INTO t_users (user_login, user_firstname, user_lastname, user_email, user_phone, user_comp, is_staffer) "
						+ "VALUES(?, ?, ?, ?, ?, ?, TRUE);";
		return req;
	}
	
	public static String selectProjects(){
		String req = "SELECT * FROM t_projet";
		return req;
	}
	
	public static String selectLivrables(){
		String req = "SELECT * FROM t_livrable";
		return req;
	}
	
	public static String selectActions(){
		String req = "SELECT * FROM t_actions";
		return req;
	}
}
