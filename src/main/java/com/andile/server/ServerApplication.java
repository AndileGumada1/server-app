package com.andile.server;

import com.andile.server.model.Server;
import com.andile.server.model.Status;
import com.andile.server.repository.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ServerRepository serverRepository){
		return args -> {
//			serverRepository.save(new Server(null,"192.168.0.1","ZTE","16GB","Router",null,Status.SERVER_UP));
//			serverRepository.save(new Server(null,"192.168.16.1","Ubuntu","32GB","Server", "http://localhost:8081/api/servers/image/server1.png",Status.SERVER_UP));
		};
	}
}
