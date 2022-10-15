package com.example.comparadordefigurinhas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.comparadordefigurinhas.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val userOne by lazy { binding.mainLayout.userOne }
    private val userTwo by lazy { binding.mainLayout.userTwo }
    private val button by lazy { binding.mainLayout.btnSave }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(
            LayoutInflater.from(this)
        )

        setContentView(binding.root)

        setSupportActionBar(toolbar)
        setListeners()
        setFakeInput()
    }

    private fun setFakeInput() {
        userOne.setRepeatValue(
            "FWC 4 5 12 14 28\n" +
                    "KOR 9 8 \n" +
                    "URU 6 7 9 12 15 19 \n" +
                    "GHA 7 11 15 19\n" +
                    "POR 4 8 11 17 20"
        )

        userOne.setMissingValue(
            "FWC 1 15 16 18 21 23 27\n" +
                    "QAT 12 14 16 17 19\n" +
                    "ECU 1 4 6 15\n" +
                    "SEN 5 19 20"
        )
    }

    private fun setListeners() {
        button.setOnClickListener {
            onClickSave()
        }
    }

    private fun onClickSave() {
        userOne.showValues()
        userTwo.showValues()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
