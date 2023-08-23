package dmytro.haiovyi.encoder;

import java.io.File;
import java.util.ArrayList;

public interface IFileService {
    Boolean fileExists(String filePath);
    void createFile(String filePath);
    ArrayList<String> readFileAsStringCollection(String filePath);
    void writeFileAsStringCollection(String filePath, ArrayList<String> data);
    File getResourceFile(String fileName);
}