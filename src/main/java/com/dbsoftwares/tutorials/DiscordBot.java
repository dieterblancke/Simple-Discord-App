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
            jda = JDABuilder.createDefault( "NzEyOTk2ODcxNjU1Nzg0NTE5.XsZsOg.yjgMzhpve-Mz4lGuVLsVdQ0vRkc" ).build();
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
