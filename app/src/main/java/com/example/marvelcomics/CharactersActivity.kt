package com.example.marvelcomics

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.example.marvelcomics.CharacterDetailsActivity.Companion.DELETE_CHARACTER_KEY
import com.example.marvelcomics.CharacterDetailsActivity.Companion.DETAILS_CHARACTER_KEY
import com.example.marvelcomics.CharacterDetailsActivity.Companion.UPDATE_CHARACTER_KEY
import com.example.marvelcomics.CharacterDetailsActivity.Companion.DETAILS_REQUEST_CODE
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
            intent.putExtra(DETAILS_CHARACTER_KEY, character)
            startActivityForResult(intent, DETAILS_REQUEST_CODE)

            Log.d("TESTING", "Character name: ${character.name}")
        }
        characters_list.adapter = CharactersAdapter(clickHandler)
        characters_list.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))

        characters_add_button.setOnClickListener {
            val intent = Intent(this, NewCharacterActivity::class.java)
            startActivityForResult(intent, ADD_REQUEST_CODE)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.sort_ascending -> {
                val adapter = characters_list.adapter as CharactersAdapter
                adapter.sortAscending()
                true
            }
            R.id.sort_descending -> {
                val adapter = characters_list.adapter as CharactersAdapter
                adapter.sortDescending()
                true
            }
            R.id.clear_items -> {
                val adapter = characters_list.adapter as CharactersAdapter
                adapter.clearItems()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val character = data?.getParcelableExtra(NEW_CHARACTER_KEY) as Character
            val adapter = characters_list.adapter as CharactersAdapter
            adapter.addCharacter(character)
        } else if (requestCode == DETAILS_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val characterToAdd: Character? = data?.getParcelableExtra(UPDATE_CHARACTER_KEY)
            val characterToDelete: Character? = data?.getParcelableExtra(DELETE_CHARACTER_KEY)
            val adapter = characters_list.adapter as CharactersAdapter
            if (characterToAdd != null) {
                adapter.updateCharacter(characterToAdd)
            } else if (characterToDelete != null) {
                adapter.deleteCharacter(characterToDelete)
            }
        }
    }
}
