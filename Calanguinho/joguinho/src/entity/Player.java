package entity;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.KeyHandler;
import main.GamePanel;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    
    public Player (GamePanel gp, KeyHandler keyH){
        this.gp= gp;
        this.keyH= keyH;
        setDefautValues();
        setPlayertImage();
        

    }

    public void setDefautValues(){

        x=100;
        y=500;
        speed=2;
        direction="left";
        lastDirectionState="left";
        keyH.idleState=true;
    }

    public void setPlayertImage(){
        
        try { 
            //sprites Left animation

            left[0]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Esquerda/01.png"));
            left[1]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Esquerda/02.png"));
            left[2]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Esquerda/03.png"));
            left[3]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Esquerda/04.png"));
            left[4]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Esquerda/05.png"));
            left[5]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Esquerda/06.png"));
           
            
            //sprites Right animation
            right[0]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Direita/01.png"));
            right[1]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Direita/02.png"));
            right[2]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Direita/03.png"));
            right[3]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Direita/04.png"));
            right[4]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Direita/05.png"));
            right[5]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Andando/Direita/06.png"));

           
            //idle left
            idleLeft[0]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Esquerda/01.png"));
            idleLeft[1]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Esquerda/02.png"));
            idleLeft[2]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Esquerda/03.png"));
            idleLeft[3]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Esquerda/04.png"));
            idleLeft[4]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Esquerda/05.png"));
            idleLeft[5]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Esquerda/06.png"));
           
            //idle right
            idleRight[0]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Direita/01.png"));
            idleRight[1]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Direita/02.png"));
            idleRight[2]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Direita/03.png"));
            idleRight[3]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Direita/04.png"));
            idleRight[4]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Direita/05.png"));
            idleRight[5]=ImageIO.read(getClass().getResourceAsStream("/player/Calanguinho/Respirando/Direita/06.png"));
           




        } catch (IOException e) {

            e.printStackTrace();
            
        

    }
}


    public void animationState(){
        spriteCounter++;
        idlespriteCounter++;


        if(spriteCounter>6){
            
            spriteNum++;
           
            spriteCounter=0;

            if(spriteNum==6)
            spriteNum=0;
        }
    }


    public void update(){

        

        if(keyH.leftPress==true){
            direction="left";
            x-=speed;
        }
        
        
        if(keyH.rightPress==true){
            direction="right";
            x+=speed;
        }
        
            //adds to animation sprite
        animationState();
        
        


    }
    public void draw(Graphics2D g2){

        
        BufferedImage image=null;

        switch(direction){
        case "left":

        if(keyH.idleState==false)
        image=left[spriteNum];

        if(keyH.idleState==true)
        image=idleLeft[spriteNum];

        break;

        case "right":

        if(keyH.idleState==false)
        image=right[spriteNum];

        if(keyH.idleState==true)
        image=idleRight[spriteNum];

        break;
    }

    g2.drawImage(image, x, y,gp.tileSize,gp.tileSize,null);
    

    }
}

