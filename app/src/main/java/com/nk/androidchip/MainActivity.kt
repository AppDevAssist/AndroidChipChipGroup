package com.nk.androidchip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var chipGroup: ChipGroup


    private fun addChip(text: String){
        val chip = Chip(this)
        chip.text = text

        chip.isCloseIconVisible = true

        chip.setChipIconResource(R.drawable.ic_baseline_android_24)

        chip.setOnCloseIconClickListener{
            chipGroup.removeView(chip)
        }

        chipGroup.addView(chip)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.button)
        chipGroup = findViewById(R.id.chipGroup)

        addButton.setOnClickListener{
            if(!editText.text.toString().isEmpty()){
                addChip(editText.text.toString())

                editText.setText("")
            }
        }
    }
}