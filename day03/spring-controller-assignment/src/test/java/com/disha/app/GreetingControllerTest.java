package com.disha.app;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class GreetingControllerTest {



        GreetingController greetingController=new GreetingController();

        @Test
        public void testGreet(){
            String expectedResult= "Greet from App";
            String result=greetingController.Greet();
            Assert.assertEquals(expectedResult,result);
        }

        @Test
        public void testWelcome(){
            String expectedResult= "Welcome from App";
            String result=greetingController.Welcome();
            Assert.assertEquals(expectedResult,result);
        }
    @Test
    public void testHi(){
        String expectedResult= "Hi from App";
        String result=greetingController.Hi();
        Assert.assertEquals(expectedResult,result);
    }
    @Test
    public void testThanks(){
        String expectedResult= "Thanks from App";
        String result=greetingController.Thanks();
        Assert.assertEquals(expectedResult,result);
    }

    }

