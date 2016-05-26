package sales.app.server.repository.salesboundedcontext.sales;
import sales.app.server.repository.core.SearchInterface;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for UserAccess Master table Entity", complexity = Complexity.LOW)
public interface UserAccessRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(Integer id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public List<T> findByUserId(String userId) throws Exception;

    public List<T> findByRegion(String region) throws Exception;

    public T findById(Integer userAccessId) throws Exception;
}
