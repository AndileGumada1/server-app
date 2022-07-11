package com.andile.server.api;

import com.andile.server.model.Server;
import com.andile.server.model.Status;
import com.andile.server.repository.ServerRepository;
import com.andile.server.service.ServerServiceImplementation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ServerController.class)
@AutoConfigureMockMvc
class ServerControllerTest {

    @Mock
    ServerRepository repository;

    @Autowired
    private  MockMvc mockMvc;
    @Autowired
    private ServerServiceImplementation serviceImplementation;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void testGettingAllServers() throws Exception {
        // given - precondition or setup
        List<Server> listOfServer = new ArrayList<>();

        listOfServer.add(
                new Server(
                1L,
                "192.168.16.1",
                "Ubuntu",
                "32GB",
                "Server",
                "http://localhost:8081/api/servers/image/server1.png",
                Status.SERVER_UP));

        //When
        when(serviceImplementation.list(10)).thenReturn(listOfServer);

        //Then
        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:9090/api/employee/all"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}]"));
    }

    @Test
    void pingServer() {
    }

    @Test
    void saveServer() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

//        when(serviceImplementation.create(any(Server.class))).thenReturn(true);
        //
        Server server = Server.builder()
                .id(null)
                .ipAddress("192.168.16.1")
                .name("Ubuntu")
                .memory("32GB")
                .type("Server")
                .imageUrl("http://localhost:8081/api/servers/image/server1.png")
                .status(Status.SERVER_UP)
                .build();


//
//        MvcResult result = mockMvc.perform(post("/api/server/save")
//                        .content(request)
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                        .andExpect(status().isOk())
//                .andReturn();
//
//       String resultContext = request.().getContentAsString();



    }
}