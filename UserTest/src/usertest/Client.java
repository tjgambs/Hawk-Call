
package usertest;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Client extends Window
{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String message = "";
    private String serverIP;
    private Socket connection;
    
    //constructor
    public Client(String host)
    {
        super();
        serverIP = host;
        userText = new JTextField();
        userText.setEditable(true);
        userText.addActionListener(
            new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    sendMessage(event.getActionCommand());
                    userText.setText("");
                }
            }
        );
        add(userText, BorderLayout.NORTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow), BorderLayout.CENTER);
        setSize(450,680);
        setVisible(true);
    }
    
    @Override
    public void send()
    {
        sendMessage(getText());
        clear();
    }
    //start running
    public void startRunning()
    {
        try
        {
            connectToServer();
            setupStreams();
            whileChatting();
        }
        catch(EOFException eofException)
        {
            print("\n Client terminated connection");
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        finally
        {
            closeCrap();
        }
    }
    
    //connect to server
    private void connectToServer() throws IOException
    {
        print("Attempting connection... \n");
        connection = new Socket(InetAddress.getByName(serverIP), 6789);
        print("Connected to: " + connection.getInetAddress().getHostName());
    }
    
    //setup stream to send messages and receive messages
    private void setupStreams() throws IOException
    {
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        print("\n Dude your strems are now good to go! \n");
    }
    
    //while chatting with server
    private void whileChatting() throws IOException
    {
        //ableToType(true);
        do
        {
            try
            {
                message = (String) input.readObject();
                print("\n" + message);
            }
            catch(ClassNotFoundException classNotFoundException)
            {
                print("\n I dont know that object type");
            }
            
        }
        while(!message.equals("SERVER - END"));
    }
    
    //close the streams and sockets
    private void closeCrap()
    {
        print("\n Closing HawkCall... ");
        //ableToType(false);
        try
        {
            output.close();
            input.close();
            connection.close();
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
    
    //send messages to server
    private void sendMessage(String message)
    {
        try
        {
            output.writeObject("CLIENT - " + message);
            output.flush();
            print("\nCLIENT - " + message);
        }
        catch(IOException ioException)
        {
            chatWindow.append("\n something messed up sending message hoss!");
            
        }
    }
    
    //change/update chatWindow
//    private void showMessage(final String m)
//    {
//        SwingUtilities.invokeLater(
//            new Runnable()
//            {
//                public void run()
//                {
//                    chatWindow.append(m);
//                }
//            }
//        );
//    }
    
    //gives user permission to type crap into the text box
//    private void ableToType(final boolean tof)
//    {
//        SwingUtilities.invokeLater(
//            new Runnable()
//            {
//                public void run()
//                {
//                    chatWindow.setEditable(tof);
//                }
//            }
//        );
//    }
}
