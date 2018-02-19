package estefaniacguardado.kotlinhelloworld

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.EditText
import android.content.Intent



class MainActivity : AppCompatActivity() {
    val EXTRA_MESSAGE = "estefaniacguardado.kotlinhelloworld.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {
        val intent = Intent(
                this,
                DisplayMessageActivity::class.java
        )
        val editText = findViewById<View>(R.id.editText) as EditText
        val message = editText.text.toString()
        intent.putExtra("EXTRA_MESSAGE", message)
        startActivity(intent)
    }
}
