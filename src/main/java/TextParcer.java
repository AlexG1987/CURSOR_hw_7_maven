import java.io.IOException;
import java.util.*;

class TextParcer {

    private static final String[] badWords = {"shit", "fuck", "bitch", "fucking", "dick", "dork", "fucked"};
    private static final int n = 5;


    private static int countNumOfWords(List<String> lineWords) {
        return lineWords.size();
    }

    private static List<String> returnBadShortWordsList(List<String> lineWords) {
        List<String> badShortWordsList = new ArrayList<>();
        for (String s : badWords) {
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

    static void printTotalAmountWords() throws IOException {
        System.out.println("Total amount of words in text is: " + TextParcer.countNumOfWords(Main.textFileParcerArrayList()));
    }

    static void printAmountClearWords() throws IOException {
        System.out.println("Amount of words without censored and less 3 characters length is: " + (countNumOfWords(Main.textFileParcerArrayList()) - countNumOfWords(TextParcer.returnBadShortWordsList(Main.textFileParcerArrayList()))));
    }

    static void printAmountCensoredWords() throws IOException {
        System.out.println("Amount of censored words: " + TextParcer.countNumOfWords(returnBadShortWordsList(Main.textFileParcerArrayList())));
    }

}
