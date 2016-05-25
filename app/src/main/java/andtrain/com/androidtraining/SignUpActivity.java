package andtrain.com.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends Activity {
    public static Button submit_btn;
    private AndroidTrainingAppDatabaseAdapter dbadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        dbadapter = new AndroidTrainingAppDatabaseAdapter(this);
        btnClickListeners();
    }

    public void btnClickListeners() {
        submit_btn = (Button) findViewById(R.id.button3);
        submit_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("andtrain.com.androidtraining.ResultActivity");
                        intent.putExtra("FromPage", "SignUpPage");
                        dbadapter.open();
                        String username = ((EditText)findViewById(R.id.editText7)).getText().toString();
                        String password = ((EditText)findViewById(R.id.editText6)).getText().toString();
                        String name = ((EditText)findViewById(R.id.editText3)).getText().toString();
                        String email = ((EditText)findViewById(R.id.editText4)).getText().toString();
                        String phno = ((EditText)findViewById(R.id.editText5)).getText().toString();
                        dbadapter.insertEntry(username,password,name,email,phno);
                        dbadapter.close();
                        startActivity(intent);
                    }
                }
        );
    }
}
