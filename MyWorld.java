import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Bar bar = new Bar("Player 1", "health Points", 25, 100);

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1);
        addObject(bar, 125, 40);
        spawn();
    }

    public void pflanzeGras()
    {
        for(int i=0; i<1000; i++) {
            for(int k=0; k<800; k++) {
                Gras gras = new Gras();
                addObject(gras, i, k);
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

        addObject(new Mensch(),randomX,randomY);
        addObject(new Spear(), randomX,100);
        for (int i = 0; i < randomAnzahl; i++ ) {
            randomX = (int)(Math.random()*1000);
            randomY = (int)(Math.random()*800);
            addObject(new Pizza(),randomX,randomY);
        }
        randomAnzahl = (int)(Math.random()*10);
        for (int i = 0; i < randomAnzahl; i++ ) {
            randomX = (int)(Math.random()*1000);
            randomY = (int)(Math.random()*800);
            addObject(new Cupcake(),randomX,randomY);
        }
        randomAnzahl = (int)(Math.random()*10);
        for (int i = 0; i < randomAnzahl; i++ ) {
            randomX = (int)(Math.random()*1000);
            randomY = (int)(Math.random()*800);
            addObject(new Hippo(),randomX,randomY);
        }
        randomAnzahl = (int)(Math.random()*10);
        for (int i = 0; i < randomAnzahl; i++ ) {
            randomX = (int)(Math.random()*1000);
            randomY = (int)(Math.random()*800);
            addObject(new Pig(),randomX,randomY);
        }

        //if (human.died == 1) {
        //    addObject(new Died(),500,400);
        //}
    }
    
    // public void healthbar()
    // {
        // if (bar.getValue() == bar.getMinimumValue())
        // {
            // if (getObjects(GameOver.class).isEmpty()) showGameOver();
            // return;
        // }
    // }
    
    // private void showGameOver()
    // {
        // addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
    // }
}
