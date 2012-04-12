package org.jayme.androidpropoints;

import org.jayme.androidpropoints.ppcalc.ProPointsCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends Activity {
	EditText protein, carbohydrate, fat, fibers, per, serving;
	TextView ppresult;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        
        protein = (EditText)findViewById(R.id.editTextProtein);
        carbohydrate = (EditText)findViewById(R.id.editTextCarbohydrate);
        fat = (EditText)findViewById(R.id.editTextFat);
        fibers = (EditText)findViewById(R.id.editTextFibers);
        per = (EditText)findViewById(R.id.editTextPer);
        serving = (EditText)findViewById(R.id.editTextServing);
        ppresult = (TextView)findViewById(R.id.textViewPPResult);
        
        /** Text watcher should calculate points if a EditText changes */
        TextWatcher Tw = new TextWatcher() {
    		@Override
    		public void afterTextChanged(Editable arg0) {
    			// Calculate ProPoints
    			double points = ProPointsCalculator.calc(protein, carbohydrate, fat, fibers, per, serving);
    			/*Toast.makeText(getApplicationContext(), String.valueOf(points),
    					Toast.LENGTH_SHORT).show();*/
    			ppresult.setText(Double.toString(points));
    		}

    		@Override
    		public void beforeTextChanged(CharSequence s, int start, int count,	int after) {
    			// Auto-generated method stub
    		}

    		@Override
    		public void onTextChanged(CharSequence s, int start, int before, int count) {
    			// Auto-generated method stub
    		}
        };
        
        protein.addTextChangedListener(Tw);
        carbohydrate.addTextChangedListener(Tw);
        fat.addTextChangedListener(Tw);
        fibers.addTextChangedListener(Tw);
        per.addTextChangedListener(Tw);
        serving.addTextChangedListener(Tw);
        
    }
    
    
}