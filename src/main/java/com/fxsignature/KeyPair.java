package com.fxsignature;

import exception.IllegalParameterException;

import java.math.BigInteger;

public class KeyPair {
    private BigInteger p;
    private BigInteger g;
    private BigInteger x;
    private BigInteger y;

    public KeyPair(BigInteger p, BigInteger g, BigInteger x, BigInteger y) throws IllegalParameterException {
        this.p = p;
        if (g.compareTo(p) < 0) {
            this.g = g;
        } else {
            throw new IllegalParameterException("Значение g должно быть меньше p");
        }
        if (x.compareTo(p) < 0) {
            this.x = x;
        } else {
            throw new IllegalParameterException("Значение x должно быть меньше p");
        }
        this.y = y;
    }

    public KeyPair() {
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getG() {
        return g;
    }

    public BigInteger getX() {
        return x;
    }

    public BigInteger getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Открытый ключ: \n" +
                "\t p= " + p + "\n" +
                "\t g= " + g + "\n" +
                "\t y= " + y + "\n \n" +
                "Закрытый ключ: \n" +
                "\t x= " + x

                ;
    }
}
