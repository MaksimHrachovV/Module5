package goit.modelRequests;

public class MaxProjectCountClient {
    private int workid;
    private int projectid;
    public MaxProjectCountClient(int workid, int projectid) {
        this.workid = workid;
        this.projectid = projectid;
    }

    @Override
    public String toString() {
        return "MaxProjectCountClient{" +
                "workid=" + workid +
                ", projectid=" + projectid +
                '}';
    }
}
