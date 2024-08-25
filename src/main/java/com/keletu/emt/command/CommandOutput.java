package com.keletu.emt.command;

import com.keletu.emt.util.EMTEssentiasOutputs;
import com.keletu.emt.util.EMTTextHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.server.MinecraftServer;
import thaumcraft.api.aspects.Aspect;

import java.util.Collection;
import java.util.Objects;

public class CommandOutput extends CommandBase {
    public String text;
    @Override
    public String getName() {
        return "emt_output";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/emt_outputs";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        text = EMTTextHelper.localize("gui.EMT.book.aspect.ouput.essentia.eu");
        Collection<Aspect> aspectCollection = Aspect.aspects.values();
        for(Aspect aspect:aspectCollection){
            String text2 = addString(text,(aspect.getTag()+":"+String.valueOf(EMTEssentiasOutputs.outputs.get(aspect.getTag()))+"\n"));
            text=text2;
        }
        addOutputsBook(EMTTextHelper.localize("gui.EMT.book.aspect.output.eu.title"),text,sender,args);

    }
    public String addString(String t_1,String t_2){
        String result = t_1+t_2;
        return result;
    }
    public void addOutputsBook(String title, String text, ICommandSender command, String[] astring) {
        ItemStack book = new ItemStack(Items.WRITTEN_BOOK);
        book.setTagInfo("author", new NBTTagString("Rumaruka"));
        book.setTagInfo("title", new NBTTagString(title));
        NBTTagCompound nbttagcompound = book.getTagCompound();
        NBTTagList bookPages = new NBTTagList();

        bookPages.appendTag(new NBTTagString(text.substring(0, 237)));
        bookPages.appendTag(new NBTTagString(text.substring(237, 476)));
        bookPages.appendTag(new NBTTagString(text.substring(476, 709)));
        bookPages.appendTag(new NBTTagString(text.substring(709)));

        assert nbttagcompound != null;
        nbttagcompound.setTag("pages", bookPages);

        System.out.println(text.length());

        if (!Objects.requireNonNull(command.getEntityWorld().getPlayerEntityByName(command.getName())).inventory.addItemStackToInventory(book))
            Objects.requireNonNull(command.getEntityWorld().getPlayerEntityByName(command.getName())).entityDropItem(book,0);
    }
}
