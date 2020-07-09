package com.flights.path.services;

import com.flights.path.config.ReadCitiesFromFile;
import com.flights.path.util.Search;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindCitiesPathService {

    private final Logger log = LoggerFactory.getLogger(Search.class);

    @Autowired
    private Search search;

    public FindCitiesPathService(){}

    public FindCitiesPathService(Search search) {
        this.search = search;
    }

    public String findCitiesPath(String origin, String destination){
        log.info("inside FindCitiesPathService.class - findCitiesPath metho()) ");

        search.setSTART(origin);
        search.setEND(destination);

        return search.searchPath(ReadCitiesFromFile.map.get("graph"));
    }
}
