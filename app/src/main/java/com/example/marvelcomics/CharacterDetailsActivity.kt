package com.example.marvelcomics

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_character_details.*

class CharacterDetailsActivity : AppCompatActivity() {

    companion object {
        const val DETAILS_CHARACTER_KEY = "DETAILS_CHARACTER"
        const val DETAILS_REQUEST_CODE = 101
        const val UPDATE_CHARACTER_KEY = "UPDATE_CHARACTER"
        const val DELETE_CHARACTER_KEY = "DELETE_CHARACTER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)
        val character = intent.getParcelableExtra<Character>(DETAILS_CHARACTER_KEY)

        details_name_edit_text.setText(character.name)
        details_id_text_view.text = character.id
        details_save_button.setOnClickListener {
            val name = details_name_edit_text.text.toString()
            if (!name.isNullOrEmpty()) {
                character.name = name
                val intent = Intent()
                intent.putExtra(UPDATE_CHARACTER_KEY, character)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
        details_delete_button.setOnClickListener {
            val intent = Intent()
            intent.putExtra(DELETE_CHARACTER_KEY, character)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        supportActionBar?.title = this.getString(R.string.details_title)
    }
}