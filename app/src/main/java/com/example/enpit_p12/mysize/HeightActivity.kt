package com.example.enpit_p12.mysize

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceManager
import android.view.View
import android.view.ViewParent
import android.widget.*
import kotlinx.android.synthetic.main.activity_height.*

class HeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)

        spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val spinner = parent as? Spinner
                        val item = spinner?.selectedItem as? String
                        item?.let {
                            if (it.isNotEmpty()) height.text = it
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }

                }
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val heightVal = getInt("HEIGHT", 160)
            height.setText(heightVal.toString())
            seekBar.progress = heightVal
        }

        seekBar.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        height.text = progress.toString()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    }

                })

        radioGroup.setOnCheckedChangeListener{
            group, checkedId ->
                height.text = findViewById<RadioButton>(checkedId).text
        }

        }

        override fun onPause() {
            super.onPause()
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("HEIGHT",height.text.toString().toInt())
                    .apply()
        }

}

