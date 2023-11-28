package MoneyCalculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileExchangeRateWriter implements ExchangeRateWriter{
    private final File file;

    public FileExchangeRateWriter(String pathname) {
        this.file = new File(pathname);
    }

    @Override
    public void write(ExchangeRate exchangeRate) {
        createFile();
        try (BufferedWriter writer = getFileWriter()) {
            writer.write(buildLine(exchangeRate));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String buildLine(ExchangeRate exchangeRate) {
        return exchangeRate.from().code() + ";"
                + exchangeRate.to().code() + ";"
                + exchangeRate.rate() + ";"
                + exchangeRate.date() + "\n";
    }

    private void createFile() {
        if (file.exists()) return;
        try (BufferedWriter writer = getFileWriter()) {
            writer.write("from;to;rate;date\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedWriter getFileWriter() {
        try {
            return new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
