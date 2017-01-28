package com.example.g00nie.capstonecottonimages;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;


public class LoginActivity extends AppCompatActivity {

    EditText input_user, input_pass;
    TextView forgot_password;
    private TextInputLayout inputLayoutUsername,inputLayoutPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputLayoutUsername = (TextInputLayout)findViewById(R.id.input_layout_username);
        inputLayoutPassword = (TextInputLayout)findViewById(R.id.input_layout_password);
        forgot_password = (TextView)findViewById(R.id.tv_forgot_password);
        input_user = (EditText)findViewById(R.id.et_username);
        input_pass = (EditText)findViewById(R.id.et_password);
        login = (Button)findViewById(R.id.btn_login);

        input_user.addTextChangedListener(new MyTextWatcher(input_user));
        input_pass.addTextChangedListener(new MyTextWatcher(input_pass));

        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                submitForm();
            }

        });

        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }


    private void submitForm() {
        boolean valid = true;
        if (!validateUsername()) {
            valid = false;
        }
        if (!validatePassword()) {
            valid = false;
        }

        if(valid = true){
            Toast.makeText(LoginActivity.this,      //Login Successful Toast
                    "Login Successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, SplashScreenActivity.class);
            startActivity(intent);
        }
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
    private boolean validateUsername() {
        String username = input_user.getText().toString().trim();

        if (username.isEmpty() || !isValidUsername(username)) {
            inputLayoutUsername.setError(getString(R.string.err_msg_username));
            requestFocus(input_user);
            return false;
        } else {
            inputLayoutUsername.setErrorEnabled(false);
        }
        return true;
    }

    private static boolean isValidUsername(String username) {
        // TODO: 1/27/2017 add username validation using db
        String validate = username;
        if(validate.equals(username)){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean validatePassword() {
        String password = input_pass.getText().toString().trim();

        if (password.isEmpty() || !isValidPassword(password)) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(input_pass);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
    }

    private static boolean isValidPassword(String password) {
        // TODO: 1/27/2017 add password validation using db
        String validate = password;
        if(validate.equals(password)){
            return true;
        }
        else{
            return false;
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.et_username:
                    validateUsername();
                    break;
                case R.id.et_password:
                    validatePassword();
                    break;
            }
        }
    }
}

