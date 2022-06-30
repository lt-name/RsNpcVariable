package cn.lanink.rsnpcvariable;

import cn.nukkit.Player;
import com.smallaswater.npc.variable.BaseVariable;
import tip.utils.Api;

/**
 * @author LT_Name
 */
public class RsNpcVariable extends BaseVariable {

    @Override
    public String stringReplace(Player player, String inString) {
        if (player.isOnline()) {
            return Api.strReplace(inString, player);
        }
        return inString;
    }

}
