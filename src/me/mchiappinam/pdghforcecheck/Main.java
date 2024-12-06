package me.mchiappinam.pdghforcecheck;

import java.util.Random;

import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Main extends JavaPlugin implements Listener {
	public String nome=null;
	
	public void onEnable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHForceCheck] §2ativando...");
		getServer().getPluginCommand("fc").setExecutor(new Comando(this));
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		nome=formatSenha();
		getServer().getConsoleSender().sendMessage("§3[PDGHForceCheck] §2nick do morcego: "+nome);
		getServer().getConsoleSender().sendMessage("§3[PDGHForceCheck] §2ativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHForceCheck] §2Acesse: http://pdgh.com.br/");
	}

	public void onDisable() {
		getServer().getConsoleSender().sendMessage("§3[PDGHForceCheck] §2desativado - Plugin by: mchiappinam");
		getServer().getConsoleSender().sendMessage("§3[PDGHForceCheck] §2Acesse: http://pdgh.com.br/");
	}

	public void check(Player p) {
        final Bat bat = (Bat)p.getLocation().getWorld().spawnEntity(p.getLocation().subtract(1.0D, 0.0D, 1.0D), EntityType.BAT);
        bat.setCustomName(nome);
        bat.setCustomNameVisible(true);
        bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2147483647, 0));
        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
          public void run() {
            bat.remove();
          }
        }, 120L);
	}
	
	private String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	private String formatSenha() {
		String senha = "";
		int t = 0;
		int senhaSize = 10;
		if(senhaSize<1)
			senhaSize=1;
		else if(senhaSize>10)
			senhaSize=10;
		boolean num = true;
		boolean letra = true;
		Random n = new Random();
		while(t<senhaSize) {
			int sort = 0;
			if(!letra)
				sort=1;
			else if(!num)
				sort=0;
			else
				sort=n.nextInt(2);
			switch(sort) {
				case 0: {senha+=letras[n.nextInt(letras.length)];break;}
				case 1: {senha+=String.valueOf(n.nextInt(10));break;}
			}
			t++;
		}
		return senha;
	}
  
  
  
  
  
  
  
  
  
  
}