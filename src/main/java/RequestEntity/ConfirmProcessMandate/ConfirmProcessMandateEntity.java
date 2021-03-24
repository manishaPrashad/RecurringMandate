
package RequestEntity.ConfirmProcessMandate;

import RequestEntity.MandateDtl;
import RequestEntity.RequestInfo;

import java.util.List;

public class ConfirmProcessMandateEntity {

    private RequestInfo requestInfo;
    private String errCode;
    private String status;
    private String statusDesc;
    private List<MandateDtl> mandateDtls = null;

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public List<MandateDtl> getMandateDtls() {
        return mandateDtls;
    }

    public void setMandateDtls(List<MandateDtl> mandateDtls) {
        this.mandateDtls = mandateDtls;
    }

}
