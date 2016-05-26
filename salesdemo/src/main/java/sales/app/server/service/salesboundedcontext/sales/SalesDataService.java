package sales.app.server.service.salesboundedcontext.sales;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import sales.app.shared.salesboundedcontext.sales.SalesData;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "root", versionNumber = "16", comments = "Service for SalesData Transaction table", complexity = Complexity.MEDIUM)
public abstract class SalesDataService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(SalesData entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<SalesData> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(Integer id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(SalesData entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<SalesData> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByChannelId(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByReatilercode(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByMaterialcode(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByBrandcode(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByCategoryId(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
