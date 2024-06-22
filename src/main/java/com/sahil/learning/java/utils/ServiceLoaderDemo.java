package com.sahil.learning.java.utils;

import java.util.ServiceLoader;

public class ServiceLoaderDemo {

    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        // DID NOT WORK
        System.out.println("Implementations of Instrument ");
        ServiceLoader.load(Instrument.class).stream().forEach(System.out::println);
    }

    interface Instrument {
        void play();
    }

    interface InstrumentBuilder {
        void build(Instrument instrument);
    }

    static class Guitar implements Instrument{
        @Override
        public void play() {
            System.out.println("Playing Guitar ...");
        }
    }

    class Keyboard implements Instrument, InstrumentBuilder{
        @Override
        public void play() {
            System.out.println("Playing Keyboard ...");
        }

        @Override
        public void build(Instrument instrument) {
            System.out.println("Building Keyboard ...");
        }
    }

    class Drums implements Instrument{
        @Override
        public void play() {
            System.out.println("Playing Drums ...");
        }
    }
}
