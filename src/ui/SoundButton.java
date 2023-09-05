package ui;

import util.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static util.LoadSave.*;
import static util.Constants.UI.PauseButton.*;

public class SoundButton extends PauseButtons{
    private BufferedImage[][] soundImages;
    private boolean mouseOver,mousePressed,muted;
    private int rowIndex,colIndex;


    public SoundButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        loadSoundImages();
    }

    private void loadSoundImages() {
        BufferedImage soundAtlas = LoadSave.getAtlas(SOUND_BUTTONS);
        soundImages = new BufferedImage[2][3];
        for(int i = 0;i<soundImages.length;i++){
            for (int j = 0; j<soundImages[i].length;j++){
                soundImages[i][j] = soundAtlas.getSubimage(j*SOUND_SIZE_DEFAULT,i*SOUND_SIZE_DEFAULT,SOUND_SIZE_DEFAULT,SOUND_SIZE_DEFAULT);
            }
        }
    }
    public void update(){
         if(muted)
             rowIndex = 1;
         else
             rowIndex = 0;

         if(mouseOver)
             colIndex = 1;
         if(mousePressed)
             colIndex = 2;


    }
    public void draw(Graphics g){
       g.drawImage(soundImages[0][0],x,y,width,height,null);
    }
    public boolean isMouseOver() {
        return mouseOver;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

}
