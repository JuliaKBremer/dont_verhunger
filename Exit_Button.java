import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit_Button extends Button
{
    /**
     * Act - do whatever the Exit_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Image();
        stop();
    }    
    private void stop() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.stop();
        }
    }
}
