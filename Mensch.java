
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
    private int nutrition = 100;
    public boolean newspawn = false;
    private int humanX = 0;
    private int humanY = 0;
    public Actor equipped = null;  
    Actor[][] inventory = new Actor[10][10]; 
    //System.out.println(nutritionbar.referenceText);
    public void act() 
    {
        int fontsize = 15;
        updateHealth();
        moveNext();
        move();
        humanX = getX();
        humanY = getY();
        collect();
        if ((System.currentTimeMillis() % 5) == 0){
            get_from_inventory();
        }
        attack();
        demage();
        die();
    }
    private void collect() {
        List <Weapon> list;
        list = getWorld().getObjectsAt(getX(), getY(), Weapon.class);
        boolean collected = false;
        if (isTouching(Food.class)) {
            Food food =(Food)getOneIntersectingObject(Food.class);
            put_in_inventory(food);
        }
        else if ( isTouching(Weapon.class) && equipped != null){
            for (Weapon weapon : list) {
                if (weapon != equipped) {
                    System.out.println("notsame");
                    put_in_inventory(weapon);
                    getWorld().removeObject(weapon);
                    collected = true;
                }
                if (collected) break;
            }
        }
        
        if (isTouching(Weapon.class) && equipped == null){
            Weapon weapon =(Weapon)getOneIntersectingObject(Weapon.class);
            equipped = weapon;
            //getWorld().addObject(weapon, getX(), getY());
        }
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
        if ((System.currentTimeMillis() % 20) == 0){
            nutrition -= 1;
        }
        if (humanX > 0|| humanX < ((MyWorld)getWorld()).worldwidth -1 || humanY > 0 || humanY < ((MyWorld)getWorld()).worldheight -1) {
            newspawn = true;
        }
        if (equipped != null) {
            equipped.setLocation(getX(), getY());
        }
    }
    private void eat(Actor food) {
        
        //Pizza pizza=(Pizza)getOneIntersectingObject(Pizza.class);
        if (nutrition+ ((Food) food).nutrition <= 100) {
            nutrition += ((Food) food).nutrition;
        }
        else nutrition = 100;
        if (health +5 < 100) {
            health+= 5;
        }
        else health = 100;
        
        updateHealth();
    }
    private void use_item(Actor item) {
        if (item instanceof Food) {
            eat(item);
        }
        if (item instanceof Weapon) {
            put_in_inventory(equipped);
            getWorld().removeObject(equipped);
            equipped = item;
            getWorld().addObject(equipped, getX(), getY());
        }
    }
    private void get_from_inventory() {
        int i = 1;
        while(i< 10) {
            if (Greenfoot.isKeyDown(Integer.toString(i))){
                break;
            }
            else i++;
        }
        if (inventory[i-1][0] != null) {
            use_item(inventory[i-1][0]);    
        }
        boolean removed = false;
        for (int j = 9; j>= 0; j --) {
            if ((inventory[i-1][j] != null)) {
                inventory[i-1][j] = null;
                removed =true;
                if (j == 0) {
                    Inventory.boxes[i-1].getItem(i);
                }
            }
            if (removed) break;
        }
        
    }
    private void put_in_inventory(Actor item) {
        boolean put = false;
        for (int i = 0 ; i < inventory.length; i++) {
            if (!put && inventory[i][0] == null) {
                inventory[i][0] = item;
                put = true;
                break;
            }
            if (!put && (inventory[i][0].getClass() == item.getClass())) {
                for (int j = 0; j < inventory[i].length; j++) {
                    if ( inventory[i][j] == null) {
                        inventory[i][j] = item;
                        put = true;
                        break;
                    }
                }
            }
            
        }
        if (!put) {
            getWorld().showText("Inventory full", 200, 300);
        }
        
        
    }
    private void die() {
        if (nutrition <= 0 || health <= 0) {
            died = 1;
            getWorld().removeObject(this);
        }
    }
    private void attack() {
        if(Greenfoot.isKeyDown("space")) {
            if (equipped != null) {
                //spear.setImage(""); <-- Neues Image bei angriff!
                if (isTouching(Target.class)) {
                    Target target=(Target)getOneIntersectingObject(Target.class);
                    target.health -= ((Weapon)equipped).damage;
                    System.out.println(target.getClass());
                    System.out.println(target.health);
                    ((Weapon)equipped).durability -= 1;
                    target.die();
                    if (((Weapon)equipped).durability <= 0) {
                        getWorld().removeObject(equipped);
                        equipped = null;
                    }
                }
            }
        }
    }
    private void demage() {
        if (isTouching(Target.class)) {
            Target target=(Target)getOneIntersectingObject(Target.class);
            if((System.currentTimeMillis() % 5) == 0) {
                health -= target.damage;
            }
            updateHealth();
        }
    }
    private void updateHealth() {
            getWorld().removeObjects(getWorld().getObjects(Bar.class));
            Bar bar = new Bar("Player", "health Points", health, 100);
            Bar nutritionbar = new Bar("Player", "nutrition Points", nutrition, 100);
            getWorld().addObject(bar, ((MyWorld)getWorld()).worldwidth/8, ((MyWorld)getWorld()).worldheight/20);
            getWorld().addObject(nutritionbar, ((MyWorld)getWorld()).worldwidth/8 *5, ((MyWorld)getWorld()).worldheight/20);
    }

    public void moveNext() {
        if (newspawn){
            if (humanX <= 1 || humanX >= ((MyWorld)getWorld()).worldwidth -1 || humanY <= 1 || humanY >= ((MyWorld)getWorld()).worldheight -1) {
                getWorld().removeObjects(getWorld().getObjects(Food.class));
                getWorld().removeObjects(getWorld().getObjects(Target.class));
                getWorld().removeObjects(getWorld().getObjects(Flora.class));
                for ( Weapon weapon : getWorld().getObjects(Weapon.class)) {
                    if (weapon != equipped) {
                        getWorld().removeObject(weapon);
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
        randomX = (int)(Math.random()*((MyWorld)getWorld()).worldwidth);
        randomY = (int)(Math.random()*((MyWorld)getWorld()).worldheight);
        randomAnzahl = (int)(Math.random()*10);
        //getWorld().addObject(new Spear(), randomX,randomY);
        ((MyWorld)getWorld()).spawn();
        newspawn =  false;
        
    }
}
