/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usertest;

import java.util.*;

/**
 *
 * @author RD
 */
public class User
{
    private String email = "";
    private String name = "";
    private String pass = "";
    
    private Boolean banned = false;
    
    private ArrayList<Message> sent = new ArrayList<Message>();
    
    public User(String e, String n, String p)
    {
        email = e;
        name = n;
        pass = p;
    }
    
    public void send(String s, Window w)
    {
        if(!banned)
        {
            sent.add(new Message(s));
            w.print(name + ": " + s);
        }
    }
    
    public void changePass(String p)
    {
        pass = p;
    }
    
    public void setBanned(boolean b)
    {
        banned = b;
    }
    
    public boolean isBanned()
    {
        return banned;
    }
    
    public ArrayList<Message> sent()
    {
        return sent;
    }
    
    public ArrayList<Message> sent(Date d)
    {
        ArrayList<Message> out = new ArrayList<Message>();
        
        for (Message m : sent)
        {
            if (m.date().after(d))
            {
                out.add(m);
            }
        }
        return out;
    }
}
