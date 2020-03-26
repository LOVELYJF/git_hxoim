package com.hxoim.common.rmbKit;

/**
 * 是否合适字号
 */
public class FitFontSize {
    private boolean fitAble=false;
    private double fontSize;
    private int lineCount;
    private double addLineSpacing=1;

    public double getAddLineSpacing() {
        return addLineSpacing;
    }

    public void setAddLineSpacing(double addLineSpacing) {
        this.addLineSpacing = addLineSpacing;
    }

    public boolean isFitAble() {
        return fitAble;
    }

    public void setFitAble(boolean fitAble) {
        this.fitAble = fitAble;
    }

    public double getFontSize() {
        return fontSize;
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }
}
