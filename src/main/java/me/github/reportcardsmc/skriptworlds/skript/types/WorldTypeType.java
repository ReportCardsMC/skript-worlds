package me.github.reportcardsmc.skriptworlds.skript.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.EnumSerializer;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import org.bukkit.WorldType;
import org.jetbrains.annotations.Nullable;

public class WorldTypeType {
    static {
        Classes.registerClass(new ClassInfo<>(WorldType.class, "bukkit world type")
                .user("world[ ]types?")
                .name("world type")
                .description("Represents a world type")
                .parser(new Parser<WorldType>() {

                    private final String[] types = new String[WorldType.values().length];

                    {
                        int i = 0;
                        for (final WorldType worldType : WorldType.values()) {
                            types[i++] = worldType.name();
                        }
                    }

                    @Nullable
                    @Override
                    public WorldType parse(String s, ParseContext context) {
                        for (int i = 0; i < types.length; i++) {
                            if (s.equalsIgnoreCase(types[i])) return WorldType.values()[i];
                        }
                        return null;
                    }

                    @Override
                    public String toString(WorldType o, int flags) {
                        return "WorldType: " + o.toString();
                    }

                    @Override
                    public String toVariableNameString(WorldType o) {
                        return "worldtype-" + o.toString();
                    }

                    @Override
                    public String getVariableNamePattern() {
                        return "worldtype-.+";
                    }
                })
                .serializer(new EnumSerializer<>(WorldType.class)));
    }
}
