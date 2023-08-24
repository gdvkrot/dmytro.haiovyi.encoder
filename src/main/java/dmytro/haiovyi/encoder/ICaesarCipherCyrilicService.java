package dmytro.haiovyi.encoder;

public interface ICaesarCipherCyrilicService {
    String encrypt(String plaintext, int shift, int alphabetSize,
                          char firstLetterInUppercase, char firstLetterInLowercase);
    String decrypt(String ciphertext, int shift, int alphabetSize,
                          char firstLetterInUppercase, char firstLetterInLowercase);
}