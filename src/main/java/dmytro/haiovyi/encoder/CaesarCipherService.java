package dmytro.haiovyi.encoder;

public class CaesarCipherService implements ICaesarCipherService {
    @Override
    public String encryptCyrilic(String plaintext, int shift, int alphabetSize) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            int charCode = plaintext.codePointAt(i);
            if (Character.isLetter(charCode)) {
                int base = Character.isUpperCase(charCode) ? 'А' : 'а';
                encryptedText.appendCodePoint(base + (charCode - base + shift) % alphabetSize);
            } else {
                encryptedText.appendCodePoint(charCode);
            }
        }

        return encryptedText.toString();
    }

    @Override
    public String encryptLatin(String plaintext, int shift, int alphabetSize) {
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = (Character.isUpperCase(ch)) ? 'A' : 'a';
                encryptedText.append((char) (base + (ch - base + shift) % alphabetSize));
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText.toString();
    }

    @Override
    public String decryptCyrilic(String ciphertext, int shift, int alphabetSize) {
        return encryptCyrilic(ciphertext, alphabetSize - shift, alphabetSize);
    }

    @Override
    public String decryptLatin(String ciphertext, int shift, int alphabetSize) {
        return encryptLatin(ciphertext, alphabetSize - shift, alphabetSize);
    }
}