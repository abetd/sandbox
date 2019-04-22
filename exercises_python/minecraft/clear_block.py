import mcpi.minecraft as minecraft
import mcpi.block as block

mc = minecraft.Minecraft.create()

playerTilePos = mc.player.getTilePos()

for x in range(-100, 100):
    for y in range(20):
        for z in range(-100, 100):
            mc.setBlock(
                playerTilePos.x + x,
                playerTilePos.y + y,
                playerTilePos.z + z,
                block.AIR)

