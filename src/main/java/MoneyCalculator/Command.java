package MoneyCalculator;

import MoneyCalculator.FixerIO.UnsucessfulFixerIOResponseException;

public interface Command {
    void execute() throws UnsucessfulFixerIOResponseException;
}
