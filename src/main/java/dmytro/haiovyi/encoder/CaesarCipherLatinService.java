package dmytro.haiovyi.encoder;

public class CaesarCipherLatinService implements ICaesarCipherService {
    @Override
    public String encrypt(String plaintext, int shift, int alphabetSize,
                               char firstLetterInUppercase, char firstLetterInLowercase) {
        StringBuilder encryptedText = new StringBuilder();

        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = (Character.isUpperCase(ch)) ? firstLetterInUppercase : firstLetterInLowercase;
                encryptedText.append((char) (base + (ch - base + shift) % alphabetSize));
            } else {
                encryptedText.append(ch);
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