import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;

/**
 * Write a description of class Bar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bar extends Actor
{
    private int barWidth = 100; 
    private int barHeight = 10; 
    private int breakPercent = 20; 
    private int breakValue = 20; 
    private boolean usingBreakValue = false;
    private boolean breakLow = true; 
    private Color backgroundColor = new Color(0, 0, 0, 0); 
    private Color textColor = Color.BLACK; 
    private Color safeColor = Color.GREEN; 
    private Color dangerColor = Color.RED; 
    private float fontSize = 18.0f; 
    private int value = 0; 
    private int maximumValue = 0; 
    private int minimumValue = 0; 
    public String referenceText = ""; 
    private String unitOfMeasure = ""; 
    private boolean showTextualUnits = true; 
    
    public Bar(String refText, String unitType, int initValue, int maxValue)
    {
        referenceText = refText;
        unitOfMeasure = unitType;
        maximumValue = maxValue;
        add(initValue);
    }

    private void newImage()
    {
        int barValue = (int) (barWidth * (value - minimumValue) / (maximumValue - minimumValue));
        GreenfootImage leftImg = new GreenfootImage(referenceText + " ", (int) fontSize, textColor, backgroundColor);
        GreenfootImage rightImg = (showTextualUnits) ? new GreenfootImage(" " + value + " " + unitOfMeasure, (int) fontSize, textColor, backgroundColor) : new GreenfootImage(1, 1);
        int maxX = (leftImg.getWidth() > rightImg.getWidth()) ? leftImg.getWidth() : rightImg.getWidth();
        GreenfootImage barImg = new GreenfootImage(barWidth + 4, barHeight + 4);
        barImg.setColor(backgroundColor);
        barImg.fill();
        barImg.setColor(textColor);
        barImg.drawRect(0, 0, barImg.getWidth() - 1, barImg.getHeight() - 1);
        if (value > minimumValue)
        {
            if (breakLow)
            {
                if (value > (usingBreakValue ? breakValue : (int) (breakPercent * (maximumValue - minimumValue) / 100 + minimumValue))) barImg.setColor(safeColor);
                else barImg.setColor(dangerColor);
            }
            else
            {
                if (value < (usingBreakValue ? breakValue : (int) (breakPercent * (maximumValue - minimumValue) / 100 + minimumValue))) barImg.setColor(safeColor);
                else barImg.setColor(dangerColor);
            }
            if (value == (usingBreakValue ? breakValue : (int) (breakPercent * (maximumValue - minimumValue) / 100 + minimumValue)))
            {
                int r = (int) ((safeColor.getRed() + dangerColor.getRed()) / 2);
                int g = (int) ((safeColor.getGreen() + dangerColor.getGreen()) / 2);
                int b = (int) ((safeColor.getBlue() + dangerColor.getBlue()) / 2);
                barImg.setColor(new Color(r, g, b));
            }
            barImg.fillRect(2, 2, barValue, barHeight);
        }
        int sumX = 2 * maxX + barImg.getWidth();
        int maxY = 0;
        if (leftImg.getHeight() > maxY) maxY = leftImg.getHeight();
        if (barImg.getHeight() > maxY) maxY = barImg.getHeight();
        if (rightImg.getHeight() > maxY) maxY = rightImg.getHeight();
        GreenfootImage image = new GreenfootImage(sumX, maxY);
        image.setColor(backgroundColor);
        image.fill();
        image.drawImage(leftImg, maxX - leftImg.getWidth(), (image.getHeight() - leftImg.getHeight()) / 2);
        image.drawImage(barImg, maxX, (image.getHeight() - barImg.getHeight()) / 2);
        image.drawImage(rightImg, maxX + barImg.getWidth(), (image.getHeight() - rightImg.getHeight()) / 2);
        setImage(image);
    }

    public void add(int amount)
    {
        value += amount;
        checkValue();
        newImage();
    }
    
    public void subtract(int amount)
    {
        value -= amount;
        checkValue();
        newImage();
    }
    
    private void checkValue()
    {
        if (value < minimumValue) value = minimumValue;
        if (value > maximumValue) value = maximumValue;
    }
}
