package GameStates;

import Entities.Player;
import Main.Game;
import levels.Level;
import levels.LevelManager;
import ui.MenuButton;
import util.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static Main.Game.*;
import static util.LoadSave.*;

public class Menu extends State implements StateMethods{
   private MenuButton[] buttons = new MenuButton[3];
   private BufferedImage background;
   private int menuX,menuY,menuWidth,menuHeight;



    public Menu(Game game) {
        super(game);
        loadBackground();
        loadButtons();
    }

    private void loadBackground() {
        background = getAtlas(MENU_BACKGROUND);
        menuWidth = (int)(background.getWidth()* SCALE);
        menuHeight = (int)(background.getHeight()*SCALE);
        menuX = GAME_WIDTH/2 - menuWidth/2;
        menuY = (int)(45*SCALE);
    }

    public void loadButtons(){
       buttons[0] = new MenuButton(GAME_WIDTH/2,(int)(150* SCALE),0,GameState.PLAYING);
       buttons[1] = new MenuButton(GAME_WIDTH/2,(int)(220* SCALE),1,GameState.OPTIONS);
       buttons[2] = new MenuButton(GAME_WIDTH/2,(int)(290* SCALE),2,GameState.QUIT);
    }

    @Override
    public void update() {
      for(MenuButton mb:buttons){
          mb.update();
      }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background,menuX,menuY,menuWidth,menuHeight,null);
        for(MenuButton mb:buttons){
            mb.draw(g);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }



    @Override
    public void mousePressed(MouseEvent e) {
        for(MenuButton mb:buttons){
            if (isIn(e,mb)){
                mb.setMousePressed(true);
                break;
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
           for(MenuButton mb:buttons){
               if(isIn(e,mb)){
                   if (mb.isMousePressed()){
                       mb.applyGameState();
                       break;
                   }
               }
           }
           resetButtons();
    }

    private void resetButtons() {
        for(MenuButton mb:buttons){
           mb.resetBooleans();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(MenuButton mb:buttons){
            mb.setMouseOver(false);
        }
        for(MenuButton mb:buttons){
            if(isIn(e,mb)){
                mb.setMouseOver(true);
                break;
            }
        }
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
