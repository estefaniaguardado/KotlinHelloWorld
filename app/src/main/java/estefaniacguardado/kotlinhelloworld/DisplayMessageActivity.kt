package estefaniacguardado.kotlinhelloworld

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView



class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        //val intent = intent
        val message = intent.getStringExtra("EXTRA_MESSAGE")

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = message

        val tableLayout = findViewById<View>(R.id.mainTable) as TableLayout
        val row = TableRow(this)
        val content = TextView(this)
        content.setText(textView.text)
        row.addView(content)


        tableLayout.addView(row)

    }
}
