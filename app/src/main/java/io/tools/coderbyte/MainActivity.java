package io.tools.coderbyte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String word = "Caesar Cipher";
        int[] arr = {4, 6, 23, 10, 1, 3};
        String[] strs = {"10:00AM-12:30PM", "02:30PM-02:45PM", "09:10AM-09:50AM"};
        boolean res = Combination_ToHop.checkArrayAddition(arr);
        Log.d("Muoi", "------------------RESULT----------------\n");
        Log.d("Muoi", String.valueOf(res));
    }
}
