package algorithms;

public class CaesarCipher {
    // Array to store the mapping for encryption (shifted letters)
    protected char[] encoder = new char[26]; // Encryption array
    // Array to store the mapping for decryption (reverse of encryption)
    protected char[] decoder = new char[26]; // Decryption array

    /**
     * Constructor that initializes the encryption and decryption arrays
     * 
     * @param rotation The number of positions to shift letters in the alphabet
     */
    public CaesarCipher(int rotation) {
        // Loop through all 26 letters of the alphabet
        for (int i = 0; i < 26; i++) {
            // Calculate the shifted letter for encryption
            // (i + rotation) % 26 ensures the result wraps around within the alphabet
            encoder[i] = (char) ('A' + (i + rotation) % 26);
            // Calculate the shifted letter for decryption
            // (i - rotation + 26) % 26 ensures the result is positive and wraps around
            decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
        }
    }

    /**
     * Encrypts a message using the Caesar cipher
     * 
     * @param message The original message to encrypt
     * @return The encrypted message
     */
    public String encrypt(String message) {
        // Use the encoder array to transform the message
        return transform(message, encoder);
    }

    /**
     * Decrypts a message using the Caesar cipher
     * 
     * @param message The encrypted message to decrypt
     * @return The original message
     */
    public String decrypt(String message) {
        // Use the decoder array to transform the message
        return transform(message, decoder);
    }

    /**
     * Transforms a message using the given code array (encoder or decoder)
     * 
     * @param message The message to transform
     * @param code    The code array to use for transformation (encoder or decoder)
     * @return The transformed message
     */
    public String transform(String message, char[] code) {
        // Convert the message to a character array for processing
        char[] messageChars = message.toCharArray();
        // Loop through each character in the message
        for (int i = 0; i < messageChars.length; i++) {
            char c = messageChars[i];
            // Only process uppercase letters
            if (Character.isUpperCase(c)) {
                // Find the index of the letter in the alphabet (0 for 'A', 1 for 'B', etc.)
                int j = c - 'A';
                // Replace the letter with the corresponding letter from the code array
                messageChars[i] = code[j];
            }
        }
        // Convert the character array back to a string and return it
        return new String(messageChars);
    }

    public static void main(String[] args) {
        // Test the CaesarCipher class with a rotation value
        int rotation = 3; // Example rotation value (shift letters by 3 positions)
        CaesarCipher cipher = new CaesarCipher(rotation);

        // Original message to encrypt
        String message = "HELLO";
        // Encrypt the message
        String encryptedMessage = cipher.encrypt(message);
        // Decrypt the encrypted message back to the original
        String decryptedMessage = cipher.decrypt(encryptedMessage);

        // Print the encoder and decoder arrays for reference
        System.out.println("encoder: " + new String(cipher.encoder)); // Shows the shifted alphabet for encryption
        System.out.println("decoder: " + new String(cipher.decoder)); // Shows the shifted alphabet for decryption

        // Print the original, encrypted, and decrypted messages
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}
