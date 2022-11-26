package com.restassured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MethodChaining {

    public static MethodChaining a1() {

        System.out.println("This is a1 method");
        return new MethodChaining();
    }

    public MethodChaining a2() {

        System.out.println("This is a2 method");
        return this;
    }

    public MethodChaining a3() {

        System.out.println("This is a3 method");

        return this;
    }

    public MethodChaining a4() {

        System.out.println("This is a4 method");
        return this;
    }


    public static void main(String[] args) {

        a1().a2().a3().a4();

    }
}
