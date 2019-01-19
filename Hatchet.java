import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hatchet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hatchet extends Weapon
{
    /**
     * Act - do whatever the Hatchet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scale();
        stick();
        
        //collect();
        // Add your action code here.
    }
    private void scale() {
        GreenfootImage image = this.getImage();
        image.scale(30,30);
        setImage(image);
    }
}
