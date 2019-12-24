package com.example.marvelcomics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcomics.CharacterDetailsActivity.Companion.NAME_KEY
import kotlinx.android.synthetic.main.activity_characters.*

class CharactersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        marvel_characters_list.layoutManager = LinearLayoutManager(this)
        val clickHandler: (Character) -> Unit = { character ->
            val intent = Intent(this, CharacterDetailsActivity::class.java)
            intent.putExtra(NAME_KEY, character.name)
            startActivity(intent)

            Log.d("TESTING", "Character name: ${character.name}")
        }
        marvel_characters_list.adapter = CharactersAdapter(clickHandler)
    }
}
