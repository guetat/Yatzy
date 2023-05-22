package fr.datanumia.yatzy;

import java.util.stream.IntStream;

public interface YatzyFactory {
	public int chance();
	public int yatzy();
	public IntStream getDicesByNbOccurences(int value) ;
	public int getScoreByKind(int value);
	public int smallStraight();
	public int largeStraight() ;
	public int  fullHouse();
	default int ones() {
	        return getScoreByKind(1);
	  }

	    default int twos() {
	        return getScoreByKind(2);
	    }
	    default int threes() {
	        return getScoreByKind(3);
	    }

	    default int fours() {
	        return getScoreByKind(4);
	    }

	    default int fives() {
	        return getScoreByKind(5);
	    }

	    default int sixes() {
	        return getScoreByKind(6);
	    }
	    default int two_pair() {
	        return getDicesByNbOccurences(2)
	                .map(i -> (i + 1) * 2)
	                .sum();
	    }
	    default int four_of_a_kind() {
	        return getDicesByNbOccurences(4)
	                .map(i -> (i + 1) * 4)
	                .sum();
	    }
	    default int three_of_a_kind() {
	        return getDicesByNbOccurences(3)
	                .map(i -> (i + 1) * 3)
	                .sum();
	    }
	    default int score_pair() {
	        return getDicesByNbOccurences(2)
	                .map(i -> (i + 1) * 2)
	                .reduce((f, s) -> s).orElse(0);
	    }

}
