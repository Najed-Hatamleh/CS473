package com.example.assignment4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.provider.AlarmClock.EXTRA_MESSAGE

class MainActivity : AppCompatActivity() {
    var users = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addUsers()
        setContentView(R.layout.activity_main)

        val user = intent.getSerializableExtra(EXTRA_MESSAGE) as? User
        if (user != null) {
            users.add(user)
            Toast.makeText(this, "Account create for ${user.firstName} ${user.lastName}", Toast.LENGTH_LONG).show()
        }
    }

    fun addUsers() {
        users.add(User("nejed", "hatamleh", "nejed@gmail.com", "1234"))
        users.add(User("rashed", "jibreen", "rashed@gmail.com", "1234"))
        users.add(User("odai", "nimri", "zain@gmail.com", "1234"))
    }

    fun login(view: View) {
        var email: String = findViewById<EditText>(R.id.emailAddress).text.toString()
        var password: String = findViewById<EditText>(R.id.password).text.toString()
        var userFound: Boolean = false

        for(user in users) {
            if(user.email.equals(email) && user.password.equals(password)) {
                userFound = true
            }
        }

        if(userFound) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_LONG).show()

            val intent = Intent(this, ShoppingCategoryActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, email)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_LONG).show()
        }
    }

    fun register(view: View) {
        val intent = Intent(this, RegistryActivity::class.java)
        startActivity(intent)
    }
}