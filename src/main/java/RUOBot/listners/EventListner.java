package RUOBot.listners;

import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class EventListner extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        Message msg = event.getMessage();
        String msge = msg.getContentRaw();

        if(msge.equals("!우석")) {
            event.getChannel().sendMessage("괜찮아?").queue();
        }
    }

    @Override
    public void onMessageReactionAdd(@NotNull MessageReactionAddEvent event) {
        super.onMessageReactionAdd(event);
        User user = event.getUser();
        String emoji = event.getReaction().getReactionEmote().getEmoji();
        String channelMention = event.getChannel().getAsMention();
        String jumplink = event.getJumpUrl();

        String message = user.getAsTag() + " 이/가 " + emoji + " 이모티콘으로 " + channelMention + " 채널에서 우석이를 위로해줬습니다!";
        event.getGuildChannel().sendMessage(message).queue();
        event.getGuildChannel().sendMessage("메시지 확인하기 : " + jumplink).queue();
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);


    }
}
