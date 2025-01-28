package acc.br;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.h2.tools.Server;
import java.sql.SQLException;

@Path("/h2-console")
public class H2ConsoleResource {

    private Server webServer;

    void onStart(@Observes StartupEvent ev) {
        try {
            webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao iniciar o H2 Console", e);
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getConsoleUrl() {
        return "H2 Console rodando em: http://localhost:8082";
    }
}
