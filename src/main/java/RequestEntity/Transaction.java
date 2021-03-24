package RequestEntity;

public class Transaction {
    public String getIdempotentKey() {
        return idempotentKey;
    }

    public void setIdempotentKey(String idempotentKey) {
        this.idempotentKey = idempotentKey;
    }

    public String getInitiatingEntityTimestamp() {
        return initiatingEntityTimestamp;
    }

    public void setInitiatingEntityTimestamp(String initiatingEntityTimestamp) {
        this.initiatingEntityTimestamp = initiatingEntityTimestamp;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public String getExpireAfter() {
        return expireAfter;
    }

    public void setExpireAfter(String expireAfter) {
        this.expireAfter = expireAfter;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Integer getApplication() {
        return application;
    }

    public void setApplication(Integer application) {
        this.application = application;
    }

    public InitiatingEntity getInitiatingEntity() {
        return initiatingEntity;
    }

    public void setInitiatingEntity(InitiatingEntity initiatingEntity) {
        this.initiatingEntity = initiatingEntity;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public StandingInstruction getStandingInstruction() {
        return standingInstruction;
    }

    public void setStandingInstruction(StandingInstruction standingInstruction) {
        this.standingInstruction = standingInstruction;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    private String idempotentKey;
    private String initiatingEntityTimestamp;
    private String created;
    private Boolean livemode;
    private Integer currency;
    private String expireAfter;
    private Method method;
    private Integer application;
    private InitiatingEntity initiatingEntity;
    private String invoice;
    private String statementDescriptor;
    private String description;
    private Integer mode;
    private StandingInstruction standingInstruction;
    private String originalId;
    private String actionCode;

}
