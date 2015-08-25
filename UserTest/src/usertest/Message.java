/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package usertest;

import java.util.Date;

/**
 *
 * @author RD
 */
public class Message
{
    private String contents = "";
    private Date date = new Date();
    
    public Message(String m)
    {
        contents = m;
        date = new Date();
    }
    
    public Date date()
    {
        return date;
    }
    
    public String contents()
    {
        return contents;
    }
}
