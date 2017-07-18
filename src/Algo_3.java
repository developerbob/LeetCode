import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. 
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author Bob_2
 * @since 2017-07-10
 */
public class Algo_3 {

	// Concept: slide window
	public int lengthOfLongestSubstring(String s) {
		int ret = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
        	if (map.containsKey(s.charAt(i))) {
        		ret = Math.max(ret, i - map.get(s.charAt(i)));
        	} 
        	map.put(s.charAt(i), i);
        }
		return ret;
    }
	
	public static void main(String[] args) {
		Algo_3 a = new Algo_3();
		int ret = a.lengthOfLongestSubstring("abcabcbb"); // result: 3
		System.out.println("ret: " + ret);
		
		ret = a.lengthOfLongestSubstring("abcdbcdmnobcd"); // result: 6
		System.out.println("ret: " + ret);
	}
}
