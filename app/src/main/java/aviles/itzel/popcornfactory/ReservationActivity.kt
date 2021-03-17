package aviles.itzel.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_reservation.*

class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val bundle = intent.extras
        var movie: String = ""
        var seat: Int = 0

        val tv_movie: TextView = findViewById(R.id.tv_movie_title)
        val tv_seat: TextView = findViewById(R.id.tv_seat_selected)

        if(bundle != null){
            movie = bundle.getString("movie")!!
            seat = bundle.getInt("seat")

        }
        tv_movie.setText("$movie")
        tv_seat_selected.setText("Your seat is no. $seat")
    }
}