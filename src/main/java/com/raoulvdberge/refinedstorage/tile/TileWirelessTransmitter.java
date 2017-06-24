package com.raoulvdberge.refinedstorage.tile;

import com.raoulvdberge.refinedstorage.apiimpl.network.node.NetworkNodeWirelessTransmitter;
import com.raoulvdberge.refinedstorage.tile.data.ITileDataProducer;
import com.raoulvdberge.refinedstorage.tile.data.TileDataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class TileWirelessTransmitter extends TileNode<NetworkNodeWirelessTransmitter> {
    public static final TileDataParameter<Integer> RANGE = new TileDataParameter<>(DataSerializers.VARINT, 0, new ITileDataProducer<Integer, TileWirelessTransmitter>() {
        @Override
        public Integer getValue(TileWirelessTransmitter tile) {
            return tile.getNode().getRange();
        }
    });

    public TileWirelessTransmitter() {
        dataManager.addWatchedParameter(RANGE);
    }

    @Override
    @Nonnull
    public NetworkNodeWirelessTransmitter createNode(World world, BlockPos pos) {
        return new NetworkNodeWirelessTransmitter(world, pos);
    }

    @Override
    public String getNodeId() {
        return NetworkNodeWirelessTransmitter.ID;
    }
}
