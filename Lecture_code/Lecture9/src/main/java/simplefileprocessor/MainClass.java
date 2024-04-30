package simplefileprocessor;

import java.io.IOException;

public class MainClass {

  /**
   * Driver method to accept the command line arguments and run the simulation.
   *
   * @param args Command line arguments
   * @throws IOException If any IOException occurs during parsing of CSV files
   */
  public static void main(String[] args) throws IOException {
    FileProcessor fProcessor = new FileProcessor();
    fProcessor.processArguments(args);
  }

}
