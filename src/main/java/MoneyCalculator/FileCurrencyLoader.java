package MoneyCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class FileCurrencyLoader implements CurrencyLoader{

    private final File file;

    public FileCurrencyLoader(String path) {
        this.file = new File(path);
    }

    @Override
    public List<Currency> load() {
        try {
            return new BufferedReader(new FileReader(file)).lines()
                    .filter(l -> !l.isBlank())
                    .map(l -> l.split(";"))
                    .map(l -> new Currency(l[1], l[0]))
                    .toList();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
