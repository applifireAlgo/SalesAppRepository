package sales.app.server.service.salesboundedcontext.sales;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import sales.app.shared.salesboundedcontext.sales.Channel;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "root", versionNumber = "5", comments = "Service for Channel Master table Entity", complexity = Complexity.LOW)
public abstract class ChannelService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Channel entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Channel> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Channel entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Channel> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
