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
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        val spinner = parent as? Spinner
                        val item = spinner?.selectedItem as? String
                        item?.let {
                            if (it.isNotEmpty()) height.text = it
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates
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
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        height.text = progress.toString()
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates{
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
        }

        override fun onPause() {
            super.onPause()
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                    .putInt("HEIGHT",height.text.toString().toInt())
                    .apply()
        }

}

