package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

}

//
//import com.calculator.Calculator;
//import java.util.Scanner;
//import org.apache.log4j.Logger;
//
//public class Main {
//    private final static Logger logger = Logger.getLogger(Main.class);
//    public static void main(String[] args) {
//
//        System.out.println("Give us path to classes files with your functions: ");
//        String pathToClasses = new Scanner(System.in).nextLine();
//
//        if(pathToClasses.equals("")){
//            System.out.println("Using default path");
////            pathToClasses = "/Users/jabko/Documents/studies/to/toNasze2/TO/plugins/class/";
//            pathToClasses = "D:\\Data\\Desktop\\TechnologieObiektowe\\TO\\plugins\\class\\";
//        }
//        try{
//            Calculator c = new Calculator(pathToClasses);
////            c.run();
//
//            System.out.println(c.add(2,3));
//            System.out.println(c.plugins(0,4,1));
//
//
//
//
//        } catch(Exception e){
//            logger.debug(e.getMessage());
//            for (StackTraceElement a: e.getStackTrace()
//                 ) {
//                logger.debug(a);
//            }
//
//        }
//    }
//}
// TODO Rest na Spring boocie