package aviles.itzel.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*
import kotlin.collections.ArrayList

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title: TextView = findViewById(R.id.tv_title_seats)
        var movie: String = ""
        var seats = 0

        val bundle = intent.extras

        if(bundle != null){
            title.setText(bundle.getString("movie"))
            movie = bundle.getString("movie")!!
            seats = bundle.getInt("seats")
        }

        val confirm: Button = findViewById(R.id.btn_confirm)

        confirm.setOnClickListener{
            var seat_selected = seat_selection()
            val intent: Intent = Intent(this, ReservationActivity::class.java)
            intent.putExtra("seat", seat_selected)
            intent.putExtra("movie", movie)
            startActivity(intent)
        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
            }
        }
        row2.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }
        }
        row3.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
            }
        }
        row4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedId)
            }
        }

        disableButtons(seats)
    }

    fun disableButtons(seatsAv: Int){
        var seats: ArrayList<Int> = ArrayList<Int>()

        for(i in 0 until seatsAv){
            seats.add(1)
        }
        for(i in seatsAv until 20){
            seats.add(0)
        }

        Collections.shuffle(seats)

        for(i in 0 until 20){
            if(seats.get(i) == 0){
                var radioId: String = "seat" + (i+1)
                var resId: Int = resources.getIdentifier(radioId, "id", packageName)
                var radio: RadioButton = findViewById(resId)
                radio.isEnabled = false
            }
        }
    }

    fun seat_selection(): Int{
        var seat = 0
        for(i in 0 until 20){
            var radioId: String = "seat" + (i+1)
            var resId: Int = resources.getIdentifier(radioId, "id", packageName)
            var radio: RadioButton = findViewById(resId)

            if(radio.isChecked){
                seat = i+1
            }
        }
        return seat
    }
}













