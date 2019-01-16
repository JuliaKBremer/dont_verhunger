import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startmenue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startmenue extends World
{

    /**
     * Constructor for objects of class Startmenue.
     * 
     */
    public Startmenue()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        spawn();
        text();
    }
    public void text() {
        this.showText("Don't    Verhunger", 500, 200);
        this.showText("Exit", 300, 500);
        this.showText("Help", 550, 500);
        this.showText("Start", 800, 500);
    }
    private void spawn() {
        this.addObject(new Exit_Button(), 300, 500);
        this.addObject(new Help_Button(), 550, 500);
        this.addObject(new Start_Button(), 800, 500);
    }
}
