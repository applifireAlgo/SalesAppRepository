package sales.app.server.service.appbasicsetup.userrolemanagement;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import sales.app.shared.appbasicsetup.userrolemanagement.UserRoleBridge;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Service for UserRoleBridge Transaction table", complexity = Complexity.MEDIUM)
public abstract class UserRoleBridgeService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(UserRoleBridge entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<UserRoleBridge> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(UserRoleBridge entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<UserRoleBridge> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByRoleId(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByUserId(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}