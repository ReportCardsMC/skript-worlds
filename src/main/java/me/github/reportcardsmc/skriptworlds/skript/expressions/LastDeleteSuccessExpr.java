package me.github.reportcardsmc.skriptworlds.skript.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.github.reportcardsmc.skriptworlds.SkriptWorlds;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;

public class LastDeleteSuccessExpr extends SimpleExpression<Boolean> {

    static {
        Skript.registerExpression(LastDeleteSuccessExpr.class, Boolean.class, ExpressionType.SIMPLE, "[multiverse] [last] [world] delete successful");
    }

    @Nullable
    @Override
    protected Boolean[] get(Event e) {
        return new Boolean[]{SkriptWorlds.info.lastDeleteSuccess};
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Boolean> getReturnType() {
        return Boolean.class;
    }

    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "Is last delete a success?";
    }

    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, SkriptParser.ParseResult parseResult) {
        return true;
    }
}
