/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usertest;

/**
 *
 * @author RD
 */
public class UserTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Window w = new Window();
        w.setVisible(true);
        
        User bob = new User("b", "bob", "bob1");
        
        bob.send("phil", w);
        
        for(Message m : bob.sent())
        {
            System.out.println(m.contents());
        }
    }
    
}
