/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		System.out.println(isAnagram("12345678","13245678"));  // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
    	str2 = preProcess(str2);
	    if(str1.length() != str2.length()){
	        return false;
    	}
	    while(str1.length() > 0){
    	    boolean foundMatch = false;
        	for(int i = 0; i < str2.length(); i++){
            	if(str2.charAt(i) == str1.charAt(0)){
                	str1 = str1.substring(1);
    	            str2 = str2.substring(0, i) + str2.substring(i + 1);
        	        foundMatch = true;
            	    break;
    	        }
	        }
	        if(!foundMatch){
    	        return false;
        	}
  		}
    	return true;
		}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted.
	// For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase().replaceAll("[^a-z]", "");
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		int rand = (int)(Math.random()*str.length()); 
		for(int i = 0; i < str.length(); i++){
			str = str.substring(0, rand) + str.substring(rand + 1 , str.length()) + str.charAt(rand);
			rand = (int)(Math.random()*str.length());
		}
		return str;
	}
}
