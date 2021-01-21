package rip.koru.roads.generation;

/**
 * Developed by FxMxGRAGFX
 * Project: KoruRoads
 **/

public class WestG {

    /*
    public WestG(Player player, String[] blocks) {

    }

    @Override
    public void run() {

        new WestGenerator(2).runTaskTimer(KoruRoads.getInstance(),0L, 2L);
        Bukkit.broadcastMessage(CC.GREEN + "Starting the road WEST generation!");

        int width = playerCache.get("width");
        int height = (int) (player.getLocation().getY() + playerCache.get("height"));

        double value = 0;
        //Aumento de X
        for (int x = -1; x > -distance; x--) {
            //Aumento de Z
            for (int z = 0; z < width; z++) {
                //Adaptacion de la road
                HashMap<Integer, Material> mats = new HashMap<Integer, Material>();
                for (String s : blocks) {
                    Material type = Material.getMaterial(Integer.parseInt(s));
                    mats.put(mats.size() + 1, type);
                }

                Location blockTop = StructureUtils.topBlock(player, x, z);
                Material selected = mats.get(Utils.getRandomNumber(1, mats.size() + 1));

                Location bb = StructureUtils.topBlock(player, x, z);
                if (bb.getY() > height) {
                    bb.setY(height);
                    bb.getBlock().setType(selected);
                    bb.setY(bb.getY() + 1);
                    while (bb.getBlock().getType() != Material.AIR) {
                        bb.getBlock().setType(Material.AIR);
                        bb.setY(bb.getY() + 1);
                    }
                }
                blockTop.setY(blockTop.getY() + 2);
                blockTop.setX(blockTop.getX() - 2);
                if (blockTop.getBlock().getType() != Material.AIR) {
                    blockTop.setX(blockTop.getX() + 2);
                    blockTop.setX(blockTop.getX() - 1);
                    StructureUtils.breackUp(blockTop);
                    blockTop.setX(blockTop.getX() - 1);
                    StructureUtils.breackUp(blockTop);
                }


                Location slabs = StructureUtils.topBlock(player, x, z);
                slabs.setY(slabs.getY() + 1);
                slabs.setX(slabs.getX() - 1);
                if(slabs.getBlock().getType() != Material.AIR) {
                    slabs.setX(slabs.getX() + 2);
                    if(slabs.getBlock().getType() == Material.AIR) {
                        slabs.setX(slabs.getX() - 1);
                        slabs.getBlock().setType(Material.STEP);
                        slabs.getBlock().setData((byte) 0);
                    }
                }


                Location down = StructureUtils.topBlock(player, x, z);
                if(down.getBlock().getType() == Material.STEP) {
                    down.setY(down.getY() - 1);
                    down.setX(down.getX() - 1);
                }
                down.setX(down.getX() - 1);
                if(down.getBlock().getType() == Material.AIR) {
                    down.getBlock().setType(Material.STEP);
                    down.getBlock().setData((byte) 0);
                    down.setY(down.getY() - 1);
                    down.getBlock().setType(selected);
                    down.setX(down.getX() - 1);
                    down.getBlock().setType(selected);
                }
                Location top = StructureUtils.topBlock(player, x, z);
                if(top.getBlock().getType() != Material.STEP) {
                    top.getBlock().setType(selected);
                } else {
                    top.setX(top.getY() - 1);
                    top.getBlock().setType(selected);
                }
                Location lF = StructureUtils.topBlock(player, x, z);
                if(lF.getY() > height) {
                    lF.setY(height);
                    lF.setX(lF.getX() + 1);
                    if(lF.getBlock().getType() == Material.AIR) {
                        lF.getBlock().setType(selected);
                    }
                    lF.setX(lF.getX() -1);
                    while (lF.getBlock().getType() != Material.AIR) {
                        if(mats.containsValue(lF.getBlock().getType())) {
                            lF.setY(lF.getY() + 1);
                        }
                        lF.getBlock().setType(Material.AIR);
                        lF.setY(lF.getY() + 1);
                    }
                }
            }
            //Reduccion de Z
            for (int z = -0; z > -width; z--) {
                //Adaptacion de la road
                HashMap<Integer, Material> mats = new HashMap<Integer, Material>();
                for (String s : blocks) {
                    Material type = Material.getMaterial(Integer.parseInt(s));
                    mats.put(mats.size() + 1, type);
                }

                Location blockTop = StructureUtils.topBlock(player, x, z);
                Material selected = mats.get(Utils.getRandomNumber(1, mats.size() + 1));

                Location bb = StructureUtils.topBlock(player, x, z);
                if (bb.getY() > height) {
                    bb.setY(height);
                    bb.getBlock().setType(selected);
                    bb.setY(bb.getY() + 1);
                    while (bb.getBlock().getType() != Material.AIR) {
                        bb.getBlock().setType(Material.AIR);
                        bb.setY(bb.getY() + 1);
                    }
                }
                blockTop.setY(blockTop.getY() + 2);
                blockTop.setX(blockTop.getX() - 2);
                if (blockTop.getBlock().getType() != Material.AIR) {
                    blockTop.setX(blockTop.getX() + 2);
                    blockTop.setX(blockTop.getX() - 1);
                    StructureUtils.breackUp(blockTop);
                    blockTop.setX(blockTop.getX() - 1);
                    StructureUtils.breackUp(blockTop);
                }


                Location slabs = StructureUtils.topBlock(player, x, z);
                slabs.setY(slabs.getY() + 1);
                slabs.setX(slabs.getX() - 1);
                if(slabs.getBlock().getType() != Material.AIR) {
                    slabs.setX(slabs.getX() + 2);
                    if(slabs.getBlock().getType() == Material.AIR) {
                        slabs.setX(slabs.getX() - 1);
                        slabs.getBlock().setType(Material.STEP);
                        slabs.getBlock().setData((byte) 0);
                    }
                }


                Location down = StructureUtils.topBlock(player, x, z);
                if(down.getBlock().getType() == Material.STEP) {
                    down.setY(down.getY() - 1);
                    down.setX(down.getX() - 1);
                }
                down.setX(down.getX() - 1);
                if(down.getBlock().getType() == Material.AIR) {
                    down.getBlock().setType(Material.STEP);
                    down.getBlock().setData((byte) 0);
                    down.setY(down.getY() - 1);
                    down.getBlock().setType(selected);
                    down.setX(down.getX() - 1);
                    down.getBlock().setType(selected);
                }
                Location top = StructureUtils.topBlock(player, x, z);
                if(top.getBlock().getType() != Material.STEP) {
                    top.getBlock().setType(selected);
                } else {
                    top.setX(top.getY() - 1);
                    top.getBlock().setType(selected);
                }
                Location lF = StructureUtils.topBlock(player, x, z);
                if(lF.getY() > height) {
                    lF.setY(height);
                    lF.setX(lF.getX() + 1);
                    if(lF.getBlock().getType() == Material.AIR) {
                        lF.getBlock().setType(selected);
                    }
                    lF.setX(lF.getX() -1);
                    while (lF.getBlock().getType() != Material.AIR) {
                        if(mats.containsValue(lF.getBlock().getType())) {
                            lF.setY(lF.getY() + 1);
                        }
                        lF.getBlock().setType(Material.AIR);
                        lF.setY(lF.getY() + 1);
                    }
                }
            }
            value = Math.abs(((double)x * 100.00D / 250.00D));
            String v = new DecimalFormat("##.##").format((value));
            //new ScoreboardCleanTask(player, "C", "C", "C", v).run();
            Bukkit.broadcastMessage(CC.GREEN + "Generating the road WEST (" + v + "%)");
        }
        if(value != 100.00D) {
            //new ScoreboardCleanTask(player, "C", "C", "C", "C").run();
            Bukkit.broadcastMessage(CC.GREEN + "Generating the road WEST (100%)");
        }
        Bukkit.broadcastMessage(CC.GREEN + "The WEST road has been successfully cleared in " + (double) TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - initTime) + " secconds!");
    }

    private static void buildPilar(Location l) {
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setY(l.getY() + 1);
        l.getBlock().setType(Material.COBBLESTONE);
        l.setX(l.getX() - 1);
        l.getBlock().setType(Material.COBBLESTONE_STAIRS);
        Block b1 = l.getBlock();
        BlockState state1 = b1.getState();
        Stairs stairs1 = (Stairs) state1.getData();
        stairs1.setFacingDirection(BlockFace.EAST);
        stairs1.setInverted(true);
        state1.update(false, false);

        l.setX(l.getX() + 2);
        l.getBlock().setType(Material.COBBLESTONE_STAIRS);
        Block b2 = l.getBlock();
        BlockState state2 = b2.getState();
        Stairs stairs2 = (Stairs) state2.getData();
        stairs2.setFacingDirection(BlockFace.WEST);
        stairs2.setInverted(true);
        state2.update(false, false);
    }

    private class WestGenerator extends BukkitRunnable {

        private int x;

        public WestGenerator(int x) {
            this.x = x;
        }

        @Override
        public void run() {
            for(int z = 0; z < width; z++) {
                Location top = StructureUtils.topBlock(player, x, z);
                top.getBlock().setType(Material.AIR);
            }
            for(int z = -0; z > -width; z--) {
                Location top = StructureUtils.topBlock(player, x, z);
                top.getBlock().setType(Material.AIR);
            }
            Bukkit.broadcastMessage(String.valueOf(x));
            x = x -1;
            Bukkit.broadcastMessage(String.valueOf(x));

            if(x < -distance) {
                cancel();
            }
        }
    }

     */
}
