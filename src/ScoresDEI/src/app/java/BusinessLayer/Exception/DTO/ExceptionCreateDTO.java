package BusinessLayer.Exception.DTO;

import java.util.StringJoiner;

public class ExceptionCreateDTO {
    private Long id;
    private String message;
    private String stackTrace;
    private String source;
    private String context;

    public ExceptionCreateDTO() {
    }

    public ExceptionCreateDTO(String message, String stackTrace, String source, String context) {
        this.message = message;
        this.stackTrace = stackTrace;
        this.source = source;
        this.context = context;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExceptionCreateDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("message='" + message + "'")
                .add("stackTrace='" + stackTrace + "'")
                .add("source='" + source + "'")
                .add("context='" + context + "'")
                .toString();
    }
}
