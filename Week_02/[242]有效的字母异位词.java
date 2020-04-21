
public class Solution {

    /**
     * 242 有效的字母异位词
     * 
     * 给定两个字符串s 和 t,编写一个函数来判断t 是否是 s的字母异位词。
     * 
     * 示例1： 输入：s = "anagram", t = "nagaram" 输出：true
     * 
     * 示例2： 输入：s = "rat", t = "car" 输出：false
     */

    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            a[t.charAt(i) - 'a']--;
        }

        for (int tmp : a) {
            if (tmp != 0) {
                return false;
            }
        }

        return true;
    }

}