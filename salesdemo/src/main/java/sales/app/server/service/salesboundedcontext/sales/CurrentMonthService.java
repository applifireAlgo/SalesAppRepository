package sales.app.server.service.salesboundedcontext.sales;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import sales.app.shared.salesboundedcontext.sales.CurrentMonth;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "root", versionNumber = "7", comments = "Service for CurrentMonth Master table Entity", complexity = Complexity.LOW)
public abstract class CurrentMonthService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(CurrentMonth entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<CurrentMonth> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(Integer id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(CurrentMonth entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<CurrentMonth> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
