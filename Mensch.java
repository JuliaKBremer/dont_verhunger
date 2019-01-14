import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mensch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mensch extends Actor
{
    private final int speed = 4;
    public static int died = 0;
    public int health = 100;
    private int nutrition = 1000;
    public void act() 
    {
        move();
        eat();
        attack();
        demage();
        heal();
        die();
    }    
    private void move()
    {
        if(Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY()-this.speed);
        }
        else if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY()+this.speed);
        }
        else if (Greenfoot.isKeyDown("left")) {
            setLocation(getX()-this.speed, getY());
        }
        else if (Greenfoot.isKeyDown("right")) {
            setLocation(getX()+this.speed, getY());
        }
        nutrition -= 1;
    }
    private void eat() {
        if (isTouching(Pizza.class)) {
            Pizza pizza=(Pizza)getOneIntersectingObject(Pizza.class);
            nutrition += Pizza.nutrition;
        }
        else if (isTouching(Cupcake.class)) {
            Cupcake cupcake=(Cupcake)getOneIntersectingObject(Cupcake.class);
            nutrition += Cupcake.nutrition;
        }
    }
    private void die() {
        if (nutrition <= 0 || health <= 0) {
            died = 1;
            getWorld().removeObject(this);
        }
    }
    private void attack() {
        if (isTouching(Pig.class)) {
            Pig pig=(Pig)getOneIntersectingObject(Pig.class);
            pig.health -= 10;
        }
        else if (isTouching(Hippo.class)) {
            Hippo hippo=(Hippo)getOneIntersectingObject(Hippo.class);
            hippo.health -= 10;
        }
    }
    private void demage() {
        if (isTouching(Hippo.class)) {
            Hippo hippo=(Hippo)getOneIntersectingObject(Hippo.class);
            health -= 10;
        }
    }
    private void heal() {
        if (nutrition >= 500 && health < 100) {
            health += 2;
        }
    }
}
