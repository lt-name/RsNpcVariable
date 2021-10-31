package cn.lanink.rsnpcveriable;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.level.Level;
import com.smallaswater.npc.data.RsNpcConfig;
import com.smallaswater.npc.variable.BaseVariableV2;

/**
 * @author LT_Name
 */
public class RsNpcVeriableV2 extends BaseVariableV2 {

    @Override
    public void onUpdate(Player player, RsNpcConfig rsNpcConfig) {
        for (Level level : Server.getInstance().getLevels().values()) {
            this.addVariable("{LevelPlayerCount#" + level.getFolderName() + "}", String.valueOf(level.getPlayers().size()));
        }
    }

}
