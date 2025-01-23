package cokr.oneweeks.imagsslider

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.timer


class PhotoFrameActivity :AppCompatActivity() {
    private val photoList = mutableListOf<Uri>()
    private var currentPosition = 0
    private var timeHandler: Handler? = null

    private lateinit var photoImageView: ImageView
    private lateinit var backgroundPhotoImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_potoframe)
        photoImageView =findViewById(R.id.ImageView)
        backgroundPhotoImageView = findViewById(R.id.photoImageView)
        getPhotoUriFromIntent()
    }
    private fun getPhotoUriFromIntent() {
        val size = intent.getIntExtra("photo$i")?.let {
            photoList.add(Uri.parse(it))
        }
    }
}

private val timerRunnable = object: Runnable {
    override fun run() {
        val current = currentPosition
        val next = if (photoList.size <= currentPosition +1) 0
        else
            currentPosition +1
        backgroundPhotoImageView.setImageUrI(photoList[current])

        photoImageView.alpha= Of
        photoImageView.setImageURI(photoList[next])

        photoImageView.animate()
            .alpha(1.Of)
            .setDuration(1000)
            .start()

        currentPosition = next

        startTimer()

    }
    private fun startTimer() {
        timerHandler?.remeveCallbacks(timerRunnable)
        timerHandler = Handler(Looper.getMainLooper())
        timerHandler?.postDelayed(timerRunnable, 3000)

    }
    override fun onStart() {
        super.onStart()
        startTimer()
    }
    override fun onStart() {
        super.onStop()
            timerHandler?.removeCallbacks(timerRunnable)
    }
    override fun onDestroy() {
        super.ouDestroy()
        timerHandler.removeCallback(timerRunnable)
    }
}