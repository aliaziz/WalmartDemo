package com.miu.mdp.walmartdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.miu.mdp.walmartdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinder: ActivityMainBinding

    private val users = arrayListOf(
        User("ali", "ziwa", "aziwa@miu.edu", "abcd"),
        User("ali1", "ziwa", "aziwa1@miu.edu", "abcd1"),
        User("ali2", "ziwa", "aziwa2@miu.edu", "abcd2"),
        User("ali3", "ziwa", "aziwa3@miu.edu", "abcd3"),
        User("ali4", "ziwa", "a", "a"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinder.root)

        viewBinder.signInButton.setOnClickListener {
            val userFound = users.find { it.username == viewBinder.emailEditText.text.toString() }
            if (userFound?.password == viewBinder.passwordEditText.text.toString()) {
                val nextIntent = Intent(this, ShoppingCategory::class.java)
                with(nextIntent) {
                    putExtra("username", userFound.username)
                    startActivity(this)
                }
            }
        }
        val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val user  = result.data?.extras?.getSerializable("user") as User
                users.add(user)
            }
        }
        viewBinder.createAccountButton.setOnClickListener {
            launcher.launch(Intent(this, RegisterActivity::class.java))
        }

        viewBinder.forgotPasswordButton.setOnClickListener {
            val password = users.find { it.username == viewBinder.emailEditText.text.toString() }?.password
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_TEXT, password)
            startActivity(emailIntent)
        }
    }
}
