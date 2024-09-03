/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Landon Moceri
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";

        // We identified #1 as a caesar cipher with a shift of 9,
        // Handles uppercase letters and wraps around if needed
        for (int index = 0; index < encrypted.length(); index++) {
            char current = encrypted.charAt(index);
            if (current >= 'A' && current <= 'Z') {
                current = (char) (current + 9);
                if (current > 'Z') {
                    current = (char) (current - 26);
                }
            }

            // Handles lowercase letters and wraps around if needed
            else if (current >= 'a' && current <= 'z') {
                current = (char) (current + 9);
                if (current > 'z') {
                    current = (char) (current - 26);
                }
            }

            // Concatenate the current character to the decrypted string
            decrypted += current;
        }

        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        // We identified #2 as ASCII values of characters

        // Split the encrypted string into an array of ASCII values separated by spaces
        String[] encryptedArray = encrypted.split(" ");
        String decrypted = "";

        // Convert each ASCII value to a character and concatenate it to the decrypted string
        for (int index = 0; index < encryptedArray.length; index++) {
            String current = encryptedArray[index];
            int ascii = Integer.parseInt(current);

            current = Character.toString(ascii);
            decrypted += current;
        }

        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        // We identified #3 as being raw binary values of chars in ASCII
        for (int index = 0; index < encrypted.length() / 8; index++) {
            // Get the first 8 characters of the encrypted string
            String current = encrypted.substring(index * 8, (index + 1) * 8);
            int ascii = Integer.parseInt(current, 2);

            // Concatenate the current character to the decrypted string after converting
            current = Character.toString(ascii);
            decrypted += current;
        }


        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // We identified #4 as a shift to dingbat characters
        for (int index = 0; index < encrypted.length(); index++) {
            char current = encrypted.charAt(index);
            // Subtract the lowest dingbat character, then add the lowest ascii letter to get the decrypted character
            current = (char) (current - '\u2700' + 'A');
            // Concatenate
            decrypted += current;
        }

        return decrypted;
    }
}