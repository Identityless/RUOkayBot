package RUOBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static JDA jda;
    public static String keyword = "우석";
    public static void main(String[] args) throws LoginException{
        jda = JDABuilder.createLight("OTk5NjQ0MzgzNTAwNTY2NTU5.GFFfqV.BJywzjs7pl4-dyi7S2cJSZEWfeyffemo2IDHfY", GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.getPresence().setActivity(Activity.listening("우석이 괜찮은지"));

        jda.addEventListener(new Main());

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        Message msg = e.getMessage();
        String content = msg.getContentRaw();
        String prefix = "$";

        if(e.getAuthor().isBot()) return;

        if(content.equals(prefix+keyword)){
            MessageChannel channel = e.getChannel();
            channel.sendMessage("괜찮아?").queue();

            System.out.printf("[%s]%#s: %s%n", e.getChannel(), e.getAuthor(), e.getMessage().getContentDisplay());
        }
    }
}
