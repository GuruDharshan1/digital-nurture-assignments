//Created by Guru Dharshan T.R - Testing Singleton Pattern

package singleton;

public class LoggerTest {
 public static void main(String[] args) {
     Logger log1 = Logger.getLogger();
     Logger log2 = Logger.getLogger();

     log1.writeLog("First log entry.");
     log2.writeLog("Second log entry.");

     if (log1 == log2) {
         System.out.println("✅ Same Logger instance being used. Singleton works!");
     } else {
         System.out.println("❌ Different instances. Singleton failed!");
     }
 }
}
