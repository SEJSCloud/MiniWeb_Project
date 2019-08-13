package model;

import java.util.ArrayList;

import model.domain.SingerDTO;

public class SingerDAO {

	private static SingerDAO instance = new SingerDAO();
	public static ArrayList<SingerDTO> virtualDB = new ArrayList<SingerDTO>();
	static {
		virtualDB.add(new SingerDTO("트와이스", 24, "YesOrYes"));
		virtualDB.add(new SingerDTO("긱스", 29, "OfficiallyMissingYou"));
		virtualDB.add(new SingerDTO("동물원", 55, "널사랑하겠어"));
	}
	
	public SingerDAO(){}
	
	public static SingerDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<SingerDTO> getAll(){
		return virtualDB;
	}
	
	public static SingerDTO getInfo(String name) {
		SingerDTO info = new SingerDTO();
		ArrayList<SingerDTO> v = getAll();
		int count = v.size();
		for (int i = 0; i < count; i++) {
			if (v.get(i).getName().equals(name)) {
				info = v.get(i);
			}
		}
		return info;
	}
	
//	public void addCustomer (String name, int age, String signatureSong) {
//		if(indentify(name, age, signatureSong))
//			virtualDB.add(new SingerDTO(name, age, signatureSong));
//	}
	
	//검증식  1. 이름에 공백이없고 이름길이가 0이 아니면 입력시 해당 이름의 가수의 나이가 일치해야하고 대표곡은 중복하지 않으면 저장 가능
	//     2. 이름에 공백이없고 이름길이가 0이 아니고 가수이름이 현재 리스트에 없을경우 저장 가능
	
	public boolean indentify(String name, int age, String signatureSong) {
		SingerDTO dto = getInfo(name);
		ArrayList<String> nameList = new ArrayList<String>();
		for(SingerDTO dto2 : getAll()) {
			nameList.add(dto2.getName());
		}
		if(!name.contains(" ") && name.length() != 0
				&& dto.getAge() == age && !dto.getSignatureSong().equals(signatureSong)) {
			return true;
		}else if(!name.contains(" ") && name.length() != 0 && !nameList.contains(name)){
			return true;
		}else {
			return false;
		}
	}
}
