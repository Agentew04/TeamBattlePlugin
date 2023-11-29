package com.rodrigoappelt.teambattleplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class ChestListener implements Listener {

    private final Logger logger = Bukkit.getServer().getLogger();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        if(!e.hasBlock()){
            logger.info("Nao era um bloco");
            return;
        }

        if(Objects.requireNonNull(e.getClickedBlock()).getType() != Material.CHEST){
            logger.info("Nao foi com um bau");
            return;
        }

        if(e.getAction() != Action.RIGHT_CLICK_BLOCK){
            e.setCancelled(true);
            logger.info("Cancelei acao q nao era botao direito");
            return;
        }

        logger.info("Listener OK");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        if(e.getBlock().getType() == Material.CHEST){
            e.setCancelled(true);
            logger.info("Cancelei o block break de bau");
        }
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent e){
        boolean removed = e.blockList().removeIf(x -> x.getType() == Material.CHEST);

        if(removed){
            logger.info("Cancelei a explosao de um bau");
        }else{
            logger.info("Sem bau na explosao");
        }
    }
}
