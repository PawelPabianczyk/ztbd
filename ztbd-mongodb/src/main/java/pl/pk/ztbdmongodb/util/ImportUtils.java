package pl.pk.ztbdmongodb.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ImportUtils {

    private ImportUtils() {
    }

    public static List<String> lines(String json) {
        String[] split = json.split("[\\r\\n]+");
        return Arrays.asList(split);
    }

    public static List<String> linesFromResource(String resource) throws IOException {
        Resource input = new ClassPathResource(resource);
        Path path = input.getFile().toPath();
        return Files.readAllLines(path);
    }
}
