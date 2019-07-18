import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {

    private static final String PATH = "src\\main\\resources\\data.txt";

    static List<String> textFileParserToArrayList() throws IOException {
        String line;
        try (Scanner scanner = new Scanner(new FileReader(PATH))) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                String textLine = scanner.nextLine();
                sb.append(textLine).append(" ");
            }
            line = sb.toString();
        }
        String lineWithoutChars = line.replaceAll("[^A-Za-zА-Яа-я0-9 ^']", "");
        String[] words = lineWithoutChars.split(" ");
        return Arrays.asList(words);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Total amount of words in text is: " + textFileParserToArrayList().size());
        System.out.println("Amount of filtered words in text is: " + (textFileParserToArrayList().size() - TextParser.returnBadShortWordsList(textFileParserToArrayList()).size()));
        System.out.println("Amount of censored words is: " + TextParser.returnBadShortWordsList(textFileParserToArrayList()).size());
        TextParser.printMaxWord(textFileParserToArrayList());

    }
}
