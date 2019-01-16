import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Arrays;
import java.util.*;
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
    public int newspawn = 0;
    private int humanX = 0;
    private int humanY = 0;
    public void act() 
    {
        moveNext();
        move();
        humanX = getX();
        humanY = getY();
        eat();
        attack();
        demage();
        //heal();
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
        if (humanX > 0 && humanX < 999 && humanY > 0 && humanY < 799) {
            newspawn = 1;
        }
    }
    private void eat() {
        if (isTouching(Pizza.class)) {
            Pizza pizza=(Pizza)getOneIntersectingObject(Pizza.class);
            nutrition += Pizza.nutrition;
            health += 5;
        }
        else if (isTouching(Cupcake.class)) {
            Cupcake cupcake=(Cupcake)getOneIntersectingObject(Cupcake.class);
            nutrition += Cupcake.nutrition;
            health += 2;
        }
        updateHealth();
    }
    private void die() {
        if (nutrition <= 0 || health <= 0) {
            died = 1;
            getWorld().removeObject(this);
        }
    }
    private void attack() {
        if(Greenfoot.isKeyDown("space")) {
            if (isTouching(Spear.class)) {
                Spear spear=(Spear)getOneIntersectingObject(Spear.class);
                //spear.setImage(""); <-- Neues Image bei angriff!
                if (isTouching(Pig.class)) {
                    Pig pig=(Pig)getOneIntersectingObject(Pig.class);
                    pig.health -= 10;
                }
                else if (isTouching(Hippo.class)) {
                    Hippo hippo=(Hippo)getOneIntersectingObject(Hippo.class);
                    hippo.health -= 10;
                }
            }
        }
    }
    private void demage() {
        if (isTouching(Hippo.class)) {
            Hippo hippo=(Hippo)getOneIntersectingObject(Hippo.class);
            health -= 5;
            updateHealth();
        }
    }
    private void updateHealth() {
            getWorld().removeObjects(getWorld().getObjects(Bar.class));
            Bar bar = new Bar("Player 1", "health Points", health, 100);
            getWorld().addObject(bar, 125, 40);
    }
    /*private void heal() {
        if (nutrition >= 400 && health < 100) {
            health += 2;
            updateHealth();
        }
    }*/
    public void moveNext() {
       
        if (newspawn == 1) {
            if (humanX <= 0 || humanX >= 999 || humanY <= 0 || humanY >= 799) {
                getWorld().removeObjects(getWorld().getObjects(Hippo.class));
                getWorld().removeObjects(getWorld().getObjects(Pizza.class));
                getWorld().removeObjects(getWorld().getObjects(Cupcake.class));
                getWorld().removeObjects(getWorld().getObjects(Pig.class));
                for (Spear spear : getWorld().getObjects(Spear.class)){
                    if (!(spear.getX() == getX() && spear.getY() == getY())){
                        getWorld().removeObject(spear);
                    }
                }
                spawn();
            }
        }
    }
    public void spawn() {
        int randomX = 0;
        int randomY = 0;
        int randomAnzahl = 0;
        
        randomX = (int)(Math.random()*1000);
        randomY = (int)(Math.random()*800);
        randomAnzahl = (int)(Math.random()*10);
        if (newspawn == 1) {
            if (humanX <= 1) {
                if (isTouching(Spear.class)) {
                    getWorld().addObject(new Spear(), 999,humanY);
                }
                this.setLocation(999, humanY);
            }
            else if (humanX >= 999) {
                if (isTouching(Spear.class)) {
                    getWorld().addObject(new Spear(), 0, humanY);
                }
                this.setLocation(0, humanY);
            }
            if (humanY <= 1) {
                if (isTouching(Spear.class)) {
                    getWorld().addObject(new Spear(), humanX,799);
                }
                this.setLocation(humanX, 799);
            }
            else if (humanY >= 799) {
                if (isTouching(Spear.class)) {
                    getWorld().addObject(new Spear(), humanX,0);
                }
                this.setLocation(humanX, 0);
            }
            getWorld().addObject(new Spear(), randomX,randomY);
            for (int i = 0; i < randomAnzahl; i++ ) {
                randomX = (int)(Math.random()*1000);
                randomY = (int)(Math.random()*800);
                getWorld().addObject(new Pizza(),randomX,randomY);
            }
            randomAnzahl = (int)(Math.random()*10);
            for (int i = 0; i < randomAnzahl; i++ ) {
                randomX = (int)(Math.random()*1000);
                randomY = (int)(Math.random()*800);
                getWorld().addObject(new Cupcake(),randomX,randomY);
            }
            randomAnzahl = (int)(Math.random()*10);
            for (int i = 0; i < randomAnzahl; i++ ) {
                randomX = (int)(Math.random()*1000);
                randomY = (int)(Math.random()*800);
                getWorld().addObject(new Hippo(),randomX,randomY);
            }
            randomAnzahl = (int)(Math.random()*10);
            for (int i = 0; i < randomAnzahl; i++ ) {
                randomX = (int)(Math.random()*1000);
                randomY = (int)(Math.random()*800);
                getWorld().addObject(new Pig(),randomX,randomY);
            }
            newspawn = 0;
        }
    }
}
