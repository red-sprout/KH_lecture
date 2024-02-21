package com.kh.practice01;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {
	}
	
	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str);
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken());
		}
		
		return sb.toString();
	}
	
	public String firstCap(String input) {
		if(input == null || input.isEmpty()) {
			return input;
		}
		
		return String.valueOf(input.charAt(0)).toUpperCase() + input.substring(1);
	}
	
	public int findChar(String input, char one) {
		int result = 0;
		for(int i = 0; i < input.length(); i++) {
			if(one == input.charAt(i)) {
				result++;
			}
		}
		
		return result;
	}
}
