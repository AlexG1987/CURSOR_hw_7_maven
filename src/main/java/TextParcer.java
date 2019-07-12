import java.io.IOException;
import java.util.*;

public class TextParcer {

    private static final String[] badWords = {"shit", "fuck", "bitch", "fucking", "dick", "dork", "fucked"};
    protected static final int n = 5;


    public static int countNumOfWords(List<String> lineWords) {
        return lineWords.size();
    }

    public static List<String> returnBadShortWordsList(List<String> lineWords) {
        List<String> badShortWordsList = new ArrayList();
        for (String s : badWords) {
            for (String w : lineWords) {
                if (s.equalsIgnoreCase(w)) {
                    badShortWordsList.add(w);
                }
            }
        }
        for (String l : lineWords) {
            if (l.length() < 3)
                badShortWordsList.add(l);
        }
        return badShortWordsList;
    }

    public static void printMaxWord(final List<String> WordsList) {
        Map<String, Integer> wordCounts = new HashMap<String, Integer>();
        for (String word : WordsList) {
            Integer count = wordCounts.get(word);
            if (count == null) {
                count = 0;
            }
            wordCounts.put(word, count + 1);
        }
        Set<Map.Entry<String, Integer>> entrySet = wordCounts.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return (e2.getValue().compareTo(e1.getValue()));
            }
        });
        System.out.println("Most frequent words are : (" + n + " most repeated)");
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            count++;
            if (entry.getValue() > 1) {
                System.out.println("Word: " + entry.getKey() + " : " + entry.getValue() + " times repeated");
            }
            if (count == n) {
                break;
            }
        }
    }

    public static void printTotalAmountWords() throws IOException {
        System.out.println("Total amount of words in text is: " + TextParcer.countNumOfWords(Main.textFileParcerArrayList()));
    }

    public static void printAmountClearWords() throws IOException {
        System.out.println("Amount of words without censored and less 3 characters length is: " + (countNumOfWords(Main.textFileParcerArrayList()) - countNumOfWords(TextParcer.returnBadShortWordsList(Main.textFileParcerArrayList()))));
    }

    public static void printAmountCensoredWords() throws IOException {
        System.out.println("Amount of censored words: " + TextParcer.countNumOfWords(returnBadShortWordsList(Main.textFileParcerArrayList())));
    }

}
