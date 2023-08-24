package dmytro.haiovyi.encoder.alphabetResource;

import java.util.Locale;

public class Alphabet {
    public char[] getAlphabet() {
        return getAlphabet(false);
    }

    public char[] getAlphabet(boolean flagToUpperCase) {
        Locale locale = Locale.getDefault();
        LocaleLanguage language = LocaleLanguage.getLocalLanguage(locale);
        return getAlphabet(language, flagToUpperCase);
    }

    public char[] getAlphabet(LocaleLanguage localeLanguage, boolean flagToUpperCase) {
        if (localeLanguage == null) {
            localeLanguage = LocaleLanguage.ENGLISH;
        }

        char[] alphabet = switch (localeLanguage) {
            case ENGLISH -> "abcdefghijklmnopqrstuvwxyz".toCharArray();
            case UKRAINIAN -> "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя".toCharArray();
            case RUSSIAN -> "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
            default -> throw new IllegalArgumentException("localeLanguage - unknown value!");
        };

        if (flagToUpperCase) {
            alphabet = new String(alphabet).toUpperCase().toCharArray();
        }

        return alphabet;
    }
}