public class KMP_basic {
	public static void main(String[] args) {
		String parent = "ababacabacaabacaaba";
		String pattern = "abacaaba";
		KMP(parent, pattern);
	}
	
	public static int[] failureFunction(String pattern) {
		int size = pattern.length();
		int[] result = new int[size];
		
		int idx = 0;
		for (int i = 1; i < size; i++) {
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = result[idx - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				result[i] = ++idx;
			}
		}
		
		return result;
	}
	
	public static void KMP(String parent, String pattern) {
		int[] table = failureFunction(pattern);
		int parentSize = parent.length();
		int patternSize = pattern.length();
		
		int idx = 0;
		for (int i = 0; i < parentSize; i++) {
			while (idx > 0 && parent.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}
			if (parent.charAt(i) == pattern.charAt(idx)) {
				if(idx == patternSize - 1) {
					System.out.println(i - patternSize + 2 + "번째에서 찾았습니다.");
					idx = table[idx];
				}
				else {
					idx++;
				}
			} 
		}
	}
}
