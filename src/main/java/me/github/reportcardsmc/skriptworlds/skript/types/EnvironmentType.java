package me.github.reportcardsmc.skriptworlds.skript.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.EnumSerializer;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import org.bukkit.World;
import org.jetbrains.annotations.Nullable;

public class EnvironmentType {
    static {
        Classes.registerClass(new ClassInfo<>(World.Environment.class, "environment")
                .user("environments?")
                .name("world environment")
                .description("Represents a world environment")
                .parser(new Parser<World.Environment>() {

                    private final String[] environments = new String[World.Environment.values().length];

                    {
                        int i = 0;
                        for (final World.Environment environment : World.Environment.values()) {
                            environments[i++] = environment.name();
                        }
                    }

                    @Nullable
                    @Override
                    public World.Environment parse(String s, ParseContext context) {
                        for (int i = 0; i < environments.length; i++) {
                            if (s.equalsIgnoreCase(environments[i])) return World.Environment.values()[i];
                        }
                        return null;
                    }

                    @Override
                    public String toString(World.Environment o, int flags) {
                        return "EnvironmentType: " + o.toString();
                    }

                    @Override
                    public String toVariableNameString(World.Environment o) {
                        return "environment-" + o.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "environment-.+";
                    }
                })
                .serializer(new EnumSerializer<>(World.Environment.class)));
    }
}
