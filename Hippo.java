import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Hippo extends Target
{
    public int health = 100;
    public void act() 
    {
        move();
    }    
    private void die() {
        if (health <= 0) {
            getWorld().removeObject(this);
        }
    }
}
