package zzz_codingChallenges.leetcode.medium;

import java.util.Arrays;

public class DesignBitset {
    public static void main(String[] args) {
        char[] bytes = new char[]{'1','0','1','1','0'};

        Bitset obj = new Bitset(5);

        obj.fix(3);
        obj.print();

        obj.fix(1);
        obj.print();

        obj.flip();
        obj.print();

        obj.all();
        obj.print();

        obj.unfix(0);
        obj.print();

        obj.flip();
        obj.print();

        obj.one();
        obj.print();

        obj.unfix(0);
        obj.print();

        obj.count();
        obj.print();

    }
}


class Bitset {

    char[] bytes;
    int countOne , countZero;

    // InComplete - Think of using HashSet instead of int counters

    public Bitset(int size) {
        bytes = new char[size];
        Arrays.fill(bytes, '0');
        countOne = 0;
        countZero = size;
    }

    public void fix(int idx) {
        if(idx >= bytes.length) return;

        char item = bytes[idx];

        if(item == '1') return;

        bytes[idx] = '1';
        countZero--;
        countOne++;
    }

    public void unfix(int idx) {
        if(idx >= bytes.length) return;

        char item = bytes[idx];

        if(item == '0') return;

        bytes[idx] = '0';
        countOne--;
        countZero++;
    }

    public void flip() {


        String binary = String.valueOf(bytes);
        int integer = Integer.parseInt(binary, 2);

        String flipped = Integer.toBinaryString(~integer);
        int flippedSize = flipped.length();

        String exactFlipped = flipped.substring(flippedSize - bytes.length);
        bytes = exactFlipped.toCharArray();

        // Swap counts
        int temp = countOne;
        countOne = countZero;
        countZero = temp;

    }

    int onesComplement(int n) {

        // Find number of bits in the
        // given integer
        int number_of_bits =
                (int)(Math.floor(Math.log(n) /
                        Math.log(2))) + 1;

        // XOR the given integer with poe(2,
        // number_of_bits-1 and print the result
        return ((1 << number_of_bits) - 1) ^ n;
    }

    public boolean all() {
        return countOne == bytes.length;
    }

    public boolean one() {
        return countOne >= 1;
    }

    public int count() {
        return countOne;
    }

    public String toString() {
        return String.valueOf(bytes);
    }

    public void print(){
        System.out.println(this);
    }

}
