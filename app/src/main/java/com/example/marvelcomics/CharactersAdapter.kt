package com.example.marvelcomics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CharactersAdapter(
    private val callback: (Character) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private var characters = mutableListOf(
        Character("Captain America"),
        Character("Iron Man"),
        Character("Thor"),
        Character("Hulk")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, callback)
    }

    fun addCharacter(character: Character) {
        characters.add(0, character)
        notifyDataSetChanged()
    }

    class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView = view.findViewById<TextView>(R.id.name_text_view)

        fun bind(character: Character, callback: (Character) -> Unit) {
            nameTextView.text = character.name
            itemView.setOnClickListener {
                callback(character)
            }
        }
    }
}
