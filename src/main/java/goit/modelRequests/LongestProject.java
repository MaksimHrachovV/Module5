package goit.modelRequests;

public class LongestProject {
    private int name;
    private int duration;

    public LongestProject(int name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "name=" + name +
                ", duration=" + duration +
                '}';
    }
}
