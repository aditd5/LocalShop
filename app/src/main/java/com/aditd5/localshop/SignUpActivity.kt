package com.aditd5.localshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.aditd5.localshop.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnSignin.setOnClickListener {
            var intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPasswordSu.text.toString()

            if (email.isEmpty()) {
                binding.etEmail.error = "Email harus diisi"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Email tidak valid"
                binding.etEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPasswordSu.error = "Password harus diisi"
                binding.etPasswordSu.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(email,password)
        }
    }
    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this,"Berhasil membuat akun",Toast.LENGTH_SHORT).show()
                    var intent = Intent(this,SignInActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this,"${it.exception?.message}",Toast.LENGTH_SHORT).show()
                }
            }
    }
}
