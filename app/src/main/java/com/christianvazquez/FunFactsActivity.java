package com.christianvazquez;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.christianvazquez.funfacts.ColorWheel;
import com.christianvazquez.funfacts.FactBook;

import java.util.Random;


public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel =  new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        final TextView factLabel = (TextView)findViewById(R.id.factTextView);
        final Button showfactButton = (Button)findViewById(R.id.showFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);




        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color  = mColorWheel.getColor();

                factLabel.setText(mFactBook.getFact());
                relativeLayout.setBackgroundColor(color);
                showfactButton.setTextColor(color);
            }
        };

        showfactButton.setOnClickListener(listener);


        String message = "Yay! Our Activity was created!";
        Toast welcomeToast = Toast.makeText(this,message,Toast.LENGTH_LONG);
        welcomeToast.show();


        Log.d(TAG, "We're logging from the onCreate Method");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
