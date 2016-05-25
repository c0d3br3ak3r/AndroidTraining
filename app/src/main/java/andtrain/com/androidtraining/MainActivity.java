package andtrain.com.androidtraining;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static Button login_btn;
    public static Button signup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickBtnListener();
    }

    public void onClickBtnListener() {
        login_btn = (Button) findViewById(R.id.button2);
        signup_btn = (Button) findViewById(R.id.button4);

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("andtrain.com.androidtraining.SignInActivity");
                        startActivity(intent);
                    }
                }
        );

        signup_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("andtrain.com.androidtraining.SignUpActivity");
                        startActivity(intent);
                    }
                }
        );
    }

}
