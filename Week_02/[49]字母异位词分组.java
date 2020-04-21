
class Solution {

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