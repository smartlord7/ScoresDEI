package BusinessLayer.Exception.DTO;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class ExceptionListDTO {
    private String message;
    private String source;
    private String context;
    private Long createdById;
    private LocalDateTime createdDate;

    public ExceptionListDTO() {
    }

    public ExceptionListDTO(String message, String source, String context, Long createdById, LocalDateTime createdDate) {
        this.message = message;
        this.source = source;
        this.context = context;
        this.createdById = createdById;
        this.createdDate = createdDate;
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

    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExceptionListDTO.class.getSimpleName() + "[", "]")
                .add("message='" + message + "'")
                .add("source='" + source + "'")
                .add("context='" + context + "'")
                .add("createdById=" + createdById)
                .add("createdDate=" + createdDate)
                .toString();
    }
}
