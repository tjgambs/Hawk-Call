
package networking;

import javax.swing.JFrame;

public class ClientTest 
{
    public static void main(String[] args)
    {
        Client charlie;
        charlie = new Client("172.27.88.187");
        charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        charlie.startRunning();
    }
}
