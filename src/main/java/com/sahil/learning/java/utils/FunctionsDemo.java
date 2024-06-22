package com.sahil.learning.java.utils;

import java.util.List;
import java.util.function.*;

public class FunctionsDemo {

    public static void main(String[] args) {
        final BiConsumer<String, String> biConsumer = (a,b) -> System.out.println(a + b);
        biConsumer.accept("Sahil ", "Verma");

        final BiFunction<String, Integer, String> biFunction = (a, b) -> a + b;
        System.out.println(biFunction.apply("ID : ", 1));

        final BinaryOperator<Double> binaryOperator = Double::sum;
        System.out.println(binaryOperator.apply(1.1, 2.2));

        final BiPredicate<Double, Long> biPredicate = (a, b) -> a > 1.0 && b > 2.0;
        System.out.println(biPredicate.test(0.9, 5L));

        final BooleanSupplier booleanSupplier = () -> Math.random() > 0.5;
        System.out.println(booleanSupplier.getAsBoolean());

        final Consumer<List<String>> consumer = (list) -> list.forEach(System.out::println);
        consumer.accept(List.of("Sahil", "Developer", "India"));

        final DoubleBinaryOperator doubleBinaryOperator = (a, b) -> a * b;
        System.out.println(doubleBinaryOperator.applyAsDouble(1.1, 5.0));

        final DoubleConsumer doubleConsumer = System.out::println;
        doubleConsumer.accept(1000.0);

        final DoubleFunction<String> doubleFunction = d -> "Double value " + d;
        System.out.println(doubleFunction.apply(3.333));

        final DoublePredicate doublePredicate = d -> d > 3.333;
        System.out.println(doublePredicate.test(4.0));
        System.out.println(doublePredicate.test(1.0));

        final DoubleSupplier doubleSupplier = () -> Math.random() * 12;
        System.out.println(doubleSupplier.getAsDouble());

        final DoubleToIntFunction doubleToIntFunction = Math::getExponent;
        System.out.println(doubleToIntFunction.applyAsInt(15.854345));

        final DoubleToLongFunction doubleToLongFunction = Math::round;
        System.out.println(doubleToIntFunction.applyAsInt(15.854345));

        final DoubleUnaryOperator doubleUnaryOperator = Math::abs;
        System.out.println(doubleUnaryOperator.applyAsDouble(-12.43));

        final Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply("india"));

        final Function<String, String> identity = Function.identity();
        System.out.println(identity.apply("MIRAGARIM"));

        // int and long functions similar to Double are skipped.

        final ObjDoubleConsumer<String> objDoubleConsumer = (obj, d) -> System.out.println(obj + d);
        objDoubleConsumer.accept("My age is ", 29);
        // similary ObjIntConsumer and ObjLongConsumer

        final Predicate<int[]> predicate = arr -> arr.length > 2;
        System.out.println(predicate.test(new int[]{1,2,3}));
        System.out.println(predicate.test(new int[]{1}));

        final Supplier<Short> supplier = () ->  (short)12 ;
        System.out.println("Value is " + supplier.get());

        final ToDoubleBiFunction<Integer, Float> toDoubleBiFunction = (a, b) -> a * b;
        System.out.println(toDoubleBiFunction.applyAsDouble(1, 4f));

        final ToDoubleFunction<Integer> toDoubleFunction = num -> Math.random() * num;
        System.out.println(toDoubleFunction.applyAsDouble(2));

        final UnaryOperator<String> unaryOperator = String::trim;
        System.out.println("Value is " + unaryOperator.apply("\t Sahil   \n"));


    }
}
