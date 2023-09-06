package shop.taeheoki.inflearnthejavatest;

public class Study {

    private StudyStatus status = StudyStatus.DRAFT;
//    private StudyStatus status;

    private int limit;

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야 한다.");
        }
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
