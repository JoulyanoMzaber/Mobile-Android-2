package comp208.Mzaber;

import android.graphics.Path;

public class Line {
    public int color;

    public int strokeWidth;

    public Path linePath;

    public Line(int color, int strokeWidth, Path linePath) {
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.linePath = linePath;
    }
}
