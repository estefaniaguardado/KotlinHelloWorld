package estefaniacguardado.kotlinhelloworld

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.RelativeLayout
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView



class DisplayMessageActivity : AppCompatActivity() {

    var companies = arrayOf("Google", "Windows", "iPhone", "Nokia", "Samsung", "Google", "Windows", "iPhone", "Nokia", "Samsung", "Google", "Windows", "iPhone", "Nokia", "Samsung")
    var os = arrayOf("Android", "Mango", "iOS", "Symbian", "Bada", "Android", "Mango", "iOS", "Symbian", "Bada", "Android", "Mango", "iOS", "Symbian", "Bada")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        fillTable()
    }

    fun fillTable() {
        val tableRow = TableRow(this)
       // tableRow.layoutParams = getLayoutParams()
        tableRow.addView(getTextView(0,
                "COMPANY", Color.WHITE,
                Typeface.BOLD, Color.BLUE))
        tableRow.addView(getTextView(0,
                "OS", Color.WHITE,
                Typeface.BOLD, Color.BLUE))
        val table = findViewById<View>(R.id.mainTable) as TableLayout
        table.addView(tableRow, getTableLayoutParams())
        addDataRows()
    }

    fun getLayoutParams(): RelativeLayout.LayoutParams {
        val params = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(2, 0, 0, 2)
        return params
    }

    fun getTextView(id:Int, title:String, color:Int, typeFace:Int, bgColor:Int):TextView {
        val textView = TextView(this)
        textView.id = id
        textView.setText(title.toUpperCase())
        textView.setTextColor(color)
        textView.setPadding(40,40,40,40)
        textView.setTypeface(Typeface.DEFAULT, typeFace)
        textView.setBackgroundColor(bgColor)
        textView.layoutParams = getLayoutParams()
        //textView.setOnClickListener(this)
        return textView
    }

    fun getTableLayoutParams():TableLayout.LayoutParams {
        return TableLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
    }

    fun addDataRows() {
        val table = findViewById<View>(R.id.mainTable) as TableLayout
        for ((index:Int,company) in companies.withIndex()) {
            val tableRow = TableRow(this)
            tableRow.layoutParams = getLayoutParams()
            tableRow.addView(getTextView(index, company, Color.BLACK, Typeface.NORMAL,
                    ContextCompat.getColor(this, R.color.colorAccent)))
            //tableRow.addView(getTextView(index + companies.size, os[index], Color.BLACK,
                    //Typeface.NORMAL, ContextCompat.getColor(this, R.color.colorAccent)))
            table.addView(tableRow)
        }
    }
}
