package DataLayer.Model;

import DataLayer.Base.BaseEntityModel;
import org.springframework.data.jpa.domain.AbstractAuditable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Exception")
@Table(name = "Exception")
public class Exception  extends AbstractAuditable<User, Long> implements BaseEntityModel {

    // region Private Properties

    @Column(length = 1024)
    private String message;

    @Column(length = 4096)
    private String stackTrace;

    @Column(length = 512)
    private String source;

    @Column(length = 256)
    private String context;

    // endregion Private Properties

    // region Constructors

    public Exception() {
    }

    public Exception(String message, String stackTrace, String source, String context) {
        this.message = message;
        this.stackTrace = stackTrace;
        this.source = source;
        this.context = context;
    }

    // endregion Constructors

    // region Getters and Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    // endregion Getters and Setters
}
