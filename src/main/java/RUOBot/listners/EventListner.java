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
        String user = event.getMember().getUser().getAsTag();
        String[] msges = new String[3];
        msges[1] = "1";
        msges = event.getMessage().getContentRaw().split(" ");


        if(msges[0].equals("!우석")) {
            try{
                int rept = Integer.parseInt(msges[1]);

                if(rept > 10){
                    event.getChannel().sendMessage("야 " + user +". 너 왜 테러하려그래? 응? 너 미친넘이야? 적당히 해.\n10회 이하로 입력하란 말이야 미친넘아.").queue();
                }
                else {
                    for (int i = 0; i < rept; i++) {
                        event.getChannel().sendMessage("괜찮아?").queue();
                    }
                }
            }catch (Exception e){
                event.getChannel().sendMessage("잘못된 값 입력!").queue();
            }
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

        String avatar = event.getUser().getEffectiveAvatarUrl();
        System.out.println(avatar);

    }
}
