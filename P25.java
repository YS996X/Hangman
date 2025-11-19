import java.util.Random;

public class P25 {
    public boolean checkChar(char c, String str) {
        return str.indexOf(c) != -1;
    }

    public String getRandomWord(String[] array) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(array.length);
        return array[randomInt];
    }

    public String getRandomWord(String[] array, int len) {
        Random randomGenerator = new Random();
        for (int i = 0; i < 500; i++) {
            int randomInt = randomGenerator.nextInt(array.length);
            if (array[randomInt].length() >= len) {
                return array[randomInt];
            }
        }
        return null;
    }

    public String getRevealedChars(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (char c : s1.toCharArray()) {
            if (checkChar(c, s2)) {
                sb.append(c);
            } else {
                sb.append("_");
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

// made by yuvraj singh


