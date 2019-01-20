import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Target extends Actor
{
    public int speed = 1;
    public int health = 10;
    public int damage = 0;
    public void act() 
    {
        move();
        die();
    }    
    
    public void move() {
      int x = getX();
      int y = getY();
      int zahl = (int)(Math.random()*4);
      
      switch (zahl) {
          case 0:
            x -= speed;
            break;
          case 1:
            y += speed;
            break;
          case 2:
            x += speed;
            break;
          case 3:
            y -= speed;
            break;
      }
      this.setLocation(x, y);   
    }    
    public void die() {
        if (this.health <= 0) {
            Banana meat = new Banana();
            getWorld().addObject(meat, this.getX(), this.getY());
            getWorld().removeObject(this);
        }
    }   
    public void setDamage() {
        for (Target target : getWorld().getObjects(Target.class)){
            //System.out.println(target.toString());
            //System.out.println(target.toString().indexOf("Hippo"));
            if (target.toString().startsWith("Hippo")) {
                    damage = Hippo.damage;
            }
            /*else if (target.toString().startsWith("Pig")) {
                    damage = 0;
            }*/
            //System.out.println(target);
        }
    }
}
