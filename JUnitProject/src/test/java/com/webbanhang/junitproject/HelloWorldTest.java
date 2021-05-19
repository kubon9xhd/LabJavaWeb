/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbanhang.junitproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author asus
 */
public class HelloWorldTest {

    HelloWorld helloWorldInstance;

    @Before
    public void setUp() {
        System.out.println("* HelloWorldTest: Before method setUp()");
        helloWorldInstance = new HelloWorld();
    }

    @After
    public void tearDown() {
        System.out.println("* HelloWorldTest: After method tearDown()");
        helloWorldInstance = null;
    }

    /**
     * unit test for formMessage method.
     */
    @Test
    public void testFormMessage() {
        //Asserts that two Strings are equal                
        String expResult = "Hello World!";
        String result = helloWorldInstance.formMessage();
        System.out.println("* HelloWorldTest: test method 1 testFormMessage()");
        Assert.assertEquals(expResult, result);
    }

}
