package aviles.itzel.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)

        val bundle = intent.extras
        var numberSeats = 0
        var id = -1
        var title = ""

        if(bundle != null){

            numberSeats = bundle.getInt("numberSeats")
            title = bundle.getString("title")!!
            iv_item_img.setImageResource(bundle.getInt("header"))
            tv_item_title.setText(bundle.getString("title"))
            tv_movie_desc.setText(bundle.getString("description"))
            tv_seats_left.setText("$numberSeats seats available")
            id = bundle.getInt("pos")
        }

        if(numberSeats == 0){
            btn_buy_tickets.isEnabled = false
        }else{
            btn_buy_tickets.setOnClickListener{
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("title", title)

                this.startActivity(intent)
            }
        }
    }
}