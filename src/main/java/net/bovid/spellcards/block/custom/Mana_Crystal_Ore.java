package net.bovid.spellcards.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class Mana_Crystal_Ore extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");
    public Mana_Crystal_Ore(Properties properties){
        super(properties);
    }

    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        interact(state, level, pos);
        super.attack(state, level, pos, player);
    }

    public void stepOn(Level p_154299_, BlockPos p_154300_, BlockState p_154301_, Entity p_154302_) {
        if (!p_154302_.isSteppingCarefully()) {
            interact(p_154301_, p_154299_, p_154300_);
        }

        super.stepOn(p_154299_, p_154300_, p_154301_, p_154302_);
    }


    private static void interact(BlockState p_55493_, Level p_55494_, BlockPos p_55495_) {
        spawnParticles(p_55494_, p_55495_);
        if (!p_55493_.getValue(LIT)) {
            p_55494_.setBlock(p_55495_, p_55493_.setValue(LIT, Boolean.valueOf(true)), 3);
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            level.setBlock(pos, state.cycle(LIT), 3);
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    private static void spawnParticles(Level p_55455_, BlockPos p_55456_) {
        double d0 = 0.5625D;
        RandomSource randomsource = p_55455_.random;

        for(Direction direction : Direction.values()) {
            BlockPos blockpos = p_55456_.relative(direction);
            if (!p_55455_.getBlockState(blockpos).isSolidRender(p_55455_, blockpos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getStepX() : (double)randomsource.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getStepY() : (double)randomsource.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getStepZ() : (double)randomsource.nextFloat();
                p_55455_.addParticle(DustParticleOptions.REDSTONE, (double)p_55456_.getX() + d1, (double)p_55456_.getY() + d2, (double)p_55456_.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }

    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
        builder.add(LIT);
    }
}
