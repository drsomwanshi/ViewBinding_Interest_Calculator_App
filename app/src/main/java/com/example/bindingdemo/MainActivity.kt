package com.example.bindingdemo

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.bindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var num= arrayOf(1,2,3,4,5,6,8,8,10)
        var adp= ArrayAdapter(this, R.layout.simple_list_item_1,num);
        binding.txtduration.adapter=adp;

        binding.btnok.setOnClickListener{
            var amt=binding.txtamt.text.toString().toInt();
            var rate=binding.txtrate.text.toString().toInt();
            var d=binding.txtduration.selectedItem.toString().toInt()
            var i=((amt*rate/100))*d;
            var total=amt+i;
            var output="Interest=" +i + "\n" + "Total=" +total;
            Toast.makeText(applicationContext, output, Toast.LENGTH_SHORT).show()


        }

    }
}