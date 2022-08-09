package RUOBot;

import RUOBot.listners.EventListner;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class Main{

    private String token = "OTk5NjQ0MzgzNTAwNTY2NTU5.Gqkyqu.ufqilkjRLUWOnktEsTdz9ftdJf38WRUEGpR400";
    private final ShardManager shardManager;

    public ShardManager getShardManager() {
        return shardManager;
    }

    public Main() throws LoginException{
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.competing("우석이 위로"));
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        shardManager = builder.build();

        //  Register Listeners
        shardManager.addEventListener(new EventListner());
    }

    public static void main(String[] args) {
        try{
            Main bot = new Main();
        } catch (LoginException e){
            System.out.println("ERROR : 유효하지 않은 토큰!");
        }
    }
}
