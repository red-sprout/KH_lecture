package com.kh.Test240126;

public class PhoneController {
	private String[] result = new String[2];
	
	public String[] method() {
		Phone[] phones = new Phone[2];
		
		phones[0] = new GalaxyNote9();
		phones[1] = new V40();
		
		for(int i = 0; i < phones.length; i++) {
//			if(phones[i] instanceof GalaxyNote9) {
//				result[i] = ((GalaxyNote9)phones[i]).printInformation();
//			} else if(phones[i] instanceof V40) {
//				result[i] = ((V40)phones[i]).printInformation();
//			}
			result[i] = ((SmartPhone)phones[i]).printInformation();
		}
		
		return result;
	}
}
