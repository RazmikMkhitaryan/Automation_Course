import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Random;

public class TestService {
    static String emailGenerator(int targetStringLength) throws IOException {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);

        }
        String gt = "";
        for (int i = 0; i < 2; i++) {
            int r = random.nextInt(10);
            gt= gt+r;
        }

        String dd= buffer.toString()+ buffer.toString().toUpperCase()+gt+"@gmail.com";
        String gg= dd+"\n";
        Files.write(Paths.get("text.txt"), gg.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        return dd;
    }

    static String stringGenerator(int targetStringLength) throws IOException {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);

        }
        String gt = "";
        for (int i = 0; i < 2; i++) {
            int r = random.nextInt(10);
            gt= gt+r;
        }

        String dd= buffer.toString()+ buffer.toString().toUpperCase()+gt;
        String gg= dd+"\n";
        Files.write(Paths.get("text.txt"), gg.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        return dd;
    }

}
