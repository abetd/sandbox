import mcpi.minecraft as minecraft
import mcpi.block as block
import time

mc = minecraft.Minecraft.create()

playerTilePos = mc.player.getTilePos()

blockBelowPlayerType = mc.getBlock(
    playerTilePos.x,
    playerTilePos.y - 1,
    playerTilePos.z)

mc.setBlock(
    playerTilePos.x + 3,
    playerTilePos.y,
    playerTilePos.z + 3,
    blockBelowPlayerType)

