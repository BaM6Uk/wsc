package com.example.ws10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class Logo extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_logo);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://mskko2021.mad.hakta.pro/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);

        findViewById(R.id.reg).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                User u = new User();

                EditText email = findViewById(R.id.email);
                EditText password = findViewById(R.id.password);

                TextView t = findViewById(R.id.text);

                u.setEmail(email.getText().toString());
                u.setPassword(password.getText().toString());

                Call<UserData> login = api.login(u);
                login.enqueue(new Callback<UserData>() {
                    @Override public void onResponse(Call<UserData> call, Response<UserData> response) {
                        Toast.makeText(
                                getApplicationContext(),
                                response.body().toString(),
                                Toast.LENGTH_LONG).show();
                        t.setText(response.body().toString());
                    }

                    @Override public void onFailure(Call<UserData> call, Throwable t) {

                    }
                });
            }
        });
    }

    public interface API {
        @POST("user/login")
        Call<UserData> login(@Body User user);
    }

    public class User {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public class UserData {
        private String id;
        private String email;
        private String nickName;
        private String avatar;
        private String token;

        public String toString() {
            return id + "; " + email + "; " + nickName + "; " + avatar + "; " + token;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
