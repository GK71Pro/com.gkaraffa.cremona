package com.gkaraffa.cremona.theoretical;

import com.gkaraffa.cremona.common.*;

public class TonalSpectrum {
	public static final int octave = 12;
	public static final int upperLimit = octave - 1;
	public static Tone[] tones = new Tone[octave];

	static {
		tones[0] = Tone.C;
		tones[1] = Tone.CSHARP_DFLAT;
		tones[2] = Tone.D;
		tones[3] = Tone.DSHARP_EFLAT;
		tones[4] = Tone.E;
		tones[5] = Tone.F;
		tones[6] = Tone.FSHARP_GFLAT;
		tones[7] = Tone.G;
		tones[8] = Tone.GSHARP_AFLAT;
		tones[9] = Tone.A;
		tones[10] = Tone.ASHARP_BFLAT;
		tones[11] = Tone.B;
	}

	private static Tone getNote(int location) throws CremonaException {
		if ((location > upperLimit) || (location < 0)) {
			throw new CremonaException(
					"parameter \"location\" outside acceptable range");
		}
		else {
			return tones[location];
		}
	}

	private static int locateNote(Tone target) {
		int index;

		for (index = 0; index <= upperLimit; index++) {
			if (tones[index].equals(target)) {
				break;
			}
		}
		return index;
	}

	public static int measureDistance(Tone startTone, Tone stopTone) {
		int startLoc = locateNote(startTone);
		int stopLoc = locateNote(stopTone);

		if (stopLoc < startLoc) {
			stopLoc += octave;
		}

		return (stopLoc - startLoc);
	}

	public static Interval measureInterval(Tone startTone, Tone stopTone)
			throws CremonaException {
		int halfSteps = measureDistance(startTone, stopTone);

		return Interval.intToInterval(halfSteps);
	}

	public static Tone traverseDistance(Tone tonic, int distance)
			throws CremonaException {

		int location = locateNote(tonic);
		location += distance;

		while (location > upperLimit) {
			location -= octave;
		}

		return getNote(location);
	}

	public static Tone traverseInterval(Tone tonic, Interval interval)
			throws CremonaException {
		return traverseDistance(tonic, interval.getSteps());
	}

}