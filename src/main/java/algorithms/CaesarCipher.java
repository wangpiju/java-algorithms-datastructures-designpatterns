package algorithms;

public class CaesarCipher {
    protected char[] encoder = new char[26]; // Encryption array
    protected char[] decoder = new char[26]; // Decryption array

    /** Constructor that initializes the encryption and decryption arrays */
    public CaesarCipher(int rotation) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + (i + rotation) % 26);
            decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
        }
    }

    public String encrypt(String message) {
        return transform(message, encoder);
    }

    public String decrypt(String message) {
        return transform(message, decoder);
    }

    public String transform(String message, char[] code) {
        char[] messageChars = message.toCharArray();
        for (int i = 0; i < messageChars.length; i++) {
            char c = messageChars[i];
            if (Character.isUpperCase(c)) {
                int j = c - 'A';
                messageChars[i] = code[j];
            }
        }
        return new String(messageChars);
    }

    public static void main(String[] args) {
        // Test the CaesarCipher class
        int rotation = 0; // Example rotation value
        CaesarCipher cipher = new CaesarCipher(rotation);

        String message = "HELLO";
        String encryptedMessage = cipher.encrypt(message);
        String decryptedMessage = cipher.decrypt(encryptedMessage);
        System.out.println("encoder: " + new String(cipher.encoder));
        System.out.println("decoder: " + new String(cipher.decoder));

        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
