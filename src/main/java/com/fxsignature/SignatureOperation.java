package com.fxsignature;

import java.math.BigInteger;
import java.security.SecureRandom;

public class SignatureOperation {
    public static Signature sign(BigInteger message, KeyPair keyPair) {
        SecureRandom random = new SecureRandom();
        BigInteger p = keyPair.getP();
        BigInteger g = keyPair.getG();
        BigInteger x = keyPair.getX();

        BigInteger k;
        do {
            k = new BigInteger(p.bitLength(), random);
        } while (k.compareTo(p) >= 0 || k.gcd(p.subtract(BigInteger.ONE)).intValue() != 1);

        BigInteger a = g.modPow(k, p);
        BigInteger kInverse = k.modInverse(p.subtract(BigInteger.ONE));
        BigInteger b = kInverse.multiply(message.subtract(x.multiply(a))).mod(p.subtract(BigInteger.ONE));

        return new Signature(a, b);
    }

    public static boolean verify(BigInteger message, Signature signature, BigInteger publicKey, BigInteger p) {
        BigInteger y = publicKey;
        BigInteger g = BigInteger.valueOf(2);
        BigInteger a = signature.getA();
        BigInteger b = signature.getB();

        if (a.compareTo(BigInteger.ONE) < 0 || a.compareTo(p.subtract(BigInteger.ONE)) >= 0 ||
                b.compareTo(BigInteger.ONE) < 0 || b.compareTo(p.subtract(BigInteger.ONE)) >= 0) {
            return false;
        }

        BigInteger left = g.modPow(message, p);
        BigInteger right = y.modPow(a, p).multiply(a.modPow(b, p)).mod(p);

        return left.equals(right);
    }

}
