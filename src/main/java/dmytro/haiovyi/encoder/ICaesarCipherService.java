package dmytro.haiovyi.encoder;

public interface ICaesarCipherService {
    String encryptCyrilic(String plaintext, int shift, int alphabetSize);
    String encryptLatin(String plaintext, int shift, int alphabetSize);
    String decryptCyrilic(String ciphertext, int shift, int alphabetSize);
    String decryptLatin(String ciphertext, int shift, int alphabetSize);
}