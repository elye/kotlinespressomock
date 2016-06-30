package com.elyeproj.javadaggeruitest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var iData: InjectedData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as MainApplication).component.inject(this)

        val textView = findViewById(R.id.txt_myview) as TextView?

        if (iData!!.status) {
            textView!!.text = "True"
        } else {
            textView!!.text = "False"
        }
    }
}
