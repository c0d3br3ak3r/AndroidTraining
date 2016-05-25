package andtrain.com.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class SignInActivity extends Activity {
    public static Switch swt;
    public static Button login_btn;
    private static AndroidTrainingAppDatabaseAdapter dbadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        dbadapter = new AndroidTrainingAppDatabaseAdapter(this); //initializing database
        buttonEventListeners();
    }
    public void buttonEventListeners() {
        swt = (Switch)findViewById(R.id.switch1);
        login_btn = (Button)findViewById(R.id.button);

        swt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("andtrain.com.androidtraining.SignUpActivity");
                        startActivity(intent);
                    }
                }
        );

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("andtrain.com.androidtraining.ResultActivity");
                        intent.putExtra("FromPage", "SignInPage");
                        dbadapter.open();
                        String pass = dbadapter.getLoginCredentials(((EditText)findViewById(R.id.editText)).getText().toString());
                        dbadapter.close();
                        intent.putExtra("Password",pass);
                        startActivity(intent);
                    }
                }
        );
    }
}
