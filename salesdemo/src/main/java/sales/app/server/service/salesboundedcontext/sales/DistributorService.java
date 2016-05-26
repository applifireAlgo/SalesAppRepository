package sales.app.server.service.salesboundedcontext.sales;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import sales.app.shared.salesboundedcontext.sales.Distributor;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "root", versionNumber = "7", comments = "Service for Distributor Master table Entity", complexity = Complexity.LOW)
public abstract class DistributorService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Distributor entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Distributor> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Distributor entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Distributor> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByRegioncode(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
