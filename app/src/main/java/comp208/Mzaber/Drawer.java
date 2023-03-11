package comp208.Mzaber;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Drawer extends View {

    private ArrayList<Line> lines = new ArrayList<>();

    Paint paint = new Paint();
    Path myPath =  new Path();

    int currentColor = Color.BLACK;
    int brushWidth = 8;
    public Drawer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Line lp: lines){
            paint.setStrokeWidth(lp.strokeWidth);
            paint.setColor(lp.color);
            paint.setStyle(Paint.Style.STROKE);
                canvas.drawPath(lp.linePath, paint);
        }


        /*paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);

        if(myPath != null)
            canvas.drawPath(myPath, paint); //make it(myPath) an array in later attempts*/
    }

    Path path = null;
    public void begin(float x, float y) {
        myPath = new Path();
        Line lp = new Line(currentColor, brushWidth, myPath);
        lines.add(lp);
        myPath.moveTo(x,y);
        //invalidate(); // calls the OnDraw method again redraws things
    }

    public void addPoint(float x, float y) {
        if (myPath != null)
        {
            myPath.lineTo(x,y);
            invalidate();
        }
    }

    public void clear() {
        lines = new ArrayList<>();
        myPath = new Path();
        invalidate();
    }

    public void setColorRed() {
        currentColor = Color.RED;
    }

    public void setColorGreen() {
        currentColor = Color.GREEN;
    }

    public void setColorBlue() {
        currentColor = Color.BLUE;
    }

    public void setColorYellow() {
        currentColor = Color.YELLOW;
    }

    public void setColorBlack() {
        currentColor = Color.BLACK;
    }
}