package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.common.BaseActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.PhoneBean
import com.example.myapplication.mvp.BaseView
import com.example.myapplication.presenter.MainPresenter
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : BaseActivity(), BaseView {
    var presenter: MainPresenter = MainPresenter()

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*textView.setOnClickListener {
            presenter.getPhone(this,"13666666666",object : DataCallBack{
                override fun callBack(obj: Any?) {
                    if (obj is PhoneBean){
                        textView.setText(obj.phone)
                    }
                }
                *//*obj -> {
                    if (obj is PhoneBean){
                        textView.setText(obj.phone)
                        }
                    }*//*
            }
            )}*/
        binding.test.setOnClickListener {
            presenter.getPhone(this, "13666666666", { obj ->
                if (obj is PhoneBean) {
                    binding.test.setText(obj.phone)
                }
            })
        }

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
         //presenter.getMainTag(this)
    }

    override fun requestStart() {

        Toast.makeText(this, "开始", Toast.LENGTH_SHORT).show()
    }

    override fun requestFinish() {
        Toast.makeText(this, "结束", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        presenter.dispose()
        super.onDestroy()
    }

}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var textContent by remember { mutableStateOf("点我刷新") }
    Text(
        text = textContent,
        modifier = modifier.clickable{
            textContent="我被刷新了"
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}