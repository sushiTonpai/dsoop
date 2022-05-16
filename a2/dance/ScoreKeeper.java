package a2.dance;

import java.util.*;

/**
 * Put your name and student id here
 */

/*
 * The ScoreKeeper class stores scores and answers basic statistical average
 * about the scores. It is intended to be use as part of another class for
 * score storage.
 */
public class ScoreKeeper {
    // TODO: Declare private member variables as needed
    private double[] scores;

    public ScoreKeeper() {
        // TODO: Create an instance for this.scores
    }

    /*
     * Record the scores given by double[] scores into your instance variable
     * scores. If the member variable already has existing data, clear it before
     * putting in the new scores.
     */
    public void setScores(double[] scores) {
        // TODO: Write me
        this.scores = scores;
    }

    // Return an array double[] of scores as was previously set
    public double[] getScores() {
        // TODO: Write me

        return this.scores;
    }

    /*
     * Return the average of the scores after excluding the minimum and maximum
     * value. In short, it should return
     *   (SUM(this.scores) - MIN(this.scores) - MAX(this.scores))/(n-2), where
     * n is the length of the score list. This function will return Double.NaN if
     * n is <= 2 because no meaningful average can be computed.
     */
    public double Min(ArrayList<Double> numbers){
        double min_now = numbers.get(0);
        for (int i =1; i < numbers.size(); i++){
            if (min_now > numbers.get(i))
                min_now = numbers.get(i);
        }
        return min_now;
    }
    public double Max(ArrayList<Double> numbers){
        double max_now = numbers.get(0);
        for (int i =1 ;i < numbers.size();i++){
            if (max_now < numbers.get(i))
                max_now = numbers.get(i);
        }
        return max_now;
    }
    public double getCalibratedAverage() {
        // TODO: Write me
        double sum = this.scores[0];
        double min;
        double max;
        double[] numbers = this.scores;
        if (this.scores.length <= 2) {
            return Double.NaN;
        }
        for (int i = 1; i < this.scores.length; i++) {
            sum += this.scores[i];
        }

        ArrayList<Double> w = new ArrayList<>();
        ArrayList<Double> l = new ArrayList<>();
        int size = this.scores.length;
        double oddkeeper = numbers[0];

        if (numbers.length % 2 != 0){
            size = numbers.length-1;
            oddkeeper = numbers[numbers.length-1];
        }
        for (int i = 0;i < size;i = i+2){
            if (numbers[i] < numbers[i+1]){
                l.add(numbers[i]);
                w.add(numbers[i+1]);
            }
            else{
                w.add(numbers[i]);
                l.add(numbers[i+1]);
            }
        }
        min = Min(l);
        max = Max(w);

        if (max < oddkeeper){
            max = oddkeeper;
        }
        else if (min > oddkeeper){
            min = oddkeeper;
        }
        return (sum - min - max) / (this.scores.length - 2);
    }

    public static void main(String[] args) {
        System.out.println("=== ScoreKeeper ===");
        double[] sampleScores0 = {2.5, 1.0, 9.8, 5.4, 3.3, 0.25, 4.25};
        double[] sampleScores1 = {0.5, 9};

        ScoreKeeper scoreKeeper0 = new ScoreKeeper();
        scoreKeeper0.setScores(sampleScores0);
        System.out.println("scoreKeeper0: " + Arrays.toString(scoreKeeper0.getScores()));
        System.out.println("Calibrated Average: " + scoreKeeper0.getCalibratedAverage());

        System.out.printf("\n");

        ScoreKeeper scoreKeeper1 = new ScoreKeeper();
        scoreKeeper1.setScores(sampleScores1);
        System.out.println("scoreKeeper1: " + Arrays.toString(scoreKeeper1.getScores()));
        System.out.println("Calibrated Average: " + scoreKeeper1.getCalibratedAverage());
    }
}
