package dmytro.haiovyi.encoder;

public class Solution {
    public static void main(String[] args) {
        ICLIService cliService = new CLIService();
        IFileService fileService = new FileService(cliService);
        ICaesarCipherService caesarCipherService = new CaesarCipherService();

        Runner runner = new Runner(cliService, fileService, caesarCipherService);
        if (args.length < 4) {
            runner.executeWithScannerParams();
        }
        else {
            runner.executeWithCLIParams(args[0], args[1], args[2], args[3]);
        }
    }
}