package entity;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {

    public void createFile(String pathResultFile, int countString, int countLinesAvailableRAM, int minLengthString, int maxLengthString) throws IOException {
        int sizeBuffer = countLinesAvailableRAM / (maxLengthString);//по-хорошему надо почитать чего и сколько, тут есть риск выскочить за размер
        List<String> stringList = new ArrayList<>(sizeBuffer);

        Path path = Paths.get(pathResultFile);
        Files.deleteIfExists(path);
        Files.createFile(path);
        for (int i = 0; i < countString; ) {
            for (int j = 0; j < sizeBuffer && i < countString; j += 20, i++) {
                stringList.add(RandomStringUtils.randomAlphanumeric(minLengthString, maxLengthString));
            }
            Files.write(path, stringList, StandardOpenOption.APPEND);
            stringList.clear();

        }
    }
}
