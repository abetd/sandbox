import mcpi.minecraft as minecraft
import time

mc = minecraft.Minecraft.create()

playerPos = mc.player.getPos()
mc.postToChat(playerPos.x)

mc.player.setPos(-133, 71, 344)
time.sleep(5)

mc.player.setPos(playerPos.x, playerPos.y, playerPos.z)
