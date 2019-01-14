import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Hippo extends Target
{
    public int health = 70;
    public void act() 
    {
        move();
        die();
    }    
    private void die() {
        if (health <= 0) {
            getWorld().removeObject(this);
        }
    }
}
