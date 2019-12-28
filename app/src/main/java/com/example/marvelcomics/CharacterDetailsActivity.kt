package com.example.marvelcomics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_character_details.*

class CharacterDetailsActivity : AppCompatActivity() {

    companion object {
        const val NAME_KEY = "NAME"
        const val UPDATE_REQUEST_CODE = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)
        val name = intent.getStringExtra(NAME_KEY)
        details_name_edit_text.setText(name)
        // Referencías cajita
        // cajita.setText(name)
        supportActionBar?.title = this.getString(R.string.details_title)
    }
}