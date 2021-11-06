package com.DigiReapercalculator;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;


public class MinimalActivity extends AppCompatActivity {

    private TextView previousCalculation;
    private EditText displayText;
     String displayHolder = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimal);

        previousCalculation = findViewById(R.id.previousCalculations);
        displayText = findViewById(R.id.displayEditText);

        displayText.setShowSoftInputOnFocus(false);
    }

    private void updateText(String num){


        int cursorpos = displayText.getSelectionStart();
        Log.d(TAG, "updateText: one");
        String leftString = displayHolder.substring(0, cursorpos);
        String rightString = displayHolder.substring(cursorpos);
        System.out.println("two");
        displayHolder = leftString+ num+ rightString;
        displayText.setText(displayHolder);
        displayText.setSelection(cursorpos + num.length());

    }


    public void equalsOnClick(View view) {
        String current = displayText.getText().toString();
        current = current.replaceAll("×", "*");
        current = current.replaceAll("÷", "/");
        current = current.replaceAll("−", "-");


        Expression exp = new Expression(current);

        String result = String.valueOf(exp.calculate());
        displayText.setText(result);
        displayHolder = result;
        displayText.setSelection(result.length());

    }

    public void clearOnClick(View view) {
        displayText.setText("");
        displayHolder = "";
    }

    public void backspaceOnClick(View view) {
        int cursorpos = displayText.getSelectionStart();
        int textLength = displayText.getText().length();

        if (cursorpos != 0 && textLength != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) displayText.getText();
            selection.replace(cursorpos-1, cursorpos, "");
            displayText.setText(selection);
            displayHolder = selection.toString() ;
            displayText.setSelection(cursorpos-1);
        }
    }




    public void zeroOnClick(View view) {
        updateText("0");

    }
    public void divideOnClick(View view) {

        updateText("÷");

    }
    public void SquareOnClick(View view) {
        updateText("^");

    }
    public void nineOnClick(View view) {
        updateText("9");

    }
    public void sevenOnClick(View view) {
        updateText("7");

    }
    public void eightOnClick(View view) {
        updateText("8");

    }
    public void multiplyOnClick(View view) {
        updateText("×");

    }
    public void subtractOnClick(View view) {
        updateText("−");

    }
    public void sixOnClick(View view) {
        updateText("6");

    }
    public void fiveOnClick(View view) {
        updateText("5");

    }
    public void fourOnClick(View view) {
        updateText("4");

    }
    public void addOnClick(View view) {
        updateText("+");

    }
    public void threeOnClick(View view) {
        updateText("3");

    }
    public void twoOnClick(View view) {
        updateText("2");

    }
    public void oneOnClick(View view) {
        updateText("1");

    }
    public void dotOnClick(View view) {
        updateText(".");

    }
    public void BracketRightOnClick(View view) {
        updateText(")");
    }
    public void BracketLeftOnClick(View view) {

        updateText("(");
    }

}