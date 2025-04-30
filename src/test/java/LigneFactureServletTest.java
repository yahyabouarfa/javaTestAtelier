import com.example.atelier02vf.LigneFactureServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class LigneFactureServletTest {

    @Test
    public void testDoGet() throws Exception {
        LigneFactureServlet servlet = new LigneFactureServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        servlet.doGet(request, response);

        writer.flush();
        String result = stringWriter.toString();

        System.out.println("GET Response:\n" + result);

        assertTrue(result.contains("GET: LigneFacture endpoint accessible"));
    }

    @Test
    public void testDoPost() throws Exception {
        LigneFactureServlet servlet = new LigneFactureServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("produit")).thenReturn("Test Produit");
        when(request.getParameter("quantite")).thenReturn("2");
        when(request.getParameter("prix")).thenReturn("100.0");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);

        servlet.doPost(request, response);

        writer.flush();
        String result = stringWriter.toString();

        System.out.println("POST Response:\n" + result);

        assertTrue(result.contains("LigneFacture ajoutée avec succès"));
        assertTrue(result.contains("\"produit\": \"Test Produit\""));
    }
}
