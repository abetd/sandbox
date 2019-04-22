import mcpi.minecraft as minecraft
import mcpi.block as block
import numpy as np


def build_block(colorArray):
    mc = minecraft.Minecraft.create()
    basePos = mc.player.getTilePos()

    basePos.x = basePos.x + colorArray.shape[0] + 2
    basePos.z = basePos.z - (colorArray.shape[1] / 2)

    for row in range(colorArray.shape[0]):
        for column in range(colorArray.shape[1]):

            colorNumber = colorArray[colorArray.shape[0] - row - 1][column]
            if colorNumber == None:
                continue

            mc.setBlock(
                basePos.x,
                basePos.y + row,
                basePos.z + column,
                block.WOOL.id,
                colorNumber)

# -----------------------------------------------------
# マリオ
# -----------------------------------------------------
RED = 0x0E
BRWN = 0x0C
YELL = 0x04
mario = np.array([
    [None,None,None,RED, RED, RED, RED, RED, None,None,None,None],
    [None,None,RED, RED, RED, RED, RED, RED, RED, RED, RED, None],
    [None,None,BRWN,BRWN,BRWN,YELL,YELL,BRWN,YELL,None,None,None],
    [None,BRWN,YELL,BRWN,YELL,YELL,YELL,BRWN,YELL,YELL,YELL,None],
    [None,BRWN,YELL,BRWN,BRWN,YELL,YELL,YELL,BRWN,YELL,YELL,YELL],
    [None,BRWN,BRWN,YELL,YELL,YELL,YELL,BRWN,BRWN,BRWN,BRWN,None],
    [None,None,None,YELL,YELL,YELL,YELL,YELL,YELL,YELL,None,None],
    [None,None,BRWN,BRWN,RED, BRWN,BRWN,BRWN,None,None,None,None],
    [None,BRWN,BRWN,BRWN,RED, BRWN,BRWN,RED, BRWN,BRWN,BRWN,None],
    [BRWN,BRWN,BRWN,BRWN,RED, RED, RED, RED, BRWN,BRWN,BRWN,BRWN],
    [YELL,YELL,BRWN,RED, YELL,RED, RED, YELL,RED, BRWN,YELL,YELL],
    [YELL,YELL,YELL,RED, RED, RED, RED, RED, RED, YELL,YELL,YELL],
    [YELL,YELL,RED, RED, RED, RED, RED, RED, RED, RED, YELL,YELL],
    [None,None,RED, RED, RED, None,None,RED, RED, RED, None,None],
    [None,BRWN,BRWN,BRWN,None,None,None,None,BRWN,BRWN,BRWN,None],
    [BRWN,BRWN,BRWN,BRWN,None,None,None,None,BRWN,BRWN,BRWN,BRWN]
])

build_block(mario)

