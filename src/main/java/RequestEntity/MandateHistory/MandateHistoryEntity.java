
package RequestEntity.MandateHistory;


public class MandateHistoryEntity {

    private String startDate;
    private String endDate;
    private String pageSize;
    private String lastPageNum;
    private String entryType;

    public String getStartDate() {
        return startDate;
    }

    public MandateHistoryEntity setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public MandateHistoryEntity setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getPageSize() {
        return pageSize;
    }

    public MandateHistoryEntity setPageSize(String pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public String getLastPageNum() {
        return lastPageNum;
    }

    public MandateHistoryEntity setLastPageNum(String lastPageNum) {
        this.lastPageNum = lastPageNum;
        return this;
    }

    public String getEntryType() {
        return entryType;
    }

    public MandateHistoryEntity setEntryType(String entryType) {
        this.entryType = entryType;
        return this;
    }
}
