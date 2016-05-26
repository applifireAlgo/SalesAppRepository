package sales.app.server.repository.appbasicsetup.usermanagement;
import com.spartan.server.interfaces.LoginSessionDataRepository;
import sales.app.server.repository.core.SearchInterface;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for SessionData Transaction table", complexity = Complexity.MEDIUM)
public interface SessionDataRepository<T> extends SearchInterface, LoginSessionDataRepository {
}
