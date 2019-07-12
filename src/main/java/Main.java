import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String path = "src\\main\\resources\\data.txt";

    public static List<String> textFileParcerArrayList() throws IOException {
        String line;
        try (Scanner scanner = new Scanner(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                String textLine = scanner.nextLine();
                sb = sb.append(textLine + " ");
            }
            line = sb.toString();
        }
        String lineWithoutChars = line.replaceAll("[^A-Za-zА-Яа-я0-9 ^']", "");
        String[] words = lineWithoutChars.split(" ");
        List<String> lineWords = new ArrayList(Arrays.asList(words));
        return lineWords;
    }


    public static void main(String[] args) throws IOException {
        TextParcer.printTotalAmountWords();
        TextParcer.printAmountClearWords();
        TextParcer.printAmountCensoredWords();
        TextParcer.printMaxWord(textFileParcerArrayList());
    }
}
