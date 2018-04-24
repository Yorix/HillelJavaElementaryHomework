package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task22.computer;

public class Computer {
    private Component os;
    private Component cpu;
    private Component ram;

    public Computer(String os, String cpu, String ram) {
        this.os = new Component(ComponentType.OS, os);
        this.cpu = new Component(ComponentType.CPU, cpu);
        this.ram = new Component(ComponentType.RAM, ram);
    }

    @Override
    public String toString() {
        return "Computer{" + os + ", " + cpu + ", " + ram + "}";
    }

    private static class Component {
        private ComponentType componentType;
        private String property;

        public Component(ComponentType component, String property) {
            this.componentType = component;
            this.property = property;
        }

        @Override
        public String toString() {
            return componentType + ": " + property;
        }
    }

    enum ComponentType {
        OS, CPU, RAM
    }
}
