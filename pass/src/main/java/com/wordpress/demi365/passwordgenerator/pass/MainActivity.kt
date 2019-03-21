package com.wordpress.demi365.passwordgenerator.pass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generatePassButton = findViewById<Button>(R.id.generatePassButton)
        val generatedPassTextView = findViewById<TextView>(R.id.generatedPasswordTextView)
        val websiteNameEditText = findViewById<EditText>(R.id.websiteNameEditText)
        val masterPasswordEditText = findViewById<EditText>(R.id.masterPasswordEditText)
        val showPasswordSwitch = findViewById<Switch>(R.id.showPasswordSwitch)
        val lengthChosenTextView = findViewById<TextView>(R.id.lengthChosenTextView)
        val lengthSeekBar = findViewById<SeekBar>(R.id.lengthSeekbar)

        lengthChosenTextView.text = lengthSeekBar.progress.toString()

        generatePassButton.setOnClickListener {
            var passAfterHashed = websiteNameEditText.text.hashCode()
            generatedPassTextView.text = passAfterHashed.toString()
        }

        showPasswordSwitch.setOnClickListener {
            if (showPasswordSwitch.isChecked)
                masterPasswordEditText.setTransformationMethod(null)
            else
                masterPasswordEditText.setTransformationMethod(PasswordTransformationMethod())
        }

        lengthSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override
            fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                lengthChosenTextView.text = progress.toString()
            }

            override
            fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override
            fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }
}
