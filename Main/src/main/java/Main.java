import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        System.out.println("Give us path to classes files with your functions: ");
        String pathToClasses = new Scanner(System.in).nextLine();

        if(pathToClasses.equals("")){
            System.out.println("Using default path");
//            pathToClasses = "/Users/jabko/Documents/studies/to/toNasze2/TO/plugins/class/";
            pathToClasses = "D:\\Data\\Desktop\\CCC\\TO\\plugins\\class\\";
        }
        try{
            Calculator c = new Calculator(pathToClasses);
            c.run();
        } catch(Exception e){
            logger.debug(e.getMessage());
            for (StackTraceElement a: e.getStackTrace()
                 ) {
                logger.debug(a);
            }

        }
    }
}
