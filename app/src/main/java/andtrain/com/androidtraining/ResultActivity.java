package andtrain.com.androidtraining;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent fromIntent = getIntent();
        String frompage = fromIntent.getStringExtra("FromPage");
        String resString = "Hello....";
        if(frompage.equals("SignUpPage")) {
            resString = "Hello ! Successfully created an account. You can go back and now login to your account";
        } else if (frompage.equals("SignInPage")) {
            if("true".equals((fromIntent.getStringExtra("valid")))) {
                resString = "Welcome !! Your details are :";
            } else {
                resString = "Your Credentials are invalid. Please try again.";
            }
        }
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.resactivity);
        LinearLayout innerLayout = new LinearLayout(this);            //create a new layout and add that layout to relative layout ?
        innerLayout.setOrientation(LinearLayout.VERTICAL);
        //innerLayout.setMinimumWidth(50); //optional ?
        //innerLayout.setMinimumHeight(50); //optional ?

        TextView txview = new TextView(this);
        txview.setText(resString);
        innerLayout.addView(txview);
        if("true".equals((fromIntent.getStringExtra("valid")))) {

            String name = fromIntent.getStringExtra("Name");
            String email = fromIntent.getStringExtra("Email");
            String phno = fromIntent.getStringExtra("phno");
            TextView name_widget = new TextView(this);
            name_widget.setText(name);
            innerLayout.addView(name_widget);
            TextView email_widget = new TextView(this);
            email_widget.setText(email);
            innerLayout.addView(email_widget);
            TextView phno_widget = new TextView(this);
            phno_widget.setText(phno);
            innerLayout.addView(phno_widget);


        }

        layout.addView(innerLayout);
    }
}
