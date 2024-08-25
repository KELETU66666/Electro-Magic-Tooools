package com.keletu.emt.proxy;


import com.keletu.emt.client.EMTKeys;
import com.keletu.emt.init.EMTBlocks;
import com.keletu.emt.init.EMTItems;

public class ClientProxy extends CommonProxy {

    @Override
    public void load() {
        EMTKeys.registerKeys();

    }

    @Override
    public void registerRenders() {
        EMTBlocks.Render();
        EMTItems.Renders();

    }


}
