package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = applicationContext.getBean("communication", Communication.class);
        String key = "";
        List<String> cookie = communication.getCookie();
        System.out.println("Cookie: "+cookie);

        User user1 = new User(3L,"James","Brown",(byte)3);
        String part1 = communication.saveUser(user1,cookie);
        key += part1;
        System.out.println("part 1 of key: " + part1);

        User user2 = new User(3L,"Thomas","Shelby",(byte)3);
        String part2 = communication.editUser(user2, cookie);
        key +=part2;
        System.out.println("part 2 of key: " + part2);

        String part3 = communication.deleteUser(3, cookie);
        key +=part3;
        System.out.println("part 2 of key: " + part3);

        System.out.println("KEY: " + key);
    }
}
