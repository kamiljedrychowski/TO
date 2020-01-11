package com.main;

import com.calculator.Calculator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class MainController {
    private Calculator c;
    private final String allFunctionsNames;
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Function name: %s!";

    public MainController() throws ClassNotFoundException, MalformedURLException, InstantiationException, IllegalAccessException {
        ///Users/jabko/Documents/studies/to/toNasze2/TO/plugins/class/
        c = new Calculator("D:\\Data\\Desktop\\TechnologieObiektowe\\TO\\plugins\\class\\");
        allFunctionsNames= "Avaiable functions: calculate?   " +
                "add, substract, multiply, divide, " +
                c.getListOfReadClass().stream().map(e -> new String(e.getClass().getName())).collect(Collectors.joining(", ")).toLowerCase() +
                "   --REMEMBER ABOUT PARAMETERS \"name\", \"a\" and \"b\"(optionally)";
    }

    @RequestMapping("/")
    public String mainInfo(){
        return allFunctionsNames;
    }

    @RequestMapping("/calculate")
    public Result calculate(@RequestParam(value="name") String name, @RequestParam(value="a") double a, @RequestParam(value="b", defaultValue="0") double b) throws IllegalArgumentException{
        switch(name){
            case "add":
                return new Result((int)counter.incrementAndGet(), name, c.add(a,b));
            case "substract":
                return new Result((int)counter.incrementAndGet(), name, c.substract(a,b));
            case "multiply":
                return new Result((int)counter.incrementAndGet(), name, c.multiply(a,b));
            case "divide":
                return new Result((int)counter.incrementAndGet(), name, c.divide(a,b));
            default:
                for(int i=0; i<c.getListOfReadClass().size(); i++){
                    if(name.equalsIgnoreCase(c.getListOfReadClass().get(i).getClass().getName())){
                        return new Result((int)counter.incrementAndGet(), name, c.getListOfReadClass().get(i).operation(a, b));
                    }
                }
                return new Result((int)counter.incrementAndGet(), "ERROR - No function with that name!", 0);
        }

    }

}
