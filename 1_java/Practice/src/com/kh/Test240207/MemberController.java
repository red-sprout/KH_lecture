package com.kh.Test240207;

import java.util.HashMap;
import java.util.TreeMap;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<>();
	
	public boolean joinMembership(String id, Member m) {
		if (map.containsKey(id)) {
			return false;
		} else {
			map.put(id, m);
			return true;
		}
	}
	
	public String login(String id, String password) {
		if (map.containsKey(id)) {
			Member member = map.get(id);
			if (member.getPassword().equals(password)) {
				return member.getName();
			}
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if (map.containsKey(id)) {
			Member member = map.get(id);
			if (member.getPassword().equals(oldPw)) {
				member.setPassword(newPw);
				return true;
			}
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
		Member member = map.get(id);
		member.setName(newName);
	}
	
	public TreeMap<String, String> sameName(String name) {
		TreeMap<String, String> treeMap = new TreeMap<>();
		Member member;
		for(String id : map.keySet()) {
			member = map.get(id);
			if(member.getName().equals(name)) {
				treeMap.put(id, name);
			}
		}
		return treeMap;
	}
}
