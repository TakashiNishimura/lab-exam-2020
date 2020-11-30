package csv;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class UserCsvReader {

    public List<User> readUserCsv(String csvFilePath) {
        try {
            return new CsvToBeanBuilder<User>(new FileReader(csvFilePath))
                    .withType(User.class).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
