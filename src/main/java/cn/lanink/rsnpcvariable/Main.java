package cn.lanink.rsnpcvariable;

import cn.lanink.rsnpcvariable.task.VariableUpdateTask;
import cn.nukkit.plugin.PluginBase;
import com.smallaswater.npc.variable.VariableManage;

/**
 * @author LT_Name
 */
public class Main extends PluginBase {

    @Override
    public void onLoad() {
        this.saveResource("变量.txt", true);
        VariableManage.addVariableV2("RsNpcVeriableV2", RsNpcVariableV2.class);
    }

    @Override
    public void onEnable() {
        this.getServer().getScheduler().scheduleAsyncTask(this, new VariableUpdateTask());

        if (this.getServer().getPluginManager().getPlugin("Tips") != null) {
            VariableManage.addVariable("RsNpcVeriable", RsNpcVariable.class);
        }
    }
}
