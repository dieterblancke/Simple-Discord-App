package com.dbsoftwares.tutorials.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter
{

    @Override
    public void onMessageReceived( @NotNull final MessageReceivedEvent event )
    {
        // If the sender is a bot, we should ignore it (avoid infinite "hello" loop)
        if ( event.getAuthor().isBot() ) return;

        // Adding the ':white_check_mark:' emote to the message and queueing the change.
        // You can search your emote here: https://emojipedia.org/discord/ (scroll down to "Codepoints" for the code needed)
        event.getMessage().addReaction( "U+2705" ).queue();

        final String message = event.getMessage().getContentRaw().toLowerCase();

        if ( message.contains( "hello" ) || message.contains( "hi" ) )
        {
            event.getTextChannel().sendMessage( "Hello " + event.getAuthor().getName() + "! How are you today?" ).queue();
        }
        else if ( ( message.contains( "i'm" ) || message.contains( "i am" ) ) && message.contains( "you" ) )
        {
            event.getTextChannel().sendMessage( "I'm doing great today :)" ).queue();
        }
    }
}
