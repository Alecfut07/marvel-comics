package com.example.marvelcomics

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
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
            val power = new_seek_bar.progress
            if (!name.isNullOrEmpty()) {
                val character = Character(name, power)
                val intent = Intent()
                intent.putExtra(NEW_CHARACTER_KEY, character)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
        new_seek_bar_progress.text = this.getString(R.string.progress, 0)
        new_seek_bar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                new_seek_bar_progress.text = this@NewCharacterActivity.getString(R.string.progress, progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

    }
}