package dmytro.haiovyi.encoder;

import dmytro.haiovyi.encoder.AlphabetResource.Alphabet;
import dmytro.haiovyi.encoder.AlphabetResource.LocaleLanguage;

public class Solution {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        char[] ukrainianAlphabet = alphabet.getAlphabet(LocaleLanguage.UKRAINIAN, true);
        char[] russianAlphabet = alphabet.getAlphabet(LocaleLanguage.RUSSIAN, false);
        char[] englishAlphabet = alphabet.getAlphabet(LocaleLanguage.ENGLISH, false);

        // get default uppercase alphabet
        char[] currentAlphabet = alphabet.getAlphabet(true);

        System.out.println(ukrainianAlphabet);
        ukrainianAlphabet = alphabet.getAlphabet(LocaleLanguage.UKRAINIAN, false);
        System.out.println(ukrainianAlphabet);
        System.out.println(russianAlphabet);
        System.out.println(englishAlphabet);
        System.out.println(currentAlphabet);
    }
}