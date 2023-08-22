package dmytro.haiovyi.encoder.AlphabetResource;

import java.util.Locale;

public enum LocaleLanguage {
    UKRAINIAN(new Locale("uk", "UA")),
    RUSSIAN(new Locale("ru", "RUS")),
    ENGLISH(new Locale("en", "US"));

    private final Locale mLocale;

    LocaleLanguage(Locale locale) {
        this.mLocale = locale;
    }

    Locale getLocale() {
        return mLocale;
    }

    String getDisplayLanguage() {
        return getLocale().getDisplayLanguage();
    }

    String getDisplayLanguage(LocaleLanguage locale) {
        return getLocale().getDisplayLanguage(locale.getLocale());
    }

    static LocaleLanguage getLocalLanguage(Locale locale) {
        if (locale == null)
            return LocaleLanguage.ENGLISH;

        for (LocaleLanguage localeLanguage : LocaleLanguage.values()) {
            if (localeLanguage.getLocale().getLanguage().equals(locale.getLanguage()))
                return localeLanguage;
        }

        return null;
    }
}