package cn.lanink.rsnpcveriable;

import cn.nukkit.plugin.PluginBase;
import com.smallaswater.npc.variable.VariableManage;

/**
 * @author LT_Name
 */
public class Main extends PluginBase {

    @Override
    public void onLoad() {
        this.saveResource("变量.txt", true);
        VariableManage.addVariableV2("RsNpcVeriableV2", RsNpcVeriableV2.class);
    }

    @Override
    public void onEnable() {
        if (this.getServer().getPluginManager().getPlugin("Tips") != null) {
            VariableManage.addVariable("RsNpcVeriable", RsNpcVeriable.class);
        }
    }
}
