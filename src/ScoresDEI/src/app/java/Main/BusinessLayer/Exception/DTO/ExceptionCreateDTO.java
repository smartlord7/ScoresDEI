/**------------scoreDEI: Resultados desportivos em direto - WEB FRAMEWORK------------
 University of Coimbra
 Degree in Computer Science and Engineering
 Sistemas Distribuidos
 3rd year, 2nd semester
 Authors:
 Sancho Amaral Simões, 2019217590, uc2019217590@student.uc.pt
 Tiago Filipe Santa Ventura, 2019243695, uc2019243695@student.uc.pt
 Coimbra, 31th May 2022
 */

package Main.BusinessLayer.Exception.DTO;

import java.util.StringJoiner;

public class ExceptionCreateDTO {

    // region Private Properties

    private Long id;
    private String message;
    private String stackTrace;
    private String source;
    private String context;

    // endregion Private Properties

    // region Constructors

    public ExceptionCreateDTO() {
    }

    public ExceptionCreateDTO(String message, String stackTrace, String source, String context) {
        this.message = message;
        this.stackTrace = stackTrace;
        this.source = source;
        this.context = context;
    }

    // endregion Constructors

    // region Getters and Setters

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

    // endregion Getters and Setters

}
