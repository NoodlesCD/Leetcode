class Solution {
    public int romanToInt(String s) {
        int result = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100); 
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5); 
        map.put("I", 1);
        
        int position = s.length() - 1;
        char previous = '-';
        
        while (position > -1) {
            if (s.charAt(position) == 'I' && (previous == 'V' || previous == 'X')) {
                result -= 1;
            } else if (s.charAt(position) == 'X' && (previous == 'L' || previous == 'C')) {
                result -= 10;
            } else if (s.charAt(position) == 'C' && (previous == 'D' || previous == 'M')) {
                result -= 100;
            } else {
                result += map.get(s.substring(position, position + 1));
            }
            
            previous = s.charAt(position);
            position--;
        }
        
        return result;
    }
}
