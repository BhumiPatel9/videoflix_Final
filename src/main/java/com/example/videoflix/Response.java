
package com.example.videoflix;


        import java.util.List;
        import com.example.videoflix.models.Movie;

public class Response<T> {

    private String message;
    private List<T> body;


    public Response()
    {

    }

    public Response(String message, List<T> body) {
        this.message = message;

        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getBody() {
        return body;
    }

    public void setBody(List<T> body) {
        this.body = body;
    }
}