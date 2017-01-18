import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Etl {

    public final int MAX_LETTER_SCORE = 10;

    public Map<String, Integer> transform(Map<Integer, List<String>> old) {

        Map<String, Integer> newMap = new HashMap<String, Integer>();

        for (int i = 1; i <= MAX_LETTER_SCORE; i++) {
            if (old.containsKey(i)) {
                List letters = old.get(i);
                if (letters.size() == 0) continue;

                for (int j = 0; j < letters.size(); j++) {
                    newMap.put(((String)(letters.get(j))).toLowerCase(), i);
                }
            }
        }

        return newMap;
    }
}
