package com.gkaraffa.cremona.theoretical;

import java.util.HashMap;

public enum Interval {
	UNISON(0, IntervalNumber.UNISON, IntervalQuality.PERFECT, "Perfect Unison", "P1"),
	DIMINISHED_SECOND(0, IntervalNumber.SECOND, IntervalQuality.DIMINISHED, "Diminished Second", "d2"),
	MINOR_SECOND(1, IntervalNumber.SECOND, IntervalQuality.MINOR, "Minor Second", "m2"),
	MAJOR_SECOND(2, IntervalNumber.SECOND, IntervalQuality.MAJOR, "Major Second", "M2"),
	AUGMENTED_SECOND(3, IntervalNumber.SECOND, IntervalQuality.AUGMENTED, "Augmented Second", "A2"),
	DIMINISHED_THIRD(2, IntervalNumber.THIRD, IntervalQuality.DIMINISHED, "Diminished Third", "d3"),
	MINOR_THIRD(3, IntervalNumber.THIRD, IntervalQuality.MINOR, "Minor Third", "m3"),
	MAJOR_THIRD(4, IntervalNumber.THIRD, IntervalQuality.MAJOR, "Major Third", "M3"),
	AUGMENTED_THIRD(5, IntervalNumber.THIRD, IntervalQuality.AUGMENTED, "Augmented Third", "A3"),
	DIMINISHED_FOURTH(4, IntervalNumber.FOURTH, IntervalQuality.DIMINISHED, "Diminished Fourth", "d4"),
	PERFECT_FOURTH(5, IntervalNumber.FOURTH, IntervalQuality.PERFECT, "Perfect Fourth", "P4"),
	AUGMENTED_FOURTH(6, IntervalNumber.FOURTH, IntervalQuality.AUGMENTED, "Augmented Fourth", "A4"),
	DIMINISHED_FIFTH(6, IntervalNumber.FIFTH, IntervalQuality.DIMINISHED, "Diminished Fifth", "d5"),
	PERFECT_FIFTH(7, IntervalNumber.FIFTH, IntervalQuality.PERFECT, "Perfect Fifth", "P5"),
	AUGMENTED_FIFTH(8, IntervalNumber.FIFTH, IntervalQuality.AUGMENTED, "Augmented Fifth", "A5"),
	DIMINISHED_SIXTH(7, IntervalNumber.SIXTH, IntervalQuality.DIMINISHED, "Diminished Sixth", "d6"),
	MINOR_SIXTH(8, IntervalNumber.SIXTH, IntervalQuality.MINOR, "Minor Sixth", "m6"),
	MAJOR_SIXTH(9, IntervalNumber.SIXTH, IntervalQuality.MAJOR, "Major Sixth", "M6"),
	AUGMENTED_SIXTH(10, IntervalNumber.SIXTH, IntervalQuality.AUGMENTED, "Augmented Sixth", "A6"),
	DIMINISHED_SEVENTH(9, IntervalNumber.SEVENTH, IntervalQuality.DIMINISHED, "Diminished Seventh", "d7"),
	MINOR_SEVENTH(10, IntervalNumber.SEVENTH, IntervalQuality.MINOR, "Minor Seventh", "m7"),
	MAJOR_SEVENTH(11, IntervalNumber.SEVENTH, IntervalQuality.MAJOR, "Major Seventh", "M7"),
	AUGMENTED_SEVENTH(12, IntervalNumber.SEVENTH, IntervalQuality.AUGMENTED, "Augmented Seventh", "A7"),
	DIMINISHED_EIGHTH(11, IntervalNumber.EIGHTH, IntervalQuality.DIMINISHED, "Diminished Eighth", "d8"),
	PERFECT_EIGHTH(12, IntervalNumber.EIGHTH, IntervalQuality.PERFECT, "Perfect Eighth", "P8");

	private final int halfSteps;
	private final IntervalNumber intervalNumber;
	private final IntervalQuality intervalQuality;
	private final String text;
	private final String abbrev;
	private final static HashMap<IntervalKey, Interval> hashMap = new HashMap<IntervalKey, Interval>();

	static {
		for (Interval interval : Interval.values()) {
			hashMap.put(interval.new IntervalKey(interval.getHalfSteps(), interval.getIntervalNumber()), interval);
		}
	}

	Interval(int halfSteps, IntervalNumber intervalNumber, IntervalQuality intervalQuality, String text, String abbrev) {
		this.halfSteps = halfSteps;
		this.intervalNumber = intervalNumber;
		this.intervalQuality = intervalQuality;
		this.text = text;
		this.abbrev = abbrev;
	}

	public final int getHalfSteps() {
		return halfSteps;
	}

	public final IntervalNumber getIntervalNumber() {
		return intervalNumber;
	}

	public final IntervalQuality getIntervalQuality() {
		return intervalQuality;
	}
	
	public final String getText() {
		return text;
	}

	public final String getAbbrev() {
		return abbrev;
	}
	
	public final String toString() {
		return text;
	}
	
	public static final Interval halfStepsAndIntervalNumberToInterval(int halfSteps, IntervalNumber intervalNumber){
		Interval output = null;
		IntervalKey iK = Interval.UNISON.new IntervalKey(halfSteps, intervalNumber);
		
		output = hashMap.get(iK);
		
		return output;
	}
	
	public class IntervalKey{
		public int halfSteps;
		public IntervalNumber intervalNumber;
		
		IntervalKey(int halfSteps, IntervalNumber intervalNumber){
			this.halfSteps = halfSteps;
			this.intervalNumber = intervalNumber;
		}
		
		@Override
		public boolean equals(Object o){
			if (!(o instanceof IntervalKey)){
				return false;
			}
			
			IntervalKey iK = (IntervalKey) o;				
			if ((iK.halfSteps == this.halfSteps)  && (iK.intervalNumber == this.intervalNumber)){
				return true;
			}
			
			return false;
		}
		
		@Override
		public int hashCode() {
	        int result = 17;
	        result = 31 * result + halfSteps;
	        result = 31 * result + intervalNumber.hashCode();
	        return result;
	    }
	}
	
}
