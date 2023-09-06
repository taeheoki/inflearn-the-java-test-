package shop.taeheoki.inflearnthejavatest;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;
//    private StudyStatus status;

    private int limit;

    public Study(int limit) {
        this.limit = limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

//    public Study() {
//        this.status = StudyStatus.DRAFT;
//    }


    public int getLimit() {
        return limit;
    }
}
