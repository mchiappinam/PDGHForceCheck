package me.mchiappinam.pdghforcecheck;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Comando implements CommandExecutor {
	private Main plugin;

	public Comando(Main main) {
		plugin = main;
	}
	
  	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("fc")) {
			if(!sender.hasPermission("pdgh.admin")) {
				sender.sendMessage("§cSem permissões");
				return true;
			}
			if(args.length>1) {
				sender.sendMessage("§cUse: /fc <nick>");
				return true;
        	}else if(args.length==1) {
				if(plugin.getServer().getPlayer(args[0]) == null) {
					sender.sendMessage("§cO jogador §e"+args[0]+" §cnão está online.");
					return true;
				}
				sender.sendMessage("§aVerificação para "+plugin.getServer().getPlayer(args[0]).getName()+" iniciada.");
				plugin.check(((Player)sender));
				sender.sendMessage("§aVerificação para "+plugin.getServer().getPlayer(args[0]).getName()+" finalizada.");
				return true;
        	}
			if(args.length==0) {
				sender.sendMessage("§cUse: /fc <nick>");
				return true;
			}
        }
		return false;
    }
  	
}