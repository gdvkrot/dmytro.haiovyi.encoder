package dmytro.haiovyi.encoder;

import dmytro.haiovyi.encoder.alphabetResource.Alphabet;
import dmytro.haiovyi.encoder.alphabetResource.LocaleLanguage;

import java.io.File;
import java.util.ArrayList;

public class Runner {
    private final ICLIService cliService;
    private final IFileService fileService;
    private final ICaesarCipherService caesarCipherLatinService;
    private final ICaesarCipherService caesarCipherCyrilicService;

    public Runner(ICLIService cliService, IFileService fileService,
                  ICaesarCipherService caesarCipherLatinService,
                  ICaesarCipherService caesarCipherCyrilicService) {
        if (cliService == null) {
            throw new IllegalArgumentException("cliService - null value!");
        }
        if (fileService == null) {
            throw new IllegalArgumentException("fileService - null value!");
        }
        if (caesarCipherLatinService == null) {
            throw new IllegalArgumentException("caesarCipherLatinService - null value!");
        }
        if (caesarCipherCyrilicService == null) {
            throw new IllegalArgumentException("caesarCipherCyrilicService - null value!");
        }

        this.cliService = cliService;
        this.fileService = fileService;
        this.caesarCipherLatinService = caesarCipherLatinService;
        this.caesarCipherCyrilicService = caesarCipherCyrilicService;
    }

    public void executeWithCLIParams(String fileName, String inputMode, String inputLanguage, String inputKey) {
        prepareParamsToExecute(fileName, inputMode, inputLanguage, inputKey);
    }

    public void executeWithScannerParams() {
        String fileName = cliService.readStringLine("Please enter name of file (get from resources)");
        String inputMode = cliService.readStringLine("Please enter mode (ENCRYPT, DECRYPT, BRUTE_FORCE)");
        String inputLanguage = cliService.readStringLine("Please enter language (UKRAINIAN, RUSSIAN, ENGLISH)");
        String inputKey = cliService.readStringLine("Please enter key value (only Integer)");

        prepareParamsToExecute(fileName, inputMode, inputLanguage, inputKey);
    }

    private void prepareParamsToExecute(String fileName, String inputMode, String inputLanguage, String inputKey) {
        File resourceFile = fileService.getResourceFile(fileName);

        if (resourceFile != null) {
            cliService.printMessage("File path: " + resourceFile.getAbsolutePath());
        } else {
            cliService.printMessage("File '" + fileName + "' not found in resources.");
            return;
        }

        Mode mode = switch (inputMode) {
            case "ENCRYPT" -> Mode.ENCRYPT;
            case "DECRYPT" -> Mode.DECRYPT;
            default -> Mode.BRUTE_FORCE;
        };
        if (mode == Mode.BRUTE_FORCE) {
            cliService.printMessage("Sorry, this method not implemented!");
            return;
        }

        LocaleLanguage language = switch (inputLanguage) {
            case "UKRAINIAN" -> LocaleLanguage.UKRAINIAN;
            case "RUSSIAN" -> LocaleLanguage.RUSSIAN;
            default -> LocaleLanguage.ENGLISH;
        };

        int key = Integer.parseInt(inputKey);

        execute(mode, resourceFile.getAbsolutePath(), key, language);
    }

    private void execute(Mode mode, String filePath, int key, LocaleLanguage language) {
        ArrayList<String> rawStrings = fileService.readFileAsStringCollection(filePath);
        var resultStrings = new ArrayList<String>();

        Alphabet currentAlphabet = new Alphabet();

        int alphabetSize = currentAlphabet.getAlphabet(language, true).length;
        char firstLetterInUppercase = currentAlphabet.getAlphabet(language, true)[0];
        char firstLetterInLowercase = currentAlphabet.getAlphabet(language, false)[0];

        switch (mode) {
            case ENCRYPT: {
                if (language == LocaleLanguage.ENGLISH) {
                    for (String item : rawStrings) {
                        resultStrings.add(caesarCipherLatinService.encrypt(
                                item, key, alphabetSize, firstLetterInUppercase, firstLetterInLowercase));
                    }
                } else {
                    for (String item : rawStrings) {
                        resultStrings.add(caesarCipherCyrilicService.encrypt(
                                item, key, alphabetSize, firstLetterInUppercase, firstLetterInLowercase));
                    }
                }
                break;
            }
            case DECRYPT: {
                if (language == LocaleLanguage.ENGLISH) {
                    for (String item : rawStrings) {
                        resultStrings.add(caesarCipherLatinService.decrypt(
                                item, key, alphabetSize, firstLetterInUppercase, firstLetterInLowercase));
                    }
                } else {
                    for (String item : rawStrings) {
                        resultStrings.add(caesarCipherCyrilicService.decrypt(
                                item, key, alphabetSize, firstLetterInUppercase, firstLetterInLowercase));
                    }
                }
                break;
            }
            default:
                break;
        }

        fileService.writeFileAsStringCollection(filePath, resultStrings);
    }
}