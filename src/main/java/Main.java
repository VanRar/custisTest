import service.*;
import entity.*;

import java.io.IOException;

public class Main {
    private static int COUNT_LINES_SOURCE;
    private static int RUNTIME_FREE_MEMORY;

    private final static int MIN_LENGTH_STRING = 5;
    private final static int MAX_LENGTH_STRING = 20;
    private final static String PATH_SOURCE_FILE = "source.txt";
    private final static String PATH_RESULT_FILE = "result.txt";


    public static void main(String[] args) throws IOException {

        RUNTIME_FREE_MEMORY = (int) Runtime.getRuntime().freeMemory(); //так-то Xmx соответствует maxMemory, но нас интересует доступная
        COUNT_LINES_SOURCE = RUNTIME_FREE_MEMORY;
        generateFileSource();
        sort();

    }

    private static void generateFileSource() throws IOException {
        long t1 = System.currentTimeMillis();
        CreateFile source = new CreateFile();
        source.createFile(PATH_SOURCE_FILE, COUNT_LINES_SOURCE,
                RUNTIME_FREE_MEMORY, MIN_LENGTH_STRING, MAX_LENGTH_STRING);
        long t2 = System.currentTimeMillis();
        System.out.println("Время создания файла: " + (t2 - t1) / 1_000 + " сек");
    }

    private static void sort() {
        long t1 = System.currentTimeMillis();
        SortFile sortFile = new SortFile();
        try {
            sortFile.sort(PATH_SOURCE_FILE, PATH_RESULT_FILE, RUNTIME_FREE_MEMORY, MAX_LENGTH_STRING);
        } catch (IOException e) {
            System.err.println("Не удалось отсортировать файл");
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("Время сортировки: " + (t2 - t1) / 1_000 + " сек");
    }

}