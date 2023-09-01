package GameStates;

import Entities.Player;
import Main.Game;
import levels.LevelManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static Main.Game.*;

public class Menu extends State implements StateMethods{
    private Player player;
    private LevelManager levelManager;

    public Menu(Game game) {
        super(game);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
          g.setColor(Color.RED);
          g.drawString("MENU",GAME_WIDTH/2,200);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
             GameState.state = GameState.PLAYING;
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
