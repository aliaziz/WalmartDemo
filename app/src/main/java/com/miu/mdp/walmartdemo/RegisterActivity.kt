package com.miu.mdp.walmartdemo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import com.miu.mdp.walmartdemo.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binder: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binder.root)


        with(binder) {
            registerButton.setOnClickListener {
                val intent = Intent()
                intent.putExtra(
                    "user", User(
                        firstNameEditText.text.toString(),
                        lastNameEditText.text.toString(),
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                    )
                )
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}
