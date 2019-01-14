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
    } 
    private void scale() {
        GreenfootImage spear = new GreenfootImage("spear.png");
        GreenfootImage image = new GreenfootImage(spear);
        image.scale(30,30);
        setImage(image);
    }
    private void stick() {
        if (isTouching(Mensch.class)) {
            Mensch human=(Mensch)getOneIntersectingObject(Mensch.class);
            int x = human.getX();
            int y = human.getY();
            this.setLocation(x, y);
        }
    }
}
