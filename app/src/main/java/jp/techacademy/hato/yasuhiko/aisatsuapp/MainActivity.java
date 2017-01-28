package jp.techacademy.hato.yasuhiko.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TimePicker mTimePicker;
    private TextView mTextView;
    private int mHour;
    private int mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(this);

        TextView textView = (TextView)findViewById(R.id.textView);
        mTextView = textView;

        showTimePickerDialog();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            setTimeToTextView();
        }
    }


    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        mHour = hourOfDay;
                        mMinute = minute;
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();
    }


    private void setTimeToTextView(){
        int hour = mHour;
        int minute = mMinute;
        String salute = new String("Good bye");

        if(hour >= 2 && hour < 10){
            salute = "Good morning";
        }
        else if(hour >= 10 && hour < 18){
            salute = "Hello";
        }
        else if(hour >= 18 && hour < 24){
            salute = "Good evening";
        }
        else if(hour >= 0 && hour < 2){
            salute = "Good evening";
        }

        mTextView.setText(salute);
    }
}
