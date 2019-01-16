import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Help_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help_Button extends Button
{
    /**
     * Act - do whatever the Help_Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Image();
        help();
    }    
    private void help() {
        if (Greenfoot.mouseClicked(this)) {
            getWorld().showText("Legende: Bewegung mit Pfeiltasten, Angriff mit Space", 500, 700);
        }
    }
}
