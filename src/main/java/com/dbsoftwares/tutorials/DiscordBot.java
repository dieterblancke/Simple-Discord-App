package com.dbsoftwares.tutorials;

import com.dbsoftwares.tutorials.listeners.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordBot
{

    private JDA jda;

    private DiscordBot()
    {
        try
        {
            jda = JDABuilder.createDefault( "YOUR_TOKEN_HERE" ).build();
            jda.addEventListener( new MessageListener() );
        }
        catch ( LoginException e )
        {
            throw new RuntimeException( "Could not start the bot ...", e );
        }
    }

    public static void main( String[] args )
    {
        new DiscordBot();
    }
}
