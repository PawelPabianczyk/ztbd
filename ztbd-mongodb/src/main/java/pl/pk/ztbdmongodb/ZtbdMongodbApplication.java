package pl.pk.ztbdmongodb;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pk.ztbdmongodb.util.ImportJsonService;
import pl.pk.ztbdmongodb.util.ImportUtils;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class ZtbdMongodbApplication implements ApplicationRunner {

    private final ImportJsonService importService;

    public ZtbdMongodbApplication(ImportJsonService importService) {
        this.importService = importService;
    }

    public static void main(String... args) {
        SpringApplication.run(ZtbdMongodbApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws IOException {

        List<String> collections = args.getOptionValues("collection");
        List<String> files = args.getOptionValues("import");

        List<String> results = List.of(importService.importTo(collections.get(0), ImportUtils.linesFromResource(files.get(0))),
                importService.importTo(collections.get(1), ImportUtils.linesFromResource(files.get(1))),
                importService.importTo(collections.get(2), ImportUtils.linesFromResource(files.get(2))));

        for (String result :
                results) {
            System.out.println(result);
        }
    }
}
