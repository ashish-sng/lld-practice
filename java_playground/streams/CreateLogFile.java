package java_playground.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateLogFile {
    public static void main(String[] args) throws IOException {
        String logContent = """
            2026-09-17 08:30:01.104 [main] INFO  com.app.Application - Starting Application on srv-prod-01 with PID 4120
            2026-09-17 08:30:02.450 [main] INFO  com.app.config.DatabaseConfig - Initializing HikariCP connection pool [jdbc:postgresql://db.internal:5432/appdb]
            2026-09-17 08:31:15.220 [http-nio-8080-exec-1] INFO  com.app.controller.AuthController - POST /api/v1/auth/login - status=200 duration=42ms
            2026-09-17 08:32:44.912 [http-nio-8080-exec-3] WARN  com.app.security.RateLimiter - Rate limit threshold exceeded for client_ip=203.0.113.50
            2026-09-17 08:33:07.502 [http-nio-8080-exec-4] ERROR com.app.service.PaymentGatewayService - Connection timed out after 5000ms
            2026-09-17 08:34:10.118 [db-worker-1] WARN  com.app.repository.OrderRepository - Slow query detected (duration: 3120ms)
            2026-09-17 08:36:22.673 [http-nio-8080-exec-5] ERROR com.app.controller.ReportController - NullPointerException in ReportService
            """;

        Files.writeString(Path.of("java_playground/streams/server.log"), logContent);
        System.out.println("server.log created successfully!");
    }
}