package sales.app.server.service.salesboundedcontext.sales;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import sales.app.shared.salesboundedcontext.sales.UserAccess;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for UserAccess Master table Entity", complexity = Complexity.LOW)
public abstract class UserAccessService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(UserAccess entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<UserAccess> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(Integer id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(UserAccess entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<UserAccess> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByUserId(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByRegion(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
