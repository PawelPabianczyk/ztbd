package pl.pk.ztbdpostgresql.service.impl;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import pl.pk.ztbdpostgresql.model.AddressEntity;
import pl.pk.ztbdpostgresql.repository.AddressRepository;
import pl.pk.ztbdpostgresql.service.SubjectService;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.System.currentTimeMillis;
import static pl.pk.ztbdpostgresql.util.SourceFiles.ADDRESS;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final AddressRepository repository;

    public SubjectServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public String loadSubject() {

        try {
            Path path = Paths.get(
                    ClassLoader.getSystemResource(ADDRESS.getFilename()).toURI());
            Reader reader = Files.newBufferedReader(path);

            CsvToBean<AddressEntity> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(AddressEntity.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<AddressEntity> addresses = csvToBean.parse();

            long before = currentTimeMillis();
            repository.saveAllAndFlush(addresses);
            long after = currentTimeMillis();

            return (after - before) + "";


        } catch (Exception ex) {
            return ex.getMessage();
        }


    }
}
