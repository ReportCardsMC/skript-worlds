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

public class CloneWorldEff extends Effect {

    static {
        Skript.registerEffect(CloneWorldEff.class, "[multiverse] clone [the] world %world% with [the] name %string%", "[multiverse] [world] %world% cloned to [the] [name] %string%");
    }

    Expression<World> worldExpression;
    Expression<String> nameExpression;

    @Override
    protected void execute(Event e) {
        if (worldExpression == null || nameExpression == null) return;
        World world = worldExpression.getSingle(e);
        SkriptWorlds.info.lastCloneSuccess = SkriptWorlds.mvCore.getMVWorldManager().cloneWorld(world.getName(), nameExpression.getSingle(e));
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "Clone world with world: " + worldExpression.toString(e, debug) + " cloned to name: " + nameExpression.toString(e, debug);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        worldExpression = (Expression<World>) exprs[0];
        nameExpression = (Expression<String>) exprs[1];
        return true;
    }

}
