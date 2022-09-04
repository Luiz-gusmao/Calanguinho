package entity;
import java.awt.image.BufferedImage;
public class Entity {
    public int x,y ;
    public int speed;



    public BufferedImage[]up= new BufferedImage[10] ;
    public BufferedImage[]down=new BufferedImage[10];
    public BufferedImage[]left=new BufferedImage[10];
    public BufferedImage[]right=new BufferedImage[10];
    public BufferedImage[]idleUp= new BufferedImage[10] ;
    public BufferedImage[]idleDown=new BufferedImage[10];
    public BufferedImage[]idleLeft=new BufferedImage[10];
    public BufferedImage[]idleRight=new BufferedImage[10];



   
    public String direction ;
    public String lastDirectionState;

    public int spriteCounter=0;
    public int spriteNum=0;
    public int idlespriteCounter=0;
    public int idleSpriteNum=0;
}
