package sales.app.server.repository.organization.contactmanagement;
import sales.app.server.repository.core.SearchInterface;
import sales.app.config.annotation.Complexity;
import sales.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;
import sales.app.shared.organization.contactmanagement.CommunicationData;
import sales.app.shared.organization.locationmanagement.Address;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for CoreContacts Transaction table", complexity = Complexity.MEDIUM)
public interface CoreContactsRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void deleteCommunicationData(List<CommunicationData> communicationdata);

    public void deleteAddress(List<Address> address);

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public List<T> findByTitleId(String titleId) throws Exception;

    public List<T> findByNativeLanguageCode(String nativeLanguageCode) throws Exception;

    public List<T> findByGenderId(String genderId) throws Exception;

    public List<T> findByTimeZoneId(String timeZoneId) throws Exception;

    public T findById(String contactId) throws Exception;
}
