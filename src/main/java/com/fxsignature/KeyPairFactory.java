package com.fxsignature;

import exception.IllegalParameterException;

import java.math.BigInteger;
import java.security.SecureRandom;


public class KeyPairFactory {
    public static BigInteger p,g,x,y;
    public static KeyPair generateKeyPair() throws IllegalParameterException {
        SecureRandom random = new SecureRandom();
         p = BigInteger.probablePrime(256, random);
         g = new BigInteger("2");
         x = new BigInteger(256, random);
         y = g.modPow(x, p);

        return new KeyPair(p, g, x, y);
    }
    public static KeyPair getKeyPair() throws IllegalParameterException {
        return new KeyPair(p, g, x, y);
    }

    public static KeyPair createKeyPair(BigInteger P, BigInteger G, BigInteger X, BigInteger Y) throws IllegalParameterException {
        return new KeyPair(P, G, X, Y);
    }

}
