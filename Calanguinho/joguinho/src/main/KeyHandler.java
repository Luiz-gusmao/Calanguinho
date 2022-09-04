package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener{

public boolean upPress,downPress,leftPress,rightPress,idleState;

    @Override
    public void keyTyped(KeyEvent e) {
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        int code = e.getKeyCode();

        
         if(code== KeyEvent.VK_A){
            leftPress=true;
            idleState=false;
        }
        if(code== KeyEvent.VK_D){
            rightPress=true;
            idleState=false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        
         if(code== KeyEvent.VK_A){
            leftPress=false;
            idleState=true;
        }
        if(code== KeyEvent.VK_D){
            rightPress=false;
            idleState=true;
        }
        
    }
    
}
