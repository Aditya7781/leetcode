class Solution {
    public int solve(int i, String s, int n, Map<String, Integer> prev_map) {
        Map<String, Integer> t = new TreeMap<>();
        
        for (; i < n; i++) {
            if (s.charAt(i) == '(') {
                i = solve(i + 1, s, n, t);
            } else if (Character.isUpperCase(s.charAt(i))) {
                StringBuilder temp = new StringBuilder();
                temp.append(s.charAt(i));
                i++;
                
                if (i < n && Character.isLowerCase(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                
                int count = 0, j;
                for (j = i; j < n; j++) {
                    if (Character.isDigit(s.charAt(j))) {
                        count = count * 10 + (s.charAt(j) - '0');
                    } else {
                        break;
                    }
                }
                
                t.put(temp.toString(), t.getOrDefault(temp.toString(), 0) + (count == 0 ? 1 : count));
                i = (count == 0) ? i - 1 : j - 1;
            } else if (s.charAt(i) == ')') {
                i++;
                int count = 0, j = i;
                
                if (i < n && Character.isDigit(s.charAt(i))) {
                    for (j = i; j < n; j++) {
                        if (Character.isDigit(s.charAt(j))) {
                            count = count * 10 + (s.charAt(j) - '0');
                        } else {
                            break;
                        }
                    }
                }
                
                if (count > 0) {
                    for (Map.Entry<String, Integer> entry : t.entrySet()) {
                        entry.setValue(entry.getValue() * count);
                    }
                    i = j - 1;
                }
                
                for (Map.Entry<String, Integer> entry : t.entrySet()) {
                    prev_map.put(entry.getKey(), prev_map.getOrDefault(entry.getKey(), 0) + entry.getValue());
                }
                return i - 1;
            }
        }
        
        for (Map.Entry<String, Integer> entry : t.entrySet()) {
            prev_map.put(entry.getKey(), prev_map.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
        return i;
    }

    public String countOfAtoms(String formula) {
        int n = formula.length();
        Map<String, Integer> m = new TreeMap<>();
        
        solve(0, formula, n, m);
        
        StringBuilder res = new StringBuilder();
        for (Map.Entry<String, Integer> entry : m.entrySet()) {
            res.append(entry.getKey());
            if (entry.getValue() != 1) {
                res.append(entry.getValue());
            }
        }
        return res.toString();
    }
}