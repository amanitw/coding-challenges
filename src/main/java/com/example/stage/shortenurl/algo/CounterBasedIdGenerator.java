package com.example.stage.shortenurl.algo;

public class CounterBasedIdGenerator implements IdGenerator{
    private static int counter=56738493;
    private static final String alphaNumeric= "abcdefghijklmopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    @Override
    public synchronized String generate() {
        counter++;
        int d = counter;
        int n = alphaNumeric.length();
        StringBuilder encodedString = new StringBuilder();
        while (d>0){
            encodedString.append(alphaNumeric.charAt(d%n));
            d=d/n;
        }
        return encodedString.toString();
    }
}
