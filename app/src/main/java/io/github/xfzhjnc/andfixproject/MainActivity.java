package io.github.xfzhjnc.andfixproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

import io.github.xfzhjnc.andfixproject.test.WrongMethodClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        WrongMethodClass wrongMethodClass = new WrongMethodClass();

        textView.setText(String.format(Locale.CHINESE, "1 - 1 = %d",
                wrongMethodClass.getWrongInteger(1, 1)));
    }
}