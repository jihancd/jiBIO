package com.jihan.jibio.signup;

/**
 * Tanggal  : 5 Aug 2019
 * Nim      : 10116356
 * Nama     : Jihan Candri Dinasty
 * Kelas    : AKB-8
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jihan.jibio.R;
import com.jihan.jibio.User;
import com.jihan.jibio.login.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity implements SignupContract.View {
    ProgressBar progressBar;
    EditText edtNim;
    EditText edtUsername;
    EditText edtPassword;
    EditText edtRetypePassword;
    EditText edtClass;
    EditText edtPhone;
    EditText edtEmail;
    EditText edtFacebook;
    EditText edtInstagram;
    Button btnSignup;

    private SignupContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
        mPresenter = new SignupPresenter(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (foundErrorInForm()) {
                    User user = new User();
                    user.setNim(edtNim.getText().toString());
                    user.setUsername(edtUsername.getText().toString());
                    user.setKelas(edtClass.getText().toString());
                    user.setPhone(edtPhone.getText().toString());
                    user.setEmail(edtEmail.getText().toString());
                    user.setInstagram(edtInstagram.getText().toString());
                    user.setFacebook(edtFacebook.getText().toString());
                    user.setPassword(edtPassword.getText().toString());
                    mPresenter.signup(user);
                }
            }
        });

    }


    boolean foundErrorInForm() {
        boolean statusForm = true;

        if (edtNim.getText().toString().isEmpty()) {
            edtNim.setError("NIM belum diisi");
            statusForm = false;
        }
        if (edtUsername.getText().toString().isEmpty()) {
            edtUsername.setError("Username belum diisi");
            statusForm = false;
        }
        if (edtClass.getText().toString().isEmpty()) {
            edtClass.setError("Kelas belum diisi");
            statusForm = false;
        }
        if (edtPhone.getText().toString().isEmpty()) {
            edtPhone.setError("Nomer telphone belum diisi");
            statusForm = false;
        }
        if (edtEmail.getText().toString().isEmpty()) {
            edtEmail.setError("Email belum diisi");
            statusForm = false;

        }
        if (edtInstagram.getText().toString().isEmpty()) {
            edtInstagram.setError("Instagram belum diisi");
            statusForm = false;
        }
        if (edtFacebook.getText().toString().isEmpty()) {
            edtFacebook.setError("Facebook belum diisi");
            statusForm = false;
        }
        if (edtPassword.getText().toString().isEmpty()) {
            edtPassword.setError("Password belum diisi");
            statusForm = false;
        }
        if (!edtRetypePassword.getText().toString().equals(edtRetypePassword.getText().toString())) {
            edtRetypePassword.setError("Pasword tidak sama");
            statusForm = false;
        }
        if (!isEmailValid(edtEmail.getText().toString())) {
            edtEmail.setError("Email harus diisi dengan benar");
            statusForm = false;
        }


        return statusForm;
    }

    public boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        return matcher.matches();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (active) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }


    @Override
    public void onSuccessSignUp() {
        Toast.makeText(this, "Congratulations! Account Created", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public void onFailedSignUp() {
        Toast.makeText(this, "Sorry, account created failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(SignupContract.Presenter presenter) {
        mPresenter = presenter;
    }

    private void initView() {
        progressBar = findViewById(R.id.signup_proggressbar);

        edtNim = findViewById(R.id.signup_edt_nim);
        edtUsername = findViewById(R.id.signup_edt_username);
        edtPassword = findViewById(R.id.signup_edt_password);
        edtRetypePassword = findViewById(R.id.signup_edt_retype_password);
        edtClass = findViewById(R.id.signup_edt_class);
        edtPhone = findViewById(R.id.signup_edt_phone);
        edtEmail = findViewById(R.id.signup_edt_email);
        edtFacebook = findViewById(R.id.signup_edt_facebook);
        edtInstagram = findViewById(R.id.signup_edt_instagram);

        btnSignup = findViewById(R.id.login_btn_signup);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }
}
