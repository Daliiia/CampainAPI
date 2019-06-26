package instascaler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;


@SpringBootApplication
public class InstaScaler {
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SpringApplication.run(InstaScaler.class, args);


    }
}

