package andtrain.com.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import java.util.HashMap;

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
                        HashMap<String,String> hmap = dbadapter.getLoginCredentials(((EditText)findViewById(R.id.editText)).getText().toString(), ((EditText)findViewById(R.id.editText2)).getText().toString());
                        dbadapter.close();
                        if(hmap!=null) {
                            intent.putExtra("valid","true");
                            intent.putExtra("Name", hmap.get("name"));
                            intent.putExtra("Email", hmap.get("email"));
                            intent.putExtra("phno", hmap.get("phno"));
                        } else {
                            intent.putExtra("valid","false");
                        }
                        startActivity(intent);
                    }
                }
        );
    }
}
