package DesignPatterns.creational.prototype;

public class HumanWorker implements Worker {
    private String name;
    private String skill;
    private int experienceYears;

    public HumanWorker(String name, String skill, int experienceYears) {
        this.name = name;
        this.skill = skill;
        this.experienceYears = experienceYears;
    }

    public HumanWorker(HumanWorker other) {
        this.name = other.name;
        this.skill = other.skill;
        this.experienceYears = other.experienceYears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public HumanWorker cloneWorker() {
        return new HumanWorker(this);
    }

    @Override
    public void work() {
        System.out.println(name + " is working on " + skill + ".");
    }

    @Override
    public String toString() {
        return "HumanWorker{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
