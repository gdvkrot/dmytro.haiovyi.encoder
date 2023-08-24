package dmytro.haiovyi.encoder.alphabetResource;

import java.util.Locale;

public enum LocaleLanguage {
    UKRAINIAN(new Locale("uk", "UA")),
    RUSSIAN(new Locale("ru", "RUS")),
    ENGLISH(new Locale("en", "US"));

    private final Locale locale;

    LocaleLanguage(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getDisplayLanguage() {
        return getLocale().getDisplayLanguage();
    }

    public String getDisplayLanguage(LocaleLanguage locale) {
        return getLocale().getDisplayLanguage(locale.getLocale());
    }

    public static LocaleLanguage getLocalLanguage(Locale locale) {
        if (locale == null)
            return LocaleLanguage.ENGLISH;

        for (LocaleLanguage localeLanguage : LocaleLanguage.values()) {
            if (localeLanguage.getLocale().getLanguage().equals(locale.getLanguage()))
                return localeLanguage;
        }

        return null;
    }
}