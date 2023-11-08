package com.fxsignature;

import java.math.BigInteger;

public class Signature {
    public static BigInteger a;
    public static BigInteger b;

    public Signature(BigInteger a, BigInteger b) {
        this.a = a;
        this.b = b;
    }

    public static BigInteger getA() {
        return a;
    }

    public BigInteger getB() {
        return b;
    }

    @Override
    public String toString() {
        return "Signature \n" +
                "\t a= " + a +
                "\n \t b= " + b
                ;
    }
}
