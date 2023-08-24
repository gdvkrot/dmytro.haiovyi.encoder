package dmytro.haiovyi.encoder;

public class CaesarCipherCyrilicService implements ICaesarCipherCyrilicService {
    @Override
    public String encrypt(String plaintext, int shift, int alphabetSize,
                                 char firstLetterInUppercase, char firstLetterInLowercase) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            int charCode = plaintext.codePointAt(i);
            if (Character.isLetter(charCode)) {
                int base = Character.isUpperCase(charCode) ? firstLetterInUppercase : firstLetterInLowercase;
                encryptedText.appendCodePoint(base + (charCode - base + shift) % alphabetSize);
            } else {
                encryptedText.appendCodePoint(charCode);
            }
        }

        return encryptedText.toString();
    }

    @Override
    public String decrypt(String ciphertext, int shift, int alphabetSize,
                                 char firstLetterInUppercase, char firstLetterInLowercase) {
        return encrypt(ciphertext, alphabetSize - shift, alphabetSize,
                firstLetterInUppercase, firstLetterInLowercase);
    }
}