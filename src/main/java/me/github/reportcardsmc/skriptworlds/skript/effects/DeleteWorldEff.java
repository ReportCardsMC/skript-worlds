package me.github.reportcardsmc.skriptworlds.skript.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.github.reportcardsmc.skriptworlds.SkriptWorlds;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class DeleteWorldEff extends Effect {

    static {
        Skript.registerEffect(DeleteWorldEff.class, "[multiverse] delete [the] world %world%");
    }

    Expression<World> worldExpression;

    @Override
    protected void execute(Event e) {
        if (worldExpression == null) return;
        World world = worldExpression.getSingle(e);
        if (world == null) {
            SkriptWorlds.info.lastDeleteSuccess = false;
            return;
        }
        SkriptWorlds.info.lastDeleteSuccess = SkriptWorlds.mvCore.getMVWorldManager().deleteWorld(world.getName(), true, true);
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "Deleting world: " + worldExpression.toString(e, debug);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        worldExpression = (Expression<World>) exprs[0];
        return true;
    }
}
