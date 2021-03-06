package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) {

    int mac9FirstNL = lines.indexOf("\r");
    int unixFirstNL = lines.indexOf("\n");
    int winFirstNL = lines.indexOf("\r\n");
    int min = mac9FirstNL;
    boolean win = false;

    if (unixFirstNL != -1 ) {
      min = unixFirstNL;
    }

    if (winFirstNL != -1 ) {
      min = winFirstNL;
      win = true;
    }

    if (min == -1) {
      String[] ret = {"",lines} ;
      return ret;
    }

    String[] ret = {lines.substring(0, min + (win ? 2 : 1)), lines.substring(min + (win ? 2 : 1))};
    return  ret;
  }

}
