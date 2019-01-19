import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spear extends Weapon
{
    
    public void act() 
    {
        scale();
        stick();
        //collect();
    } 
    private void scale() {
        GreenfootImage image = this.getImage();
        image.scale(30,30);
        setImage(image);
    }
}
