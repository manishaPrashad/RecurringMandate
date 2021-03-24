package RequestEntity;

public class StandingInstruction {
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public String getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(String scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getScheduledEnd() {
        return scheduledEnd;
    }

    public void setScheduledEnd(String scheduledEnd) {
        this.scheduledEnd = scheduledEnd;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }

    public Boolean getRevocable() {
        return revocable;
    }

    public void setRevocable(Boolean revocable) {
        this.revocable = revocable;
    }

    public String getRuleRecurrence() {
        return ruleRecurrence;
    }

    public void setRuleRecurrence(String ruleRecurrence) {
        this.ruleRecurrence = ruleRecurrence;
    }

    public String getRuleRecurrenceValue() {
        return ruleRecurrenceValue;
    }

    public void setRuleRecurrenceValue(String ruleRecurrenceValue) {
        this.ruleRecurrenceValue = ruleRecurrenceValue;
    }

    public String getRuleAmount() {
        return ruleAmount;
    }

    public void setRuleAmount(String ruleAmount) {
        this.ruleAmount = ruleAmount;
    }

    public Boolean getBlockFund() {
        return blockFund;
    }

    public void setBlockFund(Boolean blockFund) {
        this.blockFund = blockFund;
    }

    public Float getRuleAmountValue() {
        return ruleAmountValue;
    }

    public void setRuleAmountValue(Float ruleAmountValue) {
        this.ruleAmountValue = ruleAmountValue;
    }

    public String getUniqueMandateNumber() {
        return uniqueMandateNumber;
    }

    public void setUniqueMandateNumber(String uniqueMandateNumber) {
        this.uniqueMandateNumber = uniqueMandateNumber;
    }

    private Integer frequency;
    private String scheduledAt;
    private String scheduledEnd;
    private Boolean share;
    private Boolean revocable;
    private String ruleRecurrence;
    private String ruleRecurrenceValue;
    private String ruleAmount;
    //private Integer ruleAmountValue;
    private Boolean blockFund;
    // private Integer ruleRecurrenceValue;
    private Float ruleAmountValue;
    private String uniqueMandateNumber;

}
