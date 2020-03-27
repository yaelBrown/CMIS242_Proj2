import java.awt.*;

public class Project2 extends GUI {
    Project2() {
        super();
    }

    public void paint(Graphics g){
        g.drawString("HelloWorld!", 100, 100);
    }

    public static void main(String[] args) {
        System.out.println("This is working");

        Project2 p2 = new Project2();
        p2.display();

    }
    
}