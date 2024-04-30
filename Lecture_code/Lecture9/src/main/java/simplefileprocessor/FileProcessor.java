package simplefileprocessor;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by tbonaci on April 3, 2018.
 */
public class FileProcessor {
    private String processingFlag = CmdLineArgs.DEFAULT_VALUE_PROCESSING_FLAG;
    Writer writer;

    protected void processArguments(String[] args) {
        if (args.length < CmdLineArgs.MIN_NUMBER_ARGS) {
            throw new CmdLineExceptions.MissingCommandException("You have missed some required arguments."
                    + " Please check the usage");
        }
        if (args.length > CmdLineArgs.MAX_NUMBER_ARGUMENTS) {
            throw new CmdLineExceptions.ExtraArgumentException("You have provided extra arguments. Please check the usage");
        }
    }
}
