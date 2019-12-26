package com.example.marvelcomics

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_new_character.*

class NewCharacterActivity : AppCompatActivity() {
    companion object {
        const val ADD_REQUEST_CODE = 100
        const val NEW_CHARACTER_KEY = "NEW_CHARACTER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_character)
        supportActionBar?.title = this.getString(R.string.new_title)
        new_add_button.setOnClickListener {
            val name = new_name_edit_text.text.toString()
            if (!name.isNullOrEmpty()) {
                val character = Character(name)
                val intent = Intent()
                intent.putExtra(NEW_CHARACTER_KEY, character)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}