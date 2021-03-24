
package RequestEntity.reqAuthProcessMandate;

import RequestEntity.MandateDtl;
import RequestEntity.RequestInfo;

import java.util.List;

public class ReqAuthProcessMandateEntity {

    private RequestInfo requestInfo;
    private String status;
    private String statusDesc;
    private List<MandateDtl> mandateDtls = null;

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
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
