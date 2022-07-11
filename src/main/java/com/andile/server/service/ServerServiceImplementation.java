package com.andile.server.service;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andile.server.model.Server;
import com.andile.server.model.Status;
import com.andile.server.repository.ServerRepository;

import static org.springframework.data.domain.PageRequest.of;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.lang.Boolean.TRUE;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ServerServiceImplementation implements SeverService {
    private final ServerRepository repository;

    @Override
    public Server create(Server server) {
        log.info("Saving a server {}:", server.getName());
        server.setImageUrl(setServerImageUrl());
        return repository.save(server);
    }


    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = repository.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);

        repository.save(server);
        return server;
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching a list of servers :{}");
        return repository.findAll(of(0, limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("Get Server with id :{}", id);
        return repository.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating a server :{}", server.getName());
        return repository.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting a server :{}", id);
        repository.deleteById(id);
        return TRUE;
    }

    public String setServerImageUrl() {
        String[] imageNames = {"server1.png", "server2.png", "server3.png", "server4.png"};
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/servers/image/" + imageNames[new Random().nextInt(4)])
                .toUriString();
    }
}
