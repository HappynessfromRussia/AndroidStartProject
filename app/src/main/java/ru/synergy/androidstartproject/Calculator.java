package ru.synergy.androidstartproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    private static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTag = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag, "I am onCreate(), and I am started ");
        setContentView(R.layout.activity_calculator);

        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogcatTag, "Button have been pushed");
                calculateAnswer();
                Intent i = new Intent(Calculator.this, MainActivity.class); // Написать письмо
               // startActivity(i); // Отправить письмо
            }
        });
    }

     @Override
    protected void onStart() {
        super.onStart();
        Log.d(LifecycleTag, "I am onStart(), and I am Started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LifecycleTag, "I am onStop(), and I am Started");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LifecycleTag, "I am onDestroy(), and I am Started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LifecycleTag, "I am onPause(), and I am Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LifecycleTag, "I am onResume, an continue the party");
    }


        // Intent - посылка

        //context training
     //   TextView textView = new TextView(this);
     //   ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),);

        // Доступ из класса Активити наследник Контекс
      //  getSystemService(LAYOUT_INFLATER_SERVICE);

        // Sered prefs

       // SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);


        ///

    private void calculateAnswer() {
        EditText numOne = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText numTwo = (EditText) findViewById(R.id.editTextNumberDecimal2);

        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiply);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag, "All Views have been founded");

     /*   try { - если
            int a = 25/0; это разделить будут делить на 0
        } catch (ArithmeticException e){   то улови                       Арифметическое исключение.
            e.getStackTrace(); и используй этот метод
        }
*/
        float numone = 0;
        float numtwo = 0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();
        if (!num1.equals(" ") && num1 != null) {
            numone = Integer.parseInt(numOne.getText().toString());
        }
        if(!num2.equals(" ") && num2 != null) {
            numtwo = Integer.parseInt(numTwo.getText().toString());
        }
        Log.d(LogcatTag, "Successfully grabbed data from input fields");
        Log.d(LogcatTag, "numone is: " + numone + " ; "+" numtwo is: " + numtwo);

        float solution = 0;


        if (add.isChecked()){
            Log.d(LogcatTag, "Operation is add ");
            solution = numone + numtwo;
        }
        if (sub.isChecked()){
            Log.d(LogcatTag, "Operation is sub");
            solution = numone - numtwo;
        }
        if (multiply.isChecked()) {
            Log.d(LogcatTag, "Operation multiply");
            solution = numone * numtwo;
        }
        if (divide.isChecked()){
            Log.d(LogcatTag, "Operation is divide");
            if (numtwo == 0){
                Toast.makeText(this, "Number Two Cannot Be Zero", Toast.LENGTH_SHORT).show();
                return;
            }
            solution = numone / numtwo;
        }

        Log.d(LogcatTag, "The result of operation" + solution);
        answer.setText("The answer is:" + solution);

        Context contextApp = getApplicationContext();
        Context context = getBaseContext();

    }
}