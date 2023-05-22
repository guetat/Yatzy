package fr.datanumia.yatzy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import fr.datanumia.yatzy.Yatzy;



public class YatzyTest {

    @Test
    public void test_chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = new Yatzy(2,3,4,5,1).chance();
        assertEquals(expected, actual);
        assertEquals(16, new Yatzy(3,3,4,5,1).chance());
    }

    @Test
    public void test_yatzy_scores_50() {
        int expected = 50;
        int actual = new Yatzy(4,4,4,4,4).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0, new Yatzy(6,6,6,6,3).yatzy());
    }

    @Test
    public void test_ones() {
        assertTrue(new Yatzy(1,2,3,4,5).ones() == 1);
        assertEquals(2, new Yatzy(1,2,1,4,5).ones());
        assertEquals(0, new Yatzy(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy(1,2,1,1,1).ones());
    }

    @Test
    public void test_twos() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10, new Yatzy(2,2,2,2,2).twos());
    }

    @Test
    public void test_threes() {
        assertEquals(6, new Yatzy(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void test_fours()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void test_fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void test_sixes() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void test_one_pair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).score_pair());
        assertEquals(10, new Yatzy(5,3,3,3,5).score_pair());
        assertEquals(12, new Yatzy(5,3,6,6,5).score_pair());
    }

    @Test
    public void test_two_Pair() {
        assertEquals(16, new Yatzy(3,3,5,4,5).two_pair());
        assertEquals(16, new Yatzy(3,3,5,5,5).two_pair());
    }

    @Test
    public void test_three_of_a_kind()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).three_of_a_kind());
        assertEquals(15, new Yatzy(5,3,5,4,5).three_of_a_kind());
        assertEquals(9, new Yatzy(3,3,3,3,5).three_of_a_kind());
    }

    @Test
    public void test_four_of_a_knd() {
        assertEquals(12, new Yatzy(3,3,3,3,5).four_of_a_kind());
        assertEquals(20, new Yatzy(5,5,5,4,5).four_of_a_kind());
        assertEquals(9, new Yatzy(3,3,3,3,3).three_of_a_kind());
    }

    @Test
    public void test_smallStraight() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraight());
    }

    @Test
    public void test_largeStraight() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraight());
    }

    @Test
    public void test_fullHouse() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
    }
}
