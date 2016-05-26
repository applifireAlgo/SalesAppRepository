package sales.app.server.service.salesboundedcontext.sales;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import java.util.List;
import sales.app.shared.salesboundedcontext.sales.Brand;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "root", versionNumber = "5", comments = "Service for Brand Master table Entity", complexity = Complexity.LOW)
public abstract class BrandService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Brand entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Brand> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Brand entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Brand> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByCategoryId(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
