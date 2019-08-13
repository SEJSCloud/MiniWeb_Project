package model;

import java.util.ArrayList;

import model.domain.UserDTO;


public class UserDAO {
	
	private static UserDAO instance = new UserDAO();
	public static ArrayList<UserDTO> virtualDB = new ArrayList<UserDTO>();
	static {
		virtualDB.add(new UserDTO("윤하", "1234"));
		virtualDB.add(new UserDTO("키드밀리", "1234"));
		virtualDB.add(new UserDTO("치즈", "1234"));
	}
	
	public UserDAO(){}
	
	public static UserDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<UserDTO> getAll(){
		return virtualDB;
	}
	
	public static UserDTO getInfo(String id) {
		UserDTO info = null;
		ArrayList<UserDTO> v = getAll();
		int count = v.size();
		for (int i = 0; i < count; i++) {
			if (v.get(i).getId().equals(id)) {
				info = v.get(i);
			}
		}
		return info;
	}
	
	// 로그인시 이미 있는 이름이어야 하고 해당 이름과 등록되어있는 패스워드가 같아야 로그인 가능
	public boolean indentify(String id, String pw) {
		ArrayList<String> name = new ArrayList<String>();
		UserDTO info = getInfo(id);
		for(UserDTO a : virtualDB) {
			name.add(a.getId());
		}
		if(name.contains(id) && info.getPw().equals(pw)) {
			return true;
		}else {
			return false;
		}
	}
	

}
