package fr.datanumia.yatzy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Yatzy implements YatzyFactory {

    private final int[] dices;
    private final int[] tallies;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = new int[5];
        dices[0] = d1;
        dices[1] = d2;
        dices[2] = d3;
        dices[3] = d4;
        dices[4] = d5;
        tallies = initTallies(dices);
    }

    public int chance() {
        return Arrays.stream(dices).sum();
    }

    public int yatzy() {
        if (Arrays.stream(tallies).anyMatch(i -> i == 5)) {
            return 50;
        }
        return 0;
    }

    public int smallStraight() {
        if (Arrays.stream(tallies).limit(5).allMatch(i -> i == 1)) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        if (Arrays.stream(tallies).skip(1).allMatch(i -> i == 1)) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        return getDicesByNbOccurences(2)
                .map(i -> (i + 1) * tallies[i]).sum();
    }

    private int[] initTallies(int... dices) {
        int[] tallies = new int[6];
        tallies[dices[0] - 1] += 1;
        tallies[dices[1] - 1] += 1;
        tallies[dices[2] - 1] += 1;
        tallies[dices[3] - 1] += 1;
        tallies[dices[4] - 1] += 1;
        return tallies;
    }

    public IntStream getDicesByNbOccurences(int nbOccurences) {
        return IntStream.range(0, tallies.length)
                .filter(i -> tallies[i] >= nbOccurences);
    }

    public int getScoreByKind(int kind) {
        return Arrays.stream(dices)
                .filter(i -> i == kind)
                .sum();
    }
}

