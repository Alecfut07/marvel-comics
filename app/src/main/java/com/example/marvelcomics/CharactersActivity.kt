package com.example.marvelcomics

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcomics.CharacterDetailsActivity.Companion.NAME_KEY
import com.example.marvelcomics.CharacterDetailsActivity.Companion.UPDATE_REQUEST_CODE
import com.example.marvelcomics.NewCharacterActivity.Companion.ADD_REQUEST_CODE
import com.example.marvelcomics.NewCharacterActivity.Companion.NEW_CHARACTER_KEY
import kotlinx.android.synthetic.main.activity_characters.*

class CharactersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)

        characters_list.layoutManager = LinearLayoutManager(this)
        val clickHandler: (Character) -> Unit = { character ->
            val intent = Intent(this, CharacterDetailsActivity::class.java)
            intent.putExtra(NAME_KEY, character.name)
            startActivityForResult(intent, UPDATE_REQUEST_CODE)

            Log.d("TESTING", "Character name: ${character.name}")
        }
        characters_list.adapter = CharactersAdapter(clickHandler)

        characters_add_button.setOnClickListener {
            val intent = Intent(this, NewCharacterActivity::class.java)
            startActivityForResult(intent, ADD_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val character = data?.getParcelableExtra(NEW_CHARACTER_KEY) as Character
            val adapter = characters_list.adapter as CharactersAdapter
            adapter.addCharacter(character)
        } else if (requestCode == UPDATE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            // Update recycler view
            
        }
    }
}
