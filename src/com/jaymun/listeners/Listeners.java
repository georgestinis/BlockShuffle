package com.jaymun.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listeners implements Listener{
	Block blockFound;
	@EventHandler
	public void event(PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		final Block block = player.getTargetBlock(null, 100);
		if (blockFound == null) {
			blockFound = block;
		}
		if (!blockFound.equals(block)) {
			List<Material> blocks = new ArrayList<>();
			for (Material m : Material.values()) {
				if (m.isBlock()) {
					blocks.add(m);
				}
			}
			if (blockFound.getType().isBlock() && !blockFound.getType().isAir()) {
				int id = getRandom(0, blocks.size()-1);
				blockFound.setType(blocks.get(id));
			}
			blockFound = block;
		}
		
	}
	
	 public int getRandom(int lowest, int highest) {
        Random random = new Random();
        return random.nextInt((highest - lowest) + 1) + lowest;  //99
	 }
}
