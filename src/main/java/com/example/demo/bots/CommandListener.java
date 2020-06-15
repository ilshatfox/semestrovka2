package com.example.demo.bots;

import com.example.demo.service.Status;
import com.example.demo.service.WordsService;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiManager;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CommandListener extends ListenerAdapter {
    public static String my_bot_name = "ilshat_bot";
    public static Collection<Emoji> emojis = EmojiManager.getAll();
    public static Integer random_emodj_num = 3;
    public static String start_word = "!game";

    public WordsService wordsService;
    public TestComp testComp;

    public static List<MessageChannel> messageChannels = new ArrayList<>();

    public void onMessageReceived(MessageReceivedEvent event) {
        if (!event.getAuthor().getName().equals(my_bot_name) && event.getMessage().getContent().startsWith(start_word)) {
            if (!messageChannels.contains(event.getChannel())) {
                messageChannels.add(event.getChannel());
            }
            List<Member> members = event.getGuild().getMembers();
            String msg = event.getMessage().getContent().substring(start_word.length() + 1);
            Status status = wordsService.addWord(msg);
            event.getChannel().sendMessage(status.getMessage()).queue();
            if (status.status) {
                System.out.println("wrth7466566");
                try {
                    testComp.chatServer.notifyAll(status.getAllMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void notifyAll(String mess) {
        for (int i = 0; i < messageChannels.size(); i++) {
            messageChannels.get(i).sendMessage(mess).queue();
        }
    }

}
