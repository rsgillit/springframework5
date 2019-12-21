package com.gill.didemo;


import com.gill.didemo.controllers.ConstructorInjectedController;
import com.gill.didemo.controllers.MyController;
import com.gill.didemo.controllers.PropertyInjectedController;
import com.gill.didemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctx.getBean("myController");

        //controller.hello();

        System.out.println(ctx.getBean(MyController.class).hello());
        System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
        System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());


    }

}
