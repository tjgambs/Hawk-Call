
package usertest;

import javax.swing.JFrame;

public class ClientTest 
{
    public static void main(String[] args)
    {
        Client charlie;
        charlie = new Client("192.168.1.4");
        charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charlie.startRunning();
    }
}
