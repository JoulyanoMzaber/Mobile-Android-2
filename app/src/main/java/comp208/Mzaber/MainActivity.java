package comp208.Mzaber;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Drawer lines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lines = findViewById(R.id.drawer);

        OnTouchListener listener = (view, event) ->{
            int action = event.getActionMasked();

            switch (action) {
                case (MotionEvent.ACTION_DOWN):
                    lines.begin(event.getX(), event.getY());
                    break;
                case (MotionEvent.ACTION_UP):
                    view.performClick();
                    break;
                case (MotionEvent.ACTION_MOVE):
                    lines.addPoint(event.getX(), event.getY());
                    break;
            }

            return true;
        };

        lines.setOnTouchListener(listener);
    }

    public void screenClear(View view) {
        lines.clear();
    }
    public void ColorRed(View view) {
        lines.setColorRed();
    }

    public void ColorGreen(View view) {
        lines.setColorGreen();
    }

    public void ColorBlue(View view) {
        lines.setColorBlue();
    }

    public void ColorYellow(View view) {
        lines.setColorYellow();
    }

    public void ColorBlack(View view) {
        lines.setColorBlack();
    }
}