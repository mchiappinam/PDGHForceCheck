package me.mchiappinam.pdghforcecheck;

import org.bukkit.entity.Bat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Listeners implements Listener {
	
	private Main plugin;
	public Listeners(Main main) {
		plugin=main;
	}

	@EventHandler
	public void onBat(EntityDamageByEntityEvent e) {
		if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Bat))) {
			Player p = (Player)e.getDamager();
			Bat bat = (Bat)e.getEntity();
			if (bat.getCustomName().equals(plugin.nome)) {
				for (Player staff : plugin.getServer().getOnlinePlayers()) {
					if (staff.hasPermission("pdgh.admin")) {
						staff.sendMessage("§eJogador §c"+p.getName()+" §ehitou!");
					}
				}
			}
		}
	}
	
}