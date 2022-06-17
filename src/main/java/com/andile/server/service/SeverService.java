package com.andile.server.service;

import java.io.IOException;
import java.util.Collection;

import com.andile.server.model.Server;

public interface SeverService {
    Server create(Server server);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
