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
            resString = "Hello ! Welcome to Android Training App.. ";
            resString += fromIntent.getStringExtra("Password");
        }
        TextView txview = new TextView(this);
        //txview.setTextSize(40);
        txview.setText(resString);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.resactivity);
        //LinearLayout layout = (LinearLayout) View.inflate(this,R.layout.activity_result, null);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //layout.setLayoutParams(params);
        layout.addView(txview);
    }
}
