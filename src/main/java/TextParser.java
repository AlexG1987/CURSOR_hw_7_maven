import java.util.*;

class TextParser {

    private static final String[] BADWORDS = {"shit", "fuck", "bitch", "fucking", "dick", "dork", "fucked"};
    private static final int N = 5;

    static List<String> returnBadShortWordsList(List<String> lineWords) {
        List<String> badShortWordsList = new ArrayList<>();
        for (String s : BADWORDS) {
            for (String w : lineWords) {
                if (s.equalsIgnoreCase(w)) {
                    badShortWordsList.add(w);
                }
            }
        }
        for (String l : lineWords) {
            if (l.length() < 3) {
                badShortWordsList.add(l);
            }
        }
        return badShortWordsList;
    }

    static void printMaxWord(final List<String> WordsList) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : WordsList) {
            Integer count = wordCounts.get(word);
            if (count == null) {
                count = 0;
            }
            wordCounts.put(word, count + 1);
        }
        Set<Map.Entry<String, Integer>> entrySet = wordCounts.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(entrySet);
        list.sort((e1, e2) -> (e2.getValue().compareTo(e1.getValue())));
        System.out.println("Most frequent words are : (" + N + " most repeated)");
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            count++;
            if (entry.getValue() > 1) {
                System.out.println("Word: " + entry.getKey() + " : " + entry.getValue() + " times repeated");
            }
            if (count == N) {
                break;
            }
        }
    }
}
