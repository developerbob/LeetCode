
import java.util.Stack;

/**
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "a*") ? true
 * isMatch("aa", ".*") ? true
 * isMatch("ab", ".*") ? true
 * isMatch("aab", "c*a*b") ? true
 *
 * @author Bob Yang
 * @since 2017-08-10
 */
public class Algo_10 {
	
	public boolean isMatch(String s, String p) {
		int i = 0, j = 0;
		//boolean mode = false; // false: match short; true: match long
		Stack<int[]> stack = new Stack<int[]>();
		while ( i < s.length()) {
			if (p.charAt(j) == '.') {
				j++;
			} else if (p.charAt(j) == '*') {
				if (j < p.length()-1 && i < s.length()-1 && s.charAt(i+1) == p.charAt(j+1)) {
					stack.push(new int[]{i,j});
					j++;
				}
			} else if (s.charAt(i) == p.charAt(j)) {
				j++;
			} else {
				return false;
			}
			if (i == s.length() || j == p.length()) {
				if (isMatch(s, p, i, j)) {
					return true;
				} else if (!stack.isEmpty()) {
					int[] context = stack.pop();
					i = context[0] + 1;
					j = context[1];
				}
			} else {
				i++;
			}
		}
		return isMatch(s, p, i, j);
    }
	
	public boolean isMatch(String s, String p, int i, int j) {
		return (i == s.length() -1  && j == p.length()) ||
				(i == s.length() - 1 && j == p.length() - 1 && p.charAt(p.length()-1) == '*');
	}

	public static void main(String[] args) {
		Algo_10 a = new Algo_10();
		boolean ret = a.isMatch("abcabcbb", "a.c*b"); // result: true
		System.out.println("ret: " + ret);
		
		ret = a.isMatch("abcabcbb", "a.c*bb"); // result: true
		System.out.println("ret: " + ret);
	}
}
