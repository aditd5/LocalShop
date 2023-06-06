package com.aditd5.localshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.aditd5.localshop.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnSigninSi.isAllCaps = false
        binding.btnSignupSi.isAllCaps = false

        binding.btnSignupSi.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnSigninSi.setOnClickListener {
            val email = binding.etEmailSi.text.toString()
            val password = binding.etPasswordSi.text.toString()

            if (email.isEmpty()) {
                binding.etEmailSi.error = "Email harus diisi"
                binding.etEmailSi.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmailSi.error = "Email tidak valid"
                binding.etEmailSi.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPasswordSi.error = "Password harus diisi"
                binding.etPasswordSi.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(email,password)
        }
        }

    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    saveLoginStatus(email)
                    Toast.makeText(this,"Selamat datang", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"User tidak ditemukan", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun saveLoginStatus(email: String) {
        val sharedPreferences = getSharedPreferences("login_pref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("is_logged_in",true)
        editor.putString("email",email)
        editor.apply()
    }
}