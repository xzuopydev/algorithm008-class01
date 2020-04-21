
class Solution {

    /**
     * 49 给定一个字符串数组，将字母异位词组合在一起。 字母异位词指字母相同，但排列 不同的字符串。
     * 
     * 示例： 输入：["eat", "tea", "tan", "ate", "nat", "bat"] 输出： [ ["ate", "eat",
     * "tea"], ["nat", "tan"], ["bat"] ]
     * 
     * 说明： 所有输入均为小写字母。 不考虑答案输出的顺序。
     */

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> each = new ArrayList<>();
                each.add(s);
                map.put(key, each);
            }
        }

        return new ArrayList<>(map.values());
    }

}