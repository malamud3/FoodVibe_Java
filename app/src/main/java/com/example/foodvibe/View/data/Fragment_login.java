//package com.example.foodvibe.View.data;
//
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//
//import android.text.TextUtils;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.foodvibe.R;
//import com.google.firebase.auth.FirebaseAuth;
//
//import java.util.Objects;
//
//
//public class Fragment_login extends Fragment {
//
//    private EditText loginEmailText;
//    private EditText loginPassText;
//    private Button loginBtn;
//    private FirebaseAuth mAuth;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        //Importing UI
//        loginEmailText = findViewById(R.id.input_email);
//        loginPassText = findViewById(R.id.input_password);
//        loginBtn = findViewById(R.id.btn_login);
//
//
//        loginBtn.setOnClickListener(view -> {
//
//            String loginEmail = loginEmailText.getText().toString();
//            String loginPass = loginPassText.getText().toString();
//
//            if(!TextUtils.isEmpty(loginEmail) && !TextUtils.isEmpty(loginPass))
//            {
////                    mLoginProgress.setTitle("Logging In");
////                    mLoginProgress.setMessage("Please wait while we check your credentials !");
////                    mLoginProgress.setCanceledOnTouchOutside(false);
////                    mLoginProgress.show();
//
//
//                mAuth.signInWithEmailAndPassword(loginEmail, loginPass).addOnCompleteListener(task -> {
//
//                    if(task.isSuccessful())// sing In is ok
//                    {
//                        sendToMain();
//
//                    } else { //know problem - user input problem
//                        String errorMessage = Objects.requireNonNull(task.getException()).getMessage();
//                        Toast.makeText(Activity_Login.this,"Error : "+errorMessage,Toast.LENGTH_LONG).show();
//                    }
//                });
//
//            } else {// have to be info to check
//                Toast.makeText(Activity_Login.this,"Email/Password cannot be blank...",Toast.LENGTH_LONG).show();
//            }
//        });
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        ViewGroup view=(ViewGroup) inflater.inflate(R.layout.fragment_login, container, false);
//        return view;
//    }
//}