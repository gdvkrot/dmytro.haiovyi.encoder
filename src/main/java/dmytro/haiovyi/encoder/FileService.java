package dmytro.haiovyi.encoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileService implements IFileService {
    private final ICLIService cliService;

    public FileService(ICLIService cliService) {
        if (cliService == null) {
            throw new IllegalArgumentException("cliService - null value!");
        }

        this.cliService = cliService;
    }

    @Override
    public Boolean fileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }

    @Override
    public void createFile(String filePath) {
        try {
            if (!fileExists(filePath)) {
                Files.createFile(Path.of(filePath));
                cliService.printMessage("File created successfully.");
            } else {
                cliService.printMessage("File '" + filePath + "' is exists and can't to be created!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<String> readFileAsStringCollection(String filePath) {
        var result = new ArrayList<String>();

        if (!fileExists(filePath)) {
            cliService.printMessage("File '" + filePath + "' doesn't exists! Can't read info from this file!");
            return result;
        }

        try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cliService.printMessage("Read line from file: " + line);
                result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void writeFileAsStringCollection(String filePath, ArrayList<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line: data) {
                writer.write(line);
                writer.newLine();
                cliService.printMessage("Line written to file: " + line);
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public File getResourceFile(String fileName) {
        ClassLoader classLoader = FileService.class.getClassLoader();
        URL resourceUrl = classLoader.getResource(fileName);

        if (resourceUrl != null) {
            return new File(resourceUrl.getFile());
        }

        return null;
    }
}