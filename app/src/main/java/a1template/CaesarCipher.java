
// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class CaesarCipher {

    /** Character array to store the letters in the alphabet in order */
    Character[] alphabet;

    /** DynamicArray object providing ArrayList-like operations for Characters */
    DynamicArray<Character> cipher;

    /** Private offset that tracks how many positions to shift the index for
    * This cipher */
    private int offset;

    public char get(int index) { 
        // Implementation
        return cipher.get(index);
    }

    /** Constructor that should define the instance variables, including
     * populating the alphabet
     * @param offset Offset to use when creating `cipher` of DynamicArray type
     */
    CaesarCipher(int offset){
        this.offset = offset;
        this.alphabet = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Character[] shiftedAlphabet = new Character[26];
        for (int i = 0; i < 26; i++) {
            shiftedAlphabet[i] = alphabet[(i - offset + 26) % 26];
        }
        this.cipher = new DynamicArray<>(0, shiftedAlphabet);
    }

    /** Implementation of linear search that looks through the alphabet
     * array to identify the position of the passed value
     * @param val character to search for
     * @return int indicating position of val in the alphabet array
     */
    public int findIndex(char val){
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == val) {
                return i;
            }
        } return -1;
    }

    /** Encode a message using the cipher
     * @param T message to encode
     * @return encoded message */  
    public String encode(String message) {
        String lowerCaseMessage = message.toLowerCase();
        char[] encodedMessage = new char[message.length()];  
        
        for (int i = 0; i < lowerCaseMessage.length(); i++) {
            char c = lowerCaseMessage.charAt(i);
            int index = findIndex(c);  
            
            if (index != -1) {
                encodedMessage[i] = cipher.get(index);  
            } else {
                encodedMessage[i] = c;  
            }
        }
        
        // Convert char array to string and return
        return new String(encodedMessage);
    }
    

    /** Decode a message using the cipher 
     * @param String message to decode
     * @param int key to use in decoding
     * @return decoded message
    */
    public String decode(String message) {
        String lowerCaseMessage = message.toLowerCase();
        char[] decodedMessage = new char[lowerCaseMessage.length()];
        
        for (int i = 0; i < lowerCaseMessage.length(); i++) {
            char c = lowerCaseMessage.charAt(i);
            int index = -1;  // assume character not found first
    
            // Find the index of `c` in `cipher`
            for (int n = 0; n < 26; n++) {
                if (cipher.get(n) == c) {
                    index = n;  // find the index in cipher
                    break;  // Stop finding
                }
            }
    
            if (index != -1) {
                decodedMessage[i] = alphabet[index];  // locate in the original alphabet and put it in decoded message 
            } else {
                decodedMessage[i] = c;  
            }
        }
        return new String(decodedMessage);
    }
    

    public static void main(String[] args) {
        
    }
    
    
}

