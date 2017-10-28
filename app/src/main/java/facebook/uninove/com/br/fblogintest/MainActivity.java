package facebook.uninove.com.br.fblogintest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import android.support.v7.view.ActionMode;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {

    TextView txtStatus;
    LoginButton login_button;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeControls();
        loginWithFB();
    }

    public void initializeControls(){
        callbackManager = CallbackManager.Factory.create();
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        login_button = (LoginButton) findViewById(R.id.login_button);
    }
    private void loginWithFB(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                txtStatus.setText("Login Sucess\n" + loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                txtStatus.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {
                txtStatus.setText("Login Error: " + error.getMessage());
            }
        });
    }
}
