package uzayoyunu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator; 
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class Ateş {
    private int x;
    private int y;

    public Ateş(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Oyun extends JPanel implements KeyListener, ActionListener {

    Timer timer = new Timer(5, this);
    private int gecen_sure = 0;
    private int harcanan_ates = 0;
    private BufferedImage image;

    private ArrayList<Ateş> ateşler = new ArrayList<>();

    private int atesdirY = 3; 
    private int topX = 0;
    private int topdirX = 2;
    private int uzayGemisiX = 0;
    private int dirUzayX = 20;

    public boolean kontrolEt() {
        for (Ateş ateş : ateşler) {
            if (new Rectangle(ateş.getX(), ateş.getY(), 10, 20).intersects(new Rectangle(topX, 0, 20, 20))) {
                return true;
            }
        }
        return false;
    }
    
    public Oyun() {
    try {
        
        image = ImageIO.read(Oyun.class.getResource("/uzayoyunu/uzaygemisi.png"));
        
        if (image == null) {
            
            System.err.println("Resource olarak uzaygemisi.png bulunamadı!");
        }

    } catch (IOException ex) {
        System.err.println("Resim okunurken bir hata oluştu!");
        Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
    }

    setBackground(Color.BLACK);
    timer.start();
}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 

        g.setColor(Color.red);
        g.fillOval(topX, 0, 20, 20);

        if (image != null) {
            g.drawImage(image, uzayGemisiX, 490, image.getWidth() / 10, image.getHeight() / 10, this);
        } else {
            g.setColor(Color.GREEN);
            g.fillRect(uzayGemisiX, 490, 50, 30);
        }
        
        g.setColor(Color.BLUE);
  
        for (Ateş ateş : ateşler) {
            g.fillRect(ateş.getX(), ateş.getY(), 10, 20);
        }

        
        if (kontrolEt()) {
            timer.stop();
            String message = "Kazandınız.\n"
                    + "Harcanan ateş: " + harcanan_ates
                    + "\nGeçen süre: " + gecen_sure / 1000.0 + " saniye";
            JOptionPane.showMessageDialog(this, message);
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();

        if (c == KeyEvent.VK_LEFT) {
            if (uzayGemisiX <= 0) {
                uzayGemisiX = 0;
            } else {
                uzayGemisiX -= dirUzayX;
            }
        } else if (c == KeyEvent.VK_RIGHT) {
            if (uzayGemisiX >= 740) { 
                uzayGemisiX = 740;
            } else {
                uzayGemisiX += dirUzayX;
            }
        } else if (c == KeyEvent.VK_CONTROL || c == KeyEvent.VK_SPACE) { 
            ateşler.add(new Ateş(uzayGemisiX + 20, 470)); 
            harcanan_ates++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gecen_sure += 5;

        Iterator<Ateş> iterator = ateşler.iterator();
        while (iterator.hasNext()) {
            Ateş ateş = iterator.next();
            ateş.setY(ateş.getY() - atesdirY); 

            if (ateş.getY() < 0) {
                iterator.remove(); 
            }
        }

        topX += topdirX;

        if (topX >= 780) { 
            topdirX = -topdirX;
        }
        if (topX <= 0) {
            topdirX = -topdirX;
        }

        repaint(); 
    }
}


