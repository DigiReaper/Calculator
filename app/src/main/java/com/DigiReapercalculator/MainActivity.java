package com.DigiReapercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.* ;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";
    TextView resultsTV;
    TextView operationsTV;
    String workings = "";
    String formula = "";
    String tempFormula = "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTextViews();

    }

    private void initTextViews() {
        resultsTV = findViewById(R.id.Result);
        operationsTV = findViewById(R.id.operations);
    }

    public void setWorkings(String GivenValue){

        workings = workings + GivenValue;
        operationsTV.setText(workings) ;


    }

    public void equalsOnClick(View view) {

        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkPowerOf();

        try {
            result = (double)engine.eval(formula);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null){

            resultsTV.setText(String.valueOf(result.doubleValue()));
        }


    }

    private void checkPowerOf() {

        ArrayList<Integer> indexofPowers = new ArrayList<>();

        for (int i = 0; i>workings.length(); i++){

            if(workings.charAt(i) == '^'){
                indexofPowers.add(i);
            }
        }

        formula = workings;
        tempFormula = workings;

        for(Integer index: indexofPowers){
            changeFormula(index);
        }

        formula = tempFormula;

    }

    private void changeFormula(Integer index) {

        String numberLeft = "";
        String numberRight = "";

        for(int i = index +1; i<workings.length(); i++ )
        {
            if (isNumeric(workings.charAt(i))){
                numberRight = numberRight + workings.charAt(i);
            }else
                break;
        }

        for(int i = index - 1; i > 0; i-- )
        {
            if (isNumeric(workings.charAt(i))){
                numberLeft = numberLeft + workings.charAt(i);
            }else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);



    }

    private boolean isNumeric(char c){

        if ((c <= '9') && (c >= '0') || c == '.' ){
            return true;
        }

        return false;
    }


    public void ClearOnClick(View view) {

        resultsTV.setText("");
        operationsTV.setText("");
        workings = "";
        leftBracket = true;

    }

    boolean leftBracket = true;
    public void pOnClick(View view) {

        if(leftBracket){
            setWorkings("(");
            leftBracket = false;
        }
        else{
            setWorkings(")");
            leftBracket = true;
        }

    }

    public void divideOnClick(View view) {

        setWorkings("/");

    }

    public void SquareOnClick(View view) {
        setWorkings("^");

    }

    public void nineOnClick(View view) {
        setWorkings("9");

    }

    public void sevenOnClick(View view) {
        setWorkings("7");

    }

    public void eightOnClick(View view) {
        setWorkings("8");

    }

    public void multiplyOnClick(View view) {
        setWorkings("*");

    }

    public void subtractOnClick(View view) {
        setWorkings("-");

    }

    public void sixOnClick(View view) {
        setWorkings("6");

    }

    public void fiveOnClick(View view) {
        setWorkings("5");

    }

    public void fourOnClick(View view) {
        setWorkings("4");

    }

    public void addOnClick(View view) {
        setWorkings("+");

    }

    public void threeOnClick(View view) {
        setWorkings("3");

    }

    public void twoOnClick(View view) {
        setWorkings("2");

    }

    public void oneOnClick(View view) {
        setWorkings("1");

    }

    public void dotOnClick(View view) {
        setWorkings(".");

    }

    public void zeroOnClick(View view) {
        setWorkings("0");

    }


    public void tom(){

        //you there?

    }

}