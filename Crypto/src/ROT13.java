import java.io.*;

import static java.lang.Character.isUpperCase;

public class ROT13  {

    String alpha = "abcdefghijklmnopqrstuvwxyz";
    int shift;

    ROT13(Character cs, Character cf) {
        shift = cf - cs;
    }

    ROT13() {
        shift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder temp = new StringBuilder();
        String lowerCase = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) temp.append(text.charAt(i));
            else {
                int index = alpha.indexOf(lowerCase.charAt(i));
                index += shift;
                index = index % 26;
                if (isUpperCase(text.charAt(i))) temp.append(Character.toUpperCase(alpha.charAt(index)));
                else temp.append(alpha.charAt(index));
            }
        }
        return temp.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int shift = s.indexOf(c);
        return s.substring(shift) + s.substring(0, shift);
    }

    public void Encryption(String input, String output) throws IOException {
        StringBuilder holder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(input));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        String done;
        while ((done = reader.readLine()) != null) {
            holder.append(done).append("\n");
        }
        String encrypted = encrypt(String.valueOf(holder));
        writer.write(encrypted);
        reader.close();
        writer.close();
    }

}
