package com.sahil.learning.java11;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
* JVM access rules allow access to private members between nestmates; however, in previous Java versions, the reflection API denied the same access.

Java 11 fixes this issue and provides means to query the new class file attributes using the reflection API:
*/
public class NestAccessControl {

    public static void main(String[] args) {

        System.out.println(NestedClass.class.isNestmateOf(NestAccessControl.class));
        System.out.println(NestAccessControl.class.isNestmateOf(NestedClass.class));
        System.out.println(NestAccessControl.class.isNestmateOf(String.class));

        Set<String> members = Arrays.stream(NestedClass.class.getNestMembers())
                .map(Class::getName).collect(Collectors.toSet());

        System.out.println(members.contains(NestAccessControl.class.getName()));
        System.out.println(members.contains(NestAccessControl.NestedClass.class.getName()));
    }

    class NestedClass {
        private String nestedProperty;
    }
}
