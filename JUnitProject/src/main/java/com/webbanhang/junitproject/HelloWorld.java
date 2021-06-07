/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbanhang.junitproject;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 *
 * @author asus
 */
public class HelloWorld {

    private String hello;
    private String world;

    /**
     * Constructor
     */
    HelloWorld() {
        hello = "Hello";
        world = "World!";
    }

    /**
     * forms the Hello World Message.
     */
    public String formMessage() {
        String message;
        message = hello + " " + world;
        return message;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.formMessage());
         Integer[] arr = {1,3};
         Integer[] arr1 = {3,1};
         System.out.println(Arrays.deepEquals(arr, arr1));
        System.out.println();
    }

}
