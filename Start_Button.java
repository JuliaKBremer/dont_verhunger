import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start_Button extends Button
{
    /**
     * Act - do whatever the Start_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Image();
        generate();
    }    
    private void generate() {
        if (Greenfoot.mouseClicked(this)) {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
}
