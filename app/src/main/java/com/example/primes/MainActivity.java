package com.example.primes;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    long startTime = System.nanoTime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View view)
    {
        EditText lower_t = (EditText)findViewById(R.id.lowerLimit);
        EditText upper_t = (EditText)findViewById(R.id.upperLimit);
        TextView prime_t = (TextView)findViewById(R.id.primeText);
        int upper_n = Integer.parseInt(upper_t.getText().toString());
        int lower_n = Integer.parseInt(lower_t.getText().toString());
        boolean isPrime = true;
        String primeNumbersFound = "";
        for (int i = lower_n; i <= upper_n; i++) {
            isPrime = CheckPrime(i);
            if (isPrime) {
                primeNumbersFound = primeNumbersFound + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to " + upper_n + " are:");
        prime_t.setText(primeNumbersFound);
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns");
    }
    public static boolean CheckPrime(int numberToCheck)
    {
        int remainder;
        for (int i = 2; i <= numberToCheck / 2; i++)
        {
            remainder = numberToCheck % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }
}


