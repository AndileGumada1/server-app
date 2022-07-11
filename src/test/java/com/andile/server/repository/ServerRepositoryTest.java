package com.andile.server.repository;

import com.andile.server.model.Server;
import com.andile.server.model.Status;
import org.junit.jupiter.api.Test;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

class ServerRepositoryTest {
    ServerRepository repository;
    @Test
    void testShouldFindServerByIpAddress() {
        //Given
        String ipAddress = "192.168.16.1";
        Server server =new Server(
                1L,
                ipAddress,
                "Ubuntu",
                "32GB",
                "Server",
                "http://localhost:8081/api/servers/image/server1.png",
                Status.SERVER_UP);
        repository.save(server);
        //When
        Server server1 =repository.findByIpAddress(ipAddress);
        //Then
        //assertEquals(server1);
    }
}