package org.jayme.androidpropoints.ppcalc;

import java.math.BigDecimal;

import android.util.Log;
import android.widget.EditText;

public final class ProPointsCalculator {
	/**
	 * Calculate weight watchers pro points
	 * @param protein
	 * @param carbohydrate
	 * @param fat
	 * @param fibers
	 * @param per
	 * @param serving
	 * @return weight watchers pro points
	 */
	public static double calc(double protein, double carbohydrate, double fat,
			double fibers, double per, double serving) {
		//double basePoints = (fat * 0.26) + (carbohydrate * 0.11) +
		//		(fibers * 0.03) + (protein * 0.09);
		double basePoints = (fat / 3.888) + (carbohydrate / 9.208) + (fibers / 34.97) + (protein / 10.94);
		BigDecimal points = new BigDecimal( serving * basePoints / per );
		points = points.setScale(1, BigDecimal.ROUND_HALF_UP);
		return points.doubleValue();
	}
	public static double calc(EditText protein, EditText carbohydrate, EditText fat,
			EditText fibers, EditText per, EditText serving) {
		double doubleProtein = 0,
				doubleCarbohydrate = 0,
				doubleFat = 0,
				doubleFibers = 0,
				doublePer = 0,
				doubleServing = 0;
		try {
			if (! protein.getText().toString().isEmpty())
				doubleProtein = Double.parseDouble(protein.getText().toString());
			if (! carbohydrate.getText().toString().isEmpty())
				doubleCarbohydrate = Double.parseDouble(carbohydrate.getText().toString());
			if (! fat.getText().toString().isEmpty())
				doubleFat = Double.parseDouble(fat.getText().toString());
			if (! fibers.getText().toString().isEmpty())
				doubleFibers = Double.parseDouble(fibers.getText().toString());
			if (! per.getText().toString().isEmpty())
				doublePer = Double.parseDouble(per.getText().toString());
			if (! serving.getText().toString().isEmpty())
				doubleServing = Double.parseDouble(serving.getText().toString());
		} catch (NumberFormatException ex) {
			Log.e("Error parsing values for calulation", ex.toString());
			return 0.0;
		}
		return ProPointsCalculator.calc(doubleProtein, doubleCarbohydrate, doubleFat,
				doubleFibers, doublePer, doubleServing);
	}
}
