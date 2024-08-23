package org.tron.common.zksnark;

public class HexBin {

    public static int digit(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        if (c >= 'a' && c <= 'f') return c - 'a' + 10;
        if (c >= 'A' && c <= 'F') return c - 'A' + 10;
        throw new IllegalArgumentException("Wrong hex digit: " + c);
    }

    public static byte[] decode(String s) {
        if (s.length() % 2 != 0) throw new IllegalArgumentException("Should be even length");
        byte[] result = new byte[s.length()/2];
        for (int i=0; i<s.length(); i+=2) {
            result[i/2] = (byte)((digit(s.charAt(i)) << 4) + digit(s.charAt(i+1)));
        }
        return result;
    }
}
