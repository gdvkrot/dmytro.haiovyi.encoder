package dmytro.haiovyi.encoder;

public class Solution {
    public static void main(String[] args) {
        final int CORRECT_COUNT_OF_ARGUMENTS = 4;

        ICLIService cliService = new CLIService();
        IFileService fileService = new FileService(cliService);
        ICaesarCipherService caesarCipherLatinService = new CaesarCipherLatinService();
        ICaesarCipherService caesarCipherCyrilicService = new CaesarCipherCyrilicService();

        Runner runner = new Runner(cliService, fileService, caesarCipherLatinService, caesarCipherCyrilicService);
        if (args.length < CORRECT_COUNT_OF_ARGUMENTS) {
            runner.executeWithScannerParams();
        }
        else {
            runner.executeWithCLIParams(args[0], args[1], args[2], args[3]);
        }
    }
}
