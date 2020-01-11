package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;
@SpringBootApplication
public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            SpringApplication.run(Main.class, args);
        } catch(Exception e){
            logger.debug(e.getMessage());
            for (StackTraceElement a: e.getStackTrace()) {
                logger.debug(a);
            }
        }

    }

}
