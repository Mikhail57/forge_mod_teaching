package ru.mineclass.circlemod.generator;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import ru.mineclass.circlemod.register.BlocksRegister;

import java.util.Random;

public class BlockWorldGenerator implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        // Только под землей
        if (world.provider.getDimension() == 0) {
            generateOverWorld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
        }
    }

    private void generateOverWorld(Random random, int chunkX, int chunkZ, World world,
                                   IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateBlock(BlocksRegister.block.getDefaultState(), world, random,
                chunkX * 16, chunkZ * 16, 16, 64,
                4 + random.nextInt(4), 4 + random.nextInt(7));
    }

    private void generateBlock(IBlockState ore, World world, Random random,
                               int x, int z, int minY, int maxY, int size, int chances) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            System.out.printf("New block at x:%d y:%d z:%d \n",x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size);
            generator.generate(world, random, pos);
        }
    }
}
