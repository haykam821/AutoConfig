package me.sargunvohra.mcmods.autoconfig1.example;

import me.sargunvohra.mcmods.autoconfig1.ConfigData;
import me.sargunvohra.mcmods.autoconfig1.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1.serializer.PartitioningSerializer;

import java.util.Arrays;
import java.util.List;

@Config(name = "autoconfig_example")
@Config.Gui.Background("minecraft:textures/block/oak_planks.png")
class ExampleConfig extends PartitioningSerializer.GlobalData {

    @ConfigEntry.Category("a")
    @ConfigEntry.Gui.TransitiveObject
    ModuleA moduleA = new ModuleA();

    @ConfigEntry.Category("b")
    @ConfigEntry.Gui.TransitiveObject
    ModuleB moduleB = new ModuleB();

    enum ExampleEnum {
        FOO, BAR, BAZ
    }

    private static class ModuleA implements ConfigData {

        @ConfigEntry.Gui.PrefixText
        private boolean aBoolean = true;

        @ConfigEntry.Gui.Tooltip(count = 2)
        private ExampleEnum anEnum = ExampleEnum.FOO;

        private String aString = "hello";

        @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
        private PairOfIntPairs anObject = new PairOfIntPairs(new PairOfInts(), new PairOfInts(3, 4));
    }

    private static class ModuleB implements ConfigData {

        @ConfigEntry.BoundedDiscrete(min = -1000, max = 2000)
        private int intSlider = 500;

        @ConfigEntry.BoundedDiscrete(min = -1000, max = 2000)
        private Long longSlider = 500L;

        @ConfigEntry.Gui.TransitiveObject
        private PairOfIntPairs anObject = new PairOfIntPairs(new PairOfInts(), new PairOfInts(3, 4));

        @ConfigEntry.Gui.Excluded
        private List<PairOfInts> aList = Arrays.asList(new PairOfInts(), new PairOfInts(3, 4));
    }

    private static class PairOfInts {
        private int foo;
        private int bar;

        PairOfInts() {
            foo = 1;
            bar = 2;
        }

        PairOfInts(int foo, int bar) {
            this.foo = foo;
            this.bar = bar;
        }
    }

    private static class PairOfIntPairs {

        @ConfigEntry.Gui.CollapsibleObject()
        PairOfInts first;

        @ConfigEntry.Gui.CollapsibleObject()
        PairOfInts second;

        PairOfIntPairs(PairOfInts first, PairOfInts second) {
            this.first = first;
            this.second = second;
        }
    }
}