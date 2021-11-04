package me.github.reportcardsmc.skriptworlds.skript.effects;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.github.reportcardsmc.skriptworlds.SkriptWorlds;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CreateWorldEff extends Effect {

    static {
        Skript.registerEffect(CreateWorldEff.class, "[multiverse] create world with [the] name %string%[,] environment %environment% [[,] with seed %-string%][,] [and] type %world type%[[,] with generator %-string%]");
    }

    Expression<String> name;
    Expression<World.Environment> environment;
    Expression<String> seed;
    Expression<WorldType> worldType;
    Expression<String> generator;

    @Override
    protected void execute(Event e) {
        String s = seed.getSingle(e) == null ? String.valueOf(new Random().nextInt(6000000)) : seed.getSingle(e);
        String gen = generator.getSingle(e) == null ? "" : generator.getSingle(e);
        SkriptWorlds.info.lastCreateSuccess = SkriptWorlds.mvCore.getMVWorldManager().addWorld(name.getSingle(e), environment.getSingle(e), s, worldType.getSingle(e), false, gen);
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "Creating world with data: " + name.toString(e, debug) + " " + environment.toString(e, debug) + " " + seed.toString(e, debug) + " " + worldType.toString(e, debug) + " " + generator.toString(e, debug);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        name = (Expression<String>) exprs[0];
        environment = (Expression<World.Environment>) exprs[1];
        seed = (Expression<String>) exprs[2];
        worldType = (Expression<WorldType>) exprs[3];
        generator = (Expression<String>) exprs[4];
        return true;
    }
}
