//Created by Guru Dharshan T.R - Singleton Pattern Example

package singleton;

public class Logger {

 private static Logger myLogger;

 private Logger() {
     System.out.println("Logger is up and running...");
 }

 public static Logger getLogger() {
     if (myLogger == null) {
         myLogger = new Logger();
     }
     return myLogger;
 }

 public void writeLog(String msg) {
     System.out.println("[Log] " + msg);
 }
}
